package framework.data;

import framework.domain.Account;

import java.util.*;

public class AccountDAOImpl implements AccountDAO {
    Map<String, Account> accountList = new HashMap<>();
    @Override
    public void saveAccount(Account account) {
        accountList.put(account.getAccountNumber(), account);
    }

    @Override
    public void updateAccount(Account account) {
        saveAccount(account);
    }

    @Override
    public Account loadAccount(String accountNumber) {
        return accountList.get(accountNumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountList.values();
    }
}
