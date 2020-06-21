package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_HighLowTeam;
import com.daleman.game_elements.I_Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HighLowTeamTest {

    private I_HighLowTeam team;
    private I_Player p1;
    private I_Player p2;
    private I_Player[] players;

    @Before
    public void setUp() {
        team = new HighLowTeam("Kreeps" );
        p1 = new HighLowPlayer("Kreep");
        p2 = new HighLowPlayer("Preezbob");
        players = new HighLowPlayer[2];
    }

    @Test
    public void getTeamName() {
        assertEquals("Kreeps", team.getTeamName());
    }

    @Test
    public void setTeamName() {
        team.setTeamName("Kreeps2");
        assertEquals("Kreeps2", team.getTeamName());
    }

    @Test
    public void getPlayers() {
        I_Player[] fetchedPlayers = team.getPlayers();
        assertEquals(players[0], fetchedPlayers[0]);
        assertEquals(players[1], fetchedPlayers[1]);
    }

    @Test
    public void getPlayer() {
        assertEquals(team.getPlayer(0), players[0]);
        assertEquals(team.getPlayer(1), players[1]);
        assertEquals(team.getPlayer(2), players[0]);
        assertEquals(team.getPlayer(-10), players[0]);
    }

    @Test
    public void setPlayer() {
        team.setPlayer(1, players[1]);
        assertEquals(players[1], team.getPlayer(1));
        I_Player newPlayer = new HighLowPlayer("Newbie");
        team.setPlayer(10, newPlayer);
        assertNotEquals(players[0], team.getPlayer(10));
        assertEquals(newPlayer, team.getPlayer(10));
    }

    @Test
    public void setPlayers() {
        players[0] = new HighLowPlayer("Newbie2");
        team.setPlayers(players);
        assertEquals(players[0], team.getPlayer(0));
    }

    @Test (expected = IllegalArgumentException.class)
    public void setPlayersException() {
        players = new I_Player[3];
        team.setPlayers(players);
    }

    @Test
    public void getScore() {
        assertEquals(0, team.getScore());
    }

    @Test
    public void setScore() {
        team.setScore(11);
        assertEquals(11, team.getScore());
    }
}