package creditcard.service;

import creditcard.domain.CreditCardFactory;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.AccountFactory;
import framework.domain.Customer;
import framework.service.AccountServiceImpl;

public class CreditCardService extends AccountServiceImpl {


    public CreditCardService(AccountDAO accountDAO) {
       super(accountDAO, new CreditCardFactory());
    }



    @Override
    public Account createAccount(String accountNumber, double balance,  Customer customer, String accountType, int numberOfEmployees) {
        return getAccountFactory().createAccount(accountNumber,balance,customer,accountType,numberOfEmployees);
    }

}
