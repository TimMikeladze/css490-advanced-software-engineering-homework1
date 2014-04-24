import java.util.ArrayList;


public class Bank
{
	private String name;
	private ArrayList<Customer> customers;

	public Bank(String name)
	{
		this.name = name;
		customers = new ArrayList<Customer>();
	}


	public int openSimpleCheckingAccount(Customer customer)
	{
	    customers.add(customer);
	    return customer.addCheckingAccount().getAccountNumber();
	}

	public int openFullPackage(Customer customer) {
	    openSimpleCheckingAccount(customer);
	    CheckingAccount checkingsAccount = customer.getCheckingsAccounts().get(customer.getCheckingsAccounts().size() - 1);
		checkingsAccount.applyForCreditCard();
		customer.addSavingsAccount();
		checkingsAccount.addDebitCard();
		return checkingsAccount.getAccountNumber();
	}

	public boolean withdrawMoney(int accountNumber, double amount)
	{
	    for(Customer customer: customers) {
	        for(CheckingAccount account : customer.getCheckingsAccounts()) {
	            if(account.getAccountNumber() == accountNumber) {
	                account.withdrawal(amount);
	                return true;
	            }
	        }
	    }
	    return false;
	}

    public String getName() {
        return name;
    }
}