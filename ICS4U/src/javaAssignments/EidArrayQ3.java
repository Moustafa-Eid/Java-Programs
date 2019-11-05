package javaAssignments;
import java.io.File;

import java.io.FileNotFoundException;
import java.util.*;
/**
 * Java Array Q3 - Make a sorted ArrayList of integers from a file (arrayQ3data.txt) (Note: The file will just
 * contain the list of integers separated by spaces). After the ArrayList is created, find the
 * length and starting location of the longest “run” in the array. A “run” is a sequence of
 * numbers separated by 1, e.g. 3, 4, 5. If there are 2 longest runs, then output the starting
 * location for the first run.
 * @author Moustafa Eid
 * @version 10/13/2017
 */
public class EidArrayQ3 {
	/**
	   * Java Array Q3 - Make a sorted ArrayList of integers from a file (arrayQ3data.txt) (Note: The file will just
	   * contain the list of integers separated by spaces). After the ArrayList is created, find the
	   * length and starting location of the longest “run” in the array. A “run” is a sequence of
	   * numbers separated by 1, e.g. 3, 4, 5. If there are 2 longest runs, then output the starting
	   * location for the first run.
	   */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// declaring variables for files
		String fileName = "H:\\Files\\ArrayQ3data.txt";
		
		// declaring array lists to get numbers and runs and lengths
		ArrayList<Integer> sortednumbers = new ArrayList<Integer>();
		ArrayList<Integer> runlength = new ArrayList<Integer>();
		ArrayList<Integer> runstart = new ArrayList<Integer>();
		
		// declaring counter variables
		int runcounter = 0, maxrunlength = 0, maxrunindex = 0;
		
		// declaring boolean for checking runs
		boolean run = false;
		
		// try to catch any errors in locating the file
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			while(ourScanner.hasNext())
			{
				// add numbers from file to sorted numbers array
				sortednumbers.add(ourScanner.nextInt());
								
			}		
			// close file scanner
			ourScanner.close();
		}
		// catch the error if file not found and output file not found
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}
		
		// for loop that checks if there is a run by checking number after and before
		for (int i = 0; i < sortednumbers.size(); i++) {
			if (i != (sortednumbers.size() - 1)) {
				if ((sortednumbers.get(i+1) - sortednumbers.get(i)) == 1) {
					// all if it is then add to run counter and record start
					runcounter++;
					run = true;
					if (run == true && runcounter == 1) {
						runstart.add(i);
					}
				}
				// if run ended then take length and add it to array
				else if (run == true && (sortednumbers.get(i+1) - sortednumbers.get(i)) != 1) {
					// all if it is then add to run counter
					runcounter++;
					runlength.add(runcounter);
					runcounter = 0;
					run = false;
				}
				
			}
			// if run ended on last number then account for it
			else if (run == true && i == (sortednumbers.size() - 1) ) {
				// all if it is then add to run counter
				runcounter++;
				runlength.add(runcounter);
				runcounter = 0;
				run = false;
			}


		} 
		
		// for loop that prints the sortednumbers array
		for (int i = 0; i < sortednumbers.size(); i++) {
			System.out.print(sortednumbers.get(i) + " ");
		}

		System.out.println();
		// for  loop that prints run start
		for (int i = 0; i < runlength.size(); i++) {
			if (runlength.get(i) > maxrunlength) {
				maxrunlength = runlength.get(i);
				maxrunindex = i;
			}
		}
		
		//  output sentence with everything outputted
		System.out.format("\nThe longest run for this Array starts at index [%d] with %d and ends at index [%d] with  %d and the run has a length of %d numbers.", runstart.get(maxrunindex),sortednumbers.get(runstart.get(maxrunindex)), (runstart.get(maxrunindex))+(maxrunlength-1),sortednumbers.get((runstart.get(maxrunindex))+(maxrunlength-1)), maxrunlength);
		
		









	}

}
