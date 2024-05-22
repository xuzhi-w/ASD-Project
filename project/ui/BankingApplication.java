package ui;

import banking.service.BankAccountService;
import framework.data.AccountDAOImpl;
import framework.service.AccountService;

public class BankingApplication {
    private AccountService accountService;
    public BankingApplication() {
        accountService = new BankAccountService(new AccountDAOImpl());
    }

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public static void main(String[] args) {

    }

}
