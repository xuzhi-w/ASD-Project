package banking.domain;

import framework.domain.Account;
import framework.domain.AccountFactory;
import framework.domain.Customer;

public class BankFactory implements AccountFactory {
    @Override
    public Account createAccount(String accountNumber, double balance, Customer customer, String accountType, int numberOfEmployees){
        if( accountType.equals("Personal")){
            return  new PersonalBankAccount(accountNumber,balance,customer);
        }else {
            return new CompanyBankAccount(accountNumber,balance,customer,numberOfEmployees);
        }
    }
}
