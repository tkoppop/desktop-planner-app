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


    @BeforeEach
    void runBefore() {
        c = new Calender();
        ct1 = new CalenderTask(1, "January", 2020, 0100,
                0200, "Math", "Math homework" , 0);
        ct2 = new CalenderTask(1, "January", 2020, 0130,
                0230, "English", "English homework", 0);
        ct3 = new CalenderTask(2, "March", 2021, 0130,
                0230, "Biology", "Biology homework", 1);
        ct4 = new CalenderTask(1, "February", 2020, 0130,
                0230, "Physics", "Physics homework", 1);
        ct5 = new CalenderTask(1, "January", 2020, 0,
                2400, "Math", "Math homework" , 0);
        ct6 = new CalenderTask(1, "January", 2020, 0130,
                500, "Math", "Math homework" , 0);
        ct7 = new CalenderTask(1, "January", 2020, 0,
                0130, "Math", "Math homework" , 0);
        ct8 = new CalenderTask(1, "January", 2020, 0100,
                0200, "Math", "Math homework" , 0);
        ct9 = new CalenderTask(7, "January", 2020, 0100,
                0200, "Math", "Math homework" , 0);
        ct10 = new CalenderTask(1, "January", 2020, 0130,
                0145, "Math", "Math homework" , 0);
    }

    @Test
    void testConstructor() {
        assertEquals(0, c.getSize());
        assertFalse(c.removeCalenderTask("English", "English homework"));
    }

    @Test
    void testSingleTask(){
        assertTrue(c.addCalenderTask(ct1));
        assertEquals(1, c.getSize());
        assertTrue(c.removeCalenderTask("Math", "Math homework"));
        assertEquals(0,c.getSize());
    }

    @Test
    void testAddMultipleNoOverlap(){
        assertTrue(c.addCalenderTask(ct3));
        assertTrue(c.addCalenderTask(ct4));
        assertTrue(c.addCalenderTask(ct1));
        assertEquals(3, c.getSize());
        assertTrue(c.removeCalenderTask("Math", "Math homework"));
        assertEquals(2, c.getSize());
        assertEquals("On February 1, 2020 , Physics is due.Physics homework. Urgent\n" +
                "On March 2, 2021 , Biology is due.Biology homework. Urgent", c.toString());

    }

    @Test
    void testAddMultipleWithOverlap(){
        assertTrue(c.addCalenderTask(ct1));
        assertTrue(c.addCalenderTask(ct3));
        assertTrue(c.addCalenderTask(ct4));
        assertEquals(3,c.getSize());
        assertFalse(c.addCalenderTask(ct2));
        assertEquals(3, c.getSize());
        assertEquals("On February 1, 2020 , Physics is due.Physics homework. Urgent\n" +
                "On March 2, 2021 , Biology is due.Biology homework. Urgent\n" +
                "On January 1, 2020 , Math is due.Math homework. Not Urgent", c.toString());
        assertFalse(c.removeCalenderTask("English" , "English homework"));
        assertFalse(c.removeCalenderTask("Math", "Math"));
        assertFalse(c.removeCalenderTask("M", "Math homework"));
        assertTrue(c.removeCalenderTask("Math","Math homework"));
        assertEquals(2,c.getSize());
        assertTrue(c.addCalenderTask(ct1));
        assertFalse(c.addCalenderTask(ct5));
        assertFalse(c.addCalenderTask(ct6));
        assertFalse(c.addCalenderTask(ct7));
        assertFalse(c.addCalenderTask(ct8));
        assertTrue(c.addCalenderTask(ct9));
        assertFalse(c.addCalenderTask(ct10));


    }
}
