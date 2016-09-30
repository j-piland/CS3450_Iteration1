package cs3450.storemanager.admin.accountmanager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AdminAccountManagerCard extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**GUI components
	 * 
	 */
	
	private JLabel AMinputPrompt;
	private JTextField AMsearch;
	private JComboBox accountOptions;
	private String [] optionsList;
	private JButton AMexecute;
	private JPanel buttonGrid;
	
	private JTextArea display;
	private JScrollPane AVscroll;
	
	private JLabel blank;
	private JButton AMbackButton;
	private JPanel bottomBar;
	
	@SuppressWarnings("unchecked")
	public AdminAccountManagerCard(){
		this.setLayout(new BorderLayout());
		
		optionsList = new String [] {"View All", "Search by ID", "Search by Name", "Add", "Update", "Delete"};
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1,4));
		AMinputPrompt = new JLabel("Input Here: ");
		accountOptions = new JComboBox(optionsList);
		accountOptions.setSelectedIndex(0);
		AMsearch = new JTextField();
		AMexecute = new JButton("Execute");
		buttonGrid.add(AMinputPrompt);
		buttonGrid.add(AMsearch);
		buttonGrid.add(accountOptions);
		buttonGrid.add(AMexecute);
		
		display = new JTextArea();
		display.setEditable(false);
		AVscroll = new JScrollPane(display);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		blank = new JLabel("");
		AMbackButton = new JButton("Back");
		bottomBar.add(blank);
		bottomBar.add(AMbackButton);

		
		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(AVscroll, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}
	
	public JButton getAMbackButton(){
		return AMbackButton;
	}
	
	public JButton getAMexecute(){
		return AMexecute;
	}
	
	public void setAMbox(int a){
		accountOptions.setSelectedIndex(a);
	}
	
	public String getAMsearch(){
		return AMsearch.getText();
	}
	
	public void setAMsearch(String t){
		AMsearch.setText(t);
		}
	
	public int AMexecute(){
		//==================================================================
		if(accountOptions.getSelectedIndex()==0){
			int rID=0;//2
			String rUsername = new String();//3
			String rName = new String();//5
			//int rStatus=0;//6
			String rPhone = new String();//7
			String rAddress = new String();//8
			String results = new String("");
			String sStatus = new String();
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			Connection db;
			try {
				db = DriverManager.getConnection("jdbc:postgresql:testusers","postgres", "123456");
			
			
				Statement st = db.createStatement();
				
				ResultSet rs = st.executeQuery("SELECT * FROM userinfo ORDER BY storeid ASC");
				if (rs.next()){
					do{
						if (rs.getInt(6)==1){
							sStatus = "Administrator";
						}else if (rs.getInt(6)==2){
							sStatus = "Clerk";
						}
						
						rName = rs.getString(5);
						rID = rs.getInt(2);
						rUsername = rs.getString(3);
						rPhone = rs.getString(7);
						rAddress = rs.getString(8);
						
						
						results +=   "Employee: " + rName + "\n" +
									"Store ID Number: " + rID + "\n" +
									"Status: " + sStatus + "\n" +
									"Username: " + rUsername + "\n" + 
									"Phone: " + rPhone + "\n" +
									"Address: " + rAddress + "\n\n";
									
					}while(rs.next());
				} else {
					results = "No Employees listed";
				}
				display.setText(results);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		//=================================================================
		}else if (accountOptions.getSelectedIndex()==1){		
			String searchid= AMsearch.getText();
			int rID=0;//2
			String rUsername = new String();//3
			String rName = new String();//5
			//int rStatus=0;//6
			String rPhone = new String();//7
			String rAddress = new String();//8
			String results = new String();
			String sStatus = new String();
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			Connection db;
			try {
				db = DriverManager.getConnection("jdbc:postgresql:testusers","postgres", "123456");
			
			
				Statement st = db.createStatement();
				
				ResultSet rs = st.executeQuery("SELECT * FROM userinfo WHERE storeid = " + searchid + " ORDER BY storeid ASC");
				
				if(rs.next()){
					if (rs.getInt(6)==1){
						sStatus = "Administrator";
					}else if (rs.getInt(6)==2){
						sStatus = "Clerk";
					}
					
					rName = rs.getString(5);
					rID = rs.getInt(2);
					rUsername = rs.getString(3);
					rPhone = rs.getString(7);
					rAddress = rs.getString(8);
					
					
					results =   "Employee: " + rName + "\n" +
								"Store ID Number: " + rID + "\n" +
								"Status: " + sStatus + "\n" +
								"Username: " + rUsername + "\n" + 
								"Phone: " + rPhone + "\n" +
								"Address: " + rAddress + "\n\n";
								
				} else {
					results = "No results found";
				}
				
				display.setText(results);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//================================================================
		}else if(accountOptions.getSelectedIndex()==2){
			String searchName= AMsearch.getText();
			int rID=0;//2
			String rUsername = new String();//3
			String rName = new String();//5
			//int rStatus=0;//6
			String rPhone = new String();//7
			String rAddress = new String();//8
			String results = new String();
			String sStatus = new String();
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			Connection db;
			try {
				db = DriverManager.getConnection("jdbc:postgresql:testusers","postgres", "123456");
			
			
				Statement st = db.createStatement();
				
				ResultSet rs = st.executeQuery("SELECT * FROM userinfo WHERE name = " + searchName + " ORDER BY storeid ASC");
				
				if(rs.next()){
					if (rs.getInt(6)==1){
						sStatus = "Administrator";
					}else if (rs.getInt(6)==2){
						sStatus = "Clerk";
					}
					
					rName = rs.getString(5);
					rID = rs.getInt(2);
					rUsername = rs.getString(3);
					rPhone = rs.getString(7);
					rAddress = rs.getString(8);
					
					
					results =   "Employee: " + rName + "\n" +
								"Store ID Number: " + rID + "\n" +
								"Status: " + sStatus + "\n" +
								"Username: " + rUsername + "\n" + 
								"Phone: " + rPhone + "\n" +
								"Address: " + rAddress + "\n\n";
								
				} else {
					results = "No results found";
				}
				
				display.setText(results);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(accountOptions.getSelectedIndex()==3){
			return 1;//add
		//================================================================
		}else if(accountOptions.getSelectedIndex()==4){
			return 2;//update
		//================================================================
		}else if(accountOptions.getSelectedIndex()==5){
			String searchid= AMsearch.getText();
			
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
				
				if((JOptionPane.showConfirmDialog(null, "Are you sure you want to delete user: " + searchid + "?", "Delete Warning", JOptionPane.OK_CANCEL_OPTION))==JOptionPane.OK_OPTION){
					st.executeUpdate("DELETE FROM userinfo * WHERE storeid = \'" + searchid+"\'");
					db.commit();
					JOptionPane.showMessageDialog(null, "User has been deleted", "User Deleted", JOptionPane.WARNING_MESSAGE);
					st.executeUpdate("DELETE FROM userinfo * WHERE name = \'" + searchid + "\'");
					System.out.println("DELETE FROM userinfo * WHERE name = \'" + searchid + "\'");
					db.commit();
					JOptionPane.showMessageDialog(null, "User has been deleted", "User Deleted", JOptionPane.WARNING_MESSAGE);
				}
				
				int rID=0;//2
				String rUsername = new String();//3
				String rName = new String();//5
				//int rStatus=0;//6
				String rPhone = new String();//7
				String rAddress = new String();//8
				String results = new String("");
				String sStatus = new String();
				ResultSet rs = st.executeQuery("SELECT * FROM userinfo ORDER BY storeid ASC");
				if (rs.next()){
					do{
						if (rs.getInt(6)==1){
							sStatus = "Administrator";
						}else if (rs.getInt(6)==2){
							sStatus = "Clerk";
						}
						
						rName = rs.getString(5);
						rID = rs.getInt(2);
						rUsername = rs.getString(3);
						rPhone = rs.getString(7);
						rAddress = rs.getString(8);
						
						
						results +=   "Employee: " + rName + "\n" +
									"Store ID Number: " + rID + "\n" +
									"Status: " + sStatus + "\n" +
									"Username: " + rUsername + "\n" + 
									"Phone: " + rPhone + "\n" +
									"Address: " + rAddress + "\n\n";
									
					}while(rs.next());
				} else {
					results = "No Employees listed";
				}
				display.setText(results);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}//The end of the mega function
	
	
	public void AMclearBoard(){
			display.setText("");
		}























/*{
	private static final long serialVersionUID = 1L;
	
	*//**GUI components
	 * 
	 *//*
	private JLabel AMtitle;
	private JButton AMaddButton;
	private JButton AMdeleteButton;
	private JButton AMviewButton;
	private JButton AMupdateButton;
	private JPanel buttonGrid;
	
	private JButton AMbackButton;
	private JButton AMlogoutButton;
	private JPanel bottomBar;
	
	public AdminAccountManagerCard(){
		this.setLayout(new BorderLayout());
		
		AMtitle = new JLabel("Administrator Account Manager");
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(4,1));
		AMaddButton = new JButton("Add Account");
		AMdeleteButton = new JButton("Delete Account");
		AMviewButton = new JButton("View Account");
		AMupdateButton = new JButton("Update Account");
		buttonGrid.add(AMaddButton);
		buttonGrid.add(AMdeleteButton);
		buttonGrid.add(AMviewButton);
		buttonGrid.add(AMupdateButton);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		AMbackButton = new JButton("Back");
		AMlogoutButton = new JButton("Logout");
		bottomBar.add(AMbackButton);
		bottomBar.add(AMlogoutButton);
		
		this.add(AMtitle, BorderLayout.NORTH);
		this.add(buttonGrid, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}
	
	public JButton getAMaddButton(){
		return AMaddButton;
	}
	
	public JButton getAMdeleteButton(){
		return AMdeleteButton;
	}
	
	public JButton getAMviewButton(){
		return AMviewButton;
	}
	
	public JButton getAMupdateButton(){
		return AMupdateButton;
	}
	
	public JButton getAMbackButton(){
		return AMbackButton;
	}
	
	public JButton getAMlogoutButton(){
		return AMlogoutButton;
	}
	
	public void AMaddUser(){
		
	}
	
	public void AMdeleteUser(){
		
	}
	
	public void AMupdateUser(){
		
	}*/
}
