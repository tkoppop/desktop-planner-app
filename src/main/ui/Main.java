package ui;

import model.*;

import java.io.*;
import java.util.*;

import static persistence.Reader.readCalenderTask;

public class Main {

    public static final String CALENDER_FILE = "./data/calender.txt";
    public static Scanner sc = new Scanner(System.in);
    public static Calender cal = new Calender();
    public static Boolean done = false;
    public static String temp;
    public static String temp1;
    public static PrintWriter printWriter;
    public static Writer writer;
    public static ArrayList<CalenderTask> tempCal = new ArrayList<>();

    public static void main(String[] args) {
        for (int start = 0; start < 1; start--) {
            System.out.println("You are at the main menu");
            System.out.println("1 - add another task");
            System.out.println("2 - remove a task");
            System.out.println("3 - view todo list");
            System.out.println("4 - save and exit");
            System.out.println("5 - load a file");
            int choice = sc.nextInt();
            if (choice == 1) {
                addTask();
            } else if (choice == 2) {
                removeTask();
            } else if (choice == 3) {
                System.out.println("My todo list");
                System.out.println(cal.toString());
            } else if (choice == 4) {
                System.out.println("Saving...");
                saveCalender();
                System.out.println("exiting");
                System.exit(0);
            } else if (choice == 5) {
                loadCalender();
                cal = arrayListToCalender(tempCal);

            }
        }
    }

    public static void addTask() {
        do {
            sc.nextLine();
            done = cal.addCalenderTask(userInputCalTask());
            if (!done) {
                System.out.println("You have an overlapping task");
            } else {
                System.out.println("Added");
            }
        } while (!done);
    }

    public static void removeTask() {
        sc.nextLine();
        System.out.println("Enter the Name of the task you would like to remove");
        temp = sc.nextLine();
        System.out.println("Enter the description of the task you would like to remove");
        temp1 = sc.nextLine();
        done = cal.removeCalenderTask(temp, temp1);
        if (done) {
            System.out.println("removed");
        } else {
            System.out.println("Task not found");
            System.out.println("any extra capitals or spaces?");
        }
    }

    public static CalenderTask userInputCalTask() {
        System.out.println("Please enter the month of the due date");
        String month = sc.nextLine();
        System.out.println("Please enter the day of the due date");
        int day = sc.nextInt();
        System.out.println("Please enter the year of the due date");
        int year = sc.nextInt();
        System.out.println("Please enter the time you start on the task");
        int start = sc.nextInt();
        System.out.println("Please enter the time you plan to finish the task");
        int finish = sc.nextInt();
        System.out.println("Please enter the name of your task");
        sc.nextLine();
        String name = sc.nextLine();
        System.out.println("Please enter a quick description of your task,");
        System.out.println("this should not be the same for two or more tasks");
        String description = sc.nextLine();
        System.out.println("Please enter the urgency of this task");
        System.out.println("1 - Very Urgent");
        System.out.println("0 - Normal");
        int urgency = sc.nextInt();
        return new CalenderTask(day, month, year, start,
                finish, name, description, urgency);
    }

    public static void saveCalender() {
        try {
            persistence.Writer writer = new persistence.Writer(new File(CALENDER_FILE));
            persistence.Writer.write(cal);
            persistence.Writer.close();
            System.out.println("Accounts saved to file " + CALENDER_FILE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to save accounts to " + CALENDER_FILE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            // this is due to a programming error
        }
    }

    public static Calender arrayListToCalender(ArrayList al) {
        for (int z = 0; z < al.size(); z++) {
            cal.addCalenderTask((CalenderTask) al.get(z));
        }
        return cal;
    }

    public static ArrayList loadCalender() {
        try {
            tempCal = readCalenderTask(new File(CALENDER_FILE));
            return tempCal;
        } catch (IOException e) {
            System.out.print("this should not happen");
            return null;
        }
    }
}

