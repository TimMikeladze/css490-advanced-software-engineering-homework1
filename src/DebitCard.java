public class DebitCard {
	
	private static int lastDebitCardNumber;
	private CheckingAccount accountConnectedTo;
	private int debitCardNumber;
	
	public DebitCard(CheckingAccount account) {
		debitCardNumber = lastDebitCardNumber;
		lastDebitCardNumber++;
		accountConnectedTo = account;
	}
	
	public boolean pay(double amount) {
		if ((accountConnectedTo.getBalance() - amount) < -accountConnectedTo.getDebitAmount()) {
			accountConnectedTo.setBalance(accountConnectedTo.getBalance() - amount);
			return true;
		} else {
			return false;
		}
	}
	
	public int getfDebitCardNumber() {
		return debitCardNumber;
	}
	
}
