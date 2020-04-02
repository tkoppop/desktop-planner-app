package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import static ui.TodoListGui.CALENDER_FILE;
import static ui.TodoListGui.cal;

//saves calender onto txt file
public class SaveCalender implements ActionListener {
    //MODIFIES: calender.txt
    //EFFECTS: saves calender onto text file
    public void actionPerformed(ActionEvent e) {
        try {
            persistence.Writer writer = new persistence.Writer(new File(CALENDER_FILE));
            persistence.Writer.write(cal);
            persistence.Writer.close();
            System.out.println("Calendar saved to file " + CALENDER_FILE);
        } catch (FileNotFoundException d) {
            System.out.println("Unable to save Calendar to " + CALENDER_FILE);
        } catch (UnsupportedEncodingException d) {
            d.printStackTrace();
        }
    }
}
