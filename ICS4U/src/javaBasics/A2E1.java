package javaBasics;
/**
 * Java Basics Ex 4 - Write a program that stores the prices of three items (2.55, 3.20, and 4.00), and that prints
the sum as follows: $2.55 + $3.20 + $4.00 = $9.75
 * @author Moustafa Eid
 * @version 9/7/2017
 */
public class A2E1 {
	/**
	 * Write a program that stores the prices of three items (2.55, 3.20, and 4.00), and that prints
	the sum as follows: $2.55 + $3.20 + $4.00 = $9.75
	 */
	public static void main(String[] args) {
		
		// declaring variables used for prices
		double price1, price2, price3, total;
		
		// giving values to the prices
		price1 = 2.55;
		price2 = 3.20;
		price3 = 4.00;
		
		// adding prices together
		total = price1 + price2 + price3;
		
		// printing the output
		System.out.format("$%.2f + $%.2f + $%.2f = $%.2f",price1,price2,price3,total);		
	}

}
