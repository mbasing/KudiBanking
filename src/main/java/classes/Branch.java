package classes;

import interfaces.IBranch;

import java.util.ArrayList;

public class Branch implements IBranch {

    private String name;
    private ArrayList<Customer> customers;

    public Branch(String nameOfBranch){
        this.name = nameOfBranch;
        this.customers = new ArrayList<Customer>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Customer> getCustomers() {
        return this.customers;
    }

    @Override
    public boolean newCustomer(String nameOfCustomer, double initialTransaction) {
        if(findCustomer(nameOfCustomer) == null){
            customers.add(new Customer(nameOfCustomer, initialTransaction));
            return true;
        }
        return false;
    }

    @Override
    public boolean addCustomerTransaction(String nameOfCustomer, double transaction) {
        Customer customerName = findCustomer(nameOfCustomer);
        if(customerName != null){
            findCustomer(nameOfCustomer).addTransaction(transaction);
            return true;
        }
        return false;
    }

    Customer findCustomer(String nameOfCustomer) {
        for(Customer customer: customers){
            if(customer.getName().equals(nameOfCustomer)){
                return customer;
            }
        }
        return null;
    }
}
