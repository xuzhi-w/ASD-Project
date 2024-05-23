package ui.ccard;
import banking.domain.BankAccountTypeEnum;
import creditcard.data.CreditAccountDAO;
import creditcard.domain.CreditCardAccount;
import framework.data.AccountDAO;
import framework.domain.*;

import framework.domain.AccountTypeEnum;
import ui.CreditCardApplication;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

/**
 * A basic JFC based application.
 */
public class CardFrm extends javax.swing.JFrame
{

	CreditCardApplication creditCardApplication;
    /****
     * init variables in the object
     ****/
    String clientName,street,city, zip, state,amountDeposit,expdate, ccnumber, email;
	AccountTypeEnum accountType;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    CardFrm thisframe;
    private Object rowdata[];

	private String accountNumber;

//
//	private AccountDAO dao = new CreditAccountDAO();
//	private Collection<Account> daoAccounts =  dao.getAccounts();
    
	public CardFrm()
	{
		thisframe=this;
		
		setTitle("Credit-card processing Application.");
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
		Object[][] data = new Object[0][5];
		String[] columns = new String[]{"Name","CC number","Exp date","Type","Balance"};
		model = new DefaultTableModel(data,columns);
		JTable1 = new JTable(model);
		rowdata = new Object[7];
        newaccount=false;
        
        
        JPanel1.add(JScrollPane1);
        JScrollPane1.setBounds(12,92,444,160);
        JScrollPane1.getViewport().add(JTable1);
        JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];
		
		JButton_NewCCAccount.setText("Add Credit-card Account");
		JPanel1.add(JButton_NewCCAccount);
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_GenBill.setText("Generate Monthly Bills");
		JButton_GenBill.setActionCommand("jbutton");
		JPanel1.add(JButton_GenBill);
		JButton_GenBill.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Charge");
		JPanel1.add(JButton_Withdraw);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);


		JButton_GenBill.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_NewCCAccount.addActionListener(lSymAction);
		JButton_GenBill.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		setLocationRelativeTo(null);
		creditCardApplication = new CreditCardApplication();
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
			(new CardFrm()).setVisible(true);
		} 
		catch (Throwable t) {
			t.printStackTrace();
			//Ensure the application exits with an error condition.
			System.exit(1);
		}
	}


	javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	javax.swing.JButton JButton_NewCCAccount = new javax.swing.JButton();
	javax.swing.JButton JButton_GenBill = new javax.swing.JButton();
	javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	Account currentAccount;
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
			if (object == CardFrm.this)
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
			else if (object == JButton_NewCCAccount)
				JButtonNewCCAC_actionPerformed(event);
			else if (object == JButton_GenBill){
				if(checkSelected()){
					JButtonGenerateBill_actionPerformed(event);
				};
			}else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			
		}

		public boolean checkSelected(){
			// Check if a row is selected
			int selectedRow = JTable1.getSelectedRow();
			if (selectedRow != -1) {
				// A row is selected
//				JOptionPane.showMessageDialog(getContentPane(), "Row " + selectedRow + " is selected.");
				accountNumber = (String) model.getValueAt(selectedRow, 1);
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

	void JButtonNewCCAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object 
		 set the boundaries and show it 
		*/
		
		JDialog_AddCCAccount ccac = new JDialog_AddCCAccount(thisframe);
		ccac.setBounds(450, 20, 300, 380);
		ccac.setLocationRelativeTo(null);
		ccac.show();
		creditCardApplication.createAccount(ccnumber, 1000, clientName,email
				,LocalDate.of(2020, 4, 7), street, city,
				state, zip , accountType,0,null);


//		creditCardApplication.createAccount( ccnumber,
//			0, clientName, email, LocalDate.of(2020, 4, 7),
//			street,city,state,zip,accountType, 0, BankAccountTypeEnum.CREDITCARD);
		System.out.println(ccnumber + "Account number");

		if (newaccount){
            // add row to table
            rowdata[0] = clientName;
            rowdata[1] = ccnumber;
            rowdata[2] = expdate;
            rowdata[3] = accountType;
            rowdata[4] = "0";
            model.addRow(rowdata);
            JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
            newaccount=false;
        }
    }

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if(selection != -1){
			String accountNumber = (String)model.getValueAt(selection, 1);

			addSomeData(accountNumber);
			TransactionRecordsWindow recordsWindow = creditCardApplication.
					createTransactionRecordsWindow(accountNumber);
		}
	}

	private void addSomeData(String accountNumber) {
		AccountEntry accountEntry = new AccountEntry(new Date(124,Calendar.APRIL,1),-100,"pay back some debt","","",TransactionType.DEPOSIT);
		AccountEntry accountEntry2 = new AccountEntry(new Date(124,Calendar.APRIL,1),200,"buy a gift","","",TransactionType.WITHDRAW);
		AccountEntry accountEntry3= new AccountEntry(new Date(124,Calendar.APRIL,1),300,"buy some food","","",TransactionType.WITHDRAW);
		AccountEntry accountEntry4 = new AccountEntry(new Date(124, Calendar.MAY,1),400,"buy some stuff","","",TransactionType.WITHDRAW);
		AccountEntry accountEntry5 = new AccountEntry(new Date(124,Calendar.MAY,22),500,"buy some stuff","","",TransactionType.WITHDRAW);
		Account account = creditCardApplication.getAccountService().getAccount(accountNumber);
		account.addEntry(accountEntry);
		account.addEntry(accountEntry2);
		account.addEntry(accountEntry3);
		account.addEntry(accountEntry4);
		account.addEntry(accountEntry5);
	}


	/**
	 * When deposit, the balance number goes down
	 * @param event
	 */
	void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accountNumber = (String)model.getValueAt(selection, 1);
    	    
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(thisframe,accountNumber);
		    dep.setBounds(430, 15, 275, 160);
			dep.setLocationRelativeTo(null);
			dep.show();
		    // compute new amount
            double amount = Double.valueOf(amountDeposit);
			creditCardApplication.deposit(accountNumber, amount);
			updateAmount(selection, accountNumber);
		}

		
	}

	/**
	 * To credit card , withdraw has the same meaning with charge,
	 * thus you balance number goes up.
	 */
	void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
	    // get selected name
        int selection = JTable1.getSelectionModel().getMinSelectionIndex();
        if (selection >=0){
            String accountNumber = (String)model.getValueAt(selection, 1);

		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(thisframe,accountNumber);
		    wd.setBounds(430, 15, 275, 160);
			wd.setLocationRelativeTo(null);
		    wd.show();
    		
		    // compute new amount
			double amount = Double.valueOf(amountDeposit);
			creditCardApplication.withdraw(accountNumber, amount);
			updateAmount(selection, accountNumber);
		    double newamount = creditCardApplication.getAccount(accountNumber).getAccountBalance();
		    if (newamount <0){
		       JOptionPane.showMessageDialog(JButton_Withdraw, " "
					   +accountNumber+" Your balance is negative: $"
					   +String.valueOf(newamount)+" !","Warning: negative balance",
					   JOptionPane.WARNING_MESSAGE);
		    }
		}
		
		
	}
	private void updateAmount(int selectedRow,String accountNumber){
		double newamount = creditCardApplication.getAccount(accountNumber).getBalance();
		model.setValueAt(String.valueOf(newamount), selectedRow, 4);
	}
}
