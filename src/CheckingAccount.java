public class CheckingAccount extends Account {
    private boolean fDebitAllowed;
    private double fDebitAmount;
    private double fBalance;
    private static double costs = 1; // per period there is a cost associated with this account
                                     // that equals 1 pound
    private static double debitRate = 4.7;

    private DebitCard debitCard;

    public CheckingAccount(Customer customer) {
        this(customer, 0);
    }

    public CheckingAccount(Customer customer, float debit) {
        super(customer);
        fDebitAllowed = debit > 0 ? true : false;
        fDebitAmount = debit;
    }

    public void determineCosts() {
        fBalance = fBalance - costs;
        if (fBalance < 0) {
            fBalance = fBalance - (fBalance * debitRate / 100);
        }
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

    public DebitCard getDebitCard() {
        return debitCard;
    }
}
