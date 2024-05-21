package banking.data;

import framework.data.AccountDAO;
import framework.domain.Account;

import java.util.ArrayList;
import java.util.Collection;

public class BankingAccountDAO implements AccountDAO {
    Collection<Account> accountlist = new ArrayList<>();

    @Override
    public void saveAccount(Account account) {
        accountlist.add(account);
    }

    @Override
    public void updateAccount(Account account) {
        Account accountexist = loadAccount(account.getAccountNumber());
        if (accountexist != null) {
            accountlist.remove(accountexist); // remove the old
            accountlist.add(account); // add the new
        }
    }

    @Override
    public Account loadAccount(String accountnumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber().equals(accountnumber)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountlist;
    }
}
