
public class CreditCard
{
	private static int fLastCreditCardNumber;
	private int fAccountConnectedTo;
	private int fCreditCardNumber;
	private String fName;
	private String fStreet;
	private String fTown;
	private String fzipCode;
	private String fCountry;
	private double fLimit; // you cannot spend more than this limit
	private double fBalance;

	public CreditCard()
	{
		this(2500);
	}

	public CreditCard(double limit)
	{
		fLimit = limit;
		fBalance = 0;
	}

	public boolean pay(double amount)
	{
		if((fBalance - amount) < -fLimit)
		{
			fBalance -= amount;
			return true;
		}
		else
		{
			return false;
		}
	}
}
