package cs3450.storemanager.admin.accountmanager;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AccountAddCard extends JPanel{
	private static final long serialVersionUID = 1L;
	
	/**
	 * GUI components
	 */
	
	private JLabel ADinputPrompt;
	private JTextField ADsearch;
	private JComboBox accountOptions;
	private String [] optionsList;
	private JButton AUexecute;
	private JPanel buttonGrid;
	
	
	private JPanel optionsGrid;
	private JLabel lID;
	private JLabel lName;
	private JLabel lPhone;
	private JLabel lAddress;
	private JLabel lUser;
	private JLabel lPassword;
	private JTextField tID;
	private JTextField tName;
	private JTextField tPhone;
	private JTextField tAddress;
	private JTextField tUser;
	private JTextField tPassword;
	private JLabel blank = new JLabel("               ");
	private JLabel blank2 = new JLabel("               ");
	private JLabel blank3 = new JLabel("               ");
	private JLabel blank4 = new JLabel("               ");
	private JLabel blank5 = new JLabel("               ");
	private JLabel blank6 = new JLabel("               ");

	
	private JPanel cbgPanel;
	private JLabel cbgLabel;
	private CheckboxGroup cbg;
	private Checkbox ADadmin;
	private Checkbox ADclerk;
	
	private JPanel bottomBar;
	private JButton ADaddButton;
	private JButton ADbackButton;
	
	public AccountAddCard(){
		this.setLayout(new BorderLayout());
		
		optionsList = new String [] {"View All", "Search by ID", "Search by Name", "Add", "Update", "Delete"};
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1,4));
		ADinputPrompt = new JLabel("Input Here: ");
		accountOptions = new JComboBox(optionsList);
		accountOptions.setSelectedIndex(3);
		ADsearch = new JTextField();
		AUexecute = new JButton("Execute");
		buttonGrid.add(ADinputPrompt);
		buttonGrid.add(ADsearch);
		buttonGrid.add(accountOptions);
		buttonGrid.add(AUexecute);	
		
		cbgPanel = new JPanel();
		cbgPanel.setLayout(new GridLayout(3,1));
		cbg = new CheckboxGroup();
		cbgPanel.add(cbgLabel = new JLabel("Status: "));
		cbgPanel.add(ADadmin = new Checkbox("Administrator", cbg, false));
		cbgPanel.add(ADclerk = new Checkbox("Clerk", cbg, true));
		
		optionsGrid = new JPanel();
		optionsGrid.setLayout(new GridLayout(7,2));
		//optionsGrid.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		//optionsGrid.add(blank);
		optionsGrid.add(lID = new JLabel("Store ID: "));
		optionsGrid.add(tID = new JTextField());
		//optionsGrid.add(blank2);
		optionsGrid.add(lName = new JLabel("Full Name: "));
		optionsGrid.add(tName = new JTextField());
		//optionsGrid.add(blank3);
		optionsGrid.add(lPhone = new JLabel("Phone: "));
		optionsGrid.add(tPhone = new JTextField());
		//optionsGrid.add(blank4);
		optionsGrid.add(lAddress = new JLabel("Address: "));
		optionsGrid.add(tAddress = new JTextField());
		//optionsGrid.add(blank5);
		optionsGrid.add(lUser = new JLabel("User: "));
		optionsGrid.add(tUser = new JTextField());
		//optionsGrid.add(blank6);
		optionsGrid.add(lPassword = new JLabel("Password: "));
		optionsGrid.add(tPassword = new JTextField());
		optionsGrid.add(cbgPanel);
		//optionsGrid.add(blank);
		//optionsGrid.add(blank);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		ADbackButton = new JButton("Back");
		ADaddButton = new JButton("Add");
		bottomBar.add(ADaddButton);
		bottomBar.add(ADbackButton);
		
		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(blank, BorderLayout.WEST);
		this.add(optionsGrid, BorderLayout.CENTER);
	}
	
	public void setADbox(int a){
		accountOptions.setSelectedIndex(a);
	}
	
	public String getADsearch(){
		return ADsearch.getText();
	}
	
	public void setADsearch(String t){
		ADsearch.setText(t);
	}
	
	public JButton getADexecuteButton(){
		return AUexecute;
	}
	
	public JButton getADbackButton(){
		return ADbackButton;
	}
	
	
	
	public JButton getADaddButton(){
		return ADaddButton;
	}
	
	public int ADexecute(){
		//=======================================================
		if (accountOptions.getSelectedIndex()==0){
			return 0;
		}
		//=======================================================
		if(accountOptions.getSelectedIndex()==1){
			return 1;
		}
		//=======================================================
		if(accountOptions.getSelectedIndex()==2){
			return 2;
		}
		//=======================================================
		if(accountOptions.getSelectedIndex()==4){
			return 4;
		}
		//=======================================================
		if(accountOptions.getSelectedIndex()==5){
			return 5;
		}
		//=======================================================
		if(accountOptions.getSelectedIndex()==3){
	
			Boolean procede = false;
			String searcher = new String();
			String sStatus = new String();
			int idfromdb = 0;
			
			//Update testusers
			//Set id=id, ...
			//WHERE store id = 
			
			if( tID.getText().length()!=0 &&
				tName.getText().length()!=0 &&
				tPhone.getText().length()!=0 &&
				tAddress.getText().length()!=0 &&
				tUser.getText().length()!=0 &&
				tPassword.getText().length()!=0){
				//Logantesting.usu.edu
				procede = true;
			}
			
			if(!procede){
				JOptionPane.showMessageDialog(null, "Please Fill in All Fields.", "Alert", JOptionPane.ERROR_MESSAGE);
				return 3;
			}
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			Connection db;
			try {
				db = DriverManager.getConnection("jdbc:postgresql:testusers","postgres", "123456");
			
				Statement st = db.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM userinfo ORDER BY id DESC");
				
				if(rs.next()){
					idfromdb = rs.getInt("id");
				}else {
					JOptionPane.showMessageDialog(null, "Not drawing values from database.", "Alert", JOptionPane.ERROR_MESSAGE);
					return 3;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			idfromdb++;
			
			searcher = "INSERT INTO userinfo (id, storeid, username, password, name, status, phone, address) VALUES (" + idfromdb + ", " + tID.getText() + ", \'" +
						tUser.getText() + "\', \'" + tPassword.getText().hashCode() + "\', \'" + tName.getText() + "\', ";
	
			if(cbg.getSelectedCheckbox()==ADadmin){
				searcher += "1, ";
			}
			if(cbg.getSelectedCheckbox()==ADclerk){
				searcher += "2, ";
			}
			
			searcher += "\'" + tPhone.getText() + "\', \'" + tAddress.getText() + "\')";
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try {
				db = DriverManager.getConnection("jdbc:postgresql:testusers","postgres", "123456");
				db.setAutoCommit(false);
			
				Statement st = db.createStatement();
				System.out.println(searcher);
				st.executeUpdate(searcher);
				db.commit();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Update Complete!", "Update Alert", JOptionPane.PLAIN_MESSAGE);
		}
		
		return 3;
		
	}

}
