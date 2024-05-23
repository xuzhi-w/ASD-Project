package framework.utils;

import framework.domain.Account;
import framework.domain.AccountEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public abstract class CommonRecordsWindow extends JFrame {

    public CommonRecordsWindow(Account account) {
        DefaultTableModel model = getTransactionRecords(account.getAccountNumber(),(List<AccountEntry>) account.getEntryList());
        prepareWindow(model,account.getAccountNumber());
    }

    protected abstract DefaultTableModel getTransactionRecords(String accountNumber,List<AccountEntry> accountEntries);
    protected abstract void prepareWindow(DefaultTableModel model,String accountNumber);
}
