package creditcard.domain;

import java.util.Objects;

public class GoldAccount implements CreditCardAccountType{
    private static volatile GoldAccount instance;
    private GoldAccount(){}
    public static GoldAccount getInstance(){
        if(Objects.isNull(instance)){
            synchronized(GoldAccount.class){
                if(Objects.isNull(instance)){
                    instance = new GoldAccount();
                }
            }
        }
        return instance;
    }
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
