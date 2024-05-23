package creditcard.domain;

import framework.domain.Account;
import framework.domain.AccountEntry;
import framework.domain.Customer;
import framework.domain.TransactionType;

public class CreditCardAccount extends Account {



    public CreditCardAccount(String accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    @Override
    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(amount, "Account charged", "", "", TransactionType.WITHDRAW);
        addEntry(entry);
        if (amount > 400) {
            notifyObservers("Account charged " + amount, getCustomer());
        }

    }

    @Override
    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "Account credited", "", "", TransactionType.DEPOSIT);
        addEntry(entry);
    }


    @Override
    public void generateReport() {
        System.out.println("Account number: "+ getAccountNumber());
        System.out.println("Previous balance: "+ getAccountBalance());
        System.out.println("Total charges: "+ getTotalCharges());
        System.out.println("Total credit: "+ getTotalCredit());
        calculateCurrentBalance();
        System.out.println("New balance: "+ getAccountBalance());
        System.out.println("Total Due: "+ getTotalDue());

    }

    public double getTotalCharges(){
        double balance = 0;
        for (AccountEntry entry : getEntryList()) {
            if(entry.getTransactionType()==TransactionType.WITHDRAW)
                balance += entry.getAmount();
        }
        return balance;
    }
    public double getTotalCredit(){
        double balance = 0;
        for (AccountEntry entry : getEntryList()) {
            if(entry.getTransactionType()==TransactionType.DEPOSIT)
                balance += entry.getAmount();
        }
        return -1*balance;
    }
    public double getTotalDue(){
        return getAccountType().getMinimumPayment() * getAccountBalance();
    }
    public double calculateCurrentBalance() {
        double total =  getAccountBalance() - getTotalCredit() + getTotalCharges() +
                getAccountType().getMonthlyInterest()*(getAccountBalance() - getTotalCredit());
        setBalance(total);
        return total;
    }
}
