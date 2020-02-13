package model;

import java.util.*;

public class Calender {

    ArrayList<CalenderTask> ct;
    String printOut;

    public Calender() {
        ct = new ArrayList<>();
    }

    //EFFECTS: adds the task into the calender and returns true if there is no overlap or calender is empty.
    // otherwise return false.
    public boolean addCalenderTask(CalenderTask calTask) {
        if (ct.size() == 0) {
            ct.add(calTask);
            return true;

        } else {
            if (overlap(calTask)) {
                return false;
            } else if (calTask.getUrgency() == 1) {
                ct.add(0, calTask);
                return true;
            } else {
                ct.add(calTask);
                return true;
            }
        }
    }

    //REQUIRES: all task descriptions to be unique.
    //EFFECTS: returns true if the task name, and description is found in calender and removed. Otherwise, return false.
    public boolean removeCalenderTask(String name, String description) {
        for (int i = 0; i < ct.size(); i++) {
            if (name.equals(ct.get(i).getName()) && description.equals(ct.get(i).getDescription())) {
                ct.remove(i);
                return true;
            }
        }
        return false;
    }

    //REQUIRES: ct.size() > 0;
    //EFFECTS: checks if the task's time interferes with other tasks within the calender.
    public boolean overlap(CalenderTask calTask) {
        for (int x = 0; x < ct.size(); x++) {
            if (sameDay(calTask)
                    && ((calTask.getStart() < ct.get(x).getStart() && calTask.getFinish() > ct.get(x).getFinish())
                    || (calTask.getStart() > ct.get(x).getStart() && calTask.getStart() < ct.get(x).getFinish())
                    || (calTask.getFinish() > ct.get(x).getStart() && calTask.getFinish() < ct.get(x).getFinish())
                    || (calTask.getFinish() == ct.get(x).getFinish() && calTask.getStart() == ct.get(x).getStart()))) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: returns true if the date of a task is the same as something in the calender.
    public boolean sameDay(CalenderTask calenTask) {
        for (int x = 0; x < ct.size(); x++) {
            if ((calenTask.getYear() == ct.get(x).getYear())
                    && (calenTask.getMonth().equals(ct.get(x).getMonth()))
                    && (calenTask.getDay() == ct.get(x).getDay())) {
                return true;
            }
        }
        return false;
    }

    //EFFECTS: returns the size of the calender
    public int getSize() {
        return ct.size();
    }

    //EFFECT: prints the todo list to a string
    public String toString() {
        printOut = "";
        for (int k = 0; k < ct.size(); k++) {
            if (printOut == "") {
                printOut = "On " + ct.get(k).getMonth() + " " + ct.get(k).getDay() + ", " + ct.get(k).getYear() + " , "
                        + ct.get(k).getName() + " is due." + ct.get(k).getDescription()
                        + ". " + ct.get(k).toStringUrgency();
            } else {
                printOut = printOut + "\n" + "On " + ct.get(k).getMonth() + " " + ct.get(k).getDay() + ", "
                        + ct.get(k).getYear() + " , " + ct.get(k).getName() + " is due." + ct.get(k).getDescription()
                        + ". " + ct.get(k).toStringUrgency();
            }
        }
        return printOut;
    }


}
