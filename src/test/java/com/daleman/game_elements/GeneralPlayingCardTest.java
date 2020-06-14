package com.daleman.game_elements;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class GeneralPlayingCardTest {

    private static String[] testCards = {"8H", "AS", "JD", "QC"};

    @Test
    public void cardTest() {

        //I_PlayingCard card2 = new GeneralPlayingCard("10D");

        for (String s : testCards) {
            System.out.println(s);
            I_PlayingCard card1 = new GeneralPlayingCard(s);
            assertSame(s, card1.getName());
            assertEquals(whatValue(s.charAt(0)), card1.getValue());
            char  last =  s.charAt(s.length() - 1);
            assertSame(whatSuit(last), card1.getSuit());
            char first = s.charAt(0);
            assertSame(whatValue(first), card1.getValue());
        }
    }

    private int whatValue(char first) {
        switch (first) {
            case '1':
                return 10;
            case 'J':
                return 11;
            case 'Q':
                return 12;
            case 'K':
                return 13;
            case 'A':
                return 14;
            default:
                return (first - 0x30); // Crafty
        }
    }

    private String whatSuit(char last) {
        switch (last) {
            case 'S':
                return "Spades";
            case 'H':
                return "Hearts";
            case 'D':
                return "Diamonds";
            case 'C':
                return "Clubs";
            default:
                return null;
        }
    }
}
