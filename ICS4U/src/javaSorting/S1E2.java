package javaSorting;

import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class S1E3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int search;
		boolean change = false;
		String fileName = "E:\\Files\\numbers2.txt";
		int numbers [] = new int[119];
		int numberssorted [] = new int[119];
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				// store word in variable
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
		
		while (true) {
			int count = 0;
			for (int i = 0; i < numbers.length; i++) {
				if (numbers[i] == ) {
					int temp = numbers[i];
					numbers[i] = numbers[i+1];
					numbers[i+1] = temp;
					change = true;
				}
			}
			if (change == false) {
				break;
			}
			change = false;
		}

		for (int i = 0; i < numbers.length; i++) {
			System.out.print(numbers[i] + ", ");
		}
		
	}

	
	
}
