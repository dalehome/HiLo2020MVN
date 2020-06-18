package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.DefaultPack;
import com.daleman.game_elements.DefaultPackTest;
import com.daleman.game_elements.GeneralPlayingCard;
import com.daleman.game_elements.I_Pack;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class HighLowPackTest  {


    private I_Pack pack;


    @Before
    public void setUp(){
        pack = new HighLowPack();
    }

    /**
     * Test to verify the integrity of the entire pack
     */
    @Test
    public void testPackIntegrity() {
        int score = 0, value = 0;
        List<? extends GeneralPlayingCard> packList = new HighLowPack().getSortedPack();
        for (GeneralPlayingCard c : packList) {
            HighLowCard hlc = (HighLowCard)c;
            score += hlc.getScore();
            value += hlc.getValue();
        }
        assertEquals(80, score);
        assertEquals(416, value);
    }
}