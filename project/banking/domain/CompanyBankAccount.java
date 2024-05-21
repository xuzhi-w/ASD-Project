package banking.domain;

import framework.domain.Customer;

public class CompanyBankAccount extends BankAccount{
    private int numberOfEmployees;
    public CompanyBankAccount(String accountNumber, Customer customer, int numberOfEmployees) {
        super(accountNumber, customer);
        this.numberOfEmployees = numberOfEmployees;
    }
}
