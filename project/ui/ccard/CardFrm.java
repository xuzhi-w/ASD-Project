package ui.ccard;

import banking.data.BankingAccountDAO;
import banking.domain.PersonalBankAccount;
import creditcard.data.CreditAccountDAO;
import creditcard.domain.CreditCardAccount;
import framework.TransactionRecordsWindow;
import framework.data.AccountDAO;
import framework.domain.*;

import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.Collection;

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
    /****
     * init variables in the object
     ****/
    String clientName,street,city, zip, state,accountType,amountDeposit,expdate, ccnumber,email;
    boolean newaccount;
    private DefaultTableModel model;
    private JTable JTable1;
    private JScrollPane JScrollPane1;
    CardFrm thisframe;
    private Object rowdata[];

	private String accountNumber;

	private AccountDAO dao = new CreditAccountDAO();
	private Collection<Account> daoAccounts =  dao.getAccounts();
    
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
		Object[][] data = addSomeData();
//        model.addColumn("Name");
//        model.addColumn("CC number");
//        model.addColumn("Exp date");
//        model.addColumn("Type");
//        model.addColumn("Balance");
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
	}

	private Object[][] addSomeData() {
		Object[][] data = new Object[1][5];
		data[0][0] = "John Doe";
		data[0][1] = "1001";
		data[0][2] = "2034-01-01";
		data[0][3] = "Bronze";
		data[0][4] = "0.00";
		Address address = new Address("1000N 4Th ST","Fairfield","IA","52556");
		Customer customer = new Customer("John Doe",address,"johndoe@gmail.com", LocalDate.of(1991,3,23));
		Account account = new CreditCardAccount("1001",0.00,customer,"Gold");
		dao.saveAccount(account);
		// put some entries to these accounts
		return data;
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
		ccac.show();

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
		Address address = new Address(street,city,state,zip);
		//String accountnr, clientName,street,city,zip,state,accountType,clientType,amountDeposit;
		Customer customer = new Customer(clientName,address,email, null);
		Account account = new CreditCardAccount(ccnumber,0.00,customer,accountType);
		dao.saveAccount(account);
    }

	void JButtonGenerateBill_actionPerformed(java.awt.event.ActionEvent event)
	{
//		JDialogGenBill billFrm = new JDialogGenBill();
//		billFrm.setBounds(450, 20, 400, 350);
//		billFrm.show();
		int selectedRow = JTable1.getSelectedRow();
		String accountNumber = (String) model.getValueAt(selectedRow, 1);
		currentAccount = dao.loadAccount(accountNumber);
		TransactionRecordsWindow recordsWindow = new TransactionRecordsWindow(dao, currentAccount);
		// Open the transaction records window for the selected account
	    
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
            String name = (String)model.getValueAt(selection, 0);
			String accountNumber = (String) model.getValueAt(selection, 1);
			currentAccount = dao.loadAccount(accountNumber);
		    //Show the dialog for adding deposit amount for the current mane
		    JDialog_Deposit dep = new JDialog_Deposit(thisframe,name);
		    dep.setBounds(430, 15, 275, 160);
		    dep.show();
    		
		    // compute new amount
            double deposit = Double.parseDouble(amountDeposit);
            String samount = (String)model.getValueAt(selection, 4);
			double currentamount = Double.parseDouble(samount);
			double newamount=currentamount-deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 4);
			AccountEntry entry = new AccountEntry(-deposit,"deposit","","",TransactionType.DEPOSIT);
			currentAccount.addEntry(entry);
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
            String name = (String)model.getValueAt(selection, 0);
			String accountNumber = (String) model.getValueAt(selection, 1);
			currentAccount = dao.loadAccount(accountNumber);
		    //Show the dialog for adding withdraw amount for the current mane
		    JDialog_Withdraw wd = new JDialog_Withdraw(thisframe,name);
		    wd.setBounds(430, 15, 275, 160);
		    wd.show();
    		
		    // compute new amount
			double deposit = Double.parseDouble(amountDeposit);
            String samount = (String)model.getValueAt(selection, 4);
			double currentamount = Double.parseDouble(samount);
			double newamount=currentamount+deposit;
		    model.setValueAt(String.valueOf(newamount),selection, 4);
			AccountEntry entry = new AccountEntry(deposit,"withdraw","","",TransactionType.WITHDRAW);
			currentAccount.addEntry(entry);
		}
		
		
	}
	
}
