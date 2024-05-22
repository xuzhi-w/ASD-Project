package framework.domain;

public interface AccountType {
    double addInterest(double balance);
    double getMonthlyInterest();
    double getMinimumPayment();
}
