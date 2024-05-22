package framework;

import creditcard.domain.CreditCardAccount;
import creditcard.domain.GoldAccount;
import framework.domain.Account;
import framework.domain.Address;
import framework.domain.Customer;

import java.time.LocalDate;

public class Application {
	public static void main(String[] args) {

		Address a1 = new Address("1000 N","Fairfeild","IA","52557");
		Customer c1 = new Customer("Mamadu",a1, "mamadu@gmail.com", LocalDate.of(2000, 2, 7));


		Account creditcard = new CreditCardAccount("123456",1000, c1);
		creditcard.setAccountType(new GoldAccount());


		creditcard.withdraw(200);
		creditcard.withdraw(300);
		creditcard.deposit(100);


		creditcard.generateReport();









//		AccountService accountService = new AccountServiceImpl();
//
//		// create 2 accounts;
//		accountService.createAccount("1263862", "Frank Brown");
//		accountService.createAccount("4253892", "John Doe");
//		// use account 1;
//		accountService.deposit("1263862", 240);
//		accountService.deposit("1263862", 529);
//		accountService.withdraw("1263862", 230);
//		// use account 2;
//		accountService.deposit("4253892", 12450);
//		accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
//		// show balances
//
//		for (Account account : accountService.getAllAccounts()) {
//			Customer customer = account.getCustomer();
//			System.out.println("Statement for Account: " + account.getAccountNumber());
//			System.out.println("Account Holder: " + customer.getName());
//
//			System.out.println("-Date-------------------------"
//					+ "-Description------------------"
//					+ "-Amount-------------");
//
//			for (AccountEntry entry : account.getEntryList()) {
//				System.out.printf("%30s%30s%20.2f\n",
//						entry.getDate().toString(),
//						entry.getDescription(),
//						entry.getAmount());
//			}
//
//			System.out.println("----------------------------------------" + "----------------------------------------");
//			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
//		}
	}

}
