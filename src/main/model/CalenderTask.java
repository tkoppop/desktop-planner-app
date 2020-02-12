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

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getUrgency() {
        return urgency;
    }

}
