package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_Pack;
import com.daleman.game_elements.I_Player;
import com.daleman.game_elements.I_PlayingCard;

import java.util.Objects;

/**
 * Object representing individual players in a game of High Low.
 *
 * @author Daleman 2020
 *
 */
public class HighLowPlayer implements I_Player {

    private String name;

    public HighLowPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /** Cut a single card view it, but don't remove it from the pack */
    @Override
    public I_PlayingCard cut(I_Pack pack) {
        return pack.cutPack();
    }

    /** Deal out one card from the pack */
    @Override
    public I_PlayingCard dealOne(I_Pack pack) {
        return pack.dealCard();
    }

    /**  Play a card from the player's hand */
    @Override
    public I_PlayingCard playCard(int num) {
        //Todo: Play a card from a held hand
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HighLowPlayer that = (HighLowPlayer) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "[ Player: " + getName() + " ]";
    }
}
