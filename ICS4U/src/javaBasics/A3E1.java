package javaBasics;
import java.util.Scanner;
/**
 * Java Basics Ex 9 - Write a program that lets you enter information for your mailing address (your name,
 *address and city) into three variables and print out the complete mailing address
 *surrounded by a box of X’s.
 * @author Moustafa Eid
 * @version 9/11/2017
 */
public class A3E1 {
	/**
	 * Java Basics Ex 9 - Write a program that lets you enter information for your mailing address (your name,
	 *address and city) into three variables and print out the complete mailing address
	 *surrounded by a box of X’s.
	 */
	public static void main(String[] args) {

		// Declaring Variables
		String userName, userAddress, userCity;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your Full Name: ");
		userName = input.nextLine();
		System.out.print("Enter your Address: ");
		userAddress = input.nextLine();
		System.out.print("Enter your City: ");
		userCity = input.nextLine();
		input.close();
		
		System.out.println("\t\t\tXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.format("\t\t\tX %-25s%5s\n",userName,"X");
		System.out.format("\t\t\tX %-25s%5s\n",userAddress,"X");
		System.out.format("\t\t\tX %-25s%5s\n",userCity,"X");
		System.out.println("\t\t\tXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");


	}

}
