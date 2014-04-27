package model;

/**
 * This is an abstract bank account.
 * 
 */
public abstract class Account {
	
	private static int nextAccountNumber = 0;
	protected Customer customer;
	protected int accountNumber;
	protected double balance;
	
	/**
	 * Instantiates a new account.
	 * 
	 * @param customer the customer
	 */
	public Account(Customer customer) {
		this.customer = customer;
		accountNumber = nextAccountNumber;
		nextAccountNumber++;
	}
	
	/**
	 * Gets the account number.
	 * 
	 * @return the account number
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	
	/**
	 * gets the balance.
	 * 
	 * @return the balance
	 */
	public double getBalance() {
	    return balance;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		return accountNumber == ((Account) o).getAccountNumber() ? true : false;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "**************************************" + "\n";
		s += "Savings account:     " + accountNumber + "\n";
		s += "Account holder name: " + customer.getName() + "\n";
		s += "Address:             " + customer.getStreet() + "\n";
		s += "                     " + customer.getZipCode() + "\n";
		s += " " + customer.getTown() + "\n";
		s += customer.getCountry()
						.toUpperCase() + "\n";
		s += "**************************************" + "\n";
		s += "Balance:  " + balance + "\n";
		s += "**************************************";
		return s;
	}
}
