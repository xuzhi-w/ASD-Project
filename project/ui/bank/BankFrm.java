package ui.bank;

import banking.data.BankingAccountDAO;
import banking.domain.BankAccountTypeEnum;
import framework.data.AccountDAO;
import framework.service.AccountService;
import framework.domain.Account;
import framework.domain.AccountTypeEnum;
import ui.BankingApplication;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;

/**
 * A basic JFC based application.
 */
public class BankFrm extends javax.swing.JFrame
{
	//Banking Application Instance

	private AccountService service;
    /****
     * init variables in the object
     ****/
	BankingApplication bankingApplication;

    String accountnr, clientName,street,city,zip,state,clientType,amountDeposit, email, birthDate;
	AccountTypeEnum accountType;
    boolean newaccount;
    private static DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    BankFrm myframe;
    private Object rowdata[];

	private AccountDAO bankDao = new BankingAccountDAO();
	private Account currentAccount;

	public BankFrm()
	{
		myframe = this;

		setTitle("Bank Application.");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane 
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
        JScrollPane1 = new JScrollPane();
		//add some data , for demo use only
//		Object[][] data = addSomeData();
		Object[][] data = new Object[0][6];
		String[] columns = {"AccountNr","Name","City","P/C","Ch/S","Amount"};

		model = new DefaultTableModel(data,columns);
		JTable1 = new JTable(model);
		rowdata = new Object[8];
        newaccount=false;
        
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];
		
		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		//add generate report button
		JButton_GenerateReport.setText("Generate report of accounts");
		JButton_GenerateReport.setActionCommand("jbutton");
		JPanel1.add(JButton_GenerateReport);
		JButton_GenerateReport.setBounds(24,55,192,33);

		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Addinterest.setBounds(448,20,106,33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);
		JButton_GenerateReport.addActionListener(lSymAction);
		setLocationRelativeTo(null);
		bankingApplication = new BankingApplication();
	}


	/*****************************************************
	 * The entry point for this application.
	 * Sets the Look and Feel to the System Look and Feel.
	 * Creates a new JFrame1 and makes it visible.
	 *****************************************************/
	static public void main(String args[])
	{
		try {
		    // Add the following code if you want the Look and Feel
		    // to be set to the Look and Feel of the native system.
		    
		    try {
		        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		    } 
		    catch (Exception e) { 
		    }
		    
			//Create a new instance of our application's frame, and make it visible.
			(new BankFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}

	}



	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	javax.swing.JButton JButton_GenerateReport = new javax.swing.JButton();
	javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	private String  accountNumber;

	void exitApplication()
	{
		try {
		    	this.setVisible(false);    // hide the Frame
		    	this.dispose();            // free the system resources
		    	System.exit(0);            // close the application
		} catch (Exception e) {
		}
	}

	class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == BankFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.
			 
		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);
			else if (object == JButton_GenerateReport){
				if(checkSelected()){
					JButton_GenerateReport_actionPerformed(event);
				};
			}
		}
		public boolean checkSelected(){
			// Check if a row is selected
			int selectedRow = JTable1.getSelectedRow();
			if (selectedRow != -1) {
				// A row is selected
//				JOptionPane.showMessageDialog(getContentPane(), "Row " + selectedRow + " is selected.");
				 accountNumber = (String) model.getValueAt(selectedRow, 0);
				return true;
			} else if(selectedRow == -1) {
				// No row is selected
				JOptionPane.showMessageDialog(getContentPane(), "No row is selected.");
			}
			return false;
		}
	}

    
    //When the Exit button is pressed this code gets executed
    //this will exit from the system
    void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.setLocationRelativeTo(null);
		pac.show();
		bankingApplication.createAccount( accountnr,
				0, clientName, email, LocalDate.of(2020, 4, 7),
				street,city,state,zip,accountType, 0, BankAccountTypeEnum.CAMPANY);
		if (newaccount){
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "P";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }
    }

	/**
	 * Generate Report
	 * @param event
	 */
	void JButton_GenerateReport_actionPerformed(java.awt.event.ActionEvent event)
	{
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if(selection != -1){
			String accountNumber = (String)model.getValueAt(selection, 0);
			BankTransactionRecordsWindow recordsWindow =
					new BankTransactionRecordsWindow(accountNumber,
							bankingApplication.getAccountEntries(accountNumber));
		}
	}

	void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object 
		 set the boundaries and 
		 show it 
		*/
		
		JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.setLocationRelativeTo(null);
		pac.show();

		bankingApplication.createAccount( accountnr,
				0, clientName, email, LocalDate.of(2020, 4, 7),
				street,city,state,zip,accountType, 0, BankAccountTypeEnum.CAMPANY);
		if (newaccount){
            // add row to table
            rowdata[0] = accountnr;
            rowdata[1] = clientName;
            rowdata[2] = city;
            rowdata[3] = "C";
            rowdata[4] = accountType;
            rowdata[5] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }

	}
	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		//System.out.println(selection);
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);
			//currentAccount = bankDao.loadAccount(accnr);
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(myframe,accnr);
		    dep.setBounds(430, 15, 275, 160);
			dep.setLocationRelativeTo(null);
		    dep.show();
            double deposit = Double.valueOf(amountDeposit);
			//System.out.println(accnr);
			bankingApplication.deposit(accnr, deposit);
			updateAmount(selection, accnr);
		}
		
		
	}

	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accnr = (String)model.getValueAt(selection, 0);
			currentAccount = bankDao.loadAccount(accnr);
		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(myframe,accnr);
		    wd.setBounds(430, 15, 275, 160);
			wd.setLocationRelativeTo(null);
		    wd.show();

            double amount = Double.valueOf(amountDeposit);
			bankingApplication.withdraw(accnr, amount);
			double newamount = bankingApplication.getAccount(accnr).getBalance();
			updateAmount(selection, accnr);
		    if (newamount <0){
				JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !"
				,"Warning: negative balance",JOptionPane.WARNING_MESSAGE);
			}
		}
		
		
	}
	
	void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		  JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);
		  bankingApplication.getAccountService().addInterest();
		  int num = model.getRowCount();
		  for(int i=0;i<num;i++){
			  updateAmount(i, model.getValueAt(i, 0).toString());
		  }
	}

	private void updateAmount(int selectedRow,String accountNumber){
		double newamount = bankingApplication.getAccountService().getAccount(accountNumber).getBalance();
		model.setValueAt(String.valueOf(newamount), selectedRow, 5);
	}
}
