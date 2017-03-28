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
public class A4Q7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scaner to get user input
        Scanner input = new Scanner(System.in);
        
        System.out.println(" You are now on square 1. Please enter the number 0 to start");    
        int first = 1;
    
            int last = 100;
           
            int sum = input.nextInt();
        
            int currentposition = sum + first;
        while(true){
            
            System.out.println(" Enter sum of dice: ");
            int sum2 = input.nextInt();
            
            int position = sum2 + currentposition;
            System.out.println(" You are now on square " + position);
            
            
            
        }
    }
}
