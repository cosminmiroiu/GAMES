package com.sda.games.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private final List<Card> dealerCards = new ArrayList<>();
    boolean gameStarted = false;

    public void addCard(Card extractedCard){

        if(!gameStarted){
            dealerCards.add(extractedCard);
            return;
        }

        if(extractedCard.getValue() == 1){
            if(getTotalPoints() + 11 < 21){
                extractedCard.setValue(11);
                System.out.println("Dealer got an Ace, value 11");
            }
            else
            {
                System.out.println("Dealer got an Ace, value 1");
            }
        }
        dealerCards.add(extractedCard);
    }

    public int getTotalPoints(){
        int sum = 0;
        for (Card card:dealerCards){
            sum = sum + card.getValue();
        }
        return sum;
    }

    public void setAcesValuesAtStart(int playerPoints) {
        Card card = new Card(0, "", "");
        for (int i=0; i < this.dealerCards.size(); i++) {
            if(this.dealerCards.get(i).getValue()==1){
                if(getTotalPoints()+10 >= playerPoints && getTotalPoints()+10 <= 21){
                    card = this.dealerCards.get(i);
                    card.setValue(11);
                    this.dealerCards.set(0, card);
                }
            }
        }
    }


    public void setGameStarted() {
        this.gameStarted = true;
    }

    public String getFirstCard(){
        return this.dealerCards.get(0).getType();
    }

    @Override
    public String toString() {
        return "Dealer cards: " + dealerCards;
    }
}
