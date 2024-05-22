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
}
