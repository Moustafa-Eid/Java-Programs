package javaSorting;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class S2E1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice = 0,back = 0, choice2 = 0,accountnum;
		double amount;
		boolean change = false;

		String fileName = "E:\\Files\\accounts.txt";
		// creating arrays
		BankAccount accounts [] = new BankAccount[19];

		// a try to see if there is a file, if not then output file not found, if there is then extract numbers from file to array
		try
		{
			// get input from a file
			Scanner ourScanner = new Scanner(new File(fileName));
			// keep looking for more input and count the number of lines in the file
			while(ourScanner.hasNext())
			{
				for (int i = 0; i < accounts.length; i++) {
					accounts[i] = new BankAccount(ourScanner);
 				}
			}
			ourScanner.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("File not Found");
			System.exit(0);
		}


		System.out.println("Welcome to the WOSS Bank!\n");
		System.out.println("What would you like to do?");
		System.out.println("1. Access Account");
		System.out.println("\t1. View Balance");
		System.out.println("\t2. Deposit");
		System.out.println("\t3. Withdraw");
		System.out.println("2. Sort by amount using Bubble Sort");
		System.out.println("3. Sort by ID using Insertion Sort");
		System.out.println("4. Sort by names using Selection Sort\n");

		Scanner input = new Scanner(System.in);
		System.out.print("Enter Selection: ");
		choice = input.nextInt();

		while (true) {
			if (choice == 1) {
				for (int i = 0; i < accounts.length; i++) {
					System.out.print(accounts[i].getAccountNum() + ". ");
					System.out.print(accounts[i].getName());
					System.out.println();
				}
				System.out.print("What account do you want to access? (1-19): ");
				accountnum = input.nextInt();
				System.out.println("1. View Balance");
				System.out.println("2. Deposit");
				System.out.println("3. Withdraw");
				System.out.print("Enter Selection: ");
				choice2 = input.nextInt();
				if (choice2 == 1) {
					System.out.println("\nBalance: $" + accounts[accountnum - 1].getBalance());
				}
				else if (choice2 == 2) {
					System.out.print("How much do you want to deposit? ");
					amount = input.nextDouble();
					accounts[accountnum - 1].deposit(amount);
					System.out.println("\nUpdated Balance: $" + accounts[accountnum - 1].getBalance());
				}
				else if (choice2 == 3) {
					System.out.print("How much do you want to withdraw? ");
					amount = input.nextDouble();
					accounts[accountnum - 1].withdraw(amount);
					System.out.println("\nUpdated Balance: $" + accounts[accountnum - 1].getBalance());
				}
				System.out.print("Enter 0 to go back: ");
				back = input.nextInt();
				if (back == 0) {
					System.out.println("Welcome to the WOSS Bank!\n");
					System.out.println("What would you like to do?");
					System.out.println("1. Access Account");
					System.out.println("\t1. View Balance");
					System.out.println("\t2. Deposit");
					System.out.println("\t3. Withdraw");
					System.out.println("2. Sort by amount using Bubble Sort");
					System.out.println("3. Sort by ID using Insertion Sort");
					System.out.println("4. Sort by names using Selection Sort\n");

					System.out.print("Enter Selection: ");
					choice = input.nextInt();
				}
			}
			else if (choice == 2) {
				while (true) {
					// for loop that goes through numbers
					for (int i = 0; i < accounts.length -1; i++) {
						// if first number is bigger than 2nd then switch
						if (accounts[i].getBalance() > accounts[i+1].getBalance()) {
							BankAccount temp = accounts[i];
							accounts[i] = accounts[i+1];
							accounts[i+1] = temp;
							change = true;
						}
					}
					// if there is no change then break
					if (change == false) {
						break;
					}
					// reset change
					change = false;
				}
				System.out.println("\nAccounts sorted by balance (Least ---> Greatest)");
				for (int i = 0; i < accounts.length; i++) {
					System.out.print(accounts[i].getAccountNum() + ". ");
					System.out.print(accounts[i].getName() + ": $");
					System.out.print(accounts[i].getBalance());
					System.out.println();
				}
				System.out.print("Enter 0 to go back: ");
				back = input.nextInt();
				if (back == 0) {
					System.out.println("Welcome to the WOSS Bank!\n");
					System.out.println("What would you like to do?");
					System.out.println("1. Access Account");
					System.out.println("\t1. View Balance");
					System.out.println("\t2. Deposit");
					System.out.println("\t3. Withdraw");
					System.out.println("2. Sort by amount using Bubble Sort");
					System.out.println("3. Sort by ID using Insertion Sort");
					System.out.println("4. Sort by names using Selection Sort\n");

					System.out.print("Enter Selection: ");
					choice = input.nextInt();
				}
			}
			else if (choice == 3) {
				for (int i = 1; i < accounts.length; i++) {
					// if first number is bigger than 2nd then switch
					while (true) {
						if (i != 0 && accounts[i].getAccountNum() < accounts[i-1].getAccountNum()) {
							BankAccount temp = accounts[i-1];
							accounts[i-1] = accounts[i];
							accounts[i] = temp; 
							i -= 1;
						}
						else {
							break;
						}
					}

				}
				System.out.println("\nAccounts sorted by ID");
				for (int i = 0; i < accounts.length; i++) {
					System.out.print(accounts[i].getAccountNum() + ". ");
					System.out.print(accounts[i].getName() + ": $");
					System.out.print(accounts[i].getBalance());
					System.out.println();
				}
				System.out.print("Enter 0 to go back: ");
				back = input.nextInt();
				if (back == 0) {
					System.out.println("Welcome to the WOSS Bank!\n");
					System.out.println("What would you like to do?");
					System.out.println("1. Access Account");
					System.out.println("\t1. View Balance");
					System.out.println("\t2. Deposit");
					System.out.println("\t3. Withdraw");
					System.out.println("2. Sort by amount using Bubble Sort");
					System.out.println("3. Sort by ID using Insertion Sort");
					System.out.println("4. Sort by names using Selection Sort\n");

					System.out.print("Enter Selection: ");
					choice = input.nextInt();
				}


			}
			else if (choice == 4) {
				for (int i =0; i < accounts.length-1;i++) {
					for (int j = i+1; j <accounts.length;j++) {
						if (accounts[j].getName().compareTo(accounts[i].getName()) < 0) {
							BankAccount temp = accounts[j];
							accounts[j] = accounts[i];
							accounts[i] = temp;
						}
					}
				}
				System.out.println("\nAccounts sorted by names");
				for (int i = 0; i < accounts.length; i++) {
					System.out.print(accounts[i].getAccountNum() + ". ");
					System.out.print(accounts[i].getName() + ": $");
					System.out.print(accounts[i].getBalance());
					System.out.println();
				}
				System.out.print("Enter 0 to go back: ");
				back = input.nextInt();
				if (back == 0) {
					System.out.println("Welcome to the WOSS Bank!\n");
					System.out.println("What would you like to do?");
					System.out.println("1. Access Account");
					System.out.println("\t1. View Balance");
					System.out.println("\t2. Deposit");
					System.out.println("\t3. Withdraw");
					System.out.println("2. Sort by amount using Bubble Sort");
					System.out.println("3. Sort by ID using Insertion Sort");
					System.out.println("4. Sort by names using Selection Sort\n");

					System.out.print("Enter Selection: ");
					choice = input.nextInt();
				}
			}
		}

	}

}
