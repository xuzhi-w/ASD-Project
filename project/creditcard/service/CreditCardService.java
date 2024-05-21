package creditcard.service;

import creditcard.domain.CreadicardAccount;
import framework.domain.Account;
import framework.domain.Customer;
import framework.service.AccountService;

import java.util.Collection;
import java.util.List;

public class CreditCardService implements AccountService {

    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType, int numberOfEmployees) {
        return new CreadicardAccount(accountNumber, customer);
    }

    @Override
    public Account getAccount(String accountNumber) {
        return null;
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return List.of();
    }

    @Override
    public void deposit(String accountNumber, double amount) {

    }

    @Override
    public void withdraw(String accountNumber, double amount) {

    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {

    }
}
