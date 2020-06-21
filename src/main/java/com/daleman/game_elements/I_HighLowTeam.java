package com.daleman.game_elements;

public interface I_HighLowTeam {
    String getTeamName();

    void setTeamName(String teamName);

    I_Player[] getPlayers();

    I_Player getPlayer(int playerNum);

    void setPlayer(int playerNum, I_Player player);

    void setPlayers(I_Player[] players);

    int getScore();

    void setScore(int score);
}
