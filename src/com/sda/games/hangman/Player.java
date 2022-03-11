package com.sda.games.hangman;

public class Player {

    private int playerLives = 3;

    public Player() {}

    public int getPlayerLives() {
        return this.playerLives;
    }

    public void decrementLives() {
        this.playerLives --;
    }
}
