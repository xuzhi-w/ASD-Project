package creditcard.data;

import framework.data.AccountDAO;
import framework.domain.Account;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CreditAccountDAO implements AccountDAO {
    private static Map<String, Account> accountlist = new HashMap<>();
    @Override
    public void saveAccount(Account account) {
        accountlist.put(account.getAccountNumber(), account);
    }

    @Override
    public void updateAccount(Account account) {
        saveAccount(account);
    }

    @Override
    public Account loadAccount(String accountNumber) {
        return accountlist.get(accountNumber);
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountlist.values();
    }

    private static CreditAccountDAO creditAccountDAO;
    public  static CreditAccountDAO getInstance(){
        if(creditAccountDAO == null){
            creditAccountDAO = new CreditAccountDAO();
        }
        return creditAccountDAO;
    }
}
