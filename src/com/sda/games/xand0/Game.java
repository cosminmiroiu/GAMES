package com.sda.games.xand0;

import java.util.Scanner;


public class Game {
    String[][] board = this.generateBoard();
    private int movesLeft = board.length * 3;

    public Game(){}

    private String[][] generateBoard(){
        String[][] board = new String[3][3];

        for(int i=0; i< board.length; i++){
            for(int j=0; j < board.length; j++){
                board[i][j] = "_";
            }
        }
        return board;
    }

    private void printBoard(){

        for(int row=0; row < this.board.length; row++){
            for(int col=0; col < this.board.length; col++){
                System.out.print(this.board[row][col] + " ");
            }
            System.out.println("");
        }
    }

    private void setSymbol(String symbol, Position position){
        this.board[position.getRow()][position.getColumn()] = symbol;
        movesLeft--;
    }

    private boolean isRowWinner(String symbol){
        boolean isWinner = false;

        for (int row = 0; row < this.board.length; row ++) {
            for (int col = 0; col < this.board.length; col++) {
                isWinner = true;
                if (!this.board[row][col].equals(symbol)) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                break;
            }
        }
        return isWinner;
    }

    private boolean isColWinner(String symbol){
        boolean isWinner = false;

        for (int row = 0; row < this.board.length; row ++) {
            for (int col = 0; col < this.board.length; col++) {
                isWinner = true;
                if (!this.board[col][row].equals(symbol)) {
                    isWinner = false;
                    break;
                }
            }
            if (isWinner) {
                break;
            }
        }
        return isWinner;
    }

    private boolean isPrincipalDiagonalWinner(String symbol){
        boolean isWinner = true;

        for(int row = 0; row < this.board.length; row++){
            if (!this.board[row][row].equals(symbol)) {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

    private boolean isSecondaryDiagonalWinner(String symbol){
        boolean isWinner = true;

        for(int row = 0; row < this.board.length; row++){
            if (!this.board[row][this.board.length - row - 1].equals(symbol)) {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

    private boolean gameContinue(){

        boolean shouldGameContinue = isPlayerNotWinner("X") && isPlayerNotWinner("0");

        if(shouldGameContinue) {
            if (this.movesLeft == 0) {
                printBoard();
                System.out.println("Draw game!");
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    private boolean isPlayerNotWinner(String symbol){

        if(isRowWinner(symbol)){
            printBoard();
            System.out.println(symbol + " player win ( line )");
            return false;
        }
        if(isColWinner(symbol)){
            printBoard();
            System.out.println(symbol + " player win ( column )");
            return false;
        }
        if(isPrincipalDiagonalWinner(symbol)){
            printBoard();
            System.out.println(symbol + " player win ( 1st diagonal )");
            return false;
        }
        if(isSecondaryDiagonalWinner(symbol)){
            printBoard();
            System.out.println(symbol + " player win ( 2nd diagonal )");
            return false;
        }

        return true;
    }

    private void nextMove(){
        Scanner sc = new Scanner(System.in).useDelimiter("\\n");
        Position position = new Position();

        if(movesLeft%2==0){
            System.out.println("# 0 TURN #");
            position.getPositionFromPlayer(this.board, sc);
            setSymbol("0", position);
        } else {
            System.out.println("# X TURN #");
            position.getPositionFromPlayer(this.board, sc);
            setSymbol("X", position);
        }
    }

    public void startGame(){
        System.out.println("GAME STARTED");

        while(gameContinue()){
            printBoard();
            nextMove();
        }
    }
}
