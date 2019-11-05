package javaSorting;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * sorts an array of distinct numbers to a 2nd array using simple sorting method
 * @author Moustafa Eid
 * @version 13/12/2017
 */
public class S1E2A {

	/**
	 * a program that sorts an array of distinct numbers to a 2nd array using simple sorting method
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring variables
		int max = 0, count = 0;
		String fileName = "E:\\Files\\numbers2.txt";
		// creating arrays
		int numbers [] = new int[119];
		int numberssorted [] = new int[119];
		
		// a try to see if there is a file, if not then output file not found, if there is then extract numbers from file to array
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				// store number in array
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
		
		// a for loop that goes through array of numbers and finds biggest number
		for (int i = 0; i < numbers.length; i++) {
			// finds max number and sets it to variable of max
			if (numbers[i] > max) {
				max = numbers[i];
			}
		}
		
		// a for loop that goes through every number till max
		for (int j = 0; j < max+1; j++) {
			// a for loop that goes through the index in sortednumbers
			for (int i = 0; i < numberssorted.length; i++) {
				// if numbers is = to j then put it in first index and so on
				if (numbers[i] == j) {
					numberssorted[count] = numbers[i];
					count++;
				}
			}
		}
		
		
		// for loop  that prints the sorted array
		for (int i = 0; i < numberssorted.length; i++) {
			if (i < numberssorted.length - 1) {
				System.out.print(numberssorted[i] + ", ");
			}
			else {
				System.out.print(numberssorted[i]);
			}
		}
		


		
	}

	
	
}
