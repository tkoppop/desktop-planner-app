package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import static persistence.Reader.readCalenderTask;
import static ui.TodoListGui.*;

import static ui.ViewChooser.tempCal;

//Loads in previous calender data
public class LoadCalender implements ActionListener {
    //MODIFIES: cal
    //EFFECTS: loads in previous calender data
    public void actionPerformed(ActionEvent e) {
        try {
            tempCal = readCalenderTask(new File(CALENDER_FILE));
            cal = arrayListToCalender(tempCal);
        } catch (IOException d) {
            System.out.print("this should not happen");
        }
    }
}