package banking.domain;

import framework.domain.AccountEntry;
import framework.domain.Customer;

public class PersonalBankAccount extends BankAccount{
    public PersonalBankAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "Deposit", "", "");
        addEntry(entry);
        double balance = getBalance();
        if(amount > 500)
            notifyObservers(amount + " deposited", getCustomer());
        if(balance < 0)
            notifyObservers(  "Negative balance", getCustomer());
    }

    public void withdraw(double amount){
        AccountEntry entry = new AccountEntry(-amount, "Withdraw", "", "");
        addEntry(entry);
        double balance = getBalance();
        if(amount > 500)
            notifyObservers(amount + " withdrawn", getCustomer());
        if(balance < 0)
            notifyObservers(  "Negative balance", getCustomer());
    }
}
