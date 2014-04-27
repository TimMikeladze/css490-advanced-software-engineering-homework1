
package model;

/**
 * The Checking account.
 * 
 */

public class CheckingAccount extends Account {
	
	private static final int CREDIT_CARD_REQUIRMENT = 5000;
	private static final double COSTS = 1;
	private static final double DEBIT_RATE = 4.7;
	
	private boolean debitAllowed;
	private double debitAmount;
	private double balance;
	
	private DebitCard debitCard;

	/**
	 * Instantiates a new checking account.
	 * 
	 * @param customer the customer
	 */

	public CheckingAccount(Customer customer) {
		this(customer, 0);
	}

	/**
	 * Instantiates a new checking account.
	 * 
	 * @param customer the customer
	 * @param debit the debit
	 */

	public CheckingAccount(Customer customer, float debit) {
		super(customer);
		debitAllowed = debit > 0 ? true : false;
		debitAmount = debit;
	}
	
	/**
	 * Determine costs.
	 */

	public void determineCosts() {
		balance = balance - COSTS;
		if (balance < 0) {
			balance = balance - (balance * DEBIT_RATE / 100);
		}
	}
	
	/**
	 * Withdrawal.
	 * 
	 * @param amount the amount
	 * @return true, if successful
	 */
	public boolean withdrawal(double amount) {
	    boolean result = false;
	    if (debitAllowed) {
	        if (amount <=debitAmount && balance - amount > 0) {
	            result = true;
	        }
	    }
	    return result;
	}
	
	/**
	 * Deposit.
	 * 
	 * @param amount the amount
	 */
	public void deposit(double amount) {
		balance += amount;
	}

	/**
	 * Apply for credit card.
	 * 
	 * @return true, if successful
	 */
	public boolean applyForCreditCard() {
		boolean result = false;
		if (balance > CREDIT_CARD_REQUIRMENT) {
			customer.addCreditCard(new CreditCard());
			result = true;
		}
		return result;
	}
	
	/**
	 * Adds the debit card.
	 */
	public void addDebitCard() {
		debitCard = new DebitCard(this);
	}

	/**
	 * Gets the balance.
	 * 
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * Increase balance.
	 * 
	 * @param amount the amount
	 */
	public void increaseBalance(double amount) {
		balance += amount;
	}

	/**
	 * Decrease balance.
	 * 
	 * @param amount the amount
	 */
	public void decreaseBalance(double amount) {
		balance -= amount;
	}

	/**
	 * Gets the debit amount.
	 * 
	 * @return the debit amount
	 */
	public double getDebitAmount() {
		return debitAmount;
	}
	
	/**
	 * Sets the balance.
	 * 
	 * @param amount the new balance
	 */
	public void setBalance(double amount) {
		balance = amount;
	}
	
	/**
	 * Gets the debit card.
	 * 
	 * @return the debit card
	 */
	public DebitCard getDebitCard() {
		return debitCard;
	}
}
