package tests;
import static org.junit.Assert.*;

import model.Account;
import model.CheckingAccount;
import model.Customer;

import org.junit.Before;
import org.junit.Test;


public class AccountTest {

    private Customer cust;
    
    @Before
    public void setUp() {
        cust = new Customer("John Smith", "123 Main Street", "Anytown", "98001", "US");
    }
    
    @Test
    public void testAccountNumber() {
        Account newAccount = new CheckingAccount(cust);
        assertEquals("Account numbers match", newAccount.getAccountNumber() > 0, true);
    }
    
    @Test
    public void testAccountEquals() {
        Account newAccount = new CheckingAccount(cust);
        Account testAccount = newAccount;
        Account otherAccount = new CheckingAccount(cust);
        assertEquals("Account match", newAccount, testAccount);
        assertFalse("Accounts not same", newAccount.equals(otherAccount));
    }
    
    @Test
    public void testAccountToString() {
        CheckingAccount newAccount = new CheckingAccount(cust);
        String s = "**************************************" + "\n";
        s += "Savings account:     " + newAccount.getAccountNumber() + "\n";
        s += "Account holder name: " + cust.getName() + "\n";
        s += "Address:             " + cust.getStreet() + "\n";
        s += "                     " + cust.getZipCode() + "\n";
        s += " " + cust.getTown() + "\n";
        s += cust.getCountry()
                        .toUpperCase() + "\n";
        s += "**************************************" + "\n";
        s += "Balance:  " + newAccount.getBalance() + "\n";
        s += "**************************************";
        assertEquals("Strings match", newAccount.toString(), s);
    }

}
