package ui;


import model.CalenderTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;


import static ui.AddTask.*;
import static ui.CalenderView.*;

public class ViewChooser {

    public static ArrayList<CalenderTask> tempCal = new ArrayList<>();


    public static void viewChooser() {

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
        loadList.addActionListener(new LoadCalender());
        saveList.addActionListener(new SaveCalender());
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




}