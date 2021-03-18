package interfaces;

public interface IBank {

    boolean addBranch(String nameOfBranch);
    boolean addCustomer(String nameOfBranch, String nameOfCustomer, double initialTransaction);
    boolean addCustomerTransaction(String branchName, String customerName, double transaction);
    boolean listCustomers(String nameOfBranch, boolean printTransactions);
}

