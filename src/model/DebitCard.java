
package model;
/**
 * The Debit Card.
 * 
 */

public class DebitCard extends Card {
	
	private CheckingAccount account;
	
	/**
	 * Instantiates a new debit card.
	 * 
	 * @param account the account
	 */
	public DebitCard(CheckingAccount account) {
		this.account = account;
	}
	
	/* (non-Javadoc)
	 * @see Card#pay(double)
	 */
	@Override
	public boolean pay(double amount) {
		return account.withdrawal(amount);
	}
	
}
