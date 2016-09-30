package cs3450.storemanager.admin.checkoutcard;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class AdminCheckoutCard extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**GUI Members
	 * 
	 **/
	
	private JLabel title;
	private JPanel leftBar;
	private JButton CCaddItemButton;
	private JButton CCremoveItemButton;
	private JPanel bottomBar;
	private JButton ACprintReceiptButton;
	private JButton ACbackButton;
	private JButton AClogoutButton;
	private JTextArea ACItemDisplay;
	private JScrollPane ACScroll;
	
	
	public AdminCheckoutCard(){
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Checkout Item Display", SwingConstants.CENTER);
		
		leftBar = new JPanel();
		leftBar.setLayout(new GridLayout(2,1,0,100));
		CCaddItemButton = new JButton("Add");
		CCremoveItemButton = new JButton("Remove");
		leftBar.add(CCaddItemButton);
		leftBar.add(CCremoveItemButton);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,3));
		ACprintReceiptButton = new JButton("Print");
		ACbackButton = new JButton("Back");
		AClogoutButton = new JButton("Logout");
		bottomBar.add(ACprintReceiptButton);
		bottomBar.add(ACbackButton);
		bottomBar.add(AClogoutButton);
		
		ACItemDisplay = new JTextArea(5,20);
		ACItemDisplay.setEditable(false);
		ACScroll = new JScrollPane(ACItemDisplay);
		
		this.add(title, BorderLayout.NORTH);
		this.add(leftBar, BorderLayout.WEST);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(ACScroll, BorderLayout.CENTER);
	}
	
	public JButton getACaddItemButton(){
		return CCaddItemButton;
	}
	
	public JButton getACremoveItemButton(){
		return CCremoveItemButton;
	}
	
	public JButton getACprintReceiptButton(){
		return ACprintReceiptButton;
	}
	
	public JButton getACbackButton(){
		return ACbackButton;
	}
	
	public JButton getAClogoutButton(){
		return AClogoutButton;
	}

}
