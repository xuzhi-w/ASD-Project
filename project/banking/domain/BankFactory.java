package banking.domain;

import framework.domain.*;

import java.time.LocalDate;

public abstract class BankFactory implements AccountFactory {

    AccountType checkingAccount = new CheckingAccount();
    AccountType savingAccount = new SavingAccount();
//    BankAccountCreater bankAccountCreater = new BankAccountCreater();

    @Override
    public Account createAccount(String accountNumber, double balance, String name, String email,
                                 LocalDate dateOfBirth, String street, String city, String state,
                                 String zip, AccountTypeEnum accountType, int numberOfEmployees,
                                 BankAccountTypeEnum bankAccountTypeEnum) {

        Address address = new Address(street, city, state, zip);
        Customer customer = new Customer(accountNumber,address,email,dateOfBirth);
        Account account = createBankAccount(accountNumber,balance,customer,numberOfEmployees,bankAccountTypeEnum);
        setBankAccountType(account, accountType);

        return account;
    }

    public abstract Account createBankAccount(String accountNumber, double balance, Customer customer,
                                              int numberOfEmployees, BankAccountTypeEnum bankAccountTypeEnum);
    public abstract void setBankAccountType(Account account ,AccountTypeEnum accountTypeEnum);
}
