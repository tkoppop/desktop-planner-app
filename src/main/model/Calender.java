package model;

import persistence.Reader;
import persistence.Saveable;

import java.io.PrintWriter;
import java.util.*;


//represents the calender of tasks.
public class Calender implements Saveable {

    public static ArrayList<CalenderTask> ct;
    public String printOut;

    public Calender() {
        ct = new ArrayList<>();
    }

    //EFFECTS: adds the task into the calender and returns true if there is no overlap or calender is empty.
    // otherwise return false.
    public static void addCalenderTask(CalenderTask calTask) {
        if (calTask.getUrgency() == 1) {
            ct.add(0, calTask);
        } else {
            ct.add(calTask);
        }
    }

    //EFFECTS: returns true if the task name, and description is found in calender and removed. Otherwise, return false.
    public boolean removeCalenderTask(String name) throws TaskNotFoundException {
        for (int i = 0; i < ct.size(); i++) {
            if (name.equals(ct.get(i).getName())) {
                ct.remove(i);
                return true;
            }
        }
        throw new TaskNotFoundException();
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
                        + ct.get(k).getName() + " is due." + ct.get(k).toStringUrgency();
            } else {
                printOut = printOut + "\n" + "On " + ct.get(k).getMonth() + " " + ct.get(k).getDay() + ", "
                        + ct.get(k).getYear() + " , " + ct.get(k).getName() + " is due." + ct.get(k).toStringUrgency();
            }
        }
        return printOut;
    }

    //MODIFIES: calender.txt
    //EFFECTS: writes calender onto text file
    @Override
    public void save(PrintWriter printWriter) {
        for (int i = 0; i < ct.size(); i++) {
            printWriter.print(ct.get(i).getDay());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(ct.get(i).getMonth());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(ct.get(i).getYear());
            printWriter.print(Reader.DELIMITER);
            printWriter.print(ct.get(i).getName());
            printWriter.print(Reader.DELIMITER);
            printWriter.println(ct.get(i).getUrgency());
        }
    }

    //EFFECTS gets a specific element of the calender with the index i
    public CalenderTask get(int i) {
        return ct.get(i);
    }

    //EFFECTS: gets the size of the calender
    public int size() {
        return ct.size();
    }


}
