package classes;

import org.junit.Before;

import static org.junit.Assert.*;

public class BankTest {
    private Bank bank;

    // Instantiates a new bank
    @Before
    public void setUp() throws Exception {
        bank = new Bank("Ghana Commercial Bank");

      // Adds a branch to a bank
        bank.addBranch("Madina");

        // Adds a customer to a branch
        bank.addCustomer("Madina","Moses Basing",750.50);
    }
    @org.junit.Test
    public void addBranch() {
            // Given that a branch is added to a bank, should return true
            assertTrue(bank.addBranch("Dansoman branch"));

            // Given that a branch is already added to a bank, should return false
            assertFalse(bank.addBranch("Dansoman branch"));
        }


    @org.junit.Test
    public void addCustomer() {
        // Given that a customer is added to a bank, should return true
        assertTrue(bank.addCustomer("Madina","Edith Basing",73.25));

        // Given that a customer is already added to a bank, should return false
        assertFalse(bank.addCustomer("Madina", "Edith Basing",70.48));
    }

    @org.junit.Test
    public void addCustomerTransaction() {

        assertTrue(bank.addCustomerTransaction("Madina","Moses Basing",418.25));

        assertFalse(bank.addCustomerTransaction("Madina", "Paa Bobo",24.89));
    }

    @org.junit.Test
    public void listCustomers() {
        assertTrue(bank.listCustomers("Madina", true));

        assertFalse(bank.listCustomers("Takoradi", false));
    }
}