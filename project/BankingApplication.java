import banking.service.BankAccountService;
import framework.data.AccountDAO;
import framework.data.AccountDAOImpl;
import framework.service.AccountService;

public class BankingApplication {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAOImpl();
        AccountService accountService = new BankAccountService(accountDAO);
        
    }
}
