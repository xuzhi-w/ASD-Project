package creditcard.domain;

import framework.domain.Account;
import framework.domain.AccountEntry;
import framework.domain.Customer;
import framework.domain.TransactionType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CreditCardAccount extends Account {

    private String type;
    private double MP;
    private double MI;
    public String getType() {
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

    public void setType(String type) {
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
    public CreditCardAccount(String accountNumber, double balance, Customer customer, String type) {
        super(accountNumber, balance, customer);
        this.type = type;

        if(type == "Gold"){
            MI = 0.06;
            MP = 0.10;
        }else if (type == "Silver"){
            MI = 0.08;
            MP = 0.12;
        }else if(type == "Bronze"){
            MI = 0.10;
            MP = 0.14;
        }
    }

    @Override
    public void withdraw(double amount) {
        AccountEntry entry = new AccountEntry(amount, "Account charged", "", "", TransactionType.WITHDRAW);
        addEntry(entry);
        if (amount > 400) {
            notifyObservers("Account charged " + amount, getCustomer());
        }

    }

    @Override
    public void deposit(double amount) {
        AccountEntry entry = new AccountEntry(amount, "Account credited", "", "", TransactionType.DEPOSIT);
        addEntry(entry);
    }


    private double previousBalance = 0.0;
    private double totalCharges2 = 0.0;
    private double totalCredits = 0.0;
    private double newBalance = 0.0;

    public double getTotalCharges2() {
        return totalCharges2;
    }

    public double getTotalDue2() {
        return totalDue2;
    }

    double totalDue2 = 0.0;

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
                totalCharges2 += entry.getAmount();
            }
        }
        newBalance = previousBalance + totalCredits + totalCharges2 + MI * (previousBalance+totalCredits);
        totalDue2 = MP * newBalance;
    }

    public LocalDate convertDateToLocalDate(Date date){
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return localDate;
    }
    private double getTotalCharges(){
        double balance = 0;
        for (AccountEntry entry : getEntryList()) {
            if(entry.getTransactionType()==TransactionType.WITHDRAW)
                balance += entry.getAmount();
        }
        return balance;
    }
    private double getTotalCredit(){
        double balance = 0;
        for (AccountEntry entry : getEntryList()) {
            if(entry.getTransactionType()==TransactionType.DEPOSIT)
                balance += entry.getAmount();
        }
        return balance;
    }
    private double getTotalDue(){
        return getAccountType().getMinimumPayment() * getAccountBalance();
    }
    private void updateBalance() {
        double total =  getAccountBalance() - getTotalCredit() + getTotalCharges() +
                getAccountType().getMonthlyInterest()*(getAccountBalance() - getTotalCredit());
        System.out.println(total);
        setBalance(total);
    }



}
