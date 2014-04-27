
package model;
/**
 * The credit card.
 * 
 */
public class CreditCard extends Card {
	
	private double limit; // you cannot spend more than this limit
	private double balance;
	
	public CreditCard() {
		this(2500);
	}
	
	public CreditCard(double limit) {
		this.limit = limit;
	}
	
	@Override
	public boolean pay(double amount) {
		boolean result = false;
		if ((balance + amount) <= limit) {
			balance += amount;
			result = true;
		}
		return result;
	}
	
}
