package creditcard.service;

import creditcard.data.CreditAccountDAO;
import creditcard.domain.CreadicardAccount;
import framework.domain.Account;
import framework.domain.Customer;
import framework.service.AccountService;

import java.util.Collection;
import java.util.List;

public class CreditCardService implements AccountService {
    private CreditAccountDAO creditAccountDAO;

    public CreditCardService() {
        creditAccountDAO = new CreditAccountDAO();
    }

    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType, int numberOfEmployees) {
        return new CreadicardAccount(accountNumber, customer);
    }

    @Override
    public Account getAccount(String accountNumber) {
        return creditAccountDAO.loadAccount(accountNumber);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return creditAccountDAO.getAccounts();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.deposit(amount);
        creditAccountDAO.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.withdraw(amount);
        creditAccountDAO.updateAccount(account);
    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = getAccount(fromAccountNumber);
        Account toAccount = getAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        creditAccountDAO.updateAccount(fromAccount);
        creditAccountDAO.updateAccount(toAccount);
    }
}
