package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_Hand;
import com.daleman.game_elements.I_Pack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HighLowHandTest {

//    HighLowHand hand;
//    HighLowPack pack;

    I_Hand hand;
    I_Pack pack;

    @Before
    public void setUp() {
        hand = new HighLowHand();
        pack = new HighLowPack();

        for (int i = 0; i < 7; i++) {
            hand.receiveDealtCard(pack.dealCard());
        }
    }

    @Test
    public void receiveDealtCard() {

        hand.playCard(0);
        assertEquals(6, hand.howManyCards());
        hand.receiveDealtCard(pack.dealCard());
        assertEquals(new HighLowCard("3C"), hand.playCard(0));
        assertEquals(new HighLowCard("9C"), hand.playCard(5));
        assertEquals(5, hand.howManyCards());
    }

    @Test
    public void playCard() {
        assertEquals(7, hand.howManyCards());
        assertEquals(new HighLowCard("2C"), hand.playCard(0));
        assertEquals(new HighLowCard("8C"), hand.playCard(5));
        assertEquals(5, hand.howManyCards());
    }

    @Test
    public void howManyCards() {
        assertEquals(7, hand.howManyCards());
    }

    @Test
    public void testToString() {
        System.out.println(hand.toString());
        assertEquals(36, hand.toString().length());
    }
}