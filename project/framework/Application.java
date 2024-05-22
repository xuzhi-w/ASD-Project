package framework;

import creditcard.domain.CreditCardAccount;
import creditcard.domain.GoldAccount;
import creditcard.domain.SilverAccount;
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

		Account creditcard1 = new CreditCardAccount("123457",3000, c1);
		creditcard.setAccountType(new SilverAccount());


		creditcard.withdraw(200);
		creditcard.withdraw(300);
		creditcard.deposit(100);


		creditcard.generateReport();

  }
}







