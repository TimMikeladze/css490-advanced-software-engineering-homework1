package tests;
import static org.junit.Assert.*;

import model.CheckingAccount;
import model.Customer;
import model.DebitCard;

import org.junit.Before;
import org.junit.Test;


public class DebitCardTest {

    private DebitCard card;
    private CheckingAccount acct; 
    
    @Before
    public void setUp() {
        acct = new CheckingAccount(new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US"), 500);
        acct.deposit(250);
        card = new DebitCard(acct);
    }
    
    @Test
    public void testPay() {
        assertEquals("Pay is successful", card.pay(5), true);
    }

}
