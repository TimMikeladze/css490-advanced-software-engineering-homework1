
public class CreditCard
{
	private static int fLastCreditCardNumber;
	private int fCreditCardNumber;
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
		fCreditCardNumber = fLastCreditCardNumber;
		fLastCreditCardNumber++;
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

    public int getfCreditCardNumber() {
        return fCreditCardNumber;
    }

}
