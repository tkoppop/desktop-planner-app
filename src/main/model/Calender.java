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

    //EFFECTS: returns true if the task name is found in calender and removed. Otherwise, return false.
    public boolean removeCalenderTask(String name) {
        for (int i = 0; i < ct.size(); i++) {
            if (name == ct.get(i).getName()) {
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
                    || (calTask.getFinish() > ct.get(x).getStart() && calTask.getFinish() < ct.get(x).getFinish()))) {
                return true;
            }
        }
        return false;
    }

    public boolean sameDay(CalenderTask calenTask) {
        for (int x = 0; x < ct.size(); x++) {
            if ((calenTask.getYear() == ct.get(x).getYear())
                    && (calenTask.getMonth() == ct.get(x).getMonth())
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

    public String toString() {
        printOut = "";
        for (int k = 0; k < ct.size(); k++) {
            if (printOut == "") {
                printOut = ct.get(k).getName() + " " + ct.get(k).getDescription();
            } else {
                printOut = printOut + "\n" + ct.get(k).getName() + " " + ct.get(k).getDescription();
            }
        }
        return printOut;
    }
}
