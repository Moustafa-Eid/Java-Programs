package javaSorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * searches if a number is in the file
 * @author Moustafa Eid
 * @version 13/12/2017
 */
public class S1E1 {

	/**
	 * a program that searches for numbers in file.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring variables
		int search;
		boolean contains = false;
		String fileName = "E:\\Files\\numbers.txt";
		// creating array to hold numbers
		int numbers [] = new int[8000];
		
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
		
		// ask for input on what to search
		Scanner scanner = new Scanner(System.in);
		System.out.print("What number do you want to search? ");
		// add it to a variable
		search = scanner.nextInt();
		
		// for loop that goes through array
		for (int i = 0; i < numbers.length; i++) {
			// checks if number is in array and then breaks
			if (numbers[i] == search) {
				contains = true;
				break;
			}
		}
		
		// output if true yes, if false no
		if (contains == true) {
			System.out.println("The number " + search + " is in the file.");
		}
		else {
			System.out.println("The number " + search + " is not in the file.");

		}
		
	}

}
