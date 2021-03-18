package classes;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    Customer customer;

    @Before
    public void setUp() throws Exception {

        customer = new Customer("Monica",237.00);
    }

    @Test
    public void getName() {

        assertEquals("Monica", customer.getName());
    }

    @Test
    public void getTransactions() {
        assertEquals(237.00,(double) customer.getTransactions().get(0), 0.00);
    }

    @Test
    public void addTransaction() {
        customer.addTransaction(150);

        assertEquals(2, customer.getTransactions().size());
    }
}