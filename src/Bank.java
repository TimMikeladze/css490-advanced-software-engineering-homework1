import java.util.Vector;


public class Bank
{
	private String fName;
	private Vector<CheckingAccount> fCheckingAccounts;
	private Vector<SavingsAccount> fSavingAccounts;

	public Bank(String name)
	{
		fName = name;
		fCheckingAccounts = new Vector<CheckingAccount>();
		fSavingAccounts = new Vector<SavingsAccount>();
	}


	public int openSimpleCheckingAccount(String name, String street, String zipcode, String town, String country)
	{
        CheckingAccount newAccount = new CheckingAccount(name, street, zipcode, town, country);
		fCheckingAccounts.add(newAccount);
		return newAccount.getAccountNumber();
	}

	public int openFullPackage(String name, String street, String zipcode, String town, String country)
	{
	    openSimpleCheckingAccount(name, street, zipcode, town, country);
	    CheckingAccount newAccount = fCheckingAccounts.lastElement();
		newAccount.applyForCreditCard(name, street, zipcode, town, country, newAccount.getAccountNumber());
		SavingsAccount newSavingsAccount = new SavingsAccount(name, street, zipcode, town, country);
	    DebitCard newDebitCard = new DebitCard("Bob Smith", "1 Main St.", "12345", "Tacoma", "USA", newAccount);
		fSavingAccounts.add(newSavingsAccount);
		return newAccount.getAccountNumber();
	}

	public boolean withdrawMoney(int accountNumber, double amount)
	{
		CheckingAccount account = new CheckingAccount(accountNumber);
		int index = fCheckingAccounts.indexOf(account);
		return fCheckingAccounts.elementAt(index).withdrawal(amount);
	}

    public String getfName() {
        return fName;
    }
}