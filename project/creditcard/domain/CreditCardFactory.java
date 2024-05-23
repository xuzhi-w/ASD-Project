package creditcard.domain;

import banking.domain.BankAccountTypeEnum;
import framework.domain.*;

import java.time.LocalDate;

public class CreditCardFactory implements AccountFactory {

//    @Override
//    public Account createAccount(String accountNumber, double balance, Customer customer, String accountType, int numberOfEmployees) {
//        return new CreadicardAccount(accountNumber,balance,customer);
//    }
    BronzeAccount bronzeAccount = new BronzeAccount();
    GoldAccount goldAccount = new GoldAccount();
    SilverAccount silverAccount = new SilverAccount();

    @Override
    public Account createAccount(String accountNumber, double balance, String name, String email,
                                 LocalDate dateOfBirth, String street, String city, String state,
                                 String zip, AccountTypeEnum accountType, int numberOfEmployees,
                                 BankAccountTypeEnum bankAccountTypeEnum) {
        Address address = new Address(street, city, state, zip);
        Customer customer = new Customer(accountNumber,address,email,dateOfBirth);
        Account account = new CreditCardAccount(accountNumber,balance,customer);
        if(accountType == AccountTypeEnum.BRONZE)
            account.setAccountType(bronzeAccount);
        else if (accountType == AccountTypeEnum.GOLD)
            account.setAccountType(goldAccount);
        else if (accountType == AccountTypeEnum.SILVER)
            account.setAccountType(silverAccount);
        return account;

    }
}
