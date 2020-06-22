package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_Hand;
import com.daleman.game_elements.I_HighLowTeam;
import com.daleman.game_elements.I_Player;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Table {

    static final Logger LOGGER = LoggerFactory.getLogger(Table.class);

    TablePlayer[] tp = new TablePlayer[4];

    Table(I_HighLowTeam teamOne, I_HighLowTeam teamTwo) {
        tp[0] = new TablePlayer(teamOne.getPlayer(0), teamOne, new HighLowHand(), 0);
        tp[1] = new TablePlayer(teamTwo.getPlayer(0), teamTwo, new HighLowHand(), 1);
        tp[2] = new TablePlayer(teamOne.getPlayer(1), teamOne, new HighLowHand(), 2);
        tp[3] = new TablePlayer(teamTwo.getPlayer(1), teamTwo, new HighLowHand(), 3);
        LOGGER.info("TablePlayers: {}, {}, {}, {}", tp[0].getName(), tp[1].getName(),
                tp[2].getName(), tp[3].getName());
    }

    /**
     * Return the TablePlayer array for manipulation by the Game Object
     *
     * @return Array of 4 TablePlayers
     *
     */
    public TablePlayer[] getTp() {
        return tp;
    }

    public class TablePlayer {
        I_Player player;
        I_HighLowTeam team;
        I_Hand hand;
        int ordinal;

        TablePlayer(I_Player aPlayer, I_HighLowTeam aTeam, I_Hand aHand, int ordinal) {
            this.player = aPlayer;
            this.team = aTeam;
            this.hand = aHand;
            this.ordinal = ordinal;
        }

        /*  Accessors and Mutators */
        public String getName() { return player.getName(); }

        public I_Player getPlayer() { return player; }

        public I_HighLowTeam getTeam() { return team; }

        public I_Hand getHand() { return hand; }

        public int getOrdinal() { return ordinal; }

        public void setOrdinal(int ordinal) { this.ordinal = ordinal; }

    }

}
