package banking.domain;

public class CheckingAccount implements BankingAccountType{
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
