package javaRecursion;

import java.util.*;

public class A1E4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.print("What word do you want to check? ");
		CheckPalindrome(input.nextLine());
		input.close();
		
		
	}
	public static void CheckPalindrome (String word) {
		if (word.equals(WordReverse(word))) {
			System.out.println(word + " is a Palindrome.");
		}
		else {
			System.out.println(word + " is not a Palindrome.");
		}
	}
	public static String WordReverse (String word) {
		if (word.length() == 1) {
			return word;
		}
		return WordReverse(word.substring(1)) + word.charAt(0);
	}
}
