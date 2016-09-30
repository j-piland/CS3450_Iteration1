package cs3450.storemanager.logincard;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginCard extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**The Members
	 * 
	 * logins - Track number of logins
	 * The rest are as they are on the tin
	 */
	private int logins;
	private JButton lExitButton;
	private JButton lAcceptButton;
	private JTextField username;
	private JPasswordField password;
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JPanel middleGrid;
	private JPanel bottomBar;
	
	public LoginCard(){
		logins = 0;
		
		this.setLayout(new BorderLayout());
		
		middleGrid = new JPanel();
		middleGrid.setLayout(new GridLayout(2,2,20,50));
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		
		//Buttons prepared in order of insertion to grid.
		
		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		username = new JTextField();
		password = new JPasswordField();
		password.setEchoChar('*');
		lAcceptButton = new JButton("Accept");
		lExitButton = new JButton("Exit");
		
		middleGrid.add(usernameLabel);
		middleGrid.add(username);
		middleGrid.add(passwordLabel);
		middleGrid.add(password);
		bottomBar.add(lAcceptButton);
		bottomBar.add(lExitButton);
		
		this.add(middleGrid, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}
	
	public JButton getLExitButton(){
		return lExitButton;
	}
	
	public JButton getLAcceptButton(){
		return lAcceptButton;
	}
	
	public int checkpassword(){
		int status=55;
		String un = username.getText();
		char [] temp = password.getPassword();
		String pass = new String(temp);
		
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection db;
		try {
			db = DriverManager.getConnection("jdbc:postgresql:testusers","postgres", "123456");
		
		
			Statement st = db.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT status FROM userinfo WHERE username = \'" + un + "\' AND password = \'" + pass.hashCode() +"\'");
			
			if(rs.next()){
				status = rs.getInt(1);
			} else {
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		username.setText("");
		password.setText("");
		
		return status;
	}
	
	public void timeout(){
		logins++;
		
		if (logins >= 5){
			JOptionPane.showMessageDialog(null, "Login has failed 5 times. Please wait 30 seconds.", "Login Timeout", JOptionPane.WARNING_MESSAGE);
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logins=0;
		}else{
			JOptionPane.showMessageDialog(null, "Login Failed\nPassword or Username incorrect", "Login Failure", JOptionPane.WARNING_MESSAGE);
		}
	}

}
