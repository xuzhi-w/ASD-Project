package framework.domain;

import java.util.Date;

public class AccountEntry {
	private Date date;
	private double amount;
	private String description;
	private String fromAccountNumber;
	private String fromPersonName;
	private TransactionType transactionType;

	@Override
	public String toString() {
		return "AccountEntry{" +
				"date=" + date +
				", amount=" + amount +
				", description='" + description + '\'' +
				", fromAccountNumber='" + fromAccountNumber + '\'' +
				", fromPersonName='" + fromPersonName + '\'' +
				", transactionType=" + transactionType +
				'}';
	}

	public AccountEntry() {
	}

	public AccountEntry(double amount, String description, String fromAccountNumber, String fromPersonName, TransactionType transactionType) {
		super();
		this.date = new Date();
		this.amount = amount;
		this.description = description;
		this.fromAccountNumber = fromAccountNumber;
		this.fromPersonName = fromPersonName;
		this.transactionType = transactionType;
	}

	public AccountEntry(Date date, double amount, String description, String fromAccountNumber, String fromPersonName,TransactionType transactionType) {
		super();
		this.date = date;
		this.amount = amount;
		this.description = description;
		this.fromAccountNumber = fromAccountNumber;
		this.fromPersonName = fromPersonName;
		this.transactionType = transactionType;
	}
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFromAccountNumber() {
		return fromAccountNumber;
	}

	public void setFromAccountNumber(String fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	public String getFromPersonName() {
		return fromPersonName;
	}

	public void setFromPersonName(String fromPersonName) {
		this.fromPersonName = fromPersonName;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}
}
