package com.sda.games.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Card> playerCards = new ArrayList<>();

    public void addCard(Card extractedCard){
        playerCards.add(extractedCard);
    }

    @Override
    public String toString() {
        return "Player cards: " + playerCards;
    }

    public int getTotalPoints(){
        int sum = 0;
        for (Card card:playerCards){
            sum = sum + card.getValue();
        }
        return sum;
    }

    public void checkAcesAtStart(Scanner sc){
        for(Card card:this.playerCards){
            if(card.getValue()==1){
                System.out.println("Please choose the value of the Ace card! [1] or [11]");
                int value = sc.nextInt();
                while(value != 1 && value != 11){
                    System.out.println("Incorrect value! Please choose [1] or [11]");
                    value = sc.nextInt();
                }
                card.setValue(value);
            }
        }
    }
}
