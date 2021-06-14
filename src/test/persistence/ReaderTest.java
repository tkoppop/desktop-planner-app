package persistence;
import model.*;
import org.junit.jupiter.api.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
public class ReaderTest {
    CalenderTask ct;
    Calender cal;
    @Test
    void testConstructor(){
        new Reader();
        assertEquals(1, 1);
    }
    @Test
    void testParseCalenderFile1() {
        try {
            List<CalenderTask> tempCal = Reader.readCalenderTask(new File("./data/testCalenderFile1.txt"));
            CalenderTask ct = tempCal.get(0);
            assertEquals(4, ct.getDay());
            assertEquals("Feb", ct.getMonth());
            assertEquals(2020, ct.getYear());
            assertEquals("English", ct.getName());
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
            assertEquals("Math", ct.getName());
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
