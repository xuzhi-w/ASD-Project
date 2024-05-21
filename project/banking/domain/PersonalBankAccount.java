package banking.domain;

import framework.domain.Customer;

public class PersonalBankAccount extends BankAccount{
    public PersonalBankAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }
}
