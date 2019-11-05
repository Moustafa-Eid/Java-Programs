package javaAssignments;
import java.util.Scanner;
/**
 *Java Loops Assignment - Write a program that shows the payment schedule (e.g. a car
 *payment or mortgage payment) based on user input of the amount borrowed, the interest rate 
 *and the monthly payment amount.
 * @author Moustafa Eid
 * @version 9/25/2017
 */
public class EidLoop {
	/**
	 *Java Loops Assignment - Write a program that shows the payment schedule (e.g. a car
	 *payment or mortgage payment) based on user input of the amount borrowed, the interest rate 
	 *and the monthly payment amount.
	 */
	public static void main(String[] args) {
		
		// declaring variables for double amounts
		double initamount, interest, interestpaid = 0, monthlypay, monthlyinterest, principal = 0, remaining = 0;
		
		// declaring variables for month
		int month = 1;
		
		// declaring boolean for loops
		boolean payment = true, run = true;
		
		// starting input scanner variable
		Scanner input = new Scanner(System.in);

		// while loop to take the input from the user until all input is valid
		while (true) {
			// if statement to ask for input
			if (run == true) {
				// ask for initial amount
				System.out.print("Please enter the initial amount: ");
				initamount = input.nextDouble();
				input.nextLine();
				// ask for interest percentage
				System.out.print("Please enter the interest percentage: ");
				interest = input.nextDouble();
				input.nextLine();
				// ask for monthly payment amount
				System.out.print("Please enter the monthly payment amount: ");
				monthlypay = input.nextDouble();
				// calculate monthly interest amount
				double minterest = (interest / 12)*0.01;
				// if statements for error handling
				if (initamount <= 0 || interest < 0 || monthlypay < (initamount * minterest) || initamount < monthlypay) {
					if (initamount <= 0) {
						System.out.println("Invalid Input - Initial Amount");
					}
					if (interest < 0) {
						System.out.println("Invalid Input - Interest");
					}
					if (monthlypay < (initamount * minterest) || initamount < monthlypay) {
						System.out.println("Invalid Input - Monthly Payment");
					}					run = false;
				}
				else {
					break;
				}
			}
			// else if statement to ask for input if input was invalid
			else if (run == false) {
				// ask for initial amount
				System.out.print("Please enter the initial amount: ");
				initamount = input.nextDouble();
				input.nextLine();
				// ask for interest percentage
				System.out.print("Please enter the interest percentage: ");
				interest = input.nextDouble();
				input.nextLine();
				// ask for monthly payment amount
				System.out.print("Please enter the monthly payment amount: ");
				monthlypay = input.nextDouble();
				// calculate monthly interest amount
				double minterest = (interest / 12)*0.01;
				// if statements for error handling
				if (initamount <= 0 || interest < 0 || monthlypay < (initamount * minterest) || initamount < monthlypay ) {
					if (initamount <= 0) {
						System.out.println("Invalid Input - Initial Amount");
					}
					if (interest < 0) {
						System.out.println("Invalid Input - Interest");
					}
					if (monthlypay < (initamount * minterest) || initamount < monthlypay) {
						System.out.println("Invalid Input - Monthly Payment");
					}
					run = true;
				}
				else {
					break;
				}
			}


		}
		
		
		// close input scanner variable
		input.close();

		// calculate montly interest for calculations
		monthlyinterest = (interest / 12)*0.01;

		// output headings
		System.out.format("\n%-22s%-20s%-20s%-20s%-20s\n","Month", "Initial Amount", "Interest", "Principal Paid", "Amount Remaining");

		// while loop for calculating and outputting results
		while (payment == true) {
			// calculates interest paid per month
			interestpaid = initamount * monthlyinterest;
			// calculates how much of the initial amount has been paid each month
			principal = monthlypay - interestpaid;
			// calculates how much is remaining from initial amount each month
			remaining = initamount - principal;
			
			// prints results under header if it is not last month
			if (remaining > 0) {
				System.out.format("%-2d%20s%10.2f%10s%10.2f%10s%10.2f%10s%10.2f\n",month,"$", initamount,"$", interestpaid,"$", principal,"$", remaining);
			}
			// if it is last month then it adjusts for principal amount and remaining amount
			else if (remaining <= 0) {
				// pay all initial amount
				principal = initamount;
				// resets to 0
				remaining = 0;
				// print output
				System.out.format("%-2d%20s%10.2f%10s%10.2f%10s%10.2f%10s%10.2f\n",month,"$", initamount,"$", interestpaid,"$", principal,"$", remaining);
				// stops loop from calculating more and going in to negative
				payment = false;
			}

			// counter for month
			month++;
			// all updates initial amount value after every month
			initamount = remaining;


		}

	}

}
