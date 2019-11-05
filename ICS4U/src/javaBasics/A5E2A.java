package javaBasics;
import java.util.Scanner;
public class A5E2A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int markinput = 0, marktotal = 0, marknumber = 0,counter = 1;
		double average;
		
		Scanner input = new Scanner(System.in);
		System.out.print("How many marks are there? ");
		marknumber = input.nextInt();
		input.nextLine();
		
		while(counter <= marknumber) {
			System.out.format("Please enter mark number %d: ", counter);
			markinput = input.nextInt();
			input.nextLine();
			
			marktotal += markinput;
			
			counter++;
		}
		
		input.close();
		average = (double) (marktotal / marknumber);
		System.out.format("The average mark is %.2f.",average);
		
		
		
	}

}
