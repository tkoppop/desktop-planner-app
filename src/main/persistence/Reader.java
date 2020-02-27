package persistence;

import model.CalenderTask;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Reader {
    public static final String DELIMITER = ",";

    // EFFECTS: returns a list of accounts parsed from file; throws
    // IOException if an exception is raised when opening / reading from file
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
    // where each string contains data for one account
    private static ArrayList parseContent(List<String> fileContent) {
        ArrayList ct = new ArrayList<>();

        for (String line : fileContent) {
            ArrayList<String> lineComponents = splitString(line);
            ct.add(parseCalenderTask(lineComponents));
        }

        return ct;
    }

    // EFFECTS: returns a list of strings obtained by splitting line on DELIMITER
    private static ArrayList<String> splitString(String line) {
        String[] splits = line.split(DELIMITER);
        return new ArrayList<>(Arrays.asList(splits));
    }

    // REQUIRES: components has size 4 where element 0 represents the
    // id of the next account to be constructed, element 1 represents
    // the id, elements 2 represents the name and element 3 represents
    // the balance of the account to be constructed
    // EFFECTS: returns an account constructed from components
    private static CalenderTask parseCalenderTask(List<String> components) {
        int day = Integer.parseInt(components.get(0));
        String month = components.get(1);
        int year = Integer.parseInt(components.get(2));
        int start = Integer.parseInt(components.get(3));
        int finish = Integer.parseInt(components.get(4));
        String name = components.get(5);
        String description = components.get(6);
        int urgency = Integer.parseInt(components.get(7));
        return new CalenderTask(day, month, year, start, finish, name, description, urgency);
    }
}
