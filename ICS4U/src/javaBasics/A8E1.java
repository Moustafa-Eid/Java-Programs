package javaBasics;
import java.util.*;

public class A8E1 {

	public static void main(String[] args) {
		
		ArrayList<String> menunames = new ArrayList<String>();
		ArrayList<Double> menuprices = new ArrayList<Double>();

		double money, sum = 0;
		int choice;
		
		menunames.add("Miso Soup");
		menuprices.add(new Double(3.5));
		menunames.add("House Salad");
		menuprices.add(new Double(4));
		menunames.add("Tuna Tataki Salad");
		menuprices.add(new Double(14.95));
		menunames.add("Agedashi Tofu");
		menuprices.add(new Double(6));
		menunames.add("Lemon Grass Beef Skewers");
		menuprices.add(new Double(7.5));
		menunames.add("Chicken Lettuce Wrap");
		menuprices.add(new Double(9.95));
		menunames.add("Samurai Steak 14oz");
		menuprices.add(new Double(29));
		menunames.add("Hotate - Yaki");
		menuprices.add(new Double(12));
		menunames.add("Teriyaki Striploin 8oz");
		menuprices.add(new Double(32));
		menunames.add("The Emperor's Choice");
		menuprices.add(new Double(49));
		menunames.add("Wasabi Chicken");
		menuprices.add(new Double(18));
		menunames.add("Fresh Grilled Shitake Mushrooms");
		menuprices.add(new Double(6.95));
		menunames.add("Fresh Grilled Asparagus");
		menuprices.add(new Double(4.95));
		menunames.add("Teppanyaki Heaven");
		menuprices.add(new Double(89));
		menunames.add("Steamed Rice");
		menuprices.add(new Double(2.5));
		menunames.add("Grilled Tofu");
		menuprices.add(new Double(4.95));
		
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.print("How much money do you have? ");
			money = input.nextDouble();
			
			if (money < 0) {
				System.out.println("Invalid Input");
			}
			else {
				break;
			}
		}

		
		
	
		while (true) {
			
			for (int i = 0; i < menuprices.size(); i++) {
				System.out.println(menuprices.get(i));
				System.out.println(menunames.get(i));
				System.out.println("-----------------");
				if  (menuprices.get(i) > money) {
					System.out.println(menuprices.get(i));
					System.out.println(menunames.get(i));
					System.out.println("-----------------");
					menuprices.remove(i);
					menunames.remove(i);				
				}
			}
			for (int i = 0; i < menuprices.size(); i++) {
				System.out.format("%-3s %-35s%5s%6.2f\n", i+1 + ".", menunames.get(i),"$", menuprices.get(i) );
			}
			
			System.out.println(menunames);
			
			System.out.print("Please Pick a Choice: ");
			choice = input.nextInt();
			
			if (choice >= 1 && choice <= menunames.size()) {
				System.out.println(menuprices.get(choice - 1));
				sum += menuprices.get(choice - 1);
				money -= menuprices.get(choice - 1);
				menuprices.remove(choice-1);
				menunames.remove(choice-1);
			}
			else if (choice == 0) {
				break;
			}
			else {
				System.out.println("Invalid Input");
			}
			if (money < 2.5) {
				System.out.println("You ran out of money\n");
				break;
			}
			System.out.println("\n");

		}
		
		System.out.println("The Total is $" + sum);

	}

}
