package javaBasics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * Java Basics - Disemvowelling. A common feature of the txting language is to write words or sentences with
 * the vowels removed. Others can still understand your message, but fewer characters are used,
 * so you can fit more into a text message with a preset character limit.
 * @author Moustafa Eid
 * @version 10/7/2017
 */
public class A6E3 {
	/**
	 * Java Basics - Disemvowelling. A common feature of the txting language is to write words or sentences with
	 * the vowels removed. Others can still understand your message, but fewer characters are used,
	 * so you can fit more into a text message with a preset character limit.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring variables
		String word = "";
		// constant for vowels
		final String VOWELS = "aAeEiIoOuU";
		// variable for file locaion
		String fileName = "G:\\Files\\data3.txt";
		// vowel count variable
		int vowelcount = 0;
		
		// try opening file
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				// word variable 
				word = ourScanner.next() + " ";
				// checks if word has vowels
				for (int i = 0; i<word.length(); i++) {
					char letter = word.charAt(i);
					for (int j = 0; j<VOWELS.length(); j++) {
						char vowel = VOWELS.charAt(j);
						if (letter == vowel) {
							vowelcount += 1;
						}
					}
					// if no vowels then prints
					if (vowelcount == 0) {
						System.out.print(letter);
					}
					// if there is a vowel then reset vowelcount
					else {
						vowelcount = 0;
					}
				}
			}				
			ourScanner.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}
		
	}

}