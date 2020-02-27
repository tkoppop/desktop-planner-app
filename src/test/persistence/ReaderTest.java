package persistence;

import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ReaderTest {
    CalenderTask ct;
    Calender cal;
    @Test
    void testParseCalenderFile1() {
        try {
            List<CalenderTask> tempCal = Reader.readCalenderTask(new File("./data/testCalenderFile1.txt"));
            CalenderTask ct = tempCal.get(0);
            assertEquals(4, ct.getDay());
            assertEquals("Feb", ct.getMonth());
            assertEquals(2020, ct.getYear());
            assertEquals(430, ct.getStart());
            assertEquals(630, ct.getFinish());
            assertEquals("English", ct.getName());
            assertEquals("Essay 2", ct.getDescription());
            assertEquals(1, ct.getUrgency());

        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testParseCalenderFile2() {
        try {
            List<CalenderTask> tempCal = Reader.readCalenderTask(new File("./data/testCalenderFile2.txt"));
            CalenderTask ct = tempCal.get(0);
            assertEquals(5, ct.getDay());
            assertEquals("Jan", ct.getMonth());
            assertEquals(2020, ct.getYear());
            assertEquals(730, ct.getStart());
            assertEquals(830, ct.getFinish());
            assertEquals("Math", ct.getName());
            assertEquals("Webwork", ct.getDescription());
            assertEquals(0, ct.getUrgency());
        } catch (IOException e) {
            fail("IOException should not have been thrown");
        }
    }

    @Test
    void testIOException() {
        try {
            Reader.readCalenderTask(new File("./path/does/not/exist/testCalender.txt"));
        } catch (IOException e) {
            System.out.println("expected");
        }
    }
}
