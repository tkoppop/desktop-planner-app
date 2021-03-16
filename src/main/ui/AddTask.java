package ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static ui.TodoListGui.cal;

//the UI form to add task to Calender
public class AddTask extends JFrame {
    static JPanel contentPane = new JPanel();
    static int day;
    private static String month;
    static int year;
    static AddTask frame;
    static String name;
    static int urgency;
    static JTextField dayInput;
    static JTextField monthInput;
    static JTextField yearInput;
    private static JTextField nameInput;
    static JTextField urgencyInput;

    //EFFECTS: launches the add task GUI
    public static void addTasks() {
        try {
            frame = new AddTask();
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //EFFECTS: represents to Add Task GUI
    public AddTask() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 150, 500, 450);

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        getDate();

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(64, 160, 46, 30);
        contentPane.add(lblName);
        nameInput = new JTextField();
        nameInput.setBounds(150, 160, 150, 30);
        contentPane.add(nameInput);


        JLabel lblUrgency = new JLabel("Urgency, 0 or 1");
        lblUrgency.setBounds(64, 200, 120, 30);
        contentPane.add(lblUrgency);
        urgencyInput = new JTextField();
        urgencyInput.setBounds(150, 200, 150, 30);
        contentPane.add(urgencyInput);


        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setBounds(150, 250, 84, 30);
        contentPane.add(btnSubmit);
        btnSubmit.addActionListener(new SubmitTask());

    }

    //REQUIRES: submit task button is clicked
    //MODIFIES: calender
    //EFFECTS: adds a calender task to calender who's fields are put in.
    static class SubmitTask implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String s1 = dayInput.getText();
            String s2 = monthInput.getText();
            String s3 = yearInput.getText();
            String s4 = nameInput.getText();
            String s5 = urgencyInput.getText();
            dayInput.setText("");
            monthInput.setText("");
            yearInput.setText("");
            nameInput.setText("");
            urgencyInput.setText("");
            day = Integer.parseInt(s1);
            month = s2;
            year = Integer.parseInt(s3);
            name = s4;
            urgency = Integer.parseInt(s5);
            CalenderTask temp = new CalenderTask(day, month, year, name, urgency);
            cal.addCalenderTask(temp);
            frame.setVisible(false);
        }
    }

    //EFFECTS: adds the date inputs into the GUI
    public static void getDate() {

        JLabel lblDay = new JLabel("Day");
        lblDay.setBounds(64, 29, 46, 30);
        contentPane.add(lblDay);
        dayInput = new JTextField();
        dayInput.setBounds(150, 29, 150, 30);
        contentPane.add(dayInput);


        JLabel lblMonth = new JLabel("Month");
        lblMonth.setBounds(64, 75, 46, 30);
        contentPane.add(lblMonth);
        monthInput = new JTextField();
        monthInput.setBounds(150, 75, 150, 30);
        contentPane.add(monthInput);

        JLabel lblYear = new JLabel("Year");
        lblYear.setBounds(64, 117, 46, 30);
        contentPane.add(lblYear);
        yearInput = new JTextField();
        yearInput.setBounds(150, 117, 150, 30);
        contentPane.add(yearInput);
    }


}

