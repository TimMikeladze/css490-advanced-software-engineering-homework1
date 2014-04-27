package tests;
import static org.junit.Assert.*;

import model.CreditCard;

import org.junit.Before;
import org.junit.Test;


public class CreditCardTest {

    CreditCard card;
    @Before
    public void setUp() {
        card = new CreditCard();
    }

    @Test
    public void testPay() {
        assertEquals("Paid", card.pay(10), true);
        assertEquals("Not paid", card.pay(2600), false);
    }

}
