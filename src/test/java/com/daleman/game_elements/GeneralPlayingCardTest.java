package com.daleman.game_elements;

import org.junit.Test;

import javax.swing.*;

import static org.junit.Assert.*;

public class GeneralPlayingCardTest {

    private static String[] testCards = {"8H", "AS", "JD", "QC"};

    private GeneralPlayingCard c1;
    private GeneralPlayingCard c2;
    private GeneralPlayingCard c3;

    @Test
    public void cardTest() {

        // Uncomment to simulate test fails
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

    @Test
    public void logicalSortOrderTest() {
        c1 = new GeneralPlayingCard("AS");
        c2 = new GeneralPlayingCard("KS");
        c3 = new GeneralPlayingCard("AH");

        assertTrue(c1.compareTo(c2) > 0);
        assertTrue(c1.compareTo(c3) > 0);
        assertTrue(c2.compareTo(c3) > 0);

        c1 = new GeneralPlayingCard("10S");
        c2 = new GeneralPlayingCard("KH");
        c3 = new GeneralPlayingCard("AC");

        assertTrue(c1.compareTo(c2) > 0);
        assertTrue(c1.compareTo(c3) > 0);
        assertTrue(c2.compareTo(c3) > 0);

        c1 = new GeneralPlayingCard("8D");
        c2 = new GeneralPlayingCard("KC");
        c3 = new GeneralPlayingCard("2C");

        assertTrue(c1.compareTo(c2) > 0);
        assertTrue(c1.compareTo(c3) > 0);
        assertTrue(c2.compareTo(c3) > 0);
    }

    @Test
    public void testSimpleSortOrder() {
        GeneralPlayingCard.setSortMode(GeneralPlayingCard.SortMode.SORT_SIMPLE_ORDER);
        c1 = new GeneralPlayingCard("AS");
        c2 = new GeneralPlayingCard("KS");
        c3 = new GeneralPlayingCard("AH");

        assertTrue(c1.compareTo(c2) > 0);
        assertEquals(0, c1.compareTo(c3));
        assertTrue(c2.compareTo(c3) < 0);

        c1 = new GeneralPlayingCard("10S");
        c2 = new GeneralPlayingCard("KH");
        c3 = new GeneralPlayingCard("AC");

        assertTrue(c1.compareTo(c2) < 0);
        assertTrue(c1.compareTo(c3) < 0);
        assertTrue(c2.compareTo(c3) < 0);

        c1 = new GeneralPlayingCard("8D");
        c2 = new GeneralPlayingCard("KC");
        c3 = new GeneralPlayingCard("2C");

        assertTrue(c1.compareTo(c2) < 0);
        assertTrue(c1.compareTo(c3) > 0);
        assertTrue(c2.compareTo(c3) > 0);
        GeneralPlayingCard.setSortMode(GeneralPlayingCard.SortMode.SORT_LOGICAL_ORDER);
    }

    @Test
    public void testPokerSortOrder() {
        GeneralPlayingCard.setSortMode(GeneralPlayingCard.SortMode.SORT_POKER_ORDER);
        c1 = new GeneralPlayingCard("AS");
        c2 = new GeneralPlayingCard("KS");
        c3 = new GeneralPlayingCard("AH");

        assertTrue(c1.compareTo(c2) > 0);
        assertTrue(c1.compareTo(c3) > 0);
        assertTrue(c2.compareTo(c3) < 0);

        c1 = new GeneralPlayingCard("10S");
        c2 = new GeneralPlayingCard("KH");
        c3 = new GeneralPlayingCard("AC");

        assertTrue(c1.compareTo(c2) < 0);
        assertTrue(c1.compareTo(c3) < 0);
        assertTrue(c2.compareTo(c3) < 0);

        c1 = new GeneralPlayingCard("8D");
        c2 = new GeneralPlayingCard("KC");
        c3 = new GeneralPlayingCard("2C");

        assertTrue(c1.compareTo(c2) < 0);
        assertTrue(c1.compareTo(c3) > 0);
        assertTrue(c2.compareTo(c3) > 0);
        GeneralPlayingCard.setSortMode(GeneralPlayingCard.SortMode.SORT_LOGICAL_ORDER);
    }

    @Test
    public void testIcon() {
        try {
            displayGraphics();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    private void displayGraphics() throws InterruptedException {

        c1 = new GeneralPlayingCard("8D");
        c2 = new GeneralPlayingCard("KC");
        c3 = new GeneralPlayingCard("2C");

        JDialog dialog = new JDialog((new JFrame()), "Card Viewer", false);
        dialog.getContentPane().add(new JLabel(c1.getName(), c1.getGraphic(), SwingConstants.LEFT));
        dialog.pack();
        dialog.setVisible(true);
        Thread.sleep(2000);

        dialog.getContentPane().removeAll();
        dialog.getContentPane().add(new JLabel(c2.getName(), c2.getGraphic(), SwingConstants.LEFT));
        //dialog.repaint();
        dialog.revalidate();
        Thread.sleep(2000);

        dialog.getContentPane().removeAll();
        dialog.getContentPane().add(new JLabel(c3.getName(), c3.getGraphic(), SwingConstants.LEFT));
        dialog.revalidate();
        Thread.sleep(2000);

        dialog.dispose();
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
