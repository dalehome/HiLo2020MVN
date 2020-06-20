package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.GeneralPlayingCard;

import javax.swing.*;
import java.util.Objects;

/**
 * A class which represents a specialised playing card for HiLowJack.
 * <p>
 * Fields stored include name, value, suit and a graphical representation of the
 * card public accessor methods are provided to make these values available
 * <p>
 * This class extends the general Card class and adds specialised score details
 * for HiLowJack.
 *
 * @author Dale Macdonald
 * @version 1.1
 */
public class HighLowCard extends GeneralPlayingCard {

    /**
     * The score a card will return in the "Game" tally of high low
     */
    private int score;

    /**
     * Constructor which accepts a valid String name (eg "10S", "QH" etc)
     * Exceptions are not handled, so ensure the name is valid! Incorrect names
     * lead to spurious card values. Note that case is not catered for, Caps
     * only are supported. A future version may be case-insensitive
     *
     * @param name A valid card name (eg "10S", "QH" etc)
     */

    public HighLowCard(String name) {
        super(name);
        char first = name.charAt(0);
        score = whatScore(first);
    }

    public static void main(String[] args) {
        HighLowCard c;
        try {
            c = new HighLowCard(args[0]);
        } catch (Exception e) {
            String[] arr = {"AD"};
            c = new HighLowCard(arr[0]);
        }

        System.out.printf("Card Name %s%n", c.getName());
        System.out.printf("Card Suit %s%n", c.getSuit());
        System.out.printf("Card Icon %s%n", c.getGraphic());
        System.out.printf("Card Value %s%n", c.getValue());
        System.out.printf("Card Face %s%n", c.getFace());
        System.out.printf("Card Score %s%n", c.getScore());

        System.out.println("\n\n" + c.toString());
    }

    // Accessors

    /**
     * Returns the int score of the card (eg ace = 4, three = 0, ten = 10 etc)
     */
    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        String str = super.toString();
        str += " + [ Score = " + score + " ]";
        return str;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof HighLowCard)) return false;
        if (o == null) return false;
        HighLowCard that = (HighLowCard) o;
        return super.getValue() == that.getValue() &&
                score == that.score &&
                Objects.equals(super.getName(), that.getName()) &&
                Objects.equals(super.getSuit(), that.getSuit()) &&
                Objects.equals(super.getFace(), that.getFace()) ;


    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), score);
    }

    /*
     * Internal methods to produce useable characteristics of Cards
     */
    private int whatScore(char first) {
        switch (first) {
            case '1':
                return 10;
            case 'J':
                return 1;
            case 'Q':
                return 2;
            case 'K':
                return 3;
            case 'A':
                return 4;
            default:
                return 0;
        }
    }
}

