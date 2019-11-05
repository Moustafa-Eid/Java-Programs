package javaBasics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * Java Basics - Create a Pig Latin generator that takes some text from a file (use data2.txt) and changes it into
 * Pig Latin. A Pig Latin word is made by taking the first letter and putting it on the end and
 * adding an “ay”. For example, “pig” becomes “igpay”.
 * @author Moustafa Eid
 * @version 10/6/2017
 */
public class A6E2 {
	/**
	 * Java Basics - Create a Pig Latin generator that takes some text from a file (use data2.txt) and changes it into
	 * Pig Latin. A Pig Latin word is made by taking the first letter and putting it on the end and
	 * adding an “ay”. For example, “pig” becomes “igpay”.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// variable for file location
		String fileName = "H:\\Files\\data1.txt";
		// declaring variables
		String pigLatinWord = "";
		
		// declaring constant for punctuation
		final String PUNCTUATION = "~!@#$%^&*()_+=-{}[]|\\:;\"'<,>.?/";
		// variable for word
		String word = "";
		// declaring booleans
		boolean ispunctuation = false, uppercase = false;

		// try to open file
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				// store word in variable
				word = ourScanner.next();
				
				// for loop that checks if there is punctuation
				for (int j = 0; j<PUNCTUATION.length();j++) {
					if (word.charAt(word.length() - 1) == PUNCTUATION.charAt(j)) {
						ispunctuation = true;
					}
				}
				// if statement that checks if word starts with uppercase
				if (Character.isUpperCase(word.charAt(0)) == true) {
					uppercase = true;
				}
				// if statement that checks if uppercase and punctuation is true then prints pig latin
				if (ispunctuation == true && uppercase == true) {
					pigLatinWord = word.substring(1,2).toUpperCase() + word.substring(2, word.length()-1) + word.substring(0,1).toLowerCase() + "ay" + word.substring(word.length()-1,word.length()) + " ";
					ispunctuation = false;
					uppercase = false;
				}
				// if statement that checks if uppercases is false and punctuation is true then prints pig latin
				else if (ispunctuation == true && uppercase == false) {
					pigLatinWord = word.substring(1, word.length()-1) + word.substring(0,1) + "ay" + word.substring(word.length()-1,word.length()) + " ";
					ispunctuation = false;
					uppercase = false;
				}
				// if statement that checks if uppercases is true and punctuation is false then prints pig latin
				else if (ispunctuation == false && uppercase == true) {
					pigLatinWord = word.substring(1,2).toUpperCase() + word.substring(2, word.length()) + word.substring(0,1).toLowerCase() + "ay" + " ";
					ispunctuation = false;
					uppercase = false;
				}
				// if statement that checks if uppercases is false and punctuation is false then prints pig latin
				else if (ispunctuation == false && uppercase == false) {
					pigLatinWord = word.substring(1, word.length()) + word.substring(0,1) + "ay" + " ";
					ispunctuation = false;
					uppercase = false;
				}
				// prints final word
				System.out.print(pigLatinWord);


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
