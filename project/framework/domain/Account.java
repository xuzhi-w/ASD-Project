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
		AccountEntry entry = new AccountEntry(amount, "Deposit", "", "");
		addEntry(entry);
	}

	public void withdraw(double amount){
		AccountEntry entry = new AccountEntry(-amount, "Withdraw", "", "");
		addEntry(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description){
		AccountEntry entry = new AccountEntry(-amount, "Transfer", this.accountNumber, toAccount.getCustomer().getName());
		addEntry(entry);
	}

	private void addEntry(AccountEntry entry) {
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


}
