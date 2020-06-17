package com.daleman.highlow.gameobjects;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * A Unit test to check out that HighLowCard objects return the correct scores.
 *
 * This is based on version 4 of JUnit, just for the practice.
 *
 * @author dale
 *
 */
public class HighLowCardTest {

    HighLowCard c1, c2, c3, c4, c5, c6;

    @Before
    public void setUp() {
        c1 = new HighLowCard("10S");
        c2 = new HighLowCard("JC");
        c3 = new HighLowCard("QS");
        c4 = new HighLowCard("KD");
        c5 = new HighLowCard("AH");
        c6 = new HighLowCard("4S");
    }

    @Test
    public void testScores() {

        Assert.assertEquals(c1.getScore(), 10);
        Assert.assertEquals(c2.getScore(), 1);
        Assert.assertEquals(c3.getScore(), 2);
        Assert.assertEquals(c4.getScore(), 3);
        Assert.assertEquals(c5.getScore(), 4);
        Assert.assertEquals(c6.getScore(), 0);
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

