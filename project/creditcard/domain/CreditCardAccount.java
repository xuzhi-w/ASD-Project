package creditcard.domain;

import framework.domain.*;
import ui.CreditCardApplication;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class CreditCardAccount extends Account {
    @Override
    public String toString() {
        return "CreditCardAccount{" +
                "type=" + type +
                ", MP=" + MP +
                ", MI=" + MI +
                ", previousBalance=" + previousBalance +
                ", totalCharges=" + totalCharges +
                ", totalCredits=" + totalCredits +
                ", newBalance=" + newBalance +
                ", totalDue=" + totalDue +
                '}';
    }

    Logger logger =  Logger.getLogger("credit application");
    private AccountTypeEnum type;
    private double MP;
    private double MI;
    public AccountTypeEnum getType() {
        return type;
    }

    /**
     * get minimum payment,Gold
     * @return
     */
    public double getMP(){
        return MP;
    }

    /**
     * get monthly interest
     * @return
     */
    public double getMI(){
        return MI;
    }

    public void setType(AccountTypeEnum type) {
        this.type = type;
    }

    public CreditCardAccount(String accountNumber, double balance, Customer customer) {
        super(accountNumber, balance, customer);
    }

    /**
     *
     * @param accountNumber
     * @param balance
     * @param customer
     * @param type Gold Silver Bronze
     */
    public CreditCardAccount(String accountNumber, double balance, Customer customer, AccountTypeEnum type) {
        super(accountNumber, balance, customer);
//        setType(type);
//
//        if(type == AccountTypeEnum.GOLD){
//            MI = 0.06;
//            MP = 0.10;
//        }else if (type == AccountTypeEnum.SILVER){
//            MI = 0.08;
//            MP = 0.12;
//        }else if(type == AccountTypeEnum.BRONZE){
//            MI = 0.10;
//            MP = 0.14;
//        }
        logger.log(Level.INFO,toString());
    }

    @Override
    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(amount, "Account charged", "", "", TransactionType.WITHDRAW);
        addEntry(entry);
        if (amount > 400) {
            notifyObservers("Account charged " + amount, getCustomer());
        }
        logger.log(Level.INFO,toString());
    }

    @Override
    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(-amount, "Account credited", "", "", TransactionType.DEPOSIT);
        addEntry(entry);
        logger.log(Level.INFO,toString());
    }

    private double previousBalance = 0.0;
    private double totalCharges = 0.0;
    private double totalCredits = 0.0;
    private double newBalance = 0.0;
    private double totalDue = 0.0;


    public double getTotalCharges() {
        return totalCharges;
    }

    public double getTotalDue() {
        return totalDue;
    }

    public double getPreviousBalance() {
        return previousBalance;
    }

    public double getTotalCredits() {
        return totalCredits;
    }

    public double getNewBalance() {
        return newBalance;
    }
    /**
     * this method returns five values: 1.previous balance,
     * 2.total charges,3.total credits,4.new balance,5.total due
     */
    @Override
    public void generateReport() {
        LocalDate firstDay = LocalDate.now().withDayOfMonth(1);
        Predicate<AccountEntry> before = e -> convertDateToLocalDate(e.getDate()).isBefore(firstDay);
        List<AccountEntry> entryBefore = this.getEntryList().stream().filter(before).collect(Collectors.toList());
        List<AccountEntry> entryCurrentMonth = this.getEntryList().stream().filter(before.negate()).collect(Collectors.toList());
        for(AccountEntry entry : entryBefore){
            previousBalance += entry.getAmount();
        }
        for(AccountEntry entry : entryCurrentMonth){
            if(entry.getTransactionType().equals(TransactionType.DEPOSIT)){
                totalCredits += entry.getAmount();
            }else if(entry.getTransactionType().equals(TransactionType.WITHDRAW)){
                totalCharges += entry.getAmount();
            }
        }
        newBalance = previousBalance + totalCredits + totalCharges + getAccountType().getMonthlyInterest() * (previousBalance+totalCredits);
        totalDue = Math.ceil(getAccountType().getMinimumPayment() * newBalance * 100)/100;
        logger.log(Level.INFO,"Report generated:" + toString());
    }

    public LocalDate convertDateToLocalDate(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }

}
