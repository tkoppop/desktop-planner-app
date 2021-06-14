package model;
import org.junit.jupiter.api.*;
public class CalenderTest {
    private Calender c;
    private CalenderTask ct1;
    private CalenderTask ct2;
    private CalenderTask ct3;
    private CalenderTask ct4;
    private CalenderTask ct5;
    private CalenderTask ct6;
    private CalenderTask ct7;
    private CalenderTask ct8;
    private CalenderTask ct9;
    private CalenderTask ct10;
    private CalenderTask ct11;
    @BeforeEach
    void runBefore() {
        c = new Calender();
        ct1 = new CalenderTask(1, "January", 2020, "Math", 0);
        ct2 = new CalenderTask(1, "January", 2020, "English", 0);
        ct3 = new CalenderTask(2, "March", 2021, "Biology", 1);
        ct4 = new CalenderTask(1, "February", 2020, "Physics", 1);
        ct5 = new CalenderTask(1, "January", 2020, "Math", 0);
        ct6 = new CalenderTask(1, "January", 2020, "Math", 0);
        ct7 = new CalenderTask(1, "January", 2020, "Math", 0);
        ct8 = new CalenderTask(1, "January", 2020, "Math", 0);
        ct9 = new CalenderTask(7, "January", 2020, "Math", 0);
        ct10 = new CalenderTask(1, "January", 2020, "Math", 0);
        ct11 = new CalenderTask(1, "January", 2020, "Jan", 0);
    }
    @Test
    void testConstructor() {
        assertEquals(0, c.getSize());
        try {
            assertFalse(c.removeCalenderTask("English"));
            fail();
        } catch( TaskNotFoundException e) {
          //success
        }
    }
    @Test
    void testSingleTask() {
        c.addCalenderTask(ct1);
        assertEquals(1, c.getSize());
        try {
        assertTrue(c.removeCalenderTask("Math"));
        } catch( TaskNotFoundException e) {
            fail();
        }
        assertEquals(0, c.getSize());
    }
    @Test
    void testAddMultipleTask() {
        c.addCalenderTask(ct3);
        c.addCalenderTask(ct4);
        c.addCalenderTask(ct1);
        assertEquals(3, c.getSize());
        try {
        assertTrue(c.removeCalenderTask("Math"));
        } catch( TaskNotFoundException e) {
            fail();
        }
        assertEquals(2, c.getSize());
        assertEquals(2, c.size());
        assertEquals(ct4, c.get(0));
        assertEquals("On February 1, 2020 , Physics is due.Urgent\n" +
                "On March 2, 2021 , Biology is due.Urgent", c.toString());
        c.addCalenderTask(ct1);
        c.addCalenderTask(ct11);
        assertEquals("Not Urgent", ct2.toStringUrgency());
        assertEquals("Urgent", ct3.toStringUrgency());
    }
    @Test
    void testAddMultipleTaskNotFound() {
        c.addCalenderTask(ct3);
        c.addCalenderTask(ct4);
        assertEquals(2, c.getSize());
        try {
            assertFalse(c.removeCalenderTask("Math"));
            fail();
        } catch( TaskNotFoundException e) {
            //Success!! Caught
        }
        assertEquals(2, c.getSize());
        assertEquals(2, c.size());
        assertEquals(ct4, c.get(0));
        assertEquals("On February 1, 2020 , Physics is due.Urgent\n" +
                "On March 2, 2021 , Biology is due.Urgent", c.toString());
        c.addCalenderTask(ct1);
        c.addCalenderTask(ct11);
        assertEquals("Not Urgent", ct2.toStringUrgency());
        assertEquals("Urgent", ct3.toStringUrgency());
    }
}
