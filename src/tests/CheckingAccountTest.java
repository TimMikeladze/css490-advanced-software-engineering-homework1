package tests;
import static org.junit.Assert.*;

import model.CheckingAccount;
import model.Customer;

import org.junit.Before;
import org.junit.Test;


public class CheckingAccountTest {
    
    private CheckingAccount acct;
    private CheckingAccount acct2;
    private CheckingAccount acct3;
    private CheckingAccount acct4;
    private final static int DEPOSIT = 10000;
    
    @Before
    public void setUp() {
        acct = new CheckingAccount(new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US"), 500);
        acct2 = new CheckingAccount(new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US"), 0);
        acct3 = new CheckingAccount(new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US"), 10);
        acct4 = new CheckingAccount(new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US"), 0);
        acct.deposit(DEPOSIT);
        acct2.deposit(0);
        acct3.deposit(5);
        acct4.deposit(1);
        acct.determineCosts();
        acct2.determineCosts();
        acct.addDebitCard();
    }

    @Test
    public void testWithdrawl() {
        assertEquals("Can withdrawl", acct.withdrawal(10), true);
        assertEquals("Cannot withdrawl", acct.withdrawal(501), false);
        assertEquals("Cannot withdrawl", acct2.withdrawal(0), false);
        assertEquals("Cannot withdrawl", acct3.withdrawal(6), false);
        assertEquals("Cannot withdrawl", acct4.withdrawal(1), false);
    }
    
    @Test
    public void testApplyForCredit() {
        acct.deposit(6000);
        assertEquals("Gets credit card", acct.applyForCreditCard(), true);
        assertEquals("Denied credit card", acct2.applyForCreditCard(), false);
    }

    @Test
    public void testBalances() {
        int deposit = 100;
        double balance = acct.getBalance();
        acct.increaseBalance(deposit);
        assertEquals("Balance increases", acct.getBalance() >= deposit + balance, true);
        double balance2 = acct.getBalance();
        acct.decreaseBalance(deposit);
        assertEquals("Balance decreases", acct.getBalance() < balance2, true);
        acct.setBalance(DEPOSIT);
        assertEquals("Balance is equal", acct.getBalance() == (double)DEPOSIT, true);
    }
    
    @Test
    public void testGetters() {
        assertEquals("Debit ammount correct", acct.getDebitAmount() == 500, true);
        assertNotNull("Debit card created", acct.getDebitCard());
    }
}
