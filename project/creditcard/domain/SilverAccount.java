package creditcard.domain;

import java.util.Objects;

public class SilverAccount implements CreditCardAccountType{
    private static volatile SilverAccount instance;
    private SilverAccount(){}
    public static SilverAccount getInstance(){
        if(Objects.isNull(instance)){
            synchronized(SilverAccount.class){
                if(Objects.isNull(instance)){
                    instance = new SilverAccount();
                }
            }
        }
        return instance;
    }
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
