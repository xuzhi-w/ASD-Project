package banking.service;

import banking.domain.*;
import framework.data.AccountDAO;
import framework.data.AccountDAOImpl;
import framework.domain.Account;
import framework.domain.AccountTypeEnum;
import framework.service.AccountServiceImpl;

import java.time.LocalDate;
import java.util.Objects;

public class BankAccountService extends AccountServiceImpl {
    private static volatile BankAccountService instance;

    private BankAccountService(AccountDAO accountDAO) {
        super(accountDAO, new BankAccountCreator());
    }
    public static BankAccountService getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (BankAccountService.class) {
                if (Objects.isNull(instance)) {
                    instance = new BankAccountService(AccountDAOImpl.getInstance());
                }
            }
        }
        return instance;
    }


    @Override
    public Account createAccount(String accountNumber, double balance, String name, String email, LocalDate dateOfBirth, String street, String city, String state, String zip, AccountTypeEnum accountType, int numberOfEmployees, BankAccountTypeEnum bankAccountTypeEnum) {
        Account account = getAccountFactory().createAccount(accountNumber,balance,name,email,dateOfBirth,street,city,
                state,zip,accountType,numberOfEmployees,bankAccountTypeEnum);
        getAccountDAO().saveAccount(account);
        return account;
    }

}