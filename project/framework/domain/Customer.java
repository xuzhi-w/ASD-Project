package framework.domain;

import banking.domain.BankAccount;
import creditcard.domain.CreditCardAccount;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {

	private String customerID;
	private String name;
	private Address address;
	private String email;
	private LocalDate dateOfBirth;

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}


	public String getCustomerID() {
		return customerID;
	}


	public Customer(String name, Address address, String email, LocalDate dateOfBirth) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"name='" + name + '\'' +
				", address=" + address +
				", email='" + email + '\'' +
				", dateOfBirth=" + dateOfBirth +
				'}';
	}
}
