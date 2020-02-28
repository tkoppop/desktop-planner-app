package persistence;

import model.Calender;
import model.CalenderTask;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class WriterTest {
    public CalenderTask ct = new CalenderTask(4, "Feb", 2020, 430, 630,
            "English", "Essay 2", 1);
    public Calender cal;

    @BeforeEach
    void runBefore() {
        cal = new Calender();
    }

    @Test
    void testWrite() {
        try {
            cal.addCalenderTask(ct);
            persistence.Writer writer = new persistence.Writer(new File("./data/testCalender.txt"));
            persistence.Writer.write(cal);
            persistence.Writer.close();
            List<CalenderTask> tempCal = Reader.readCalenderTask(new File("./data/testCalender.txt"));
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

}
