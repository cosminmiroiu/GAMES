package com.sda.games.hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private final List<String> wordList;
    private final Player player;
    private final Scanner scanner;

    Game() {
        this.wordList = getTheWordList();
        this.player = new Player();
        this.scanner = new Scanner(System.in);
    }

    public void startGame() {
        String solution = this.getRandomWord();
        String gameWord = solution.replaceAll("[a-zA-Z]", "_");
        String input;

        while (gameWord.contains("_") && this.player.getPlayerLives() > 0) {
            System.out.println("# Write one character and press enter");
            System.out.println(gameWord);
            input = scanner.next().toLowerCase();

            while (input.length() > 1) {
                System.out.println("# Please enter only one character!");
                input = scanner.next().toLowerCase();
            }

            if (!solution.contains(input)) {
                this.player.decrementLives();
                System.out.println("# Wrong character. Player lives: " + this.player.getPlayerLives());
            } else {
                if (gameWord.contains(input)) {
                    System.out.println("# Letter already found!");
                } else {
                    gameWord = this.replaceChar(solution, gameWord, input.charAt(0));
                    System.out.println("Excellent! Chars left: " + this.getNumberOfMissingChars(gameWord));
                }
            }
        }
        if (this.player.getPlayerLives() > 0) {
            System.out.println("Congratulations! You won.");
        } else {
            System.out.println("No more lives. Game lost.");
        }
    }

    private List<String> getTheWordList() {
        List<String> wordList = new ArrayList<>();

        wordList.add("mozilla");
        wordList.add("firefox");
        wordList.add("chrome");

        return wordList;
    }

    private int getListCount() {
        return this.wordList.size();
    }

    private String getRandomWord() {
        return this.wordList.get((int) (Math.random() * this.getListCount()));
    }

    private int getNumberOfMissingChars(String word) {
        int nrOfMissingChars = 0;

        for (int i=0; i < word.length(); i++) {
            if (word.charAt(i) == '_') {
                nrOfMissingChars ++;
            }
        }

        return  nrOfMissingChars;
    }

    private String replaceChar(String solution, String gameWord, char ch) {
        char[] solutionArray = solution.toCharArray();
        char[] gameWordArray = gameWord.toCharArray();

        for (int i = 0; i < solutionArray.length; i++) {
            if (solutionArray[i] == ch) {
                gameWordArray[i] = ch;
            }
        }

        return new String(gameWordArray);
    }

}

