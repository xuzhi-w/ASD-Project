package framework.data;

import framework.domain.Account;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class AccountDAOImpl implements AccountDAO {

    private static volatile AccountDAO instance;
    private AccountDAOImpl() {}
    public static AccountDAO getInstance() {
        if (Objects.isNull(instance)) {
            synchronized (AccountDAOImpl.class) {
                if (Objects.isNull(instance)) {
                    instance = new AccountDAOImpl();
                }
            }
        }
        return instance;
    }
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
