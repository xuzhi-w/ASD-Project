package framework.service;

import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.Customer;

import java.util.Collection;

public abstract class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public abstract Account createAccount(String accountNumber, Customer customer, String accountType, int numberOfEmployees);


    @Override
    public Account getAccount(String accountNumber) {
        return accountDAO.loadAccount(accountNumber);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);

    }
}
