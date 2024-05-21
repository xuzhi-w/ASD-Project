package framework.banking.domain;

import framework.domain.Account;
import framework.domain.Customer;

public class BankAccount extends Account {


	public BankAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
	}

	@Override
	public void withdraw(double amount) {

	}

	@Override
	public void transferFunds(Account toAccount, double amount, String description) {

	}

	@Override
	public void generateReport() {

	}

	@Override
	public void addInterest() {

	}


}
