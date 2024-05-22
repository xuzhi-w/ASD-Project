package framework.domain;

import framework.integration.Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Account implements Subject{
	private Customer customer;

	private String accountNumber;

	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

	List<Observer> observers;

	public Account(String accountNumber, Customer customer) {
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.observers = new ArrayList<>();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : entryList) {
			balance += entry.getAmount();
		}
		return balance;
	}

//	public void deposit(double amount) {
//		AccountEntry entry = new AccountEntry(amount, "Deposit", "", "");
//		addEntry(entry);
//	}
//
//	public void withdraw(double amount){
//		AccountEntry entry = new AccountEntry(-amount, "Withdraw", "", "");
//		addEntry(entry);
//	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry fromEntry = new AccountEntry(-amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName());

		entryList.add(fromEntry);

		toAccount.addEntry(toEntry);
	}

	public void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}



	public abstract void generateReport();

	public abstract void addInterest();
	public abstract void deposit(double amount);
	public abstract void withdraw(double amount);



	// Subject for observer
	@Override
	public void registerObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
	}

	@Override
	public void notifyObservers(String message, Customer customer) {
		for (Observer o : observers) {
			o.update(message, customer);
		}
	}


}
