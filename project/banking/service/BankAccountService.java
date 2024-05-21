package banking.service;

import banking.domain.CompanyBankAccount;
import banking.domain.PersonalBankAccount;
import banking.data.BankingAccountDAO;
import framework.domain.Account;
import framework.domain.Customer;
import framework.service.AccountService;

import java.util.Collection;
import java.util.List;

public class BankAccountService implements AccountService {

    private BankingAccountDAO bankingAccountDAO;

    public BankAccountService() {
        bankingAccountDAO = new BankingAccountDAO();
    }

    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType, int numberOfEmployees) {
        Account account;
        if(accountType.equals("company")) {
            account = new CompanyBankAccount(accountNumber, customer, numberOfEmployees);
        }else {
            account = new PersonalBankAccount(accountNumber, customer);
        }
        return account;
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
        Account account = bankingAccountDAO.loadAccount(accountNumber);
        account.deposit(amount);
    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {

    }
}