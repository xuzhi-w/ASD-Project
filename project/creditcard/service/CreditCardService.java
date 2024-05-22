package creditcard.service;

import creditcard.domain.CreadicardAccount;
import creditcard.domain.CreditCardFactory;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.AccountFactory;
import framework.domain.Customer;
import framework.service.AccountServiceImpl;

public class CreditCardService extends AccountServiceImpl {

    private AccountFactory accountFactory;
    public CreditCardService(AccountDAO accountDAO) {
       super(accountDAO);
       this.accountFactory = new CreditCardFactory();
    }



    @Override
    public Account createAccount(String accountNumber, double balance,  Customer customer, String accountType, int numberOfEmployees) {
        return accountFactory.createAccount(accountNumber,balance,customer,accountType,numberOfEmployees);
    }

}
