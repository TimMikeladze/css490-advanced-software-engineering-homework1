package model;

/**
 * Abstract class for cards
 * 
 */
public abstract class Card {
	
	private static int lastCardNumber;
	private int cardNumber;
	
	public Card() {
		cardNumber = lastCardNumber;
		lastCardNumber++;
	}
	
	public abstract boolean pay(double amount);
	
	public int getCardNumber() {
		return cardNumber;
	}
	
}
