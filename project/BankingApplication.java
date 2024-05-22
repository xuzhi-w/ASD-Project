import banking.service.BankAccountService;
import framework.data.AccountDAO;
import framework.data.AccountDAOImpl;
import framework.domain.Address;
import framework.domain.Customer;
import framework.service.AccountService;

import java.time.LocalDate;

public class BankingApplication {
    private AccountService accountService;

    public BankingApplication(){
        this.accountService = new BankAccountService(new AccountDAOImpl());
    }

    public AccountService getAccountService(){
        return accountService;
    }
    public static void main(String[] args) {



//        Customer customer = new Customer("John Doe", new Address("")"johndoe@gmail.com", LocalDate.of(1991, 4, 23))
//
//        accountService.createAccount("3523523", 800, )
    }
}
