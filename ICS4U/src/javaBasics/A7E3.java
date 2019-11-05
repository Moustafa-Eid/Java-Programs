package javaBasics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Java Basics - Determine if a given 3 X 3 matrix (read from file) is a Magic Square. A Magic Square is one
 * such that the sum along each row, column and diagonal are all the same. For a level 4, use a
 * 2D array and make good use of loops in your algorithm.
 * @author Moustafa Eid
 * @version 10/10/2017
 */
public class A7E3 {
	/**
	 * Java Basics - Determine if a given 3 X 3 matrix (read from file) is a Magic Square. A Magic Square is one
	 * such that the sum along each row, column and diagonal are all the same. For a level 4, use a
	 * 2D array and make good use of loops in your algorithm.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// variable for file location
		String fileName = "G:\\Files\\arraydata.txt";
		// variable to create 2d array
		int [] [] table = new int[3] [3];
		// array list for storing magic square numbers
		ArrayList<Integer> magicsquare = new ArrayList();
		// boolean that checks if it is magic square
		boolean ismagicsquare = false;
		// counter variable
		int counter = 0;
		
		// try looking for file
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				// adds number to num then adds it to magic square array
				int num = ourScanner.nextInt();
				magicsquare.add(new Integer(num));

			}				
			ourScanner.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}
		// 2 nested for loops that add magic square numbers to there respective places on 2d array
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				table [i] [j] = magicsquare.get(counter);
				counter++;

			}
		}
		// make variables that equal to sum of rows, columns and diagonals
		int row1 = table [0] [0] + table [0] [1] + table [0] [2];
		int row2 = table [1] [0] + table [1] [1] + table [1] [2];
		int row3 = table [2] [0] + table [2] [1] + table [2] [2];
		int column1 = table [0] [0] + table [1] [0] + table [2] [0];
		int column2 = table [0] [1] + table [1] [1] + table [2] [1];
		int column3 = table [0] [2] + table [1] [2] + table [2] [2];
		int diagonal1 = table [0] [0] + table [1] [1] + table [2] [2];
		int diagonal2 = table [0] [2] + table [1] [1] + table [2] [0];
		
		// if statements to check if rows are equal
		if (row1 == row2 && row1 == row3) {
			// nested if statements to check if columns are equal
			if (row1 == column1 && row1 == column2 && row1 == column3) {
				// nested nested if statements to check if rows are equal
				if (row1 == diagonal1 && row1 == diagonal2) {
					ismagicsquare = true;
				}
				// else is false
				else {
					ismagicsquare = false;
				}
			}
			// else is false

			else {
				ismagicsquare = false;
			}
		}
		// else is false
		else {
			ismagicsquare = false;
		}

		// for loop that prints majic square
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.print(table [i][j] + "\t");
			}
			System.out.println();

		}
		// if statement that prints true if it is a magic square and false if it is not
		if (ismagicsquare = true ) {
			System.out.println("This 3x3 Matrix is a Magic Square.");
		}
		else {
			System.out.println("This 3x3 Matrix is not a Magic Square");
		}






	}

}
