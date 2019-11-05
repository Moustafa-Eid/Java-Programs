package javaRecursion;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class A1E5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "G:\\Files\\numbers.txt";
		int numsearch;
		// creating arrays
		int numbers [] = new int[8000];
		// try to get files in to array
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				// store number in Array
				for (int i = 0; i < numbers.length; i ++) {
					numbers [i] = ourScanner.nextInt();
				}

			}
			ourScanner.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}
		

		
		for (int i = 1; i < numbers.length; i++) {
			int temp = numbers[i];
			int pre = i-1;
			// if first number is bigger than 2nd then switch
			while ((numbers[pre] > temp) && (pre > 0)) {
				numbers[pre+1] = numbers[pre];
				pre -= 1;
			}
			if (numbers[pre] > temp) {
				numbers[pre+1] = numbers[pre];
				numbers[pre] = temp;
			}
			else {
				numbers[pre+1] = temp;
			}

		}
		
		Scanner input = new Scanner(System.in);
		System.out.print("What number do you want to search?");
		numsearch = input.nextInt();
		
		if (binarySearch(numbers,numsearch,0,numbers.length) == -1) {
			System.out.println("Sorry the number does not exist in the list.");
		}
		else {
			System.out.println("The number exists at index position " + binarySearch(numbers,numsearch,0,numbers.length) + "." );
			System.out.println(numbers[binarySearch(numbers,numsearch,0,numbers.length)]);
		}
	}
	
	public static int binarySearch(int[]numbers, int search, int left, int right) {
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		if (numbers[mid] == search) {
			return mid;
		}
		else if (numbers[mid] > search) {
			return binarySearch(numbers,search,left,mid-1);
		}
		else if (numbers[mid] < search) {
			return binarySearch(numbers,search,mid+1,right);
		}
		return -1;
	}

}
