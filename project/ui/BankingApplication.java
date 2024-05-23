package ui;

import banking.service.BankAccountService;
import framework.data.AccountDAOImpl;
import framework.domain.AccountEntry;
import framework.service.AccountService;

import java.util.List;

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


    public List<AccountEntry> getAccountEntries(String accountNumber) {
        return accountService.getAccount(accountNumber).getEntryList().stream().toList();
    }

}
