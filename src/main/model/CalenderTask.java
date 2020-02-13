package model;

import java.util.*;

public class CalenderTask {

    int day;
    String month;
    int year;
    int start;
    int finish;
    String name;
    String description;
    int urgency;


    public CalenderTask(int day, String month, int year, int start,
                        int finish, String name, String description, int urgency) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.start = start;
        this.finish = finish;
        this.name = name;
        this.description = description;
        this.urgency = urgency;
    }

    public int getDay() {
        return day;
    }

    //EFFECTS: returns the month of the task
    public String getMonth() {
        return month;
    }

    //EFFECTS: returns the year of the task
    public int getYear() {
        return year;
    }

    //EFFECTS: returns the start of the task
    public int getStart() {
        return start;
    }

    //EFFECTS: returns the finish of the task
    public int getFinish() {
        return finish;
    }

    //EFFECTS: returns the name of the task
    public String getName() {
        return name;
    }

    //EFFECTS: returns the description of the task
    public String getDescription() {
        return description;
    }

    //EFFECTS: returns the urgency of the task
    public int getUrgency() {
        return urgency;
    }

}
