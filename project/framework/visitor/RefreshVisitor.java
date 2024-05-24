package framework.visitor;

import framework.domain.Account;
import ui.BankingApplication;
import ui.bank.BankFrm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class RefreshVisitor implements Visitor{

    @Override
    public void visit(BankFrm bankFrm, Account account) {
        JTable jTable = bankFrm.getJTable1();
        DefaultTableModel model = bankFrm.getModel();
        String accountNumber = account.getAccountNumber();
        BankingApplication bankingApplication = bankFrm.getBankingApplication();
        int rows = jTable.getRowCount();
        for(int i = 0; i< rows;i++){
            if(model.getValueAt(i,0).equals(accountNumber) ){
                double updatedBalance = bankingApplication.getAccountService()
                        .getAccount(accountNumber).getBalance();
                model.setValueAt(updatedBalance,i,5);
            }
        }
    }
}
