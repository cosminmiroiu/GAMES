package com.sda.games.blackjack;

import java.util.Locale;
import java.util.Scanner;

// Generate a cards deck - checked
// Shuffle method for deck - checked
// Extract first card - checked
// If player gets more than 21 points => game lost - checked
// If player gets 21 points, then black jack! - checked
// Implement dealer class. If dealer has less than 17 points, a card must be extracted
// When game starts, dealer will receive 2 cards ( only one visible for player )
//                   player will receive 2 cards
// Player is able to see first extracted card for dealer
// Dealer game starts when player doesn't want to extract another card
// Player is able to choose the value of the Ace card. Same for dealer
// Homework 5: Show player cards before selecting Ace value - checked

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Player player = new Player();
        Dealer dealer = new Dealer();
        Deck deck = new Deck();

        deck.shuffle();

        initialDeal(deck, player, dealer, sc);
    }

    public static void initialDeal(Deck deck, Player player, Dealer dealer, Scanner sc){
        System.out.println("------------------" + "\n"
                + "|  GAME STARTED  |" + "\n" + "------------------");

        dealer.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard(sc));
        player.addCard(deck.drawCard(sc));

        System.out.println("Dealer cards: [" + dealer.getFirstCard() + ", HIDDEN]");
        System.out.println(player + "\n-------------------");

        startGame(deck, player, dealer, sc);
    }

    public static void startGame(Deck deck, Player player, Dealer dealer, Scanner sc){

        deck.setGameStarted();
        dealer.setGameStarted();
        player.checkAcesAtStart(sc);

        if (player.getTotalPoints() == 21){
            System.out.println("Black jack! Player wins!");
            return;
        } else {
            System.out.println("Player total points: " + player.getTotalPoints() + "\n-------------------");
        }

        boolean play = true;
        while (play) {
            System.out.println("Do you want to draw a card? Y/N");
            String option = sc.next().toUpperCase();

            if(option.equals("Y")){
                player.addCard(deck.drawCard(sc));
                System.out.println(player + " Total points: " + player.getTotalPoints());
                if(player.getTotalPoints() > 21){
                    System.out.println("Dealer wins! Player exceeded 21 points.");
                    play = false;
                } else if(player.getTotalPoints()==21){
                    System.out.println("Black jack! Player wins!");
                    play = false;
                }
            } else {
                play = false;
                dealer.setAcesValuesAtStart(player.getTotalPoints());
                System.out.println(dealer);

                while (dealer.getTotalPoints() < 17 && dealer.getTotalPoints() <= player.getTotalPoints()) {
                    dealer.addCard(deck.drawCard());
                    System.out.println("Dealer got new card!" + "\n" + dealer + " Total points: " + dealer.getTotalPoints());
                }

                if(dealer.getTotalPoints() > 21) {
                    System.out.println("Player wins! Dealer exceeded 21 points.");
                } else if(dealer.getTotalPoints() > player.getTotalPoints()){
                    System.out.println("Dealer wins! Total points: " + dealer.getTotalPoints());
                } else if(dealer.getTotalPoints() == player.getTotalPoints()){
                    System.out.println("Draw game!");
                } else {
                    System.out.println("Player wins!");
                }

            }
        }
    }
}
