package banking.service;

import banking.domain.*;
import banking.data.BankingAccountDAO;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.AccountFactory;
import framework.domain.AccountTypeEnum;
import framework.domain.Customer;
import framework.service.AccountService;
import framework.service.AccountServiceImpl;

import java.time.LocalDate;
import java.util.Collection;

public class BankAccountService extends AccountServiceImpl {

    public BankAccountService(AccountDAO accountDAO) {
        super(accountDAO, new BankAccountCreater());
    }

    private static BankAccountService bankAccountService;

    public  static BankAccountService getInstance(){
        if(bankAccountService == null){
            bankAccountService = new BankAccountService(new BankingAccountDAO());
        }
        return  bankAccountService;
    }
    @Override
    public Account createAccount(String accountNumber, double balance, String name, String email, LocalDate dateOfBirth, String street, String city, String state, String zip, AccountTypeEnum accountType, int numberOfEmployees, BankAccountTypeEnum bankAccountTypeEnum) {
        Account account = getAccountFactory().createAccount(accountNumber,balance,name,email,dateOfBirth,street,city,
                state,zip,accountType,numberOfEmployees,bankAccountTypeEnum);
        getAccountDAO().saveAccount(account);
        return account;
    }

}