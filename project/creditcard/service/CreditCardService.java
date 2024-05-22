package creditcard.service;

import creditcard.domain.CreditCardFactory;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.AccountFactory;
import framework.domain.AccountTypeEnum;
import framework.domain.Customer;
import framework.service.AccountServiceImpl;

import java.time.LocalDate;

public class CreditCardService extends AccountServiceImpl {


    public CreditCardService(AccountDAO accountDAO) {
       super(accountDAO, new CreditCardFactory());
    }



    @Override
    public Account createAccount(String bankAccountType, String accountNumber, double balance,
                                 String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType, int numberOfEmployees) {
        Account account = getAccountFactory().createCreditCardAccount(accountNumber,balance, name,street, city, state, zip, email, dateOfBirth,accountType);
        getAccountDAO().saveAccount(account);
        return account;
    }

}
