package cs3450.storemanager.admin.accountmanager;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AccountViewCard  extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**GUI components
	 * 
	 */
	
	private JLabel AVinputPrompt;
	private JTextField AVsearch;
	private JButton AVsearchButton;
	private JButton AVviewAllButton;
	private JPanel buttonGrid;
	
	private JTextArea display;
	private JScrollPane AVscroll;
	
	private JLabel blank;
	private JButton AVbackButton;
	private JPanel bottomBar;
	
	public AccountViewCard(){
		this.setLayout(new BorderLayout());
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(1,4));
		AVinputPrompt = new JLabel("Input User Store ID: ");
		AVsearch = new JTextField();
		AVsearchButton = new JButton("Search");
		AVviewAllButton = new JButton("View All");
		buttonGrid.add(AVinputPrompt);
		buttonGrid.add(AVsearch);
		buttonGrid.add(AVsearchButton);
		buttonGrid.add(AVviewAllButton);
		
		display = new JTextArea();
		display.setEditable(false);
		AVscroll = new JScrollPane(display);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		blank = new JLabel("");
		AVbackButton = new JButton("Back");
		bottomBar.add(blank);
		bottomBar.add(AVbackButton);

		
		this.add(buttonGrid, BorderLayout.NORTH);
		this.add(AVscroll, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}
	
	public JButton getAVbackButton(){
		return AVbackButton;
	}
	
	public JButton getAVsearchButton(){
		return AVsearchButton;
	}
	
	public JButton getAVviewAllButton(){
		return AVviewAllButton;
	}
	
	public void AVviewResults(){
		String searchid= AVsearch.getText();
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
		
	}
	
	public void AVviewAllResults(){
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
	}
	
	public void AVclearBoard(){
		display.setText("");
	}
}
