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
	
	public int openSimpleCheckingAccount()
	{
		CheckingAccount newAccount = new CheckingAccount("Bob Smith", "1 Main St.", "12345", "Tacoma", "USA");
		fCheckingAccounts.add(newAccount);
		return newAccount.getAccountNumber();
	}
	
	public int openFullPackage()
	{
		CheckingAccount newAccount = new CheckingAccount("Bob Smith", "1 Main St.", "12345", "Tacoma", "USA");
		fCheckingAccounts.add(newAccount);
		newAccount.applyForCreditCard("Bob Smith", "1 Main St.", "12345", "Tacoma", "USA", newAccount.getAccountNumber());
		SavingsAccount newSavingsAccount = new SavingsAccount("Bob Smith", "1 Main St.", "12345", "Tacoma", "USA");
		fSavingAccounts.add(newSavingsAccount);
		DebitCard newDebetCard = new DebitCard("Bob Smith", "1 Main St.", "12345", "Tacoma", "USA", 0, newAccount);
		return newAccount.getAccountNumber();
	}
	
	public boolean withdrawMoney(int accountNumber, double amount)
	{
		CheckingAccount account = new CheckingAccount(accountNumber);
		int index = fCheckingAccounts.indexOf(account);
		return fCheckingAccounts.elementAt(index).withdrawal(amount);
	}
	
}
