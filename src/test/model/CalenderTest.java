package model;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class CalenderTest {

    Calender c;
    CalenderTask ct1;
    CalenderTask ct2;
    CalenderTask ct3;
    CalenderTask ct4;

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
    }

    @Test
    void testConstructor() {
        assertEquals(0, c.getSize());
        assertFalse(c.removeCalenderTask("English"));
    }

    @Test
    void testSingleTask(){
        assertTrue(c.addCalenderTask(ct1));
        assertEquals(1, c.getSize());
        assertTrue(c.removeCalenderTask("Math"));
        assertEquals(0,c.getSize());
    }

    @Test
    void testAddMultipleNoOverlap(){
        assertTrue(c.addCalenderTask(ct3));
        assertTrue(c.addCalenderTask(ct4));
        assertTrue(c.addCalenderTask(ct1));
        assertEquals(3, c.getSize());
        assertTrue(c.removeCalenderTask("Math"));
        assertEquals(2, c.getSize());
        assertEquals("Physics Physics homework\nBiology Biology homework", c.toString());

    }

    @Test
    void testAddMultipleWithOverlap(){
        assertTrue(c.addCalenderTask(ct1));
        assertTrue(c.addCalenderTask(ct3));
        assertTrue(c.addCalenderTask(ct4));
        assertEquals(3,c.getSize());
        assertFalse(c.addCalenderTask(ct2));
        assertEquals(3, c.getSize());
        assertEquals("Physics Physics homework\nBiology Biology homework\nMath Math homework", c.toString());
        assertFalse(c.removeCalenderTask("English"));
        assertTrue(c.removeCalenderTask("Math"));
        assertEquals(2,c.getSize());


    }
}
