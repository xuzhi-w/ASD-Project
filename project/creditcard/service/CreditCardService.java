package creditcard.service;

import creditcard.domain.CreadicardAccount;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.Customer;
import framework.service.AccountServiceImpl;

public class CreditCardService extends AccountServiceImpl {

    public CreditCardService(AccountDAO accountDAO) {
       super(accountDAO);
    }

    @Override
    public Account createAccount(String accountNumber, Customer customer, String accountType, int numberOfEmployees) {
        return new CreadicardAccount(accountNumber, customer);
    }

}
