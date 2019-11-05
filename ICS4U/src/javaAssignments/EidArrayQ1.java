package javaAssignments;
import java.util.*;

/**
 * Java Array Q1 - Write a program that simulates the rolling of two dice. The user inputs how many times
 * to roll the dice. The program then outputs a frequency table of the sum of each roll in the
 * form of a text-based horizontal bar graph (for a Level 4, print the graph as a vertical bar
 * graph).
 * @author Moustafa Eid
 * @version 10/13/2017
 */

public class EidArrayQ1 {
	
	/**
      * Java Array Q1 - Write a program that simulates the rolling of two dice. The user inputs how many times
      * to roll the dice. The program then outputs a frequency table of the sum of each roll in the
      * form of a text-based horizontal bar graph (for a Level 4, print the graph as a vertical bar
      * graph).
	 */
	
	public static void main(String[] args) {
		// Declaring variables to store dice rolls
		int diceroll, dice1, dice2, dicetotal, graphsize = 0;
		
		// Declaring array to store frequency
		int [] frequency = new int[11];
		
		// declaring variable for sum
		final int SUM = 2, DICEMAX = 7;

		// starting random generator and input scanner
		Random generator = new Random ( );
		Scanner input = new Scanner(System.in);
		
		// While loop that asks user how many dice rolls they want until they type in a valid input
		while (true) {
			System.out.print("How many times do you want to roll the dice? ");
			diceroll = input.nextInt();
			if (diceroll >= 0) {
				break;
			}
			else {
				System.out.println("Invalid Input");;
			}
		}
		
		// Close input
		input.close();


		// for loop that rolls dice for however many times the user entered
		for (int i = 0; i < diceroll; i++) {
			dice1 = generator.nextInt(DICEMAX);
			dice2 = generator.nextInt(DICEMAX);
			// if dice rolls are valid meaning they are greater than 0
			if (dice1 != 0 && dice2 != 0) {
				dicetotal = dice1 + dice2;
				for (int j = 0; j < frequency.length; j++) {
					if ( (j + SUM) == dicetotal) {
						frequency [j] += 1;
					}
				}
			}
			// if dice == 1 then reset
			else if (dice1 == 0 || dice2 == 0) {
				diceroll++;
			}
		}
		
		// for loop that gets the graph size
		for (int i = 0; i < frequency.length; i++) {
			if (frequency[i] > graphsize) {
				graphsize = frequency[i];
			}
		}
		
		// prints spaces
		System.out.println("\n\n");

		// while loop that draws the graph
		while (graphsize > 0) {
			// for loop that loops through the array
			for (int j = 0; j < frequency.length; j++) {
				// if the frequency is part of graph size
				if (frequency[j] == graphsize) {
					// print a point
					System.out.format("\t%-3s", "^");
					frequency[j] -= 1;
				}
				// else then print nothing
				else {
					System.out.format("\t%-3s", " ");
				}
			}
			// subtracts graph size to look at next line
			System.out.println();
			graphsize--;
		}
		
		// outputs line between labels and graph
		System.out.println("      --------------------------------------------------------------------------------------");
		
		// for loop that prints labels
		for (int j = 0; j < frequency.length; j++) {
			System.out.format("\t%-3d", j+SUM);
			}
		
		// prints title
		System.out.println("\n\t\t\t\t\t  Sum of 2 Dices");
		
		
		
		
	}

}
