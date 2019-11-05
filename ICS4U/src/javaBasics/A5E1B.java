package javaBasics;
import java.util.Scanner;
public class A5E1B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * A program that prints out the first x number of primes as entered by the user.
		 */

		int primes; //Change to user input 
		int primesFound = 0;
		int num=2;
		int numFactors = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.print("How many Prime numbers? ");
		primes = input.nextInt();
		input.close();
		
		while (primesFound < primes) {
			//This code finds factors for one particular number

			for (int i = 1; i < num+1; i ++) {
				if (num%i==0)
					numFactors++;

			}	
			if (numFactors == 2) {
				System.out.println(num);				
				primesFound++;

			}

			//reset variables to look for the next number
			num++;
			numFactors = 0;

		}

	}
}
