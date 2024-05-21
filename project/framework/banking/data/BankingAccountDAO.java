package framework.banking.data;

import framework.data.AccountDAO;
import framework.domain.Account;

import java.util.Collection;
import java.util.List;

public class BankingAccountDAO implements AccountDAO {
    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {

    }

    @Override
    public Account loadAccount(String accountnumber) {
        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return List.of();
    }
}
