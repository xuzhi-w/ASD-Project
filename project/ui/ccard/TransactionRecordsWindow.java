package ui.ccard;

import creditcard.domain.CreditCardAccount;
import framework.domain.Account;
import framework.domain.AccountEntry;
import framework.utils.CommonRecordsWindow;
import ui.CreditCardApplication;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class TransactionRecordsWindow extends CommonRecordsWindow {

    private CreditCardApplication application = CreditCardApplication.getInstance();
//    private CreditCardAccount account1;
    public TransactionRecordsWindow(Account account) {
        super(account);
    }

    protected DefaultTableModel getTransactionRecords(Account account) {
        // Implement this method to retrieve transaction records based on the account name
        // This could involve querying a database or accessing some data source
        // For demonstration purposes, let's assume a simple DefaultTableModel

        // according to account number , get all transaction records.
//        Account account = application.getAccount(accountNumber);
        ArrayList<AccountEntry> entries = new ArrayList<>();
        if(account != null){
            entries = (ArrayList)account.getEntryList();
        }
        Object[][] data = new Object[entries.size()][6]; // Assuming there are 5 columns

        // Populate the array with data from the ArrayList
        for (int i=0; i < entries.size(); i++) {
            AccountEntry entry = entries.get(i);
            data[i][0] = entry.getDate().toString();
            data[i][1] = "$ "+entry.getAmount();
            data[i][2] = entry.getDescription();
            data[i][3] = entry.getFromAccountNumber();
            data[i][4] = entry.getFromPersonName();
            data[i][5] = entry.getTransactionType();
        }

        // Define column names
        String[] columnNames = {"Date", "Amount", "Description", "From Account Number", "From Person Name","Credit/Charged"};

        // Create the DefaultTableModel with the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

    @Override
    protected void prepareWindow(DefaultTableModel model, Account account) {
        setTitle("Transaction Records for Account: " + account.getAccountNumber());
        setSize(800, 600);
        CreditCardAccount account1 = (CreditCardAccount)account;
        // Assuming you have a method to retrieve transaction records based on the account name
        DefaultTableModel transactionModel = getTransactionRecords(account1);
        JTable transactionTable = new JTable(transactionModel);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        add(scrollPane, BorderLayout.CENTER);
        JLabel totalTransactionsLabel = new JLabel("   Previous balance: $" + account1.getPreviousBalance()
                + "   Total charges: $" + account1.getTotalCharges() +"   Total credit: $"
                + account1.getTotalCredits() + " " + "   new balance: $" + account1.getNewBalance()
                + "   Total due: $" + account1.getTotalDue());
        add(totalTransactionsLabel, BorderLayout.SOUTH);
        setVisible(true);
        setLocationRelativeTo(null);
    }

}
