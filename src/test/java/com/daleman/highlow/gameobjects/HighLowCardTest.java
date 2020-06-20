package com.daleman.highlow.gameobjects;

import org.junit.*;

import static org.junit.Assert.*;

/**
 * A Unit test to check out that HighLowCard objects return the correct scores.
 *
 * This is based on version 4 of JUnit, just for the practice.
 *
 * @author dale
 *
 */
public class HighLowCardTest {

    HighLowCard c1, c2, c3, c4, c5, c6, c7;

    @Before
    public void setUp() {
        c1 = new HighLowCard("10S");
        c2 = new HighLowCard("JC");
        c3 = new HighLowCard("QS");
        c4 = new HighLowCard("KD");
        c5 = new HighLowCard("AH");
        c6 = new HighLowCard("4S");
        c7 = new HighLowCard("QC");
    }

    @Test
    public void testScores() {

        assertEquals(10, c1.getScore());
        assertEquals(1, c2.getScore());
        assertEquals(2, c3.getScore());
        assertEquals(3, c4.getScore());
        assertEquals(4, c5.getScore());
        assertEquals(0, c6.getScore());
        assertEquals(2, c7.getScore());
    }
    @Test
    @Ignore
    public void testEquals() {
        assertTrue(c1.equals(c1));
        assertNotEquals(c3,c7);
        assertNotEquals(c3,c4);
        HighLowCard hlc1 = new HighLowCard("AH");
        HighLowCard hlc2 = new HighLowCard("AH");
        assertEquals(hlc1,hlc2);
    }

    @After
    public void tearDown() {
        // Not needed of course, but a reasonable demo
        c1 = null;
        c2 = null;
        c3 = null;
        c4 = null;
        c5 = null;
        c6 = null;
    }
}

