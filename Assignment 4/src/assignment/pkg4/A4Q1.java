/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg4;

import java.util.Scanner;

/**
 *
 * @author Owner
 */
public class A4Q1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner to get user input
        Scanner input = new Scanner(System.in);

        // asking the user to type their name 
        System.out.println("Please enter your name");
        // scanning their name into a variable
        String name2 = input.nextLine();
        
        // greeting the user by their name in a friendly manner 
        System.out.println(" Hello " + name2 + ". How are you today?");

    }

}
