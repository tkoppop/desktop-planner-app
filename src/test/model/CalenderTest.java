package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalenderTest {

    Calender c;
    CalenderTask ct1;
    CalenderTask ct2;
    CalenderTask ct3;
    CalenderTask ct4;
    CalenderTask ct5;
    CalenderTask ct6;
    CalenderTask ct7;
    CalenderTask ct8;
    CalenderTask ct9;
    CalenderTask ct10;
    CalenderTask ct11;


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
        assertFalse(c.removeCalenderTask("English"));
    }

    @Test
    void testSingleTask() {
        c.addCalenderTask(ct1);
        assertEquals(1, c.getSize());
        assertTrue(c.removeCalenderTask("Math"));
        assertEquals(0, c.getSize());
    }

    @Test
    void testAddMultiple() {
        c.addCalenderTask(ct3);
        c.addCalenderTask(ct4);
        c.addCalenderTask(ct1);
        assertEquals(3, c.getSize());
        assertTrue(c.removeCalenderTask("Math"));
        assertEquals(2, c.getSize());
        assertEquals("On February 1, 2020 , Physics is due.Urgent\n" +
                "On March 2, 2021 , Biology is due.Urgent", c.toString());
        c.addCalenderTask(ct1);
        c.addCalenderTask(ct11);

    }


}
