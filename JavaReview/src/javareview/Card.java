/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javareview;

/**
 *
 * @author New User
 */
public class Card {
    private char value;
    private boolean guess=false;
    //no card is guessed

    public Card(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public boolean isGuess() {
        return guess;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void setGuess(boolean guess) {
        this.guess = guess;
    }
    
}
