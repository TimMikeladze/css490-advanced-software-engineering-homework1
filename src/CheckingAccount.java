public class CheckingAccount extends Account {
	
	private static final double COSTS = 1;
	private static final double DEBIT_RATE = 4.7;
	
	private boolean debitAllowed;
	private double debitAmount;
	private double balance;
	
	private DebitCard debitCard;
	
	public CheckingAccount(Customer customer) {
		this(customer, 0);
	}
	
	public CheckingAccount(Customer customer, float debit) {
		super(customer);
		debitAllowed = debit > 0 ? true : false;
		debitAmount = debit;
	}
	
	public void determineCosts() {
		balance = balance - COSTS;
		if (balance < 0) {
			balance = balance - (balance * DEBIT_RATE / 100);
		}
	}
	
	public boolean withdrawal(double amount) {
		if (((balance - amount) < 0) && (!debitAllowed)) {
			return false;
		} else if ((balance - amount) < -debitAmount) {
			balance = balance - amount;
			return true;
		} else {
			return false;
		}
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	
	public boolean applyForCreditCard() {
		double limit = 0;
		
		if (balance < 0) {
			return false;
		}
		if (balance > 5000) {
			limit = 5000;
		}
		customer.addCreditCard(new CreditCard(limit));
		return true;
	}
	
	public void addDebitCard() {
		debitCard = new DebitCard(this);
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void increaseBalance(double amount) {
		balance += amount;
	}
	
	public void decreaseBalance(double amount) {
		balance -= amount;
	}
	
	public double getDebitAmount() {
		return debitAmount;
	}
	
	public void setBalance(double amount) {
		balance = amount;
	}
	
	public DebitCard getDebitCard() {
		return debitCard;
	}
}
