package javaBasics;
import java.util.Scanner;
/**
 * Java Basics Ex 10 - Federal income tax is to be levied in stages on taxable income. On the first $27,500 you
 * pay 17%, on the next $27,500 you pay 24%, and on the rest 29%. Write a program to
 * read in a taxable income and compute the federal tax payable to the nearest cent.
 * @author Moustafa Eid
 * @version 9/11/2017
 */

public class A4E2 {
	/**
     *Java Basics Ex 10 - Federal income tax is to be levied in stages on taxable income. On the first $27,500 you
     * pay 17%, on the next $27,500 you pay 24%, and on the rest 29%. Write a program to
     * read in a taxable income and compute the federal tax payable to the nearest cent.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring constants
		final double TAX1 = 0.17;
		final double TAX2 = 0.24;
		final double TAX3 = 0.29;
		
		//declaring variables
		double income, taxpayable1,taxpayable2,taxpayable3, totaltax;
		
		// Creating Scanner
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter your yearly income: ");
		//Getting input
		income = input.nextDouble();
		input.close();
		
		// if statements to calculate tax payable
		if (income <= 27500) {
			taxpayable1 = income * TAX1;
			totaltax = taxpayable1;
			// output
			System.out.format("Your federal income tax is $%.2f" , totaltax);
		}
		else if (income > 27500 && income <= 55000) {
			taxpayable1 = 27500 * TAX1;
			taxpayable2 = (income - 27500) * TAX2;
			totaltax = taxpayable1 + taxpayable2;
			// output
			System.out.format("Your federal income tax is $%.2f" , totaltax);
		}
		else if (income > 55000) {
			taxpayable1 = 27500 * TAX1;
			taxpayable2 = 27500 * TAX2;
			taxpayable3 = (income - 55000) * TAX3;
			totaltax = taxpayable1 + taxpayable2 + taxpayable3;
			
			// output
			System.out.format("Your federal income tax is $%.2f" , totaltax);
		}
		else {
			// output
			System.out.print("Invalid Number, please try again");
		}

	}

}
