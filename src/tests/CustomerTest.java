package tests;
import static org.junit.Assert.*;

import model.Customer;

import org.junit.Before;
import org.junit.Test;


public class CustomerTest {
    
    Customer cust;
    @Before
    public void setUp() {
        cust = new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US");
        cust.addCheckingAccount();
        cust.addSavingsAccount();
    }

    @Test
    public void testGetters() {
        assertNotNull("Not null", cust.getCheckingsAccounts());
        assertNotNull("Not null", cust.getSavingsAccounts());
        assertNotNull("Not null", cust.getCreditCards());
    }

}
