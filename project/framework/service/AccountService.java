package framework.service;

import banking.domain.BankAccountTypeEnum;
import framework.domain.Account;
import framework.domain.AccountTypeEnum;
import framework.rule.Rule;
import framework.visitor.Visitor;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public interface AccountService {
    Account createAccount (String accountNumber, double balance, String name, String email,
                           LocalDate dateOfBirth, String street, String city, String state,
                           String zip, AccountTypeEnum accountType, int numberOfEmployees,
                           BankAccountTypeEnum bankAccountTypeEnum);
    Account getAccount(String accountNumber);
    Collection<Account> getAllAccounts();
    void deposit (String accountNumber, double amount);
    void withdraw (String accountNumber, double amount);
    void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description);
    void addInterest();

    List<Rule> getAllRules();

    List<Visitor> getAllVisitors();
 }
