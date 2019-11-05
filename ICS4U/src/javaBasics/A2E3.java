package javaBasics;
/**
 * Java Basics Ex 6 - Write a simple cash register program that stores the product name and cost for three products. 
   The program should then calculate HST (13%) on the product and add the tax to the total price.
   The products are gloves, toque and scarf with the respective prices $12.89, $18.99 and $20.00.
 * @author Moustafa Eid
 * @version 9/7/2017
 */
public class A2E3 {
	/**
	 * Write a simple cash register program that stores the product name and cost for three products. 
   	   The program should then calculate HST (13%) on the product and add the tax to the total price.
   	   The products are gloves, toque and scarf with the respective prices $12.89, $18.99 and $20.00.
	 */
	public static void main(String[] args) {

		// declaring variables used for prices
		double price1, price2, price3, total, tax;
		final double TAX_RATE = 0.13;
		String item1, item2, item3, taxtitle;
		
		//  giving the string variables strings
		item1 = "glove";
		item2 = "toque";
		item3 = "scarf";
		taxtitle = "HST (13%)";
		
		// giving values to the prices
		price1 = 12.89;
		price2 = 18.99;
		price3 = 20.00;
		
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
