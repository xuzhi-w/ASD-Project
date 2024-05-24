package banking.domain;

import framework.domain.Account;
import framework.domain.AccountTypeEnum;
import framework.domain.Customer;

public class BankAccountCreator extends BankFactory {

    @Override
    public Account createBankAccount(String accountNumber, double balance, Customer customer, int numberOfEmployees, BankAccountTypeEnum bankAccountTypeEnum) {
        if (bankAccountTypeEnum == BankAccountTypeEnum.CAMPANY){
            return new CompanyBankAccount(accountNumber,0,customer,numberOfEmployees);
        }else if (bankAccountTypeEnum == BankAccountTypeEnum.PERSONAL){
            return new PersonalBankAccount(accountNumber,0,customer);
        }
        return null;
    }

    @Override
    public void setBankAccountType(Account account, AccountTypeEnum accountTypeEnum) {
        if (accountTypeEnum == AccountTypeEnum.CHECKING){
            account.setAccountType(CheckingAccount.getInstance());
        } else if (accountTypeEnum == AccountTypeEnum.SAVINGS) {
            account.setAccountType(SavingAccount.getInstance());
        }
    }
}
