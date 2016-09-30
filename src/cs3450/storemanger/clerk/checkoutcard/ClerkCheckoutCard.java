package cs3450.storemanger.clerk.checkoutcard;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ClerkCheckoutCard extends JPanel {
	private static final long serialVersionUID = 1L;
	
	/**GUI Members
	 * 
	 **/
	
	private JLabel title;
	private JPanel leftBar;
	private JButton CCaddItemButton;
	private JButton CCremoveItemButton;
	private JPanel bottomBar;
	private JButton CCprintReceiptButton;
	private JButton CClogoutButton;
	private JTextArea CCItemDisplay;
	private JScrollPane CCScroll;
	
	
	public ClerkCheckoutCard(){
		this.setLayout(new BorderLayout());
		
		title = new JLabel("Checkout Item Display", SwingConstants.CENTER);
		
		leftBar = new JPanel();
		leftBar.setLayout(new GridLayout(2,1,0,100));
		CCaddItemButton = new JButton("Add");
		CCremoveItemButton = new JButton("Remove");
		leftBar.add(CCaddItemButton);
		leftBar.add(CCremoveItemButton);
		
		bottomBar = new JPanel();
		bottomBar.setLayout(new GridLayout(1,2));
		CCprintReceiptButton = new JButton("Print");
		CClogoutButton = new JButton("Logout");
		bottomBar.add(CCprintReceiptButton);
		bottomBar.add(CClogoutButton);
		
		CCItemDisplay = new JTextArea(5,20);
		CCItemDisplay.setEditable(false);
		CCScroll = new JScrollPane(CCItemDisplay);
		
		this.add(title, BorderLayout.NORTH);
		this.add(leftBar, BorderLayout.WEST);
		this.add(bottomBar, BorderLayout.SOUTH);
		this.add(CCScroll, BorderLayout.CENTER);
	}
	
	public JButton getCCaddItemButton(){
		return CCaddItemButton;
	}
	
	public JButton getCCremoveItemButton(){
		return CCremoveItemButton;
	}
	
	public JButton getCCprintReceiptButton(){
		return CCprintReceiptButton;
	}
	
	public JButton getCClogoutButton(){
		return CClogoutButton;
	}

}
