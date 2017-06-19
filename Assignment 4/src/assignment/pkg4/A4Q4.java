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
public class A4Q4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // scanner to get the user's input
        Scanner input = new Scanner(System.in);
        
        System.out.println(" How much does the food for prom cost? : ");
        int foodcost = input.nextInt();
        System.out.println(" How much does the DJ cost? : ");
        int djcost = input.nextInt();
        System.out.println(" How much does it cost to rent the hall? : ");
        int hallcost = input.nextInt();
        System.out.println(" How much does decorations cost? : ");
        int decorationscost = input.nextInt();
        System.out.println(" How much does it cost for staff? : ");
        int staffcost = input.nextInt();
        System.out.println(" How much for miscellaneous costs? : ");
        int miscellaneouscost = input.nextInt();
        
        // calculating the total cost of all the expenses
        int totalcost = foodcost + djcost + hallcost + decorationscost + staffcost + miscellaneouscost;
        
        // calculating how many tickets are needed
        int tickets = totalcost/35;
        
        // Telling the user their total cost of all expenses and the amount of tickets they will need to break even
        System.out.println(" The total cost is $" + totalcost + ". You will need to sell " + tickets + " to break even. ");
        
        
    }
    
}
