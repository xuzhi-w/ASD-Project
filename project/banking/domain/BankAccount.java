package banking.domain;

import framework.domain.Account;
import framework.domain.AccountEntry;
import framework.domain.Customer;
import framework.domain.TransactionType;


public abstract class BankAccount extends Account {


	public BankAccount(String accountNumber, double balance, Customer customer) {
        super(accountNumber, 0, customer);
	}

	@Override
	public void transferFunds(Account toAccount, double amount, String description) {

	}

	@Override
	public void generateReport() {
//		return this.getEntryList();
	}



}