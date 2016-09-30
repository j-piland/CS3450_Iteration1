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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AccountUpdateCard extends JPanel{
	private static final long serialVersionUID = 1L;
	
	/**
	 * GUI components
	 */
	
	private JLabel AUinputPrompt;
	private JTextField AUsearch;
	private JComboBox accountOptions;
	private String [] optionsList;
	private JButton AUexecute;
	private JPanel buttonGrid;
	
	
	private JPanel optionsGrid;
	private JCheckBox cbID;
	private JCheckBox cbName;
	private JCheckBox cbPhone;
	private JCheckBox cbAddress;
	private JCheckBox cbUser;
	private JCheckBox cbPassword;
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
	private Checkbox AUadmin;
	private Checkbox AUclerk;
	private Checkbox AUnochange;
	
	private JPanel bottomBar;
	private JButton AUupdateButton;
	private JButton AUbackButton;
	
	public AccountUpdateCard(){
		this.setLayout(new BorderLayout());
		
		optionsList = new String [] {"View All", "Search by ID", "Search by Name", "Add", "Update", "Delete"};
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1,4));
		AUinputPrompt = new JLabel("Input Here: ");
		accountOptions = new JComboBox(optionsList);
		accountOptions.setSelectedIndex(3);
		AUsearch = new JTextField();
		AUexecute = new JButton("Execute");
		buttonGrid.add(AUinputPrompt);
		buttonGrid.add(AUsearch);
		buttonGrid.add(accountOptions);
		buttonGrid.add(AUexecute);	
		
		cbgPanel = new JPanel();
		cbgPanel.setLayout(new GridLayout(3,1));
		cbg = new CheckboxGroup();
		cbgPanel.add(cbgLabel = new JLabel("Status: "));
		cbgPanel.add(AUadmin = new Checkbox("Administrator", cbg, false));
		cbgPanel.add(AUclerk = new Checkbox("Clerk", cbg, false));
		cbgPanel.add(AUnochange = new Checkbox("No Change", cbg, true));
		
		optionsGrid = new JPanel();
		optionsGrid.setLayout(new GridLayout(7,4));
		//optionsGrid.setAlignmentY(JComponent.CENTER_ALIGNMENT);
		//optionsGrid.add(blank);
		optionsGrid.add(cbID = new JCheckBox());
		optionsGrid.add(lID = new JLabel("Store ID: "));
		optionsGrid.add(tID = new JTextField());
		//optionsGrid.add(blank2);
		optionsGrid.add(cbName = new JCheckBox());
		optionsGrid.add(lName = new JLabel("Full Name: "));
		optionsGrid.add(tName = new JTextField());
		//optionsGrid.add(blank3);
		optionsGrid.add(cbPhone = new JCheckBox());
		optionsGrid.add(lPhone = new JLabel("Phone: "));
		optionsGrid.add(tPhone = new JTextField());
		//optionsGrid.add(blank4);
		optionsGrid.add(cbAddress = new JCheckBox());
		optionsGrid.add(lAddress = new JLabel("Address: "));
		optionsGrid.add(tAddress = new JTextField());
		//optionsGrid.add(blank5);
		optionsGrid.add(cbUser = new JCheckBox());
		optionsGrid.add(lUser = new JLabel("User: "));
		optionsGrid.add(tUser = new JTextField());
		//optionsGrid.add(blank6);
		optionsGrid.add(cbPassword = new JCheckBox());
		optionsGrid.add(lPassword = new JLabel("Password: "));
		optionsGrid.add(tPassword = new JTextField());
		optionsGrid.add(cbgPanel);
		//optionsGrid.add(blank);
		//optionsGrid.add(blank);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		AUbackButton = new JButton("Back");
		AUupdateButton = new JButton("Update");
		bottomBar.add(AUupdateButton);
		bottomBar.add(AUbackButton);
		
		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(blank, BorderLayout.WEST);
		this.add(optionsGrid, BorderLayout.CENTER);
	}
	
	public void setAUbox(int a){
		accountOptions.setSelectedIndex(a);
	}
	
	public String getAUsearch(){
		return AUsearch.getText();
	}
	
	public void setAUsearch(String t){
		AUsearch.setText(t);
	}
	
	public JButton getAUexecuteButton(){
		return AUexecute;
	}
	
	public JButton getAUbackButton(){
		return AUbackButton;
	}
	
	public JCheckBox getCBID(){
		return cbID;
	}
	
	public JCheckBox getCBName(){
		return cbName;
	}
	
	public JCheckBox getCBPhone(){
		return cbPhone;
	}
	
	public JCheckBox getCBAddress(){
		return cbAddress;
	}
	
	public JCheckBox getCBUser(){
		return cbUser;
	}
	
	public JCheckBox getCBPassword(){
		return cbPassword;
	}
	
	public JButton getAUupdateButton(){
		return AUupdateButton;
	}
	
	public int AUexecute(){
		//=======================================================
		if (accountOptions.getSelectedIndex()==0){
			return 0;
		}
		//=======================================================
		if(accountOptions.getSelectedIndex()==1){
			return 1;
		}
		//=======================================================
		if(accountOptions.getSelectedIndex()==3){
			return 3;
		}
		//=======================================================
		if(accountOptions.getSelectedIndex()==5){
			return 5;
		}
		//=======================================================
		if(accountOptions.getSelectedIndex()==4){
			if((JOptionPane.showConfirmDialog(null, "Are you sure you want to make these updates?", "Update Warning", JOptionPane.OK_CANCEL_OPTION))==JOptionPane.CANCEL_OPTION){
				return 4;
			}
			
			Boolean procede = false;
			String searcher = new String("Update userinfo SET ");
			String sStatus = new String();
			
			//Update testusers
			//Set id=id, ...
			//WHERE store id = 
			
			if(cbID.isSelected() && tID.getText().length()!=0){
				searcher += "storeID = " + tID.getText() + ", ";
				procede = true;
			}
			if(cbName.isSelected() && tName.getText().length()!=0){
				searcher += "name = \'" + tName.getText() + "\', ";
				procede = true;
			}
			if(cbPhone.isSelected() && tPhone.getText().length()!=0){
				searcher += "phone = \'" + tPhone.getText() + "\', ";
				procede = true;
			}
			if(cbAddress.isSelected() && tAddress.getText().length()!=0){
				searcher += "address = \'" + tAddress.getText() + "\', ";
				procede = true;
			}
			if(cbUser.isSelected() && tUser.getText().length()!=0){
				searcher += "username = \'" + tUser.getText() + "\', ";
				procede = true;
			}
			if(cbPassword.isSelected() && tPassword.getText().length()!=0){
				searcher += "password = \'" + tPassword.getText().hashCode() + "\', ";
				procede = true;
				if(passwordUsedCheck()){
					JOptionPane.showMessageDialog(null, "Update Unsuccessful - password has been used before", "Alert", JOptionPane.ERROR_MESSAGE);
					return 4;
				}
			}
			if(cbg.getSelectedCheckbox()==AUadmin){
				searcher += "status = 1, ";
			}
			if(cbg.getSelectedCheckbox()==AUclerk){
				searcher += "status = 2, ";
			}
			
			if(!procede || AUsearch.getText().length()==0){
				JOptionPane.showMessageDialog(null, "No changes made.", "Alert", JOptionPane.ERROR_MESSAGE);
				return 4;
			}
			
			searcher = searcher.substring(0, searcher.length()-2);
			searcher += " WHERE storeid = " + AUsearch.getText();
			
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			Connection db;
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
		
		return 4;
		
	}
	
	private boolean passwordUsedCheck(){
		Connection db;
		String tester = new String();
		try {
			db = DriverManager.getConnection("jdbc:postgresql:testusers","postgres", "123456");
			db.setAutoCommit(false);
			
			Statement st = db.createStatement();
			
			
			ResultSet rs = st.executeQuery("SELECT password FROM passwords WHERE storeid = " + AUsearch.getText());
			
			if (rs.next()){
				do{
					tester=rs.getString("password");
					if(tPassword.getText().equals(tester)){
						return true;
					}
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;

	}
}
