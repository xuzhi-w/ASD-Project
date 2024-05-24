package creditcard.domain;

import java.util.Objects;

public class BronzeAccount implements CreditCardAccountType{
    private static volatile BronzeAccount instance;
    private BronzeAccount(){}
    public static BronzeAccount getInstance(){
        if(Objects.isNull(instance)){
            synchronized(BronzeAccount.class){
                if(Objects.isNull(instance)){
                    instance = new BronzeAccount();
                }
            }
        }
        return instance;
    }
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
