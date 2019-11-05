package javaSorting;

import java.io.File;

import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Sort using bubble sort
 * @author Moustafa Eid
 * @version 13/12/2017
 */
public class S1E3 {

	/**
	 * sorting numbers using bubble sort and 1 array from a file
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring variables
		int search;
		boolean change = false;
		String fileName = "E:\\Files\\numbers.txt";
		// creating arrays
		int numbers [] = new int[8000];
		// try to get files in to array
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				// store number in Array
				for (int i = 0; i < numbers.length; i ++) {
					numbers [i] = ourScanner.nextInt();
				}

			}
			ourScanner.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}
		
		// while loop that goes through array
		while (true) {
			// for loop that goes through numbers
			for (int i = 0; i < numbers.length -1; i++) {
				// if first number is bigger than 2nd then switch
				if (numbers[i] > numbers[i+1]) {
					int temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
					change = true;
				}
			}
			// if there is no change then break
			if (change == false) {
				break;
			}
			// reset change
			change = false;
		}

		// for loop that prints array and outputs to console
		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
		
	}

	
	
}
