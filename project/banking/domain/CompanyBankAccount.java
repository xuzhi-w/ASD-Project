package banking.domain;

import framework.domain.AccountEntry;
import framework.domain.Customer;
import framework.integration.Observer;

import java.util.ArrayList;
import java.util.List;

public class CompanyBankAccount extends BankAccount{
    private int numberOfEmployees;
    public CompanyBankAccount(String accountNumber, Customer customer, int numberOfEmployees) {
        super(accountNumber, customer);
        this.numberOfEmployees = numberOfEmployees;
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "Deposit", "", "");
        addEntry(entry);
        notifyObservers(amount + " deposited", getCustomer());
    }

    public void withdraw(double amount){
        AccountEntry entry = new AccountEntry(-amount, "Withdraw", "", "");
        addEntry(entry);
        notifyObservers(amount + " withdrawn", getCustomer());
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }
}
