package framework.domain;

import framework.integration.Observer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class Account implements Subject{

	private Customer customer;

	private String accountNumber;
	private double balance;

	private AccountType accountType;

	private List<AccountEntry> entryList;

	List<Observer> observers;

	public Account(String accountNumber, double balance, Customer customer) {
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.balance = balance;
		this.observers = new ArrayList<>();
		this.entryList = new ArrayList<>();
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
				toAccount.getCustomer().getName(), TransactionType.TRANSFER);
		AccountEntry toEntry = new AccountEntry(amount, description, toAccount.getAccountNumber(),
				toAccount.getCustomer().getName(), TransactionType.DEPOSIT);

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

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	public  double getAccountBalance(){
		return this.balance;
	}

	public abstract void generateReport();

	public void addInterest() {
		double calculatedInterest  = getAccountType().addInterest(getBalance());
		deposit(calculatedInterest);
	}

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

	@Override
	public String toString() {
		return "Account{" +
				"customer=" + customer +
				", accountNumber='" + accountNumber + '\'' +
				", balance=" + balance +
				", accountType=" + accountType +
				", entryList=" + entryList +
				", observers=" + observers +
				'}';
	}
}
