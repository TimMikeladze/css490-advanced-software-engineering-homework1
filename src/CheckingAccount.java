public class CheckingAccount {

    private int fAccountNumber;
    private boolean fDebitAllowed;
    private double fDebitAmount;
    private double fBalance;
    private Customer customer;
    private static double costs = 1; // per period there is a cost associated with this account
                                     // that equals 1 pound
    private static double debitRate = 4.7;
    private static int fNextAccountNumber = 0;

    private DebitCard debitCard;

    public CheckingAccount(Customer customer) {
        this(customer, 0);
    }

    public CheckingAccount(Customer customer, float debit) {
        this.customer = customer;
        fAccountNumber = fNextAccountNumber;
        fNextAccountNumber++;
        fDebitAllowed = debit > 0 ? true : false;
        fDebitAmount = debit;
    }

    public CheckingAccount(int accountnumber) {
        fAccountNumber = accountnumber;
    }

    public void determineCosts() {
        fBalance = fBalance - costs;
        if (fBalance < 0) {
            fBalance = fBalance - (fBalance * debitRate / 100);
        }
    }

    public void print() {
        System.out.println("**************************************");
        System.out.println("Savings account:     " + fAccountNumber);
        System.out.println("Account holder name: " + customer.getName());
        System.out.println("Address:             " + customer.getStreet());
        System.out.print("                     " + customer.getZipCode());
        System.out.println(" " + customer.getTown());
        System.out.println(customer.getCountry().toUpperCase());
        System.out.println("**************************************");
        System.out.println("Balance:  " + fBalance);
        System.out.println("**************************************");
    }

    public boolean withdrawal(double amount) {
        if (((fBalance - amount) < 0) && (!fDebitAllowed)) {
            return false;
        }
        else if ((fBalance - amount) < -fDebitAmount) {
            fBalance = fBalance - amount;
            return true;
        }
        else {
            return false;
        }
    }

    public void verseMoney(double amount) {
        fBalance += amount;
    }

    public boolean applyForCreditCard() {
        double limit = 0;

        if (fBalance < 0) {
            return false;
        }
        if (fBalance > 5000) {
            limit = 5000;
        }
        customer.addCreditCard(new CreditCard(limit));
        return true;
    }

    public void addDebitCard() {
        debitCard = new DebitCard(this);
    }

    public double getBalance() {
        return fBalance;
    }

    public void increaseBalance(double amount) {
        fBalance += amount;
    }

    public void decreaseBalance(double amount) {
        fBalance -= amount;
    }

    public double getDebitAmount() {
        return fDebitAmount;
    }

    public void setBalance(double amount) {
        fBalance = amount;
    }

    public int getAccountNumber() {
        return fAccountNumber;
    }

    public DebitCard getDebitCard() {
        return debitCard;
    }

    @Override
    public boolean equals(Object o) {
        if (fAccountNumber == ((CheckingAccount) o).fAccountNumber) {
            return true;
        }
        else {
            return false;
        }

    }
}
