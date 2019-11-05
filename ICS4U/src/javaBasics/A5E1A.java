package javaBasics;
import java.util.Scanner;
public class A5E1A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;

		Scanner input = new Scanner(System.in);
		System.out.print("Please enter a number: ");
		num = input.nextInt();
		input.close();
		
		System.out.format("%-15s%s","number","factors\n");
		System.out.format("%-15d",num);

		
		for (int factor = 1; factor <= num; factor++) {
			if (num % factor == 0) {
				System.out.format("%d\t", factor);
			}
		}
	}

}
