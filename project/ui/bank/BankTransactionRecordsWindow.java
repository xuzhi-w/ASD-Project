package ui.bank;

import framework.domain.Account;
import framework.domain.AccountEntry;
import framework.utils.CommonRecordsWindow;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class BankTransactionRecordsWindow extends CommonRecordsWindow {

//
    public BankTransactionRecordsWindow(Account account) {
        super(account);
    }

    public DefaultTableModel getTransactionRecords(String accountNumber,List<AccountEntry> entries) {
        // Implement this method to retrieve transaction records based on the account name
        // This could involve querying a database or accessing some data source
        // For demonstration purposes, let's assume a simple DefaultTableModel

        //data used for demo
        Object[][] data = new Object[entries.size()][5]; // Assuming there are 5 columns
        // Populate the array with data from the ArrayList
        for (int i=0; i < entries.size(); i++) {
            AccountEntry entry = entries.get(i);
            data[i][0] = entry.getDate();
            data[i][1] = entry.getAmount();
            data[i][2] = entry.getDescription();
            data[i][3] = entry.getFromAccountNumber();
            data[i][4] = entry.getFromPersonName();
        }

        // Define column names
        String[] columnNames = {"Date", "Amount", "Description", "From Account Number", "From Person Name"};

        // Create the DefaultTableModel with the data and column names
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

    @Override
    protected void prepareWindow(DefaultTableModel model,String accountNumber) {
        setTitle("All Records of Customer's Accounts: " + accountNumber );
        setSize(800, 600);
        // Assuming you have a method to retrieve transaction records based on the account name
        JTable transactionTable = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
        setLocationRelativeTo(null);
    }


}
