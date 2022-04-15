package ru.tp.add_01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AddTest {

    @Test
    public void testAdd() {
        assertEquals(4, Add.add(2, 2));
    }
}
