package com.daleman.game_elements;

import javax.swing.Icon;

/**
 * An interface which represents a general purpose playing card. Fields stored
 * include name, value, suit, face and a graphical representation of the card. Additionally ,
 * a "score" which in some games like Bridge can differ from it's representative value.
 *
 * It will be interesting to see how we solve the problem in games like Blackjack,
 * where and Ace can be 11 or 1, for example.
 *
 * Public accessor methods are provided to make these values available.
 *  *
 * This version is updated with
 *
 *
 * @author Dale Macdonald
 * @version 1.2
 */
public interface I_PlayingCard extends Comparable<I_PlayingCard>{

    /**
     * Returns the String name of the card (eg "2C", "JD" etc)
     *
     * @return Card short name
     */
    String getName();

    /**
     * Returns the String suit of the card (eg "Clubs", "Diamonds" etc)
     *
     * @return The suit
     */

    String getSuit();

    /**
     * Returns the Icon name of the card as an Icon reference to an ImageIcon
     * instance which depicts the actual card
     *
     * @return The pictoral representation
     */

    Icon getGraphic();

    /**
     * Returns the int value of the card (eg ace = 14, three = 3 etc)
     *
     * @return the numerical value for comparison
     */

    int getValue();

    /**
     * Return the score of the card, for tally purposes
     * @return What the card will score.
     */
    int getScore();

    /**
     * Returns the String face value of the card (eg "2", "J", "A" etc)
     *
     * @return Card short name
     */
     String getFace();

}
