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
import java.util.List;

public class CreditCardApplication implements Application{

    private AccountService accountService;
    public CreditCardApplication() {
        this.accountService = new CreditCardService(new AccountDAOImpl());
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
    @Override
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
