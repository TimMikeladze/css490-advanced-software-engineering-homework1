public abstract class Account {
	
	protected Customer customer;
	private int accountNumber;
	private static int nextAccountNumber = 0;
	
	public Account(Customer customer) {
		this.customer = customer;
		accountNumber = nextAccountNumber;
		nextAccountNumber++;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	@Override
	public boolean equals(Object o) {
		return accountNumber == ((Account) o).getAccountNumber() ? true : false;
	}
	
	@Override
	public String toString() {
		String s = "**************************************" + "\n";
		s += "Savings account:     " + accountNumber + "\n";
		s += "Account holder name: " + customer.getName() + "\n";
		s += "Address:             " + customer.getStreet() + "\n";
		s += "                     " + customer.getZipCode() + "\n";
		s += " " + customer.getTown() + "\n";
		s += customer.getCountry()
						.toUpperCase() + "\n";
		s += "**************************************" + "\n";
		s += "Balance:  " + balance + "\n";
		s += "**************************************";
		return s;
	}
}
