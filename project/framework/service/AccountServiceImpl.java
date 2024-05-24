package framework.service;

import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.AccountFactory;
import framework.rule.ChargeMonthlyFeeRule;
import framework.rule.MayPromotionRule;
import framework.rule.Rule;
import framework.visitor.RefreshVisitor;
import framework.visitor.Visitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AccountServiceImpl implements AccountService {

    private AccountDAO accountDAO;
    private AccountFactory accountFactory;

    public AccountServiceImpl(AccountDAO accountDAO, AccountFactory accountFactory) {
        this.accountDAO = accountDAO;
        this.accountFactory = accountFactory;
    }


    @Override
    public Account getAccount(String accountNumber) {
        return accountDAO.loadAccount(accountNumber);
    }

    @Override
    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    @Override
    public void deposit(String accountNumber, double amount) {
        Account account = getAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
    }

    @Override
    public void withdraw(String accountNumber, double amount) {

        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
    }

    @Override
    public void transferFunds(String fromAccountNumber, String toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
    }
    @Override
    public void addInterest(){
        for(Account account : accountDAO.getAccounts()){
            account.addInterest();
        }
    }

    public AccountFactory getAccountFactory() {
        return accountFactory;
    }

    public AccountDAO getAccountDAO() {
        return accountDAO;
    }

    public List<Rule> getAllRules(){
        List<Rule> ruleList = new ArrayList<>();
        Rule balanceRule = new MayPromotionRule();
        Rule ChargeMonthlyFeeRule = new ChargeMonthlyFeeRule();
        ruleList.add(balanceRule);
        ruleList.add(ChargeMonthlyFeeRule);
        return ruleList;
    }

    public List<Visitor> getAllVisitors(){
        List<Visitor> visitorList = new ArrayList<>();
        Visitor refreshVisitor = new RefreshVisitor();
        visitorList.add(refreshVisitor);

        return visitorList;
    }

}
