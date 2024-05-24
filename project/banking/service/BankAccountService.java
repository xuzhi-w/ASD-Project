package banking.service;

import banking.domain.*;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.AccountTypeEnum;
import framework.service.AccountServiceImpl;

import java.time.LocalDate;

public class BankAccountService extends AccountServiceImpl {

    public BankAccountService(AccountDAO accountDAO) {
        super(accountDAO, new BankAccountCreator());
    }


    @Override
    public Account createAccount(String accountNumber, double balance, String name, String email, LocalDate dateOfBirth, String street, String city, String state, String zip, AccountTypeEnum accountType, int numberOfEmployees, BankAccountTypeEnum bankAccountTypeEnum) {
        Account account = getAccountFactory().createAccount(accountNumber,balance,name,email,dateOfBirth,street,city,
                state,zip,accountType,numberOfEmployees,bankAccountTypeEnum);
        getAccountDAO().saveAccount(account);
        return account;
    }

}