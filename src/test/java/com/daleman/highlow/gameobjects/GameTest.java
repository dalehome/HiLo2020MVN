package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_HighLowTeam;
import com.daleman.game_elements.I_Pack;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    I_HighLowTeam team1;
    I_HighLowTeam team2;
    I_Pack pack;
    Game game;

    @Before
    public void setUp() {
        team1 =  new HighLowTeam("Team#1");
        team2 =  new HighLowTeam("Team#2");

        team1.setPlayer(0, new HighLowPlayer("T1P1"));
        team1.setPlayer(1, new HighLowPlayer("T1P2"));
        team2.setPlayer(0, new HighLowPlayer("T2P1"));
        team2.setPlayer(1, new HighLowPlayer("T2P2"));

        pack = new HighLowPack();

        game = new Game(team1, team2, pack);
    }

    @Test
    public void getTeam1() {
        assertEquals(team1, game.getTeam1());
    }

    @Test
    public void getTeam2() {
        assertEquals(team2, game.getTeam2());
    }

    @Test
    public void getPack() {
        assertEquals(pack, game.getPack());
    }

    @Test
    public void getGameTable() {
        assertTrue(game.getGameTable() != null);
        assertEquals(game.getGameTable().getTp()[0].getName(), "T1P1");
    }
}