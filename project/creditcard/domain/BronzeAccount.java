package creditcard.domain;

public class BronzeAccount implements CreditCardAccountType{
    @Override
    public double addInterest(double balance) {
        return balance * 0.1;
    }
}
