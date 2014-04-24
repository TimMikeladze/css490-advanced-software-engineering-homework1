
public class Main
{
	public static void main(String[] args)
	{
		Bank bank = new Bank("Bank of America");
		int accountnumber = bank.openSimpleCheckingAccount("Bob Smith", "1 Main St.", "12345", "Tacoma", "USA");
		if(bank.withdrawMoney(accountnumber, 2525)) {
            System.out.println("Success");
        }
        else {
            System.out.println("Failure");
        }

	}

}
