package ui;

import banking.domain.BankAccountTypeEnum;
import creditcard.data.CreditAccountDAO;
import creditcard.domain.CreditCardAccount;
import creditcard.domain.CreditCardFactory;
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

public class CreditCardApplication implements Application{

    private static AccountService accountService;

    public static AccountService getAccountService() {
        return accountService;
    }
    private static CreditCardApplication instance = new CreditCardApplication();
    public static CreditCardApplication getInstance(){
        if(instance == null){
            instance = new CreditCardApplication();
        }
        return instance;
    }

    private CreditCardApplication() {
        this.accountService = CreditCardService.getServiceInstance();
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
        return accountService.getAccount(accountNumber).getEntryList().stream().sorted((e1,e2) -> e1.getDate()
                .compareTo(e2.getDate())).collect(Collectors.toList());
    }
    public TransactionRecordsWindow createTransactionRecordsWindow(String accountNumber){
        CreditCardAccount account = (CreditCardAccount)accountService.getAccount(accountNumber);
        account.generateReport();
        return new TransactionRecordsWindow(account);
    }
}
