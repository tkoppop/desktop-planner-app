package persistence;

import model.CalenderTask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of calendertasks parsed from file
    public static ArrayList readCalenderTask(File file) throws IOException {
        List<String> fileContent = readFile(file);
        return parseContent(fileContent);
    }

    // EFFECTS: returns content of file as a list of strings, each string
    // containing the content of one row of the file
    private static List<String> readFile(File file) throws IOException {
        return Files.readAllLines(file.toPath());
    }

    // EFFECTS: returns a list of accounts parsed from list of strings
    // where each string contains data for one calender task
    private static ArrayList parseContent(List<String> fileContent) {
        ArrayList ct = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            ct.add(parseCalenderTask(lineComponents));
        }

        return ct;
    }

    // EFFECTS: returns a list of strings obtained on the DELIMITER
    public static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has the size of 5 and is day month year name urgency
    // EFFECTS: returns an calender Task constructed from components
    public static CalenderTask parseCalenderTask(List<String> components) {
        int day = Integer.parseInt(components.get(0));
        String month = components.get(1);
        int year = Integer.parseInt(components.get(2));
        String name = components.get(3);
        int urgency = Integer.parseInt(components.get(4));
        return new CalenderTask(day, month, year, name, urgency);
    }
}
