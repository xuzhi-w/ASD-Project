package creditcard.domain;

public class SliverAccount implements CreditCardAccountType{
    @Override
    public double addInterest(double balance) {
        return balance * 0.08;
    }
}
