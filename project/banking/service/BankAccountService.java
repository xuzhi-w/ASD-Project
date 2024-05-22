package banking.service;

import banking.domain.BankFactory;
import banking.domain.CompanyBankAccount;
import banking.domain.PersonalBankAccount;
import banking.data.BankingAccountDAO;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.AccountFactory;
import framework.domain.Customer;
import framework.service.AccountService;
import framework.service.AccountServiceImpl;

import java.util.Collection;

public class BankAccountService extends AccountServiceImpl {

    public BankAccountService(AccountDAO accountDAO) {
        super(accountDAO, new BankFactory());
    }

    public Account createAccount(String accountNumber, double balance , Customer customer, String accountType, int numberOfEmployees) {
        return getAccountFactory().createAccount(accountNumber,balance,customer,accountType,numberOfEmployees);
    }
}