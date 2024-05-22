package banking.domain;

import framework.domain.AccountType;

public interface BankingAccountType extends AccountType {
    double addInterest(double balance);
}
