public class SavingsAccount extends Account {
	
	private static final double INTREREST_RATE = 1.25;
	
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
	
	public void deposit(double amount) {
		balance += amount;
	}
	
}
