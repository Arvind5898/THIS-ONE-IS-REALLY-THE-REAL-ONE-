package assignment.pkg4;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Owner
 */
public class A4Q2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner to get user input
        Scanner input = new Scanner(System.in);

        // asking the user to enter the measurement in inches which they wish to convert
        System.out.println("Please enter the measurement in inches you wish to convert :");
        int inch = input.nextInt();
        // converting inches to cm
        double cm = 2.54 * inch;
        if (cm > 0) {
            System.out.println(inch + " inches is the same as " + cm + " cm");
        }

    }

}
