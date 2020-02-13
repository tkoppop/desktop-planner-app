package ui;

import model.*;

import java.util.*;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static Calender cal = new Calender();
    public static Boolean done;
    public static String temp;
    public static String temp1;

    public static void main(String[] args) {
        for (int start = 0; start < 1; start--) {
            System.out.println("Welcome to your planner");
            System.out.println("Currently your planner is empty");
            System.out.println("Do you want to add a task?");
            System.out.println("y - Yes");
            System.out.println("n - No");
            String choice1 = sc.nextLine();
            if (choice1.equals("y") || choice1.equals("Y")) {
                Boolean success = cal.addCalenderTask(userInputCalTask());
                if (success == true) {
                    System.out.println("Added");
                    mainMenu();

                } else {
                    System.out.println("You have an overlapping task");
                }
            } else {
                System.out.println("Exiting ...");
                System.exit(0);
            }

        }
    }


    public static void mainMenu() {

        for (int main = 0; main < 1; main--) {
            System.out.println("You are at the main menu");
            System.out.println("1 - add another task");
            System.out.println("2 - remove a task");
            System.out.println("3 - view todo list");
            System.out.println("4 - exit");
            sc.nextLine();
            int choice = sc.nextInt();

            if (choice == 1) {
                addTask();
            } else if (choice == 2) {
                removeTask();
            } else if (choice == 3) {
                System.out.println("My todo list");
                System.out.println(cal.toString());
            } else {
                System.out.println("exiting");
                System.exit(0);
            }
        }
    }

    public static void addTask() {
        do {
            sc.nextLine();
            done = cal.addCalenderTask(userInputCalTask());
            if (done == false) {
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
        done = cal.removeCalenderTask(temp,temp1);
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

}

