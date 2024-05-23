package creditcard.domain;

import banking.domain.BankAccountTypeEnum;
import framework.domain.*;

import java.time.LocalDate;

public abstract class CreditCardFactory implements AccountFactory {
    
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
        setAccountype(account,accountType);
        return account;
    }
    public abstract void setAccountype(Account account, AccountTypeEnum accountTypeEnum);

}
