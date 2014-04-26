public class DebitCard extends Card {
	
	private CheckingAccount account;
	
	public DebitCard(CheckingAccount account) {
		this.account = account;
	}
	
	@Override
	public boolean pay(double amount) {
		boolean result = false;
		if ((account.getBalance() - amount) < -account.getDebitAmount()) {
			account.setBalance(account.getBalance() - amount);
			result = true;
		}
		return result;
	}
	
}
