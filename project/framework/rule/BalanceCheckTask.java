package framework.rule;

import framework.domain.Account;
import framework.service.AccountService;
import framework.visitor.MyOperation;
import framework.visitor.Visitor;
import ui.bank.BankFrm;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class BalanceCheckTask implements Runnable {

    private static AccountService bankAccountService = BankFrm.getBankingApplication().getAccountService();
    Logger logger = BankFrm.getLogger();
    private static List<Rule> ruleList;
    private static List<Account> accountList;
    private static List<Visitor> visitorList;
    private BankFrm bankFrm = BankFrm.getBankFrmInstance();
//    private MyOperation operation = bankFrm;
    @Override
    public void run() {
        accountList = new ArrayList<>(bankAccountService.getAllAccounts());
        ruleList = bankAccountService.getAllRules();
        visitorList = bankAccountService.getAllVisitors();
        for (Account account : accountList) {
            ruleList.stream().filter(rule -> rule.matches(account))
                    .forEach(rule -> {rule.apply(account);
                        visitorList.forEach(visitor -> bankFrm.action(visitor,account));
                    });
        }
        accountList.forEach(account -> System.out.println(account));
    }

}
