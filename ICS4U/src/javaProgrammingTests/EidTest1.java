package javaProgrammingTests;
import java.util.Scanner;
public class EidTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double applekg = 1, totalapplekg = 0,cost = 0,totalcost = 0, leftover, maxkg = 0, profit = 0, revenue = 0;
		final double rate = 0.85, bonus = 50;
		int count = 1, bagnumber, maxcount = 0;

		while (applekg != 0) {
			System.out.format("Farmer #%d\n", count);
			Scanner input = new Scanner(System.in);
			System.out.print("Number of kg: ") ;
			applekg = input.nextDouble(); 
			input.nextLine();
			if (applekg > -1) {
				totalapplekg += applekg;
				if (applekg > maxkg) {
					maxkg = applekg;
					maxcount = count;
				}
				if (applekg <= 500) {
					cost = applekg * rate;
				}
				else if (applekg > 500) {
					cost = (applekg * rate) + bonus;
				}
				if (applekg != 0) {
					totalcost += cost;
					System.out.format("Purchase Cost: %-2s%7.2f\n\n","$", cost);
				}
				count++;
			}
			else {
				System.out.print("Invalid Input\n\n");
			}


		}
		
		bagnumber = (int) (totalapplekg / 3);
		leftover = (totalapplekg % 3);
		revenue = bagnumber * 4;
		profit = revenue - totalcost;
		
		System.out.format("\nTotal number of bags: %d\n", bagnumber);
		System.out.format("Amount Leftover (in kg): %.1f\n", leftover);
		System.out.format("Max apples: %.2fkg from farmer %d\n\n", maxkg, maxcount);
		System.out.format("Total Revenue: %-2s%7.2f\n", "$", revenue);
		System.out.format("Total Cost:    %-2s%7.2f\n", "$", totalcost);
		System.out.format("               ---------\n", "$", totalcost);
		System.out.format("Total Profit:  %-2s%7.2f\n", "$", profit);

	}

}
