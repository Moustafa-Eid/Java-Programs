ypackage javaApplets;
/**
 * Accounting program
 * @author Moustafa Eid
 * @version 11/5/2017
 */
public class Account {
	// declaring variables for accounts
	private double balance;
	private int accountNum;
	
	/**
	 * This method makes the variable equal to the global variable for account number
	 * @param acctNum is the account number
	 */
	public Account (int acctNum) {
		this.accountNum = acctNum;
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
}
