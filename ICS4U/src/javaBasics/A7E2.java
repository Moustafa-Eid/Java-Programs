package javaBasics;
import java.util.*;
/**
 * Java Basics - Create a program that generates 25 random integers between 0 and 99 and then displays all the
 * evens on one line and all the odds on the next line. Make use of ArrayLists in this program.
 * @author Moustafa Eid
 * @version 10/9/2017
 */
public class A7E2 {
	/**
	 * Java Basics - Determine if an array of 5 doubles entered by the user is in sorted order (smallest to largest)
	 * without using the sort method. Output true if it is and false if it is not.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 3 array lists created to store random ,even and odd
		ArrayList<Integer> randomnum = new ArrayList();
		ArrayList<Integer> evennum = new ArrayList();
		ArrayList<Integer> oddnum = new ArrayList();

		// random generator initiated
		Random generator = new Random ( );
		// for loop that adds random numbers to random array
		for (int i = 0; i < 25 ; i++) {
			int num = generator.nextInt(100);
			randomnum.add(new Integer(num));
		}
		
		// for loop that sorts the random numbers in to even and odd then adds it to array
		for (int i = 0; i < randomnum.size(); i++) {
			if (randomnum.get(i) % 2 == 0) {
				evennum.add(randomnum.get(i));
			}
			else {
				oddnum.add(randomnum.get(i));
			}
		}
		
		// prints odd numbers
		System.out.println("ODD:");
		for (int i = 0; i < oddnum.size(); i++) {
			System.out.print(oddnum.get(i) + " ");
		}
		// prints even numbers
		System.out.println("\nEVEN:");
		for (int i = 0; i < evennum.size(); i++) {
			System.out.print(evennum.get(i) + " ");
		}

	}

}
