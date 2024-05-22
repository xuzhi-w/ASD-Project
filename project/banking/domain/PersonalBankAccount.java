package banking.domain;

import framework.domain.AccountEntry;
import framework.domain.Customer;
import framework.domain.TransactionType;

public class PersonalBankAccount extends BankAccount{
    public PersonalBankAccount(String accountNumber, double balance, Customer customer) {
        super(accountNumber, 0, customer);
    }

    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "Deposit", "", "", TransactionType.DEPOSIT);
        addEntry(entry);
        double balance = getBalance();
        if(amount > 500)
            notifyObservers(amount + " deposited", getCustomer());
        if(balance < 0)
            notifyObservers(  "Negative balance", getCustomer());
    }

    public void withdraw(double amount){
        AccountEntry entry = new AccountEntry(-amount, "Withdraw", "", "",TransactionType.WITHDRAW);
        addEntry(entry);
        double balance = getBalance();
        if(amount > 500)
            notifyObservers(amount + " withdrawn", getCustomer());
        if(balance < 0)
            notifyObservers(  "Negative balance", getCustomer());
    }
}
