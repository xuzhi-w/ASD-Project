package ui;

import banking.domain.BankAccountTypeEnum;
import framework.domain.Account;
import framework.domain.AccountEntry;
import framework.domain.AccountTypeEnum;
import framework.service.AccountService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface Application {
    Account createAccount(String accountNumber, double balance, String name, String email,
                          LocalDate dateOfBirth, String street, String city, String state,
                          String zip, AccountTypeEnum accountType, int numberOfEmployees,
                          BankAccountTypeEnum bankAccountTypeEnum);
    List<AccountEntry> getAccountEntries(String accountNumber);
    void deposit(String accountNumber, double amount);
    void withdraw(String accountNumber, double amount);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
}
