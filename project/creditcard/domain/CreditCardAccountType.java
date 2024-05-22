package creditcard.domain;

import framework.domain.AccountType;

public interface CreditCardAccountType extends AccountType {
    double addInterest(double balance);
}
