package banking.domain;

import creditcard.domain.SilverAccount;

import java.util.Objects;

public class SavingAccount implements BankingAccountType{
    private static volatile SavingAccount instance;
    private SavingAccount(){}
    public static SavingAccount getInstance(){
        if(Objects.isNull(instance)){
            synchronized(SavingAccount.class){
                if(Objects.isNull(instance)){
                    instance = new SavingAccount();
                }
            }
        }
        return instance;
    }
    @Override
    public double addInterest(double balance) {
        if(balance < 1000){
            return balance * 0.01;
        }else if(balance >1000 && balance < 5000){
            return balance * 0.02;
        }else {
            return balance * 0.04;
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
