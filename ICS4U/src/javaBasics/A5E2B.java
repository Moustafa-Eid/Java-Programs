package javaBasics;
import java.util.*;
import java.io.*;

public class A5E2B {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int markinput = 0, marktotal = 0, marknumber = 0;
		double average;
		String fileName = "H:\\Files\\marks.txt";

		// try doing this code, but if an exception occurs
		// catch it so that the program does not crash
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				markinput = ourScanner.nextInt();
				marktotal += markinput;
				marknumber++;
			}
			ourScanner.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}	

		average = (double) (marktotal / marknumber);
		System.out.format("The average mark is %.2f.",average);
	}

}
