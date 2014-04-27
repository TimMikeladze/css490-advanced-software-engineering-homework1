package tests;
import static org.junit.Assert.*;

import model.Bank;
import model.Customer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BankTest {
    
    private Bank bank;
    @Before
    public void setUp() {
        bank = new Bank("The Bank");
        bank.getName();
    }

    @Test
    public void withDrawMoney() {
        Customer cust = new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US");
        int num = bank.openSimpleCheckingAccount(cust);
        cust.getCheckingsAccounts().get(0).deposit(100);
        assertEquals("Got money", bank.withdrawMoney(num, 10), true);
        assertEquals("No money", bank.withdrawMoney(0, 10), false);
    }
    
    @After
    public void takeDown() {
        bank.openFullPackage(new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US"));
        bank.openSimpleCheckingAccount(new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US"));
    }

}
