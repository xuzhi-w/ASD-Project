package creditcard.domain;

public class SilverAccount implements CreditCardAccountType{
    @Override
    public double addInterest(double balance) {
        return balance * 0.08;
    }

    @Override
    public double getMonthlyInterest() {
        return 0.08;
    }

    @Override
    public double getMinimumPayment() {
        return 0.12;
    }
}
