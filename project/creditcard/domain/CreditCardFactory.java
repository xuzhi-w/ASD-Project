package creditcard.domain;

import framework.domain.Account;
import framework.domain.AccountFactory;
import framework.domain.Customer;

public class CreditCardFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountNumber, double balance, Customer customer, String accountType, int numberOfEmployees) {
        return new CreadicardAccount(accountNumber,balance,customer);
    }
}
