package javaBasics;
import java.util.Scanner;
/**
 *Java Basics Ex 8 - Modify your a simple cash register program from assignment one to allow the user to
 *input the names of the products and the prices. The program should then calculate HST
 *(13%) on the product and add the tax to the total price.
 * @author Moustafa Eid
 * @version 9/11/2017
 */
public class A3E2 {
	/**
     *Java Basics Ex 8 - Modify your a simple cash register program from assignment one to allow the user to
     *input the names of the products and the prices. The program should then calculate HST
     *(13%) on the product and add the tax to the total price.
	 */
	public static void main(String[] args) {

		// declaring variables used for prices
		double price1, price2, price3, total, tax;
		final double TAX_RATE = 0.13;
		String item1, item2, item3, taxtitle;
				
		//  giving the string variables strings
		taxtitle = "HST (13%)";
		Scanner input = new Scanner(System.in);
		System.out.print("Enter item 1 name: ");
		item1 = input.nextLine();
		System.out.print("Enter item 1 price: ");
		price1 = input.nextDouble();
		input.nextLine();
		System.out.print("Enter item 2 name: ");
		item2 = input.nextLine();
		System.out.print("Enter item 2 price: ");
		price2 = input.nextDouble();
		input.nextLine();
		System.out.print("Enter item 3 name: ");
		item3 = input.nextLine();
		System.out.print("Enter item 3 price: ");
		price3 = input.nextDouble();
		input.nextLine();

		input.close();
				
		// calculating tax
		tax = (price1 + price2 + price3) * TAX_RATE;
				
		// adding prices together
		total = price1 + price2 + price3 + tax;
				
		// printing the output
		System.out.println("");
		System.out.println("WOSS Gift Shop Receipt");
		System.out.println("----------------------");
		System.out.format("\n%-15s%s%5.2f\n",item1,"$",price1);
		System.out.format("%-15s%s%5.2f\n",item2,"$",price2);
		System.out.format("%-15s%s%5.2f\n",item3,"$",price3);
		System.out.format("%22s\n","-------");
		System.out.format("%-15s%s%5.2f\n",taxtitle,"$",tax);
		System.out.format("%22s\n","-------");
		System.out.format("TOTAL%11s%5.2f\n","$",total);
	}

}
