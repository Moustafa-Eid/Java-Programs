package javaProgrammingTests;
import java.util.*;
public class EidTest2Q7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// declaring variables
		int [] regular = {1,2, 3};
		int [] flipflop = new int[regular.length];
		
		int half2 = (regular.length / 2), counter = half2;
		
		// if length is even then get half and store to array
		if ((regular.length % 2 == 0)) {
			for (int i = 0; i < half2; i++) {
				flipflop[i] = regular[counter];
				counter++;
			}
		}
		// else odd then get half and store to array
		else {
			for (int i = 0; i <= half2; i++) {
				flipflop[i] = regular[counter];
				counter++;
			}
		}

		// reset counter
		counter = 0;
		// put rest of numbers in second half of array
		for (int i = (regular.length - half2); i < regular.length; i++) {
			flipflop[i] = regular[counter];
			counter++;;
		}
	
		
		// outputs regular array
		System.out.print("[");
		for (int i = 0; i < regular.length; i++) {
			if (i < regular.length -1) {
				System.out.print(regular[i] + "," + " ");

			}
			else {
				System.out.print(regular[i]);

			}
		}
		System.out.print("]");

		System.out.println();
		
		// outputs flip flop array
		System.out.print("[");
		for (int i = 0; i < regular.length; i++) {
			if (i < regular.length -1) {
				System.out.print(flipflop[i] + "," + " ");

			}
			else {
				System.out.print(flipflop[i]);

			}
		}
		System.out.print("]");


		
	}

}
