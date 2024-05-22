package banking.domain;

public class SavingAccount implements BankingAccountType{

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
