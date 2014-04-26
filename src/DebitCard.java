public class DebitCard {
	
	private static int fLastDebitCardNumber;
	private CheckingAccount fAccountConnectedTo;
	private int fDebitCardNumber;
	
	public DebitCard(CheckingAccount account) {
		fDebitCardNumber = fLastDebitCardNumber;
		fLastDebitCardNumber++;
		fAccountConnectedTo = account;
	}
	
	public boolean pay(double amount) {
		if ((fAccountConnectedTo.getBalance() - amount) < -fAccountConnectedTo.getDebitAmount()) {
			fAccountConnectedTo.setBalance(fAccountConnectedTo.getBalance() - amount);
			return true;
		} else {
			return false;
		}
	}
	
	public int getfDebitCardNumber() {
		return fDebitCardNumber;
	}
	
}
