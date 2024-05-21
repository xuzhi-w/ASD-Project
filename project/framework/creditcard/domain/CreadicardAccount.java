package framework.creditcard.domain;

import framework.domain.Account;
import framework.domain.Customer;

public class CreadicardAccount extends Account {
    public CreadicardAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public void withdraw(double amount) {

    }

    @Override
    public void transferFunds(Account toAccount, double amount, String description) {

    }

    @Override
    public void generateReport() {

    }

    @Override
    public void addInterest() {

    }
}
