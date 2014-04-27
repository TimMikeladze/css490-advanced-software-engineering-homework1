package tests;
import static org.junit.Assert.*;

import model.Customer;
import model.SavingsAccount;

import org.junit.Before;
import org.junit.Test;


public class SavingsAccountTest {

    SavingsAccount acct;
    
    @Before
    public void setUp() {
        acct = new SavingsAccount(new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US"));
    }

    @Test
    public void testCalculateInterestAndDeposit() {
        double deposit = 1000;
        acct.deposit(deposit);
        double balance = acct.getBalance();
        acct.calculateInterest();
        assertEquals("Interest Calculated", balance < acct.getBalance(), true);
    }
    
    @Test
    public void testWithdrawl() {
        double deposit = 1000;
        acct.deposit(deposit);
        double balance = acct.getBalance();
        assertEquals("Success on withdrawl", acct.withdrawal(1), true);
        assertEquals("Failure on withdrawl", acct.withdrawal(1000000), false);
    }

}
