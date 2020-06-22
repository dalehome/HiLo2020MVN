package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_HighLowTeam;
import com.daleman.game_elements.I_Pack;

public class Game {

    private I_HighLowTeam team1;
    private I_HighLowTeam team2;

    private I_Pack pack;

    private Table gameTable;

    public Game(I_HighLowTeam team1, I_HighLowTeam team2, I_Pack pack) {
        this.team1 = team1;
        this.team2 = team2;
        this.pack = pack;

        this.gameTable = new Table(team1, team2);
    }

//    public static Game getGame() {
//        return new Game();
//    }

    public I_HighLowTeam getTeam1() {
        return team1;
    }

    public I_HighLowTeam getTeam2() {
        return team2;
    }

    public I_Pack getPack() {
        return pack;
    }

    public Table getGameTable() {
        return gameTable;
    }

}
