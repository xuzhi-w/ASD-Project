package ui;

import banking.domain.BankAccountTypeEnum;
import banking.service.BankAccountService;
import creditcard.domain.CreditCardAccount;
import framework.data.AccountDAOImpl;
import framework.domain.Account;
import framework.domain.AccountEntry;
import framework.domain.AccountTypeEnum;
import framework.service.AccountService;
import ui.ccard.TransactionRecordsWindow;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class BankingApplication implements Application{
    private AccountService accountService;
    public BankingApplication() {
        accountService = new BankAccountService(new AccountDAOImpl());
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public Account createAccount(String accountNumber, double balance, String name, String email,
                                 LocalDate dateOfBirth, String street, String city, String state,
                                 String zip, AccountTypeEnum accountType, int numberOfEmployees,
                                 BankAccountTypeEnum bankAccountTypeEnum) {

        return accountService.createAccount(accountNumber,balance,name,email,dateOfBirth,street,city,
                state,zip,accountType,numberOfEmployees,bankAccountTypeEnum);
    }
    @Override
    public List<AccountEntry> getAccountEntries(String accountNumber) {
        return accountService.getAccount(accountNumber).getEntryList().stream().toList();
    }
    @Override
    public void deposit(String accountNumber, double amount){
        accountService.deposit(accountNumber, amount);
    }

    @Override
    public void withdraw(String accountNumber, double amount){
        accountService.withdraw(accountNumber, amount);
    }
    @Override
    public Account getAccount(String accountNumber){
        return accountService.getAccount(accountNumber);
    }
    @Override
    public Collection<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    public TransactionRecordsWindow createTransactionRecordsWindow(String accountNumber){
        CreditCardAccount account = (CreditCardAccount)getAccount(accountNumber);
        return new TransactionRecordsWindow(account);
    }

}
