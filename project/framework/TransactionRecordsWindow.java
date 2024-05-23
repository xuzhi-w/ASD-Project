package framework;

import banking.data.BankingAccountDAO;
import creditcard.data.CreditAccountDAO;
import creditcard.domain.CreditCardAccount;
import framework.data.AccountDAO;
import framework.domain.Account;
import framework.domain.AccountEntry;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TransactionRecordsWindow extends JFrame {

    private AccountDAO accountDAO ;

    public TransactionRecordsWindow(AccountDAO accountDAO,Account currentAccount) {
        this.accountDAO = accountDAO;
        String accountNumber = currentAccount.getAccountNumber();
        setTitle("Transaction Records for Account: " + accountNumber);
        setSize(800, 600);

        // Assuming you have a method to retrieve transaction records based on the account name
        DefaultTableModel transactionModel=new DefaultTableModel();
        if(accountDAO instanceof BankingAccountDAO){
             transactionModel = getTransactionRecords(currentAccount);
        }else if (accountDAO instanceof CreditAccountDAO){
            transactionModel = getMonthlyReport((CreditCardAccount) currentAccount);
        }
        JTable transactionTable = new JTable(transactionModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Disable editing for all cells
            }
        };

        JScrollPane scrollPane = new JScrollPane(transactionTable);

        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private DefaultTableModel getTransactionRecords(Account account) {
        // Implement this method to retrieve transaction records based on the account name
        // This could involve querying a database or accessing some data source
        // For demonstration purposes, let's assume a simple DefaultTableModel

        // according to account number , get all transaction records.
        ArrayList<AccountEntry> accountEntries = (ArrayList)account.getEntryList();
        Object[][] data = new Object[accountEntries.size()][5]; // Assuming there are 5 columns
        // Populate the array with data from the ArrayList

        for (int i = 0; i < accountEntries.size(); i++) {
            AccountEntry entry = accountEntries.get(i);
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


    public DefaultTableModel getMonthlyReport(CreditCardAccount account){
        Object[][] data = new Object[5][2];
        String[] columnNames = {"Item","Value"};
        data[0][0]="previous balance";
        data[0][1]=account.getPreviousBalance();
        data[1][0]="total charges";
        data[1][1]=account.getTotalCharges2();
        data[2][0]="total credits";
        data[2][1]=account.getTotalCredits();
        data[3][0]="new balance";
        data[3][1]=account.getNewBalance();
        data[4][0]="total due";
        data[4][1]=account.getTotalDue2();
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        return model;
    }

}
