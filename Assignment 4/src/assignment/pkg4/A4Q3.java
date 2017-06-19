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
public class A4Q3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner to get user input
        Scanner input = new Scanner(System.in);

        // asking the user to enter 4 numbers on 4 separate lines
        System.out.println(" Please enter 4 numbers on separate lines: ");
        double number = input.nextDouble();
        double number2 = input.nextDouble();
        double number3 = input.nextDouble();
        double number4 = input.nextDouble();

        // Tell the user the 4 numbers they have entered with commas in between them
        System.out.println(" Your numbers were " + number + ", " + number2 + ", " + number3 + ", and " + number4);

    }

}
