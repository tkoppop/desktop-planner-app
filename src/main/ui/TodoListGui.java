package ui;

import model.Calender;
import model.CalenderTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static ui.CalenderView.calenderView;


public class TodoListGui {
    public static final String CALENDER_FILE = "./data/calender.txt";
    public static Calender cal = new Calender();
    public static JFrame jf;
    public static JButton refresh;
    public static JButton finishTask;
    public static JTextArea display;
    public static SoundEffect se = new SoundEffect();

    //EFFECTS: launches the todoList GUI
    public static void todoList() {
        jf = new JFrame("Todo List");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(350, 900);
        refresh = new JButton("Refresh");
        finishTask = new JButton("Finish");
        display = new JTextArea(25, 90);
        jf.getContentPane().add(display, BorderLayout.CENTER);
        jf.getContentPane().add(refresh, BorderLayout.PAGE_START);
        jf.getContentPane().add(finishTask, BorderLayout.PAGE_END);
        refresh.addActionListener(new TodoListGui.RefreshTodoList());
        finishTask.addActionListener(new TodoListGui.FinishTask());
        JScrollPane areaScrollPane = new JScrollPane(display);
        areaScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        areaScrollPane.setPreferredSize(new Dimension(250, 250));
        jf.setVisible(true);
    }

    //REQUIRES refresh list button is hit
    //MODIFIES: display
    //EFFECTS: updates display if the user adds more calender tasks
    static class RefreshTodoList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            display.setText("");
            addTasks();
        }
    }

    //REQUIRES: finish task button is hit
    //MODIFIES: display, cal
    //EFFECTS: removes selected Task, removes it from calender, and plays a sound
    static class FinishTask implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ArrayList<String> temp = persistence.Reader.splitString(display.getSelectedText());
            display.setText(display.getText().replace(display.getSelectedText(), ""));
            cal.removeCalenderTask(temp.get(0));
            se.setFile("./data/finish.wav");
            se.play();
        }
    }

    //MODIFIES: display
    //EFFECTS: loads the calender tasks onto display
    public static void addTasks() {
        for (int x = 0; x < cal.size(); x++) {
            display.setText(display + "\n" + cal.get(x).getName() + ", " + cal.get(x).getMonth() + ", "
                    + cal.get(x).getDay() + ", " + cal.get(x).getYear() + ", " + cal.get(x).toStringUrgency());
        }
    }

    //MODIFIES: al
    //EFFECTS: converts cal into arraylist<calenderTask>
    public static Calender arrayListToCalender(ArrayList al) {
        for (int z = 0; z < al.size(); z++) {
            cal.addCalenderTask((CalenderTask) al.get(z));
        }
        return cal;
    }

}
