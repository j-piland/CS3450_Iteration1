package cs3450.storemanager.admin.accountcard;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AdminAccountCard extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**GUI Components
	 * 
	 */
	private JLabel title;
	private JPanel buttonGrid;
	private JButton AAaccountButton;
	private JButton AAcheckoutButton;
	private JButton AAinventoryButton;
	private JButton AAhistoryButton;
	private JPanel bottomBar;
	private JButton AAlogoutButton;
	private JButton AAexitButton;
	
	
	public AdminAccountCard(){
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Administrator Main Menu", SwingConstants.CENTER);
		
		buttonGrid = new JPanel();
		buttonGrid.setLayout(new GridLayout(2,2));
		AAaccountButton = new JButton("Account Manager");
		AAcheckoutButton = new JButton("Checkout");
		AAinventoryButton = new JButton("Inventory Manager");
		AAhistoryButton = new JButton("Sales History");
		buttonGrid.add(AAaccountButton);
		buttonGrid.add(AAcheckoutButton);
		buttonGrid.add(AAinventoryButton);
		buttonGrid.add(AAhistoryButton);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		AAlogoutButton = new JButton("Logout");
		AAexitButton = new JButton("Exit");
		bottomBar.add(AAlogoutButton);
		bottomBar.add(AAexitButton);
		
		this.add(title, BorderLayout.NORTH);
		this.add(buttonGrid, BorderLayout.CENTER);
		this.add(bottomBar, BorderLayout.SOUTH);
	}
	
	public JButton getAAaccountButton(){
		return AAaccountButton;
	}
	
	public JButton getAAcheckoutButton(){
		return AAcheckoutButton;
	}
	
	public JButton getAAinventoryButton(){
		return AAinventoryButton;
	}
	
	public JButton getAAhistoryButton(){
		return AAhistoryButton;
	}
	
	public JButton getAAlogoutButton(){
		return AAlogoutButton;
	}
	
	public JButton getAAexitButton(){
		return AAexitButton;
	}

}
