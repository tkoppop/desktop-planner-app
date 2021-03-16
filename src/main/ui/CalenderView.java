package ui;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import static ui.TodoListGui.cal;

//Represents the Calender UI
public class CalenderView {
    public static JTextArea numTasks;
    public static JLabel lblMonth;
    public static JLabel lblYear;
    private static JButton prevMonth;
    public static JButton nextMonth;
    public static JTable calenderTable;
    private static JComboBox cmbYear;
    public static JFrame frame;
    public static Container pane;
    public static DefaultTableModel calender; //Table model
    public static JScrollPane stblCalendar; //The scrollpane
    private static JPanel pnlCalendar;
    public static int userYear;
    public static int userMonth;
    public static int userDay;
    public static int currentYear;
    public static int currentMonth;
    public static String[] months = {"January", "February", "March", "April", "May", "June", "July", "August",
            "September", "October", "November", "December"};

    //EFFECTS: launches Calender GUI
    public static void calenderView() {
        initializeSize();
        setControls();
        setBorders();
        frame.setVisible(true);
        getUserTime();
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i < 7; i++) {
            calender.addColumn(headers[i]);
        }
        calenderTable.getParent().setBackground(calenderTable.getBackground());
        calenderTable.setColumnSelectionAllowed(true);
        calenderTable.setRowSelectionAllowed(true);
        calenderTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        calenderTable.setRowHeight(76);
        calender.setColumnCount(7);
        calender.setRowCount(6);
        for (int i = userYear - 100; i <= userYear + 100; i++) {
            cmbYear.addItem(String.valueOf(i));
        }
        refreshCalendar(userMonth, userYear);
    }

    //MODIFIES: calender, calenderTable
    //EFFFECTS: updates the calender and user dates
    public static void refreshCalendar(int month, int year) {
        int nod;
        int som;
        allowButtons(month, year);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                calender.setValueAt(null, i, j);
            }
        }
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        for (int i = 1; i <= nod; i++) {
            int row = new Integer((i + som - 2) / 7);
            int column = (i + som - 2) % 7;
            calender.setValueAt(i, row, column);
        }
        calenderTable.setDefaultRenderer(calenderTable.getColumnClass(0), new CalenderRenderer());
    }

    //MODIFIES: frame
    //EFFECTS: draws the calender onto the frame.
    static class CalenderRenderer extends DefaultTableCellRenderer {
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean selected, boolean focused, int row, int column) {
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            setBackground(new Color(255, 255, 255));

            if (value != null && (Integer.parseInt(value.toString())
                        == userDay && currentMonth == userMonth && currentYear == userYear)) { 
                    setBackground(new Color(220, 220, 255));
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }

    //REQUIRES: prevmonth button to be pushed
    //MODIFIES: frame
    //EFFECTS: changes user view the the previous month
    static class PrevMonth implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentMonth == 0) {
                currentMonth = 11;
                currentYear -= 1;
            } else {
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }

    //REQUIRES: next month button to be clicked
    //MMODIFIES: frame
    //EFFECTS: switches the frame to display the next month
    static class NextMonth implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (currentMonth == 11) {
                currentMonth = 0;
                currentYear += 1;
            } else {
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }

    //REQUIRE: year selection to be clicked
    //MODIFIES: frame
    //EFFECTS: switches to the year user selected
    static class YearSelection implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (cmbYear.getSelectedItem() != null) {
                String selectedYear = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(selectedYear);
                refreshCalendar(currentMonth, currentYear);
            }
        }
    }

    //MODIFIES: frame
    //EFFECTS: sets up the initial conidtions of the frame
    static void initializeSize() {
        frame = new JFrame("Calender");
        frame.setSize(660, 750);
        pane = frame.getContentPane();
        pane.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //MODIFIES: frame
    //EFFECTS: adds buttons onto the frame
    static void setControls() {
        lblMonth = new JLabel("January");
        lblYear = new JLabel("Change year:");
        cmbYear = new JComboBox();
        prevMonth = new JButton("Prev");
        nextMonth = new JButton("Next");
        calender = new DefaultTableModel() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        calenderTable = new JTable(calender);
        stblCalendar = new JScrollPane(calenderTable);
        pnlCalendar = new JPanel(null);
        prevMonth.addActionListener(new PrevMonth());
        nextMonth.addActionListener(new NextMonth());
        cmbYear.addActionListener(new YearSelection());
        pane.add(pnlCalendar);
        pnlCalendar.add(lblMonth);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(prevMonth);
        pnlCalendar.add(nextMonth);
        pnlCalendar.add(stblCalendar);
    }

    //MODIFIES: frame
    //EFFECTS: sets the borders of the calender
    static void setBorders() {
        pnlCalendar.setBounds(0, 0, 640, 670);
        lblMonth.setBounds(320 - lblMonth.getPreferredSize().width / 2, 50, 200, 50);
        lblYear.setBounds(20, 610, 160, 40);
        cmbYear.setBounds(460, 610, 160, 40);
        prevMonth.setBounds(20, 50, 100, 50);
        nextMonth.setBounds(520, 50, 100, 50);
        stblCalendar.setBounds(20, 100, 600, 500);
    }

    //MODIFIES: userday, usermonth, useryear
    //EFFECTS: finds the real time of the user
    static void getUserTime() {
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        userDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        userMonth = cal.get(GregorianCalendar.MONTH); //Get month
        userYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth = userMonth; //Match month and year
        currentYear = userYear;
    }

    //EFFECTS: sets the buttons so that they can't go too far back or forward in time
    private static void allowButtons(int month, int year){
        prevMonth.setEnabled(true);
        nextMonth.setEnabled(true);
        if (month == 0 && year <= userYear - 10) {
            prevMonth.setEnabled(false);
        } //Too early
        if (month == 11 && year >= userYear + 100) {
            nextMonth.setEnabled(false);
        }
        lblMonth.setText(months[month]);
        lblMonth.setBounds(320 - lblMonth.getPreferredSize().width / 2, 50, 360, 50);
        cmbYear.setSelectedItem(String.valueOf(year));
    }

}
