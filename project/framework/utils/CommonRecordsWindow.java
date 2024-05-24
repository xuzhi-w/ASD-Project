package framework.utils;

import framework.domain.Account;
import framework.domain.AccountEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public abstract class CommonRecordsWindow extends JFrame {

    public CommonRecordsWindow(Account account) {
        DefaultTableModel model = getTransactionRecords(account);
        prepareWindow(model,account);
    }

    public CommonRecordsWindow() throws HeadlessException {
    }

    protected abstract DefaultTableModel getTransactionRecords(Account account1);
    protected abstract void prepareWindow(DefaultTableModel model,Account account1);
}
