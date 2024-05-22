package creditcard.domain;

public class GoldAccount implements CreditCardAccountType{
    @Override
    public double addInterest(double balance) {
        return balance * 0.06;
    }
}
