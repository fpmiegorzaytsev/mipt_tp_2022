package ru.tp.add_01;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LeapTest {

    @Test(expected = IllegalArgumentException.class)
    public void testIsLeap() {

        assertTrue(Leap.isLeap(2000));
        assertTrue(Leap.isLeap(1984));

        assertFalse(Leap.isLeap(2100));
        assertFalse(Leap.isLeap(2013));

        Leap.isLeap(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetMothDay(){

        for (int i = 1; i < 13; i++) {
            assertEquals(30, Leap.GetMonthDays(1930, i));
        }

        assertEquals(29, Leap.GetMonthDays(1984, 2));
        assertEquals(28, Leap.GetMonthDays(1983, 2));

        for (int month : Arrays.asList(4, 6, 9, 11)){
            assertEquals(30, Leap.GetMonthDays(2017, month));

        }

        assertEquals(31, Leap.GetMonthDays(2017, 7));
        Leap.GetMonthDays(2017, 13);
    }
}
