
public class SavingsAccount {
	private int fAccountNumber;
	private String fName;
	private String fStreet;
	private String fZipCode;
	private String fTown;
	private String fCountry;
	private double fBalance;
	private static double costs = 1; // per period there is a cost associated with this account
									// that equals 1 pound
	private static double interestRate = 1.25;
	private static int fNextAccountNumber = 0;
	
	public SavingsAccount(String name, String street, String zipCode, String town, String country)
	{
		fName = name;
		fStreet = street;
		fZipCode = zipCode;
		fTown = town;
		fCountry = country;
		fAccountNumber = fNextAccountNumber;
		fNextAccountNumber++;
	}
	
	public void calculateInterest()
	{
		fBalance = fBalance + (fBalance * interestRate / 100);
	}
	
	public boolean withdrawal(double amount)
	{
		if(((fBalance - amount) < 0))
		{
			return false;
		}
		else
		{
			fBalance = fBalance - amount;
			return true;
		}
	}
	
	public void verseMoney(double amount)
	{
		fBalance += amount;
	}
	
	public void print()
	{
		System.out.println("**************************************");
		System.out.println("Savings account:     " + fAccountNumber);
		System.out.println("Account holder name: " + fName);
		System.out.println("Address:             " + fStreet);
		System.out.print("                     " + fZipCode);
		System.out.println(" " + fTown);
		System.out.println(fCountry.toUpperCase());
		System.out.println("**************************************");
		System.out.println("Balance:  " + fBalance);
		System.out.println("**************************************");
	}
	
	
}
