package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_HighLowTeam;
import com.daleman.game_elements.I_Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * This represents a team of 2 HighLow Players, holds their names, the Team name, and
 * Game Scores
 *
 * @author dale.macdonald
 */

public class HighLowTeam implements I_HighLowTeam {

    static Logger logger = LoggerFactory.getLogger(HighLowTeam.class);

    private String teamName;

    public I_Player[] players = new HighLowPlayer[2];

    public int score;

    /**
     * Constructor
     * 
     * @param teamName - Designated Team Name
     */
    public HighLowTeam(String teamName) {
        this.teamName = teamName;
    }


    /**
     * Returns designated Team name
     *
     * @return The designated Team Name
     */
    @Override
    public String getTeamName() {
        return teamName;
    }

    /**
     * Mutator to reset the designated Team Name
     *
     * @param teamName - new designated team name
     */
    @Override
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }


    /**
     * Returns the two player objects for the team in an array.
     *
     * @return array of the 2 team players.
     */
    @Override
    public I_Player[] getPlayers() {
        return players;
    }

    /**
     * Convenience method to return the specified player, 0 or 1
     *
     * @param playerNum - number of the player returned (0 or 1)
     * @return the specified player (Player 0 by default for bad request)
     */
    @Override
    public I_Player getPlayer(int playerNum) {
        logger.debug("Entering getPlayer(#) method");
        switch (playerNum) {
            case 1:
                return players[1];
            default:
                return players[0];
        }
    }

    /**
     * Convenience method to set the specified player, 0 or 1
     *
     * @param playerNum which player to set (Player 0 by default for bad request)
     * @param player playe object to be added to team
     */
    @Override
    public void setPlayer(int playerNum, I_Player player) {
        logger.debug("Entering setPlayer(#, player) method");
        switch (playerNum) {
            case 1:
                players[1] = player;
            default:
                players[0] = player;
        }
    }

    /**
     * Convenience method to set the specified player array
     *
     * @param players Must be a 2 element player array
     */
    @Override
    public void setPlayers(I_Player[] players) throws IllegalArgumentException{
        logger.debug("Entering setPlayer(#, player) method");
        if (players.length != 2 ) {
            logger.error("Players array {} must be exactly size 2", Arrays.toString(players));
            throw new IllegalArgumentException("Players array must be exactly size 2");
        }

        this.players = players;
    }

    /**
     * Get current score
     *
     * @return the current score
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * Update the score
     *
     * @param score new value for score
     */
    @Override
    public void setScore(int score) {
        this.score = score;
    }

    public String toString() {
        return "[ HighLow Team: " + teamName + " ]";
    }
}
