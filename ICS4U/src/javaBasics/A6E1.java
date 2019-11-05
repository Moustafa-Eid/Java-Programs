package javaBasics;
/**
 * Java Basics - Reading a text document from a file (use data1.txt), find the average word length of the words
 * in the text file. (if you want to extend yourself, also calculate the average number of words per
 * sentence)
 * @author Moustafa Eid
 * @version 10/5/2017
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
	/**
	 * Java Basics - Reading a text document from a file (use data1.txt), find the average word length of the words
	 * in the text file. (if you want to extend yourself, also calculate the average number of words per
	 * sentence)
	 */
public class A6E1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// declaring variables
		int numWords = 0, total = 0;
		// declaring file location
		String fileName = "H:\\Files\\data1.txt";
		// declaring punctuation constant
		final String PUNCTUATION = "~!@#$%^&*()_+=-{}[]|\\:;\"'<,>.?/";

		// try opening file
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				// store word in variable
				String word = ourScanner.next();

				// for loop that looks for punctuation and takes it out of word length
				for (int i=0; i<word.length();i++) {
					for (int j = 0; j<PUNCTUATION.length();j++) {
						if (word.charAt(i) == PUNCTUATION.charAt(j)) {
							total--;
						}
					}
				}

				// adds word length to total
				total += word.length();
				numWords++;
			}
			ourScanner.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}
		// output final statement
		System.out.format("The average word length is %.2f letters.", (double) total/numWords);
	}

}
