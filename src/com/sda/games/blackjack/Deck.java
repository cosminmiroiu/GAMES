package com.sda.games.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Deck {
    private List<Card> cardList = new ArrayList<>();
    private boolean gameStarted = false;

    Deck(){
        this.cardList = getCardList();
    }

    @Override
    public String toString() {
        return "Deck{" +
                "cardList=" + cardList +
                '}';
    }

    private List<Card> getCardList() {

        List<String> suits = new ArrayList<>();
        List<Card> cardList = new ArrayList<>();

        suits.add("Clubs");
        suits.add("Diamonds");
        suits.add("Hearts");
        suits.add("Spades");

        for(int i = 1; i <= 13; i++){
            for(String suit: suits){
                if(i == 1){
                    Card card = new Card(1, "Ace", suit);
                    cardList.add(card);
                } else if(i == 11){
                    Card card = new Card(10, "Jack", suit);
                    cardList.add(card);
                } else if(i == 12){
                    Card card = new Card(10, "Queen", suit);
                    cardList.add(card);
                } else if(i == 13){
                    Card card = new Card(10, "King", suit);
                    cardList.add(card);
                } else {
                    Card card = new Card(i, String.valueOf(i), suit);
                    cardList.add(card);
                }

            }
        }

        return cardList;
    }

    public void shuffle() {

        for (int i = 0; i < 1000; i++) {
            int randomIndex1 = (int) (Math.random() * 52);
            int randomIndex2 = (int) (Math.random() * 52);

            Card c1 = this.cardList.get(randomIndex1);
            Card c2 = this.cardList.get(randomIndex2);

            this.cardList.set(randomIndex1, c2);
            this.cardList.set(randomIndex2, c1);
        }

        // or Collections.shuffle
    }

        public Card drawCard(){
            Card drawCards = this.cardList.get(0);
            this.cardList.remove(0);
            return drawCards;
    }

        public Card drawCard(Scanner sc) {

            Card drawnCard = this.cardList.get(0);
            this.cardList.remove(0);

            if(gameStarted) {
                if (drawnCard.getValue() == 1) {
                    System.out.println("Ace card was drawn. Please choose [1] or [11] value for this card!");
                    int value = sc.nextInt();
                    while (value != 1 && value != 11) {
                        System.out.println("Wrong value! Please choose [1] or [11] value for Ace card!");
                        value = sc.nextInt();
                    }
                    drawnCard.setValue(value);
                }
            }
            return drawnCard;
        }

        public void setGameStarted() {
            this.gameStarted = true;
        }

}
