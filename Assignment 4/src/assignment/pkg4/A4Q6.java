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
public class A4Q6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner to get the input of the user 
        Scanner input = new Scanner(System.in);

        System.out.println(" Enter the speed limit: ");
        int limit = input.nextInt();

        System.out.println(" Enter the recorded speed of the car: ");
        int speed = input.nextInt();

        if (speed < limit) {
            System.out.println(" Congratulations, you are within the speed limit! ");
        }

        int limit2 = limit + 21;
        int limit3 = limit + 31;
        

        while (true) {
            if (speed > limit && speed < limit2) {
                System.out.println(" You are speeding and your fine is $100. ");
                break;
            }
            if (speed > limit && speed < limit3) {
                System.out.println(" You are speeding and your fine is $270. ");
                break;
            }
            if (speed > limit3){
                System.out.println(" You are speeding and your fine is $500. ");
                break;
            }

        }

    }
}
