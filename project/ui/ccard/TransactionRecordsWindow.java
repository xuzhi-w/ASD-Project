package ui.ccard;

import creditcard.data.CreditAccountDAO;
import framework.domain.Account;
import framework.domain.AccountEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransactionRecordsWindow extends JFrame {

    private CreditAccountDAO creditAccountDAO = new CreditAccountDAO();

    private List<AccountEntry> entryList;
    private double previousBalance;
    private double totalCharge;
    private double totalCredit;
    private double newBalance;
    private double totalDue;

    public TransactionRecordsWindow(String accountNumber, List<AccountEntry> entryList, double previousBalance,
                                    double totalCharge, double totalCredit, double newBalance,
                                    double totalDue) {
        this.entryList = entryList;
        this.previousBalance = previousBalance;
        this.totalCharge = totalCharge;
        this.totalCredit = totalCredit;
        this.newBalance = newBalance;
        this.totalDue = totalDue;
        setTitle("Transaction Records for Account: " + accountNumber);
        setSize(800, 600);

        // Assuming you have a method to retrieve transaction records based on the account name
        DefaultTableModel transactionModel = getTransactionRecords(accountNumber);
        JTable transactionTable = new JTable(transactionModel);
        JScrollPane scrollPane = new JScrollPane(transactionTable);
        add(scrollPane, BorderLayout.CENTER);
        JLabel totalTransactionsLabel = new JLabel("Previous balance: " + previousBalance
        + " Total charges: " + totalCharge +" Total credit: " + totalCredit +
                " " + "new balance: " + newBalance + " Total due: " + totalDue);
        add(totalTransactionsLabel, BorderLayout.SOUTH);


        setVisible(true);
    }

    private DefaultTableModel getTransactionRecords(String accountNumber) {
        // Implement this method to retrieve transaction records based on the account name
        // This could involve querying a database or accessing some data source
        // For demonstration purposes, let's assume a simple DefaultTableModel

        // according to account number , get all transaction records.
        Account account = creditAccountDAO.loadAccount(accountNumber);
        ArrayList<AccountEntry> accountEntries = new ArrayList<>();
        if(account != null){
            accountEntries = (ArrayList)account.getEntryList();
        }
        //data used for demo
        accountEntries.add(new AccountEntry(new Date(2024,01,01),100.00,"a T shirt","10001","Tom"));
        accountEntries.add(new AccountEntry(new Date(2024,01,02),200.00,"a T shirt2","10001","Tom"));
        accountEntries.add(new AccountEntry(new Date(2024,01,03),300.00,"a T shirt3","10001","Tom"));
        Object[][] data = new Object[entryList.size()][5]; // Assuming there are 5 columns
        // Populate the array with data from the ArrayList
        for (int i=0; i < entryList.size(); i++) {
            AccountEntry entry = entryList.get(i);
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

}
