package ru.tp.add_01;

import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LeapTest {

    @Test
    public void testIsLeap1() {
        assertTrue(Leap.isLeap(2000));
    }

    @Test
    public void testIsLeap2() {
        assertTrue(Leap.isLeap(1984));
    }

    @Test
    public void testIsLeap3(){
        assertFalse(Leap.isLeap(2100));
    }

    @Test
    public void testIsLeap4(){
        assertFalse(Leap.isLeap(2013));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIsLeapForException(){
        Leap.isLeap(0);
    }


    @Test
    public void testGetMonthDay1(){
        for (int i = 1; i < 13; i++) {
            assertEquals(30, Leap.GetMonthDays(1930, i));
        }
    }

    @Test
    public void testGetMonthDay2(){
        assertEquals(29, Leap.GetMonthDays(1984, 2));
    }

    @Test
    public void testGetMothDay3(){
        assertEquals(28, Leap.GetMonthDays(1983, 2));
    }

    @Test
    public void testGetMothDay4(){
        for (int month : Arrays.asList(4, 6, 9, 11)){
            assertEquals(30, Leap.GetMonthDays(2017, month));
        }
    }

    @Test
    public void testGetMothDay5(){
        assertEquals(31, Leap.GetMonthDays(2017, 7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMothDayForException(){
        Leap.GetMonthDays(2017, 13);
    }
}
