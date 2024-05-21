package framework.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Account {
	private Customer customer;

	private String accountNumber;

	private List<AccountEntry> entryList = new ArrayList<AccountEntry>();

	public Account(String accountNumber, Customer customer) {
		this.accountNumber = accountNumber;
		this.customer = customer;
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

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		entryList.add(entry);
	}

	public abstract void withdraw(double amount);

	private void addEntry(AccountEntry entry) {
		entryList.add(entry);
	}

	public abstract void transferFunds(Account toAccount, double amount, String description);

	public abstract void generateReport();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Collection<AccountEntry> getEntryList() {
		return entryList;
	}

	public abstract void addInterest();


}
