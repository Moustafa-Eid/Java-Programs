package javaBasics;
import java.util.Scanner;
/**
 *Java Basics Ex 9 - Prepare a receipt for someone eating lunch in a restaurant. If the meal costs more than
 *$4.00, then an 8% tax is added.
 * @author Moustafa Eid
 * @version 9/19/2017
 */
public class A4E1 {
	/**
     *Java Basics Ex 9 - Prepare a receipt for someone eating lunch in a restaurant. If the meal costs more than
     *$4.00, then an 8% tax is added.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring variables
		double cost, taxcost;
		final double TAX = 0.08;
		
		// creating scanner
		Scanner input = new Scanner(System.in);
		System.out.print("What is the price of your meal? ");
		//getting input
		cost = input.nextDouble();
		input.close();
		
		//calculating tax
		taxcost = (cost * TAX);
		
		// if statement to check if cost is bigger than 4
		if (cost > 4) {
			cost = cost + taxcost;
			// output
			System.out.format("Your total cost for the meal is $%.2f", cost);
		}
		else {
			//output
			System.out.format("Your total cost for the meal is $%.2f", cost);
		}
	}

}
