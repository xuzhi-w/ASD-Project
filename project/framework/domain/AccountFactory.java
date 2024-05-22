package framework.domain;

public interface AccountFactory {
    Account createAccount(String accountNumber, double balance ,
                       Customer customer, String accountType, int numberOfEmployees);
}
