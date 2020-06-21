package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_Pack;
import com.daleman.game_elements.I_Player;
import com.daleman.game_elements.I_PlayingCard;
import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class HighLowPlayerTest {

    static I_Player player1;
    static I_Player player2;
    static I_Player player3;
    static I_Pack pack;

    @Before
    public void setUp() {
        pack = new HighLowPack();
        player1 = new HighLowPlayer("Kreep");
        player2 = new HighLowPlayer("Kreep");
        player3 = new HighLowPlayer("Kreepo");
    }


    @Test
    public void getName() {
        assertEquals("Kreep", player1.getName());
    }

    @Test
    public void cut() {
//        I_PlayingCard c1 = new HighLowCard("AH");
//        I_PlayingCard c2 = new HighLowCard("AH");

        I_PlayingCard c1 = pack.cutPack();
        I_PlayingCard c2 = pack.cutPack();
        assertNotEquals(c1, c2);
    }

    @Test
    public void dealOne() {

        I_PlayingCard c1 = pack.dealCard();
        I_PlayingCard c2 = pack.dealCard();
        I_PlayingCard c3 = pack.dealCard();
        assertNotEquals(c1, c2);
        assertNotEquals(c1, c3);
        assertNotEquals(c2, c3);
        assertEquals(49, pack.getNumOfCards());
    }

    @Test
    public void playCard() {
        //Todo: Fix this test when Hand is implemented
//        I_PlayingCard c1 = new HighLowCard("2C");
//        assertEquals(player1.dealOne(pack), c1);
//        assertEquals(51, pack.getNumOfCards());
    }

    @Test
    public void testEquals() {
        assertEquals(player1, player2);
        assertNotEquals(player1, player3);
    }

    @Test
    public void testHashCode() {
        //Todo: Maybe later
    }

    @Test
    public void testToString() {
        //Todo: Maybe later
    }
}