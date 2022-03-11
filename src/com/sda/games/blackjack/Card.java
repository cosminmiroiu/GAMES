package com.sda.games.blackjack;

public class Card {
    private int value;
    private final String type;
    private final String suit;

    public Card(int value, String type, String suit){
        this.value = value;
        this.type = type;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return type;
    }
}
