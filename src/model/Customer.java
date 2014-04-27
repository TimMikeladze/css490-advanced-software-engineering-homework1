package model;
import java.util.ArrayList;

/**
 * The customer class.
 * 
 */
public class Customer {
	
	private String name;
	private String street;
	private String town;
	private String zipCode;
	private String country;
	
	private ArrayList<SavingsAccount> savingsAccounts = new ArrayList<SavingsAccount>();
	private ArrayList<CheckingAccount> checkingsAccounts = new ArrayList<CheckingAccount>();
	private ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();
	
	/**
	 * Instantiates a new customer.
	 * 
	 * @param name the name
	 * @param street the street
	 * @param town the town
	 * @param zipCode the zip code
	 * @param country the country
	 */
	public Customer(String name, String street, String town, String zipCode, String country) {
		this.name = name;
		this.street = street;
		this.town = town;
		this.zipCode = zipCode;
		this.country = country;
	}
	
	/**
	 * Gets the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Gets the street.
	 * 
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * Gets the town.
	 * 
	 * @return the town
	 */
	public String getTown() {
		return town;
	}
	
	/**
	 * Gets the zip code.
	 * 
	 * @return the zip code
	 */
	public String getZipCode() {
		return zipCode;
	}
	
	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Gets the savings accounts.
	 * 
	 * @return the savings accounts
	 */
	public ArrayList<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}
	
	/**
	 * Gets the checkings accounts.
	 * 
	 * @return the checkings accounts
	 */
	public ArrayList<CheckingAccount> getCheckingsAccounts() {
		return checkingsAccounts;
	}
	
	/**
	 * Gets the credit cards.
	 * 
	 * @return the credit cards
	 */
	public ArrayList<CreditCard> getCreditCards() {
		return creditCards;
	}
	
	/**
	 * Adds the savings account.
	 * 
	 * @return the savings account
	 */
	public SavingsAccount addSavingsAccount() {
		SavingsAccount account = new SavingsAccount(this);
		savingsAccounts.add(account);
		return account;
	}
	
	/**
	 * Adds the checking account.
	 * 
	 * @return the checking account
	 */
	public CheckingAccount addCheckingAccount() {
		CheckingAccount account = new CheckingAccount(this);
		checkingsAccounts.add(account);
		return account;
	}
	
	/**
	 * Adds the credit card.
	 * 
	 * @param card the card
	 */
	public void addCreditCard(CreditCard card) {
		creditCards.add(card);
	}
	
}
