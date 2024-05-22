package creditcard.domain;

public class GoldAccount implements CreditCardAccountType{
    @Override
    public double addInterest(double balance) {
        return balance * 0.06;
    }

    @Override
    public double getMonthlyInterest() {
        return 0.06;
    }

    @Override
    public double getMinimumPayment() {
        return 0.1;
    }
}
