package framework.service;

import framework.domain.Account;
import framework.domain.AccountTypeEnum;
import framework.domain.Customer;

import java.time.LocalDate;
import java.util.Collection;

public interface AccountService {
    Account createAccount(String bankAccountType, String accountNumber, double balance,
                          String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType, int numberOfEmployees);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest();
}
