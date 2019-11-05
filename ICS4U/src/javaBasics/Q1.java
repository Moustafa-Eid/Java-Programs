package javaBasics;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] data = {"Janice","janice","Thompson","thompson","1935","1976","M2M","Jeff","jeff"};
		String fileName = "E:\\Files\\numbers2.txt";

		
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			// store number in array
	
			ourScanner.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}
				
	}

}
