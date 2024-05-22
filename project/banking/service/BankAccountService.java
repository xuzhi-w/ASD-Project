package banking.service;

import banking.domain.CompanyBankAccount;
import banking.domain.PersonalBankAccount;
import banking.data.BankingAccountDAO;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.Customer;
import framework.service.AccountService;
import framework.service.AccountServiceImpl;

import java.util.Collection;

public class BankAccountService extends AccountServiceImpl {


    public BankAccountService(AccountDAO accountDAO) {
        super(accountDAO);
    }

    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType, int numberOfEmployees) {
        Account account;
        if(accountType.equals("company")) {
            account = new CompanyBankAccount(accountNumber, customer, numberOfEmployees);
        }else {
            account = new PersonalBankAccount(accountNumber, customer);
        }
        return account;
    }

}