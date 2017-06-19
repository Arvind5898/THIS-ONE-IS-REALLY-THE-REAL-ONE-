/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg5;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class A5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        while (true) {

            // asking player 1 to enter a word for player 2 to guess
            System.out.println(" Player 1: Enter a word for Player 2 to guess: ");

            // saving the inputed word as "inputedword"
            // creating scanner for user input
            Scanner input = new Scanner(System.in);
            String inputedword = input.nextLine();

            // creating spaces
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");

            // the word's length is transformed into dashes
            int lengthofword = inputedword.length();
            String createddashes = "";
            for (int i = 0; i < lengthofword; i++) {
                createddashes = createddashes + "-";
            }

            System.out.println(createddashes);

            // creating 6 lives and all letters correspond to the word's length
            int correct = lengthofword;
            int maxlives = 6;

            // while zero is less than the amount of lives
            while (correct > 0 && maxlives > 0) {

                // telling player 2 their maximum amount of lives and asking them to guess a letter 
                System.out.println(" Player 2: You have " + maxlives + " lives. You may now guess a letter: ");

                // saving player 2's guessed letter as char
                String guessedletter = input.nextLine();
                char letter = guessedletter.charAt(0);

                int letterio2 = inputedword.indexOf(letter);
                // once the correct letter is guessed
                if (letterio2 >= 0) {
                    while (letterio2 >= 0) {
                        String one = createddashes.substring(0, letterio2);
                        String two = createddashes.substring(letterio2 + 1, lengthofword);
                        // changing the word according to dashes
                        createddashes = one + letter + two;

                        String onee = inputedword.substring(0, letterio2);
                        String twoo = inputedword.substring(letterio2 + 1, lengthofword);
                        // changing order of word
                        inputedword = onee + "+" + twoo;
                        // looking for letter
                        letterio2 = inputedword.indexOf(letter, letterio2 + 1);

                        correct = correct - 1;
                    }
                    // telling the player they got the right answer
                    System.out.println(" The letter you guess is correct! ");
                }
                
                
                // these liines of code are engaged once the player guesses the wrong answer
                else {
                    System.out.println(" That was not the correct letter ");
                    // if the wrong letter is guess, they lose one life 
                    maxlives = maxlives - 1;
                }
            }
            // once the game is won, the player is informed
            if (maxlives > 0) {
                System.out.println(" Good job! You won the game!!!!!!");
            // once the game is lost, the game will inform them what the word was 
            } else if (maxlives == 0) {
                System.out.println(" Sorry you lost the game ");
                System.out.println(" The word player 1 inputed was " + inputedword);
            }

            }

        }

    }

