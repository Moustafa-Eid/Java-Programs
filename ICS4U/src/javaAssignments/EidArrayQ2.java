package javaAssignments;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Java Array Q2 - Make two sorted arrays of integers from a file (arrayQ2data.txt). Then merge these two
 * arrays into one sorted array. This question is to be completed with arrays only and you
 * should not make use of the sort method. The file will contain a number indicating the
 * number of elements in the array followed by the elements in the array itself.
 * @author Moustafa Eid
 * @version 10/13/2017
 */

public class EidArrayQ2 {
 /**
   * Java Array Q2 - Make two sorted arrays of integers from a file (arrayQ2data.txt). Then merge these two
   * arrays into one sorted array. This question is to be completed with arrays only and you
   * should not make use of the sort method. The file will contain a number indicating the
   * number of elements in the array followed by the elements in the array itself.
   */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Declaring variable for file name
		String fileName = "H:\\Files\\ArrayQ2data.txt";
		
		// declaring the 3 array to be used
		int [] sorted1 = new int [0];
		int [] sorted2 = new int [0];
		int [] mergesorted;
		
		// declaring all counter variables
		int counter = 0;
		int mergecounter = 0, sorted1counter = 0, sorted2counter = 0, sorted1len, sorted2len;
		
		// try to catch any errors in locating the file
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			while(ourScanner.hasNext())
			{
				// if nextInt is first number then make it equal to the number of elements of first array
				if (counter == 0) {
					int sorted1num = ourScanner.nextInt();
					sorted1 = new int[sorted1num];
					counter++;
				}
				// if nextInt is in the elements then add it to 1st array
				if (counter > 0 && counter <= sorted1.length) {
					for (int i = 0; i < sorted1.length; i++) {
						sorted1[i] = ourScanner.nextInt();
						counter++;
					}
				}
				// if nextInt is first number after 1st array then make it equal to the number of elements of 2nd array
				if (counter == (sorted1.length +1)) {
					int sorted2num = ourScanner.nextInt();
					sorted2 = new int[sorted2num];
					counter++;
				}
				// if nextInt is in the elements then add it to 2nd array
				if (counter > (sorted1.length+1) && counter <= (sorted2.length + sorted1.length + 1)) {
					for (int i = 0; i < sorted2.length; i++) {
						sorted2[i] = ourScanner.nextInt();
						counter++;
					}
				}
								
			}	
			// close file input
			ourScanner.close();
		}
		// catch the error if file not found and output file not found
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}
		
		// declare merged array with number of elements
		mergesorted = new int[(sorted1.length + sorted2.length)];
		
		// make 2 variables for length of arrays
		sorted1len = sorted1.length;
		sorted2len = sorted2.length;
		
		
		// While loop that merges the 2 array together sorted
		while (sorted1counter < sorted1len && sorted2counter < sorted2len) {
			// if 2nd array number is bigger than first array number
			if (sorted2[sorted2counter] >= sorted1[sorted1counter]) {
				mergesorted[mergecounter] = sorted1[sorted1counter]; // add it to merged array
				sorted1counter += 1;
			}
			// if 2nd array number is smaller than first array number
			else if (sorted2[sorted2counter] < sorted1[sorted1counter]) {
				mergesorted[mergecounter] = sorted2[sorted2counter]; // add it to merged array
				sorted2counter += 1;
			}
			mergecounter += 1;
		}
		
		// While sorted array 2 is still not done
	    while (sorted2len > sorted2counter)
	    {
	        mergesorted[mergecounter] = sorted2[sorted2counter]; // add it to merged array
	        mergecounter++;
	        sorted2counter++;

	    }
	    
		// While sorted array 1 is still not done
		while (sorted1len > sorted1counter) {
	        mergesorted[mergecounter] = sorted1[sorted1counter]; // add it to merged array
	        mergecounter++;
	        sorted1counter++;

	    }
		
	    // output sorted array 1
	    System.out.println("Sorted Array #1");
		for (int i = 0; i < sorted1.length; i++) {
			System.out.print(sorted1[i] + " ");
		}
		
		// output sorted array 2
		System.out.println("\nSorted Array #2");
		for (int i = 0; i < sorted2.length; i++) {
			System.out.print(sorted2[i] + " ");
		}
		
		// output merged array
		System.out.println("\nMerged Sorted Array from #1 and #2");
		for (int i = 0; i < mergesorted.length; i++) {
			System.out.print(mergesorted[i] + " ");
		}
	}

}
