package ui;

import model.Calender;
import model.CalenderTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import static persistence.Reader.readCalenderTask;
import static ui.AddTask.*;
import static ui.CalenderView.*;
import static ui.TodoListGui.CALENDER_FILE;
import static ui.TodoListGui.arrayListToCalender;
import static ui.TodoListGui.cal;

public class ViewChooser {

    public static ArrayList<CalenderTask> tempCal = new ArrayList<>();


    public static void main(String[] args) {

        JFrame frame = new JFrame("ViewChooser");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 300);
        JButton cal = new JButton("Calendar");
        JButton todoList = new JButton("To-do List");
        JButton addTask = new JButton("Add new task");
        JButton loadList = new JButton("Load Tasks");
        JButton saveList = new JButton("Save Task");
        frame.getContentPane().add(cal, BorderLayout.LINE_START);
        frame.getContentPane().add(todoList, BorderLayout.CENTER);
        frame.getContentPane().add(addTask, BorderLayout.LINE_END);
        frame.getContentPane().add(loadList,BorderLayout.PAGE_START);
        frame.getContentPane().add(saveList, BorderLayout.PAGE_END);
        frame.setVisible(true);
        cal.addActionListener(new ViewChooser.LaunchCalendar());
        todoList.addActionListener(new ViewChooser.LaunchTodoList());
        addTask.addActionListener(new ViewChooser.LaunchAddTask());
        loadList.addActionListener(new ViewChooser.LoadCalender());
        saveList.addActionListener(new ViewChooser.SaveCalender());
    }

    //REQUIRES: launchcalender button to be clicked
    //MODIFIES: display
    //EFFECTS: launches the calender GUI
    static class LaunchCalendar implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            calenderView();
        }
    }

    //REQUIRES: launchTodoList button to be clicked
    //MODIFIES: display
    //EFFECTS: launches the todolist GUI
    static class LaunchTodoList implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            TodoListGui.todoList();
        }
    }

    //REQUIRES: addTask button to be clicked
    //MODIFIES: display
    //EFFECTS: launches the addTask GUI
    static class LaunchAddTask implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            addTasks();
        }
    }

   //MODIFIES: cal
    //EFFECTS: loads in previous calender data
    static class LoadCalender implements  ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                tempCal = readCalenderTask(new File(CALENDER_FILE));
                cal = arrayListToCalender(tempCal);
            } catch (IOException d) {
                System.out.print("this should not happen");
            }
        }
    }

    //MODIFIES: calender.txt
    //EFFECTS: saves calender onto text file
    static class SaveCalender implements  ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                persistence.Writer writer = new persistence.Writer(new File(CALENDER_FILE));
                persistence.Writer.write(cal);
                persistence.Writer.close();
                System.out.println("Calendar saved to file " + CALENDER_FILE);
            } catch (FileNotFoundException d) {
                System.out.println("Unable to save Calendar to " + CALENDER_FILE);
            } catch (UnsupportedEncodingException d) {
                d.printStackTrace();
            }
        }
    }
}