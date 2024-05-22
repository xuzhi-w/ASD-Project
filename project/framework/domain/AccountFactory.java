package framework.domain;

import java.time.LocalDate;

public interface AccountFactory {
    //Account createAccount(String accountNumber, double balance ,
                       //Customer customer, String accountType, int numberOfEmployees);
    Account createPersonalBankAccount(String accountNumber,
                                      String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType);
    Account createCompanyBankAccount(String accountNumber,
                                     String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType, int numberOfEmployees);
    Account createCreditCardAccount(String accountNumber, double balance,
                                    String name, String street, String city, String state, String zip, String email, LocalDate dateOfBirth, AccountTypeEnum accountType);

}
