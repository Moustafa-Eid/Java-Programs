package javaSorting;

import java.util.Scanner;

public class BankAccount {

	private double balance;
	private String name;
	private int accountNum;
	
	/**
	 * This method makes the variable equal to the global variable for account number
	 * @param acctNum is the account number
	 */
	public BankAccount (Scanner s) {
		this.accountNum = s.nextInt();
		this.balance = s.nextDouble();
		this.name = s.nextLine();
	}
	
	/**
	 * This method is used to deposit money
	 * @param amount to deposit
	 */
	public void deposit (double amount){
		balance += amount;
	}
	
	/**
	 * This method is used to withdraw money
	 * @param amount to withdraw
	 */
	public void withdraw (double amount) {
		if (balance >= amount) {
			balance -= amount;
		}
	}
	
	/**
	 * This method is used to get current balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * This method is used to get current balance
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method is used to get current balance
	 */
	public int getAccountNum() {
		return accountNum;
	}
}
