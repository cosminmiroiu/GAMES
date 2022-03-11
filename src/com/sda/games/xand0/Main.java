package com.sda.games.xand0;

/**
 Method to generate game table
 Method for player to choose symbol x or 0 ( if invalid position => error message )
 Method to determine if there are 3 simultaneous symbols on a row/column/diagonals
 **/

public class Main {

    public static void main(String[] args) {
            Game game = new Game();
            game.startGame();
    }

}
