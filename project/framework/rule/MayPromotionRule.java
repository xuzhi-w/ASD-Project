package framework.rule;

import framework.domain.Account;

import java.time.LocalDate;
import java.time.Month;

public class MayPromotionRule implements Rule{
    @Override
    public boolean matches(Account account) {
        return account.getBalance() > 10000
                && LocalDate.now().getMonth() == Month.MAY;
    }

    @Override
    public void apply(Account account) {
        double bonus = account.getBalance() * 0.01 <= 100 ?account.getBalance()*0.01 : 100;
        account.deposit(bonus);
    }

    @Override
    public String toString() {
        return "MayPromotionRule{}";
    }
}
