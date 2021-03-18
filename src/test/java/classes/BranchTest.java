package classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BranchTest {
    Branch branch;

    @Before
    public void setUp() throws Exception {
        // Creating an instance of a branch
        branch = new Branch("Takoradi");
        branch.newCustomer("Kelvin",532);
    }

    @Test
    public void getName() {
        assertEquals("Takoradi",branch.getName());
    }

    @Test
    public void getCustomers() {
        assertEquals("Kelvin",branch.getCustomers().get(0).getName());
    }

    @Test
    public void newCustomer() {
        assertTrue(branch.newCustomer("Moses",32.23));
        assertFalse(branch.newCustomer("Kelvin",657.72));
    }

    @Test
    public void addCustomerTransaction() {
        assertTrue( branch.addCustomerTransaction("Kelvin",78.02));
        assertFalse(branch.addCustomerTransaction("Moses",51.23));
    }
}