public class CreditCard {
	
	private static int lastCreditCardNumber;
	private int creditCardNumber;
	private double limit; // you cannot spend more than this limit
	private double balance;
	
	public CreditCard() {
		this(2500);
	}
	
	public CreditCard(double limit) {
		this.limit = limit;
		balance = 0;
		creditCardNumber = lastCreditCardNumber;
		lastCreditCardNumber++;
	}
	
	public boolean pay(double amount) {
		if ((balance - amount) < -limit) {
			balance -= amount;
			return true;
		} else {
			return false;
		}
	}
	
	public int getfCreditCardNumber() {
		return creditCardNumber;
	}
	
}
