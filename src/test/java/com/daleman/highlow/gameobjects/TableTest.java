package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_HighLowTeam;
import com.daleman.game_elements.I_Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TableTest {

    I_HighLowTeam team1;
    I_HighLowTeam team2;
    Table table;

    @Before
    public void setUp() {
        team1 =  new HighLowTeam("Team#1");
        team2 =  new HighLowTeam("Team#2");

        team1.setPlayer(0, new HighLowPlayer("T1P1"));
        team1.setPlayer(1, new HighLowPlayer("T1P2"));
        team2.setPlayer(0, new HighLowPlayer("T2P1"));
        team2.setPlayer(1, new HighLowPlayer("T2P2"));

        table = new Table(team1, team2);
    }

    @Test
    public void getTp() {
        Table.TablePlayer[] tpArray = table.getTp();
        Table.TablePlayer tp1 =  tpArray[0];
        Table.TablePlayer tp2=  tpArray[3];

        I_Player iPlayer = tp1.getPlayer();
        assertEquals("T1P1", iPlayer.getName());
        iPlayer = tp2.getPlayer();
        assertEquals("T2P2", iPlayer.getName());
    }
}