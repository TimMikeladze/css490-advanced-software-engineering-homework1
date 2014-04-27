import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.AccountTest;
import tests.BankTest;
import tests.CardTest;
import tests.CheckingAccountTest;
import tests.CreditCardTest;
import tests.CustomerTest;
import tests.DebitCardTest;
import tests.SavingsAccountTest;

/**
 * The Class TestSuite.
 * 
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ CheckingAccountTest.class, AccountTest.class, SavingsAccountTest.class, CardTest.class, DebitCardTest.class,
		CreditCardTest.class, CustomerTest.class, BankTest.class })
public class TestSuite {
}