package banking.service;

import banking.domain.CompanyBankAccount;
import banking.domain.PersonalBankAccount;
import banking.data.BankingAccountDAO;
import framework.domain.Account;
import framework.domain.Customer;
import framework.service.AccountService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

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
        return bankingAccountDAO.loadAccount(accountNumber);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return bankingAccountDAO.getAccounts();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.deposit(amount);
        bankingAccountDAO.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = bankingAccountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        bankingAccountDAO.updateAccount(account);
    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = bankingAccountDAO.loadAccount(fromAccountNumber);
        Account toAccount = bankingAccountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        bankingAccountDAO.updateAccount(fromAccount);
        bankingAccountDAO.updateAccount(toAccount);

    }
}