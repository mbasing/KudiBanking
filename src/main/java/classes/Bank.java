package classes;

import interfaces.IBank;
import java.util.ArrayList;

public class Bank implements IBank  {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String nameOfBank){
        this.name = nameOfBank;
        this.branches = new ArrayList<Branch>();
    }

    @Override
    public boolean addBranch(String nameOfBranch) {
        if(findBranch(nameOfBranch) == null){
            branches.add(new Branch(nameOfBranch));
            return true;
        }
        return false;
    }

    @Override
    public boolean addCustomer(String nameOfBranch, String nameOfCustomer, double initialTransaction) {

        Branch branchName = findBranch(nameOfBranch);
        if(branchName != null){
            return findBranch(nameOfBranch).newCustomer(nameOfCustomer, initialTransaction);
        }

        return false;
    }

    @Override
    public boolean addCustomerTransaction(String nameOfBranch, String nameOfCustomer, double transaction) {

        Branch branchName = findBranch(nameOfBranch);
        if(branchName != null){
            return findBranch(nameOfBranch).addCustomerTransaction(nameOfCustomer, transaction);
        }

        return false;
    }

    Branch findBranch(String nameOfBranch) {

        for (Branch branch : branches) {
            if (branch.getName().equals(nameOfBranch)) {
                return branch;
            }
        }
        return null;
    }

    @Override
    public boolean listCustomers(String nameOfBranch, boolean printTransactions) {
        Branch branchName = findBranch(nameOfBranch);
        if (branchName != null) {
            System.out.println("Customer details for branch " + nameOfBranch);
            ArrayList<Customer> branchCustomer = branchName.getCustomers();

            for (int i = 0; i < branchCustomer.size(); i++) {
                System.out.println("Customer: " + branchCustomer.get(i).getName() + "["+ (i+1) +"]");

                if (printTransactions) {
                    System.out.println("Transactions ");
                    ArrayList<Double> transactions = branchCustomer.get(i).getTransactions();

                    for (int j = 0; j < transactions.size(); j++) {
                        System.out.println("["+ (j+1) +"]" + " Amount " + transactions.get(j));
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}
