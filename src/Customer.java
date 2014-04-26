import java.util.ArrayList;

public class Customer {
	
	private String name;
	private String street;
	private String town;
	private String zipCode;
	private String country;
	
	private ArrayList<SavingsAccount> savingsAccounts;
	private ArrayList<CheckingAccount> checkingsAccounts;
	private ArrayList<CreditCard> creditCards;
	
	public Customer(String name, String street, String town, String zipCode, String country) {
		this.name = name;
		this.street = street;
		this.town = town;
		this.zipCode = zipCode;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getTown() {
		return town;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getCountry() {
		return country;
	}
	
	public ArrayList<SavingsAccount> getSavingsAccounts() {
		return savingsAccounts;
	}
	
	public ArrayList<CheckingAccount> getCheckingsAccounts() {
		return checkingsAccounts;
	}
	
	public ArrayList<CreditCard> getCreditCards() {
		return creditCards;
	}
	
	public SavingsAccount addSavingsAccount() {
		SavingsAccount account = new SavingsAccount(this);
		savingsAccounts.add(account);
		return account;
	}
	
	public CheckingAccount addCheckingAccount() {
		CheckingAccount account = new CheckingAccount(this);
		checkingsAccounts.add(account);
		return account;
	}
	
	public void addCreditCard(CreditCard card) {
		creditCards.add(card);
	}
	
}
