
public class SavingsAccount {
	private int fAccountNumber;
	private double balance;
	private Customer customer;
	private static double costs = 1; // per period there is a cost associated with this account
									// that equals 1 pound
	private static double interestRate = 1.25;
	private static int fNextAccountNumber = 0;

	public SavingsAccount(Customer customer)
	{
		fAccountNumber = fNextAccountNumber;
		fNextAccountNumber++;
	}

	public void calculateInterest()
	{
		balance = balance + (balance * interestRate / 100);
	}

	public boolean withdrawal(double amount)
	{
		if(((balance - amount) < 0))
		{
			return false;
		}
		else
		{
			balance = balance - amount;
			return true;
		}
	}

	public void verseMoney(double amount)
	{
		balance += amount;
	}

	public void print()
	{
		System.out.println("**************************************");
		System.out.println("Savings account:     " + fAccountNumber);
		System.out.println("Account holder name: " + customer.getName());
		System.out.println("Address:             " + customer.getStreet());
		System.out.print("                     " + customer.getZipCode());
		System.out.println(" " + customer.getTown());
		System.out.println(customer.getCountry().toUpperCase());
		System.out.println("**************************************");
		System.out.println("Balance:  " + balance);
		System.out.println("**************************************");
	}


}
