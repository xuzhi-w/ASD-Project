package banking.domain;

import java.util.Objects;

public class CheckingAccount implements BankingAccountType{
    private static volatile CheckingAccount instance;
    private CheckingAccount(){}
    public static CheckingAccount getInstance(){
        if(Objects.isNull(instance)){
            synchronized(CheckingAccount.class){
                if(Objects.isNull(instance)){
                    instance = new CheckingAccount();
                }
            }
        }
        return instance;
    }
    @Override
    public double addInterest(double balance) {
        if(balance < 1000){
            return balance * 0.015;
        }else {
            return balance * 0.025;
        }
    }

    @Override
    public double getMonthlyInterest() {
        return 0;
    }

    @Override
    public double getMinimumPayment() {
        return 0;
    }
}
