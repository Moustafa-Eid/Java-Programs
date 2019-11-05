package javaApplets;
/**
 * Bank application probram to account template
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class Bank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// creating an account named moustafa
		Account Moustafa = new Account(11);
		
		// depositing $200
		Moustafa.deposit(200);
		// withdrawing $20
		Moustafa.withdraw(2000);
		// outputting balance
		System.out.println("You have $" + Moustafa.getBalance() + " in the Bank.");
	}

}
