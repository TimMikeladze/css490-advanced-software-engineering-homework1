package tests;
import static org.junit.Assert.*;

import model.Card;
import model.CheckingAccount;
import model.Customer;
import model.DebitCard;

import org.junit.Before;
import org.junit.Test;


public class CardTest {

    private Card card;
    
    @Before
    public void setUp() {
        card = new DebitCard(new CheckingAccount(new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US"), 500));
    }

    @Test
    public void test() {
        assertTrue("Card is there", card.getCardNumber() > 0);
    }

}
