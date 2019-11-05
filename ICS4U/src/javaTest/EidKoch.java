package javaTest;

import java.util.Scanner;

public class EidKoch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the Koch Snowflake number ==> ");
		int number = input.nextInt();
		
		System.out.println("There are " + kochNum(number) + " sides.");
	}
	public static int kochNum (int num) {
		if (num == 1) {
			return 3;
		}
		else {
			return kochNum (num-1) * 4;
		}
	}
	
	

}
