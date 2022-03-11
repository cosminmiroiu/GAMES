package com.sda.games.xand0;

import java.util.Scanner;

public class Position {
    private int row;
    private int column;

    public Position(){ }

    private void isPositionOccupied(String[][] board, Scanner sc){
        while(!board[this.row][this.column].equals("_")){
            System.out.println("Position occupied! Please set symbol again!");
            System.out.print("Row: ");
            this.row = sc.nextInt();
            System.out.print("Column: ");
            this.column = sc.nextInt();
        }
    }

    private void isIndexInRange(String[][] board, Scanner sc){
        while(this.column > board.length || this.row > board.length){
            System.out.println("Enter index in range 0 - " + (board.length - 1)+ ".");
            System.out.print("Row: ");
            this.row = sc.nextInt();
            System.out.print("Column: ");
            this.column = sc.nextInt();
        }
    }

    private void isPositionValid(String[][] board, Scanner sc){
        isIndexInRange(board, sc);
        isPositionOccupied(board, sc);
    }

    public void getPositionFromPlayer(String[][] board, Scanner sc){
        System.out.print("Row: ");
        this.row = sc.nextInt();
        System.out.print("Column: ");
        this.column = sc.nextInt();
        isPositionValid(board, sc);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
