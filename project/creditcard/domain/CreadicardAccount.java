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
<<<<<<< HEAD
        AccountEntry entry = new AccountEntry(-amount, "Account charged", "", "");
        addEntry(entry);
        if (amount > 400) {
            notifyObservers("Account charged " + amount, getCustomer());
        }
=======
        throw new UnsupportedOperationException();
>>>>>>> 5f3f6611892c87a7aa07bf094b0446e84e007a88
    }



    @Override
    public void generateReport() {

    }

    @Override
    public void addInterest() {

    }

}
