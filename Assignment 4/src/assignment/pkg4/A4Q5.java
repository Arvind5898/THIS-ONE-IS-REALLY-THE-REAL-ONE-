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
public class A4Q5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner to get the input of the user
        Scanner input = new Scanner(System.in);

        // asking the user to enter their name
        System.out.println(" Please enter your name: ");
        String name = input.nextLine();

        // asking the user to input what the first test was out of
        System.out.println(" What was the first test out of?: ");
        double firsttest = input.nextInt();
        // asking the user what they got on the first test
        System.out.println(" What mark did u get?: ");
        double firstmark = input.nextInt();

        // asking the user to input what the second test was out of
        System.out.println(" What was the second test out of?: ");
        double secondtest = input.nextInt();
        // asking the user what they got on the second test
        System.out.println(" What mark did u get?: ");
        double secondmark = input.nextInt();

        // asking the user to input what the third test was out of
        System.out.println(" What was the third test out of?: ");
        double thridtest = input.nextInt();
        // asking the user what they got on the thrid test
        System.out.println(" What mark did u get?: ");
        double thirdmark = input.nextInt();

        // asking the user to input what the fourth test was out of
        System.out.println(" What was the fourth test out of?: ");
        double fourthtest = input.nextInt();
        // asking the user what they got on the fourth test
        System.out.println(" What mark did u get?: ");
        double fourthmark = input.nextInt();

        // asking the user to input what the fifth test was out of
        System.out.println(" What was the fifth test out of?: ");
        double fifthtest = input.nextInt();
        // asking the user what they got on the fifth test
        System.out.println(" What mark did u get?: ");
        double fifthmark = input.nextInt();

        // calculating the user's test scores in percentages
        System.out.println(" Test Scores for " + name);
        double percent1 = firstmark / firsttest * 100;
        double percent2 = secondmark / secondtest * 100;
        double percent3 = thirdmark / thridtest * 100;
        double percent4 = fourthmark / fourthtest * 100;
        double percent5 = fifthmark / fifthtest * 100;

        // telling the user their test percentages in order of each tests 
        System.out.println(" Test 1: " + percent1 + "%");
        System.out.println(" Test 2: " + percent2 + "%");
        System.out.println(" Test 3: " + percent3 + "%");
        System.out.println(" Test 4: " + percent4 + "%");
        System.out.println(" Test 5: " + percent5 + "%");

        // calculating the user's test score average percentage
        double average = (percent1 + percent2 + percent3 + percent4 + percent5) / 5;

        // telling the user their percent average 
        System.out.println(" Average: " + average + "%");

    }

}
