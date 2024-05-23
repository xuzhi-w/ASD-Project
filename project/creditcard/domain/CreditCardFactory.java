package creditcard.domain;

import framework.domain.*;

import java.time.LocalDate;

public class CreditCardFactory implements AccountFactory {
    AccountType bronze = new BronzeAccount();
    AccountType gold = new GoldAccount();
    AccountType silver = new SilverAccount();

    @Override
    public Account createPersonalBankAccount(String accountNumber, String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Account createCompanyBankAccount(String accountNumber, String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType, int numberOfEmployees) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Account createCreditCardAccount(String accountNumber, double balance, String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType) {
        Address address = new Address(street, city, state, zip);
        Customer customer = new Customer(name, address, email, dateOfBirth);
        Account account = new CreditCardAccount(accountNumber, balance, customer,accountType);
        if (accountType == AccountTypeEnum.BRONZE)
            account.setAccountType(bronze);
        else if (accountType == AccountTypeEnum.GOLD)
            account.setAccountType(gold);
        else if (accountType == AccountTypeEnum.SILVER)
            account.setAccountType(silver);
        return account;
    }
}
