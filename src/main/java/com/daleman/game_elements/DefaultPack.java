package com.daleman.game_elements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


import static com.daleman.game_elements.GeneralPlayingCard.setSortMode;

/**
 * A default implementation of a pack (of cards) This is fine for highlow,
 * but could be subclassed if necessary, 2 packs for blackjack or include jokers
 * for rummy.
 *
 * @author dale.macdonald
 *
 */
public class DefaultPack implements I_Pack {

    /** An array for constructing the pack - Future implementation may allow such to be passed in */
     public final String [] cardNameArray ={"AS","2S", "3S", "4S", "5S", "6S", "7S", "8S", "9S",
            "10S", "JS", "QS", "KS" , "AH","2H", "3H", "4H", "5H", "6H", "7H", "8H", "9H",
            "10H", "JH", "QH", "KH" , "AD","2D", "3D", "4D", "5D", "6D", "7D", "8D", "9D",
            "10D", "JD", "QD", "KD" , "AC","2C", "3C", "4C", "5C", "6C", "7C", "8C", "9C",
            "10C", "JC", "QC", "KC" };

    //TODO - try to go to PlayingCard, using wild-cards / bounds etc
    protected List<? extends GeneralPlayingCard> packList;


    private	int numOfCards;

    Random random = new Random(System.currentTimeMillis());


    public DefaultPack() {
        packList = getSortedPack();
        numOfCards = packList.size();
    }

    @Override
    public synchronized void  sortPack() {
        Collections.sort(packList);
    }

    @Override
    public synchronized void  reversePack() {
        Collections.reverse(packList);
    }

    @Override
    public synchronized void  shufflePack() {
        Collections.shuffle(packList);
    }

    @Override
    public synchronized I_PlayingCard cutPack() {
        //Random random = new Random(System.currentTimeMillis());
        return cutPack(random.nextInt(52) + 1);
    }

    @Override
    public synchronized I_PlayingCard cutPack(int cutpoint) {
        return packList.get(cutpoint - 1); //TODO is this best based at 1?
    }

    @Override
    public I_PlayingCard dealCard() {
        numOfCards--;
        return packList.remove(0);
    }

    /**
     * A convenience method for checking the number of cards in the pack.
     * @return The number of cards in the pack.
     */
    @Override
    public int getNumOfCards() {
        return numOfCards;
    }

    /**
     * This method refreshes the internal pack holding list, and builds
     * a new one, sorted according to the Sort Type of the cards.
     *
     *
     * @return A fresh, sorted pack
     */
    public List<? extends GeneralPlayingCard> getSortedPack() {
        //packList.clear(); // A fresh pack
        List<GeneralPlayingCard> packL = new ArrayList<>();
        for (String s : cardNameArray) {
            GeneralPlayingCard c = new GeneralPlayingCard(s);
            packL.add(c);
        }
        //Todo: packList = Arrays.asList(cargNameArray);
        packList = packL;
        sortPack();
        numOfCards = packL.size();
        return packL;
    }

    /**
     * Convenience static method to serve up a pack instance.
     *
     * Current implementation returns a new pack instance each time.
     * @return A new Pack instance
     */
    public static I_Pack getInstance() {
        return new DefaultPack();
    }

    @Override
    public String toString() {

        String str = "";
        str += ("[ ");
        for (I_PlayingCard card : packList) {
            str += (card.getName() + ",");
        }
        str = str.substring(0, str.length() - 1);
        str += (" ]");
        return str;
    }

    public static void main(String[] args) {
        I_Pack pack = new DefaultPack();
        System.out.println("Fresh Pack: " + pack.toString());
        pack.shufflePack();
        System.out.println("Shuffled Pack: " + pack.toString());
        ((DefaultPack)pack).getSortedPack();
        System.out.println("Sorted Pack: " + pack.toString());
        pack.reversePack();
        System.out.println("Reversed Pack: " + pack.toString());
        pack.shufflePack();
        System.out.println("Shuffled Pack: " + pack.toString());
        setSortMode(GeneralPlayingCard.SortMode.SORT_POKER_ORDER);
        ((DefaultPack)pack).getSortedPack();
        System.out.println("Poker-Sorted Pack: " + pack.toString());
    }
}
