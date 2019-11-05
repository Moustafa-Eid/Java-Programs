package javaBasics;
import java.util.*;
/**
 * Java Basics - Determine if an array of 5 doubles entered by the user is in sorted order (smallest to largest)
 * without using the sort method. Output true if it is and false if it is not.
 * @author Moustafa Eid
 * @version 10/8/2017
 */
public class A7E1 {
	/**
	 * Java Basics - Determine if an array of 5 doubles entered by the user is in sorted order (smallest to largest)
	 * without using the sort method. Output true if it is and false if it is not.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// array that stores numbers
		double [] num = new double [5];
		// bolean and counter variable for sorted array
		int counter = 0;
		boolean sorted;
		
		// input scanner initiated
		Scanner input = new Scanner(System.in);
		// asks for input
		System.out.print("Please enter 5 numbers: ");
		// stores input in array with for loop
		for (int i = 0; i< num.length; i++) {
			num[i] = input.nextDouble();
		}
		input.close();
		
		// if number is smaller then number after then it is sorted
		for (int i = 0; i < (num.length-1); i++) {
			if (num[i] < num[i+1]) {
				counter += 1;
			}
		}
		// if counter variable is 4 then it is sorted
		if (counter == 4) {
			sorted = true;
		}
		// else it is not sorted
		else {
			sorted = false;
		}
		System.out.println("Is the Array Sorted? " + sorted);
		
	}

}
