package framework.rule;

import framework.domain.Account;
import ui.bank.BankFrm;

public class ChargeMonthlyFeeRule implements Rule{


    @Override
    public boolean matches(Account account) {
       return account.getBalance() < 1000;
    }

    @Override
    public void apply(Account account) {
        double monthlyFee  = 5.00;
        account.withdraw(monthlyFee);
    }

    @Override
    public String toString() {
        return "ChargeMonthlyFeeRule{}";
    }
}
