package model;
//represents each task within Calender
public class CalenderTask {
    public int day;
    public String month;
    public int year;
    public String name;
    public int urgency;
    public CalenderTask(int day, String month, int year, String name, int urgency) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.name = name;
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
    //EFFECTS: returns the name of the task
    public String getName() {
        return name;
    }
    //EFFECTS: returns the urgency of the task
    public int getUrgency() {
        return urgency;
    }
    //EFFECTS: returns urgent if urgency is 1, and normal urgency if urgency is 0
    public String toStringUrgency() {
        if (getUrgency() == 1) {
            return "Urgent";
        } else {
            return "Not Urgent";
        }
    }
}
