package creditcard.domain;

public class BronzeAccount implements CreditCardAccountType{
    @Override
    public double addInterest(double balance) {
        return balance * 0.1;
    }

    @Override
    public double getMonthlyInterest() {
        return 0.1;
    }

    @Override
    public double getMinimumPayment() {
        return 0.14;
    }
}
