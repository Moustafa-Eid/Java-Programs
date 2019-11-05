package javaBasics;
/**
 * Java Basics Ex 5 - Write a program that stores the prices of three items (2.55, 3.20, and 4.00), and that prints
 * the sum in a table
 * @author Moustafa Eid
 * @version 9/7/2017
 */
public class A2E2 {
	/**
	 * Write a program that stores the prices of three items (2.55, 3.20, and 4.00), and that prints
	 * the sum in a table
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
		System.out.format("Item one:%8.2s%5.2f\n","$",price1);
		System.out.format("Item two:%8.2s%5.2f\n","$",price2);
		System.out.format("Item three:%6.2s%5.2f\n","$",price3);
		System.out.format("%23s\n","-------");
		System.out.format("Total cost%7.2s%5.2f\n","$",total);


	}

}
