public class CheckingAccount extends Account {
	
	private boolean debitAllowed;
	private double debitAmount;
	private double balance;
	private static double costs = 1; // per period there is a cost associated with this account
										// that equals 1 pound
	private static double debitRate = 4.7;
	
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
		balance = balance - costs;
		if (balance < 0) {
			balance = balance - (balance * debitRate / 100);
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
	
	public void verseMoney(double amount) {
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
