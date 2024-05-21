package banking.domain;

import banking.data.BankingAccountDAO;
import framework.domain.Account;
import framework.domain.Customer;

public abstract class BankAccount extends Account {


	public BankAccount(String accountNumber, Customer customer) {
        super(accountNumber, customer);
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