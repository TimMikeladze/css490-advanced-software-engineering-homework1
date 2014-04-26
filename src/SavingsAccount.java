public class SavingsAccount extends Account {
	
	private static final double INTREREST_RATE = 1.25;
	
	private double balance;
	private Customer customer;
	
	public SavingsAccount(Customer customer) {
		super(customer);
	}
	
	public void calculateInterest() {
		balance = balance + (balance * INTREREST_RATE / 100);
	}
	
	public boolean withdrawal(double amount) {
		if (((balance - amount) < 0)) {
			return false;
		} else {
			balance = balance - amount;
			return true;
		}
	}
	
	public void verseMoney(double amount) {
		balance += amount;
	}
	
	public void print() {
		System.out.println("**************************************");
		System.out.println("Savings account:     " + fAccountNumber);
		System.out.println("Account holder name: " + customer.getName());
		System.out.println("Address:             " + customer.getStreet());
		System.out.print("                     " + customer.getZipCode());
		System.out.println(" " + customer.getTown());
		System.out.println(customer.getCountry()
									.toUpperCase());
		System.out.println("**************************************");
		System.out.println("Balance:  " + balance);
		System.out.println("**************************************");
	}
	
}
