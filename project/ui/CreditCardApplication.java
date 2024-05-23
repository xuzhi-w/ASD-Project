package ui;

import banking.domain.BankAccountTypeEnum;
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
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CreditCardApplication {

    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public CreditCardApplication() {
        this.accountService = new CreditCardService(new AccountDAOImpl());
    }
    public Account createAccount(String accountNumber, double balance, String name, String email,
                                 LocalDate dateOfBirth, String street, String city, String state,
                                 String zip, AccountTypeEnum accountType, int numberOfEmployees,
                                 BankAccountTypeEnum bankAccountTypeEnum) {

        return accountService.createAccount(accountNumber,balance,name,email,dateOfBirth,street,city,
                state,zip,accountType,numberOfEmployees,bankAccountTypeEnum);
    }

    public Account createAccount(String accountNumber, double balance, String name, String email,
                                 LocalDate dateOfBirth, String street, String city, String state,
                                 String zip, AccountTypeEnum accountType, int numberOfEmployees
                                 ) {
        return accountService.createAccount(accountNumber,balance,name,email,dateOfBirth,street,city,
                state,zip,accountType,numberOfEmployees,null);
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
        return accountService.getAccount(accountNumber).getEntryList().stream().sorted((e1,e2) -> e1.getDate()
                .compareTo(e2.getDate())).collect(Collectors.toList());
    }
    public TransactionRecordsWindow createTransactionRecordsWindow(String accountNumber){
        CreditCardAccount account = (CreditCardAccount)getAccount(accountNumber);
        account.generateReport();
        return new TransactionRecordsWindow(accountNumber, getAccountEntries(accountNumber), account.getPreviousBalance(),
                account.getTotalCharges(), account.getTotalCredits(), account.getNewBalance(),
                account.getTotalDue());
    }
}
