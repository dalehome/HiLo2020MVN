package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.DefaultPack;
import com.daleman.game_elements.GeneralPlayingCard;

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of a pack (of cards) specifically for High Low.
 *
 * @author dale.macdonald (2020)
 *
 */
public class HighLowPack extends DefaultPack {

    public HighLowPack() {
        super();
        packList = new ArrayList<HighLowCard>();
        packList = getSortedPack();
    }

    /**
     * This method refreshes the internal pack holding list, and builds
     * a new one, sorted according to the Sort Type of the cards.
     *
     *
     * @return A fresh, sorted pack
     */
    @Override
    public List<? extends GeneralPlayingCard> getSortedPack() {

        List<HighLowCard> packL = new ArrayList<>();
        for (String s : cardNameArray) {
            HighLowCard c = new HighLowCard(s);
            packL.add(c);
        }

        sortPack();
        return packL;
    }
}
