package creditcard.domain;

import framework.domain.Account;
import framework.domain.Customer;

public class CreadicardAccount extends Account {
    public CreadicardAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException();
    }



    @Override
    public void generateReport() {

    }

    @Override
    public void addInterest() {

    }
}
