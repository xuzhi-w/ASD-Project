package creditcard.service;

import banking.domain.BankAccountTypeEnum;
import creditcard.data.CreditAccountDAO;
import creditcard.domain.CreditCardAccount;
import creditcard.domain.CreditCardFactory;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.AccountFactory;
import framework.domain.AccountTypeEnum;
import framework.domain.Customer;
import framework.service.AccountServiceImpl;

import java.time.LocalDate;

public class CreditCardService extends AccountServiceImpl {

    //private AccountFactory accountFactory;
    private static volatile CreditCardService instance;
    private CreditCardService(AccountDAO accountDAO) {
        super(accountDAO, new CreditCardFactory());
    }

    public static CreditCardService  getServiceInstance(){
        if(instance == null){
            instance = new CreditCardService(CreditAccountDAO.getInstance());
        }
        return instance;
    }

    @Override
    public Account createAccount(String accountNumber, double balance, String name, String email,
                                 LocalDate dateOfBirth, String street, String city, String state,
                                 String zip, AccountTypeEnum accountType, int numberOfEmployees,
                                 BankAccountTypeEnum bankAccountTypeEnum) {

        Account account = getAccountFactory().createAccount(accountNumber,balance,name,email,dateOfBirth,street,city,
                state,zip,accountType,numberOfEmployees,bankAccountTypeEnum);
        getAccountDAO().saveAccount(account);
        return account;

    }
}
