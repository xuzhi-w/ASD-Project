package creditcard.domain;

import framework.domain.Account;
import framework.domain.AccountEntry;
import framework.domain.Customer;
import framework.integration.Observer;

import java.util.ArrayList;
import java.util.List;

public class CreadicardAccount extends Account {
    public CreadicardAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "Account charged", "", "");
        addEntry(entry);
        if (amount > 400) {
            notifyObservers("Account charged " + amount, getCustomer());
        }
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
