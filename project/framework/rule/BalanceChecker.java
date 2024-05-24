package framework.rule;

import banking.service.BankAccountService;
import framework.domain.Account;
import framework.service.AccountService;
import ui.CreditCardApplication;
import ui.bank.BankFrm;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BalanceChecker {
    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    Thread thread;
    public BalanceChecker()  {
        try{
            Thread.sleep(30000);
        }catch (Exception e){
            e.printStackTrace();
        }
//            scheduler.scheduleAtFixedRate(new BalanceCheckTask(), 0, 1, TimeUnit.SECONDS);
        while(true){
            try{
                Thread.sleep(5000);
            }catch (Exception e){
                e.printStackTrace();
            }
            thread = new Thread(new BalanceCheckTask());
            thread.start();
        }
    }

}

