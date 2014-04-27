package model;
import java.util.ArrayList;

/**
 * The bank class. Holds all the customers in the bank.
 * 
 */
public class Bank {
	
	private String name;
	private ArrayList<Customer> customers;
	
	/**
	 * Instantiates a new bank.
	 * 
	 * @param name the name
	 */
	public Bank(String name) {
		this.name = name;
		customers = new ArrayList<Customer>();
	}
	
	/**
	 * Open simple checking account.
	 * 
	 * @param customer the customer
	 * @return the int
	 */
	public int openSimpleCheckingAccount(Customer customer) {
		customers.add(customer);
		return customer.addCheckingAccount()
						.getAccountNumber();
	}
	
	/**
	 * Open full package.
	 * 
	 * @param customer the customer
	 * @return the int
	 */
	public int openFullPackage(Customer customer) {
		openSimpleCheckingAccount(customer);
		CheckingAccount checkingsAccount = customer.getCheckingsAccounts()
													.get(customer.getCheckingsAccounts()
																	.size() - 1);
		checkingsAccount.applyForCreditCard();
		customer.addSavingsAccount();
		checkingsAccount.addDebitCard();
		return checkingsAccount.getAccountNumber();
	}
	
	/**
	 * Withdraw money.
	 * 
	 * @param accountNumber the account number
	 * @param amount the amount
	 * @return true, if successful
	 */
	public boolean withdrawMoney(int accountNumber, double amount) {
		for (Customer customer : customers) {
			for (CheckingAccount account : customer.getCheckingsAccounts()) {
				if (account.getAccountNumber() == accountNumber) {
					account.withdrawal(amount);
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Gets the bank name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
}