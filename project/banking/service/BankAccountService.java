package banking.service;

import banking.domain.BankFactory;
import banking.domain.CompanyBankAccount;
import banking.domain.PersonalBankAccount;
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
        super(accountDAO, new BankFactory());
    }

    public Account createAccount(String bankAccountType, String accountNumber, double balance,
                                 String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType, int numberOfEmployees) {
        System.out.println("Creating account " + accountNumber);
        Account account;
        if(bankAccountType.equals("Personal"))
            account = getAccountFactory().createPersonalBankAccount(accountNumber,
                    name, street, city, state, zip, email, dateOfBirth, accountType);
        else
            account =  getAccountFactory().createCompanyBankAccount(accountNumber,
                    name, street, city, state, zip, email, dateOfBirth, accountType, numberOfEmployees);
        getAccountDAO().saveAccount(account);
        return account;
    }
}