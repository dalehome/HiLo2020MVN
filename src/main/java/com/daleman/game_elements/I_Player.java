package com.daleman.game_elements;


/**
 * General Interface representing a Card Player. Subclasses could represent High Low players,
 * Rummy players etc
 *
 * @author dale.macdonald
 *
 */
public interface I_Player {

    /** Cut a single card view it, but don't remove it from the pack */
    I_PlayingCard cut(I_Pack pack);

    /** Deal out one card from the pack */
    I_PlayingCard dealOne(I_Pack pack);

    /** Return the player's name */
    String getName();

    /**  Play a card from their hand*/
    I_PlayingCard playCard(int num);
}
