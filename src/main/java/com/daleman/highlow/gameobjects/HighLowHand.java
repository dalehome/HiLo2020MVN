package com.daleman.highlow.gameobjects;

import com.daleman.game_elements.I_Hand;
import com.daleman.game_elements.I_PlayingCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class HighLowHand implements I_Hand {

    static Logger logger = LoggerFactory.getLogger(HighLowHand.class);

    List<HighLowCard> cardsL = new ArrayList<>(7);

    /** Add a dealt card to this hand*/
    @Override
    public boolean receiveDealtCard(I_PlayingCard card) {
        logger.debug("Entering receiveDealtCard() method");

        try {
            cardsL.add((HighLowCard) card);
        } catch (Exception e) {
            logger.error("Problem adding card: {} to Hand", card, e);
        }
        return true;
    }

    /** Play the appropriate numbered card from the Hand
     *
     * @param cardnum number from 0 to 6 which card should be played
     *
     * */
    @Override
    public HighLowCard playCard(int cardnum) {
        logger.debug("Entering playCard() method");
        HighLowCard card = null;

        try {
            card = cardsL.remove(cardnum);
        } catch (ClassCastException cce) {
            logger.error("Incorrect Card Type {} supplied to method", card.toString(), cce);
        }
        return card;
    }

    /** @return the number of cards left in the hand*/
    @Override
    public int howManyCards() {
        logger.debug("Entering howManyCards() method");
        return cardsL.size();
    }

    @Override
    public String toString() {

        String s = "";
        for (HighLowCard c : cardsL) {
            s += c.getName() + ", ";
        }
        s = s.substring(0, s.length() - 2);
        return "[ Hand: " + s + " ]";
    }
}
