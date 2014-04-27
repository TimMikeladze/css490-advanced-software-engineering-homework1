package tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   CheckingAccountTest.class,
   AccountTest.class,
   SavingsAccountTest.class,
   CardTest.class,
   DebitCardTest.class,
   CreditCardTest.class,
   CustomerTest.class,
   BankTest.class
})

public class TestSuite {
}