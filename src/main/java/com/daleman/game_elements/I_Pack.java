package com.daleman.game_elements;

/**
 * An interface which represents a general purpose pack of playing card.
 *
 * @author Dale Macdonald
 * @version 1.0
 */
public interface I_Pack {

    /**
     * Sort the pack according to the sort-order of the supplied
     * cards.
     *
     * <B> Ensure that you don't make a pack of cards which have different
     * sort types, or sorting will be erratic</B>
     */
    void sortPack();

    /**
     * Reverse the order of the pack.
     *
     */
     void reversePack();

    /**
     * Shuffle the pack into a nice random order.
     *
     */
     void shufflePack();

    /**
     * Cut the pack randomly and return the card
     *
     * @return The card that is cut.
     */
     I_PlayingCard cutPack();

    /**
     * Cut the pack at the point specified and return the card
     *
     * @param cutpoint - the point within the pack at which to cut.
     * @return The card that is cut.
     */
     I_PlayingCard cutPack(int cutpoint);


    /**
     * Deal a single card from the top of the pack.
     *
     * @return The dealt card
     */
     I_PlayingCard dealCard();

    /**
     * Return the number of cards in the pack.
     *
     * @return The number of cards in the full pack.
     */
     int getNumOfCards();

    /**
     * Deal a card to each player.
     *
     * @param players
     * @return
     */
    /// - We need a player class public abstract PlayingCard dealHand(int players);

    /**
     * Deal
     * @param players
     * @param cards
     * @return
     */
    ///public abstract PlayingCard dealHand(int players, int cards);



}

