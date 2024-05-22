package banking.domain;

import framework.domain.*;

import java.time.LocalDate;

public class BankFactory implements AccountFactory {
    AccountType checkinAccountType = new CheckingAccount();
    AccountType savingsAccountType = new SavingAccount();

    @Override
    public Account createPersonalBankAccount(String accountNumber, String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType) {
        Address address = new Address(street, city, state, zip);
        Customer customer = new Customer(name, address, email, dateOfBirth);
        Account account = new PersonalBankAccount(accountNumber, 0, customer);
        if(accountType == AccountTypeEnum.CHECKING) {
            account.setAccountType(checkinAccountType);
        }else if(accountType == AccountTypeEnum.SAVINGS) {
            account.setAccountType(savingsAccountType);
        }
        return account;
    }

    @Override
    public Account createCompanyBankAccount(String accountNumber, String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType, int numberOfEmployees) {
        Address address = new Address(street, city, state, zip);
        Customer customer = new Customer(name, address, email, dateOfBirth);
        Account account = new CompanyBankAccount(accountNumber, 0, customer, numberOfEmployees);
        if(accountType == AccountTypeEnum.CHECKING) {
            account.setAccountType(checkinAccountType);
        }else if(accountType == AccountTypeEnum.SAVINGS) {
            account.setAccountType(savingsAccountType);
        }
        return account;
    }

    @Override
    public Account createCreditCardAccount(String accountNumber, double balance, String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
