package com.daleman.game_elements;


import java.util.List;

/**
 * A holder for cards, which can be subclassed for the particular game in question.
 *
 * @author dale.macdonald
 *
 */
public interface I_Hand {

    /** Receive a card dealt to one */
    boolean receiveDealtCard(I_PlayingCard card);

    /** Play the appropriate cars from one's hand */
    I_PlayingCard playCard(int cardnum);

    /** Check how many cards are left*/
    int howManyCards();
}
