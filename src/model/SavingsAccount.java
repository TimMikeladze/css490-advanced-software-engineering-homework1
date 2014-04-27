
package model;

/**
 * The Savings Account.
 * 
 */

public class SavingsAccount extends Account {
	
	private static final double INTREREST_RATE = 1.25;
	
	/**
	 * Instantiates a new savings account.
	 * 
	 * @param customer the customer
	 */
	public SavingsAccount(Customer customer) {
		super(customer);
	}
	
	/**
	 * Calculate interest.
	 */
	public void calculateInterest() {
		balance = balance + (balance * INTREREST_RATE / 100);
	}
	
	/**
	 * Withdrawal.
	 * 
	 * @param amount the amount
	 * @return true, if successful
	 */
	public boolean withdrawal(double amount) {
		if (((balance - amount) < 0)) {
			return false;
		} else {
			balance = balance - amount;
			return true;
		}
	}
	
	/**
	 * Deposit.
	 * 
	 * @param amount the amount
	 */
	public void deposit(double amount) {
		balance += amount;
	}
	
}
