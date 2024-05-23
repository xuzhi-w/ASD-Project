package framework.domain;

import banking.domain.BankAccountTypeEnum;

import java.time.LocalDate;

public interface AccountFactory {
    //Account createAccount(String accountNumber, double balance ,
                       //Customer customer, String accountType, int numberOfEmployees);
    Account createAccount(String accountNumber, double balance ,
                          String name, String email, LocalDate dateOfBirth,
                          String street, String city, String state, String zip,
                          AccountTypeEnum accountType, int numberOfEmployees, BankAccountTypeEnum bankAccountTypeEnum);

}
