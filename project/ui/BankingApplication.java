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

public class BankingApplication {
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


    public Account createAccount(String accountNumber, double balance, String name, String email,
                                 LocalDate dateOfBirth, String street, String city, String state,
                                 String zip, AccountTypeEnum accountType, int numberOfEmployees,
                                 BankAccountTypeEnum bankAccountTypeEnum) {

        return accountService.createAccount(accountNumber,balance,name,email,dateOfBirth,street,city,
                state,zip,accountType,numberOfEmployees,bankAccountTypeEnum);
    }

    public List<AccountEntry> getAccountEntries(String accountNumber) {
        return accountService.getAccount(accountNumber).getEntryList().stream().toList();
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

    public TransactionRecordsWindow createTransactionRecordsWindow(String accountNumber){
        CreditCardAccount account = (CreditCardAccount)getAccount(accountNumber);
        return new TransactionRecordsWindow(accountNumber, getAccountEntries(accountNumber), account.getPreviousBalance(),
                account.getTotalCharges(), account.getTotalCredits(), account.getNewBalance(),
                account.getTotalDue());
    }

}
