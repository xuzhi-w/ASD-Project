package ui;

import creditcard.domain.CreditCardAccount;
import creditcard.service.CreditCardService;
import framework.data.AccountDAOImpl;
import framework.domain.Account;
import framework.domain.AccountEntry;
import framework.domain.AccountTypeEnum;
import framework.service.AccountService;
import ui.ccard.TransactionRecordsWindow;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class CreditCardApplication {

    private AccountService accountService;
    public CreditCardApplication() {
        this.accountService = new CreditCardService(new AccountDAOImpl());
    }
    public Account createAccount(String bankAccountType, String accountNumber, double balance,
                                 String name, String street, String city, String state, String zip, String email,
                                 LocalDate dateOfBirth, AccountTypeEnum accountType, int numberOfEmployees){
        return accountService.createAccount(bankAccountType, accountNumber, balance,
        name, street, city, state, zip, email, dateOfBirth, accountType, numberOfEmployees);
    }
    public void deposit(String accountNumber, double amount){
        accountService.deposit(accountNumber, amount);
    }
    public void withdraw(String accountNumber, double amount){
        accountService.withdraw(accountNumber, amount);
    }
    public Account getAccount(String accountNumber){
        return accountService.getAccount(accountNumber);
    }
    public Collection<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }
    public List<AccountEntry> getAccountEntries(String accountNumber){
        return accountService.getAccount(accountNumber).getEntryList().stream().toList();
    }
    public TransactionRecordsWindow createTransactionRecordsWindow(String accountNumber){
        CreditCardAccount account = (CreditCardAccount)getAccount(accountNumber);
        return new TransactionRecordsWindow(accountNumber, getAccountEntries(accountNumber), account.getAccountBalance(),
                account.getTotalCharges(), account.getTotalCredit(), account.calculateCurrentBalance(),
                account.getTotalDue());
    }
}
