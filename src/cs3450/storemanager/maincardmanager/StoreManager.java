package cs3450.storemanager.maincardmanager;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cs3450.storemanager.admin.accountcard.AdminAccountCard;
import cs3450.storemanager.admin.accountmanager.AccountAddCard;
import cs3450.storemanager.admin.accountmanager.AccountUpdateCard;
//import cs3450.storemanager.admin.accountmanager.AccountViewCard;
import cs3450.storemanager.admin.accountmanager.AdminAccountManagerCard;
import cs3450.storemanager.admin.checkoutcard.AdminCheckoutCard;
import cs3450.storemanager.logincard.LoginCard;
import cs3450.storemanager.welcomecard.WelcomeCard;
import cs3450.storemanger.clerk.checkoutcard.ClerkCheckoutCard;


/**Store Manager
 * 
 * This is the main class. It will contain all the cards and references and gui
 * @author AdminPiland
 *
 */

public class StoreManager extends JFrame implements ActionListener, MouseListener, ItemListener {
	private static final long serialVersionUID = 1L;
	/**
	 * Gui base components
	 * pane - the container
	 * deck - part of card layout
	 * cl - part of card layout
	 * 
	 */
	private Container pane;
	private JPanel deck;
	private CardLayout cl;
	
	/**The cards
	 * 
	 * welcomeCard - The first card displayed
	 * loginCard - The card that displays the login menu
	 * ClerkCheckoutCard - The only card a logged in clerk should see
	 * AdminAccountCard - Admin main menu
	 * AdminCheckoutCard - Checkout card that Admins see
	 * AdminAccountManagerCard - Admin account manager menu
	 * (deprecated)Account View Card - For viewing accounts
	 * AccountUpdateCard - a screen for updating accounts
	 * AccountAddCard - a screen for adding accounts
	 */
	private WelcomeCard welcomeCard = new WelcomeCard();
	private LoginCard loginCard = new LoginCard();
	private ClerkCheckoutCard clerkCheckoutCard = new ClerkCheckoutCard();
	private AdminAccountCard adminAccountCard = new AdminAccountCard();
	private AdminCheckoutCard adminCheckoutCard = new AdminCheckoutCard();
	private AdminAccountManagerCard adminAccountManagerCard = new AdminAccountManagerCard();
	//private AccountViewCard accountViewCard = new AccountViewCard();
	private AccountUpdateCard accountUpdateCard = new AccountUpdateCard();
	private AccountAddCard accountAddCard = new AccountAddCard();
	
	/**
	 * StoreManager Constructor
	 */
	public StoreManager(){
		
		/**
		 * These are for the main window of the GUI
		 */
		this.setTitle("StoreManager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(true);
		pane = this.getContentPane();
		pane.setLayout(new BorderLayout());
		pane.setPreferredSize(new Dimension(640, 480));
		
		/**
		 * Setting up the WelcomeCard and listeners for login and exit buttons
		 */
		welcomeCard.getWExitButton().addActionListener(this);
		welcomeCard.getWLoginButton().addActionListener(this);
		
		/**
		 * Setting up the LoginCard and listeners for it's accept and exit buttons
		 */
		loginCard.getLAcceptButton().addActionListener(this);
		loginCard.getLExitButton().addActionListener(this);
		
		/**
		 * Setting up the ClerkCheckoutCard and listeners for it's addItem, removeItem, printReciept, and logout buttons
		 */
		clerkCheckoutCard.getCCaddItemButton().addActionListener(this);
		clerkCheckoutCard.getCCremoveItemButton().addActionListener(this);
		clerkCheckoutCard.getCCprintReceiptButton().addActionListener(this);
		clerkCheckoutCard.getCClogoutButton().addActionListener(this);
		
		/**
		 * Setting up the AdminAccountCard and it's 6 listeners
		 */
		adminAccountCard.getAAaccountButton().addActionListener(this);
		adminAccountCard.getAAcheckoutButton().addActionListener(this);
		adminAccountCard.getAAinventoryButton().addActionListener(this);
		adminAccountCard.getAAhistoryButton().addActionListener(this);
		adminAccountCard.getAAlogoutButton().addActionListener(this);
		adminAccountCard.getAAexitButton().addActionListener(this);
		
		/**
		 * Setting up the AdminCheckoutCard and it's 5 listeners
		 */
		adminCheckoutCard.getACaddItemButton().addActionListener(this);
		adminCheckoutCard.getACremoveItemButton().addActionListener(this);
		adminCheckoutCard.getACprintReceiptButton().addActionListener(this);
		adminCheckoutCard.getAClogoutButton().addActionListener(this);
		adminCheckoutCard.getACbackButton().addActionListener(this);
		
		/**
		 * Setting up the AdminAccountManagerCard and it's 6 listeners
		 */
		adminAccountManagerCard.getAMbackButton().addActionListener(this);
		adminAccountManagerCard.getAMexecute().addActionListener(this);
		/*adminAccountManagerCard.getAMaddButton().addActionListener(this);
		adminAccountManagerCard.getAMdeleteButton().addActionListener(this);
		adminAccountManagerCard.getAMviewButton().addActionListener(this);
		adminAccountManagerCard.getAMupdateButton().addActionListener(this);
		adminAccountManagerCard.getAMbackButton().addActionListener(this);
		adminAccountManagerCard.getAMlogoutButton().addActionListener(this);*/
		
		/**
		 *Setting up the AccountViewCard and it's 3 listeners 	
		 */
		/*accountViewCard.getAVsearchButton().addActionListener(this);
		accountViewCard.getAVviewAllButton().addActionListener(this);
		accountViewCard.getAVbackButton().addActionListener(this);*/
		
		/**
		 * Setting up the AccountUpdateCard and it's 8 listeners
		 */
		accountUpdateCard.getAUbackButton().addActionListener(this);
		accountUpdateCard.getAUexecuteButton().addActionListener(this);
		accountUpdateCard.getAUupdateButton().addActionListener(this);
		accountUpdateCard.getCBID().addItemListener(this);
		accountUpdateCard.getCBName().addItemListener(this);
		accountUpdateCard.getCBPhone().addItemListener(this);
		accountUpdateCard.getCBAddress().addItemListener(this);
		accountUpdateCard.getCBUser().addItemListener(this);
		accountUpdateCard.getCBPassword().addItemListener(this);
		
		/**
		 * Setting up the AccountAddCard and it's 3 listeners
		 */
		accountAddCard.getADbackButton().addActionListener(this);
		accountAddCard.getADexecuteButton().addActionListener(this);
		accountAddCard.getADaddButton().addActionListener(this);
		
		/**
		 * Adding cards to the deck
		 */
		deck = new JPanel(new CardLayout());
		deck.add(welcomeCard, "Welcome");
		deck.add(loginCard, "Login");
		deck.add(clerkCheckoutCard, "ClerkCheckout");
		deck.add(adminAccountCard, "AdminAccount");
		deck.add(adminCheckoutCard, "AdminCheckout");
		deck.add(adminAccountManagerCard, "AdminAccountManager");
		//deck.add(accountViewCard, "AccountView");
		deck.add(accountUpdateCard, "AccountUpdate");
		deck.add(accountAddCard, "AccountAdd");
		
		pane.add(deck, BorderLayout.CENTER);
		cl= (CardLayout)(deck.getLayout());
		cl.show(deck, "Welcome");
		
		this.pack();
		this.setLocationRelativeTo(null);	
		this.setVisible(true);
	}

	/**main
	 * 
	 * Creates a new StoreManager 
	 * @param args
	 */
	public static void main(String[] args) {
		new StoreManager();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//exit buttons
		if(e.getSource()==welcomeCard.getWExitButton() || e.getSource()==loginCard.getLExitButton()){
			System.exit(0);
		}
		
		//Welcome Card Login
		if(e.getSource()==welcomeCard.getWLoginButton()){
			cl.show(deck, "Login");
		}
		
		//Check correct Login
		if(e.getSource()==loginCard.getLAcceptButton()){
			int status = loginCard.checkpassword();
			
			if(status==0){
				loginCard.timeout();
			}
			
			if(status==1){
				cl.show(deck, "AdminAccount");
			}
			
			if(status==2){
				cl.show(deck, "ClerkCheckout");
			}
			
			if(status==55){
				System.out.println("Error 55, baby! Woooo!");
			}
			
		}
		
		//Clerk add items to receipt
		if(e.getSource()==clerkCheckoutCard.getCCaddItemButton()){
			
		}
		
		//Clerk remove items from receipt
		if(e.getSource()==clerkCheckoutCard.getCCremoveItemButton()){
			
		}
		
		//Clerk print receipt
		if(e.getSource()==clerkCheckoutCard.getCCprintReceiptButton()){
			
		}
		
		//Clerk logout
		if(e.getSource()==clerkCheckoutCard.getCClogoutButton()){
			cl.show(deck, "Welcome");
		}
		
		//Admin Main -> account
		if(e.getSource()==adminAccountCard.getAAaccountButton()){
			cl.show(deck, "AdminAccountManager");
		}
		
		//Admin Main -> checkout
		if(e.getSource()==adminAccountCard.getAAcheckoutButton()){
			cl.show(deck, "AdminCheckout");
		}
		
		//Admin Main -> inventory
		if(e.getSource()==adminAccountCard.getAAinventoryButton()){
			
		}
		
		//Admin Main -> history
		if(e.getSource()==adminAccountCard.getAAhistoryButton()){
			
		}
		
		//Admin Main -> logout
		if(e.getSource()==adminAccountCard.getAAlogoutButton()){
			cl.show(deck, "Welcome");
		}
		
		//Admin Main -> exit
		if(e.getSource()==adminAccountCard.getAAexitButton()){
			System.exit(0);
		}
		
		//Admin add items to receipt
		if(e.getSource()==adminCheckoutCard.getACaddItemButton()){
					
		}
				
		//Admin remove items from receipt
		if(e.getSource()==adminCheckoutCard.getACremoveItemButton()){
					
		}
				
		//Admin print receipt
		if(e.getSource()==adminCheckoutCard.getACprintReceiptButton()){
					
		}
				
		//Admin logout
		if(e.getSource()==adminCheckoutCard.getAClogoutButton()){
			cl.show(deck, "Welcome");
		}
		
		//Admin back button
		if(e.getSource()==adminCheckoutCard.getACbackButton()){
			cl.show(deck, "AdminAccount");
		}
		
		//Admin account manager back 
		if(e.getSource()==adminAccountManagerCard.getAMbackButton()){
			adminAccountManagerCard.AMclearBoard();
			cl.show(deck, "AdminAccount");
		}
		
		//Admin account manager execute
		if(e.getSource()==adminAccountManagerCard.getAMexecute()){
			int executer = adminAccountManagerCard.AMexecute();
			
			if(executer==1){
				accountAddCard.setADsearch(adminAccountManagerCard.getAMsearch());
				accountAddCard.setADbox(3);
				cl.show(deck, "AccountAdd");
			}
			if(executer==2){
				accountUpdateCard.setAUsearch(adminAccountManagerCard.getAMsearch());
				accountUpdateCard.setAUbox(4);
				cl.show(deck, "AccountUpdate");
			}
			
		}
			//Account Update suboptions
			if(e.getSource()==accountUpdateCard.getAUbackButton()){
				cl.show(deck, "AdminAccountManager");
			}
			if(e.getSource()==accountUpdateCard.getAUexecuteButton() || e.getSource()==accountUpdateCard.getAUupdateButton()){
				int executer = accountUpdateCard.AUexecute();
				
				if(executer==0){
					adminAccountManagerCard.setAMbox(0);
					adminAccountManagerCard.setAMsearch(accountUpdateCard.getAUsearch());
					cl.show(deck, "AdminAccountManager");
					adminAccountManagerCard.AMexecute();
				}
				if(executer==1){
					adminAccountManagerCard.setAMbox(1);
					adminAccountManagerCard.setAMsearch(accountUpdateCard.getAUsearch());
					cl.show(deck, "AdminAccountManager");
					adminAccountManagerCard.AMexecute();
				}
				if(executer==2){
					adminAccountManagerCard.setAMbox(2);
					adminAccountManagerCard.setAMsearch(accountUpdateCard.getAUsearch());
					cl.show(deck, "AdminAccountManager");
					adminAccountManagerCard.AMexecute();
				}
				if(executer==3){
					accountAddCard.setADbox(3);
					accountAddCard.setADsearch(accountUpdateCard.getAUsearch());
					cl.show(deck, "AccountAdd");
				}
				if(executer==5){
					adminAccountManagerCard.setAMbox(1);
					adminAccountManagerCard.setAMsearch(accountUpdateCard.getAUsearch());
					adminAccountManagerCard.AMexecute();
					adminAccountManagerCard.setAMbox(5);
					adminAccountManagerCard.setAMsearch(accountUpdateCard.getAUsearch());
					cl.show(deck, "AdminAccountManager");
					adminAccountManagerCard.AMexecute();
				}
			}
			//AccountAddSuboptions
			if(e.getSource()==accountUpdateCard.getAUbackButton()){
				cl.show(deck, "AdminAccountManager");
			}
			if(e.getSource()==accountAddCard.getADexecuteButton() || e.getSource()==accountAddCard.getADaddButton()){
				int executer = accountAddCard.ADexecute();
				
				if(executer==0){
					adminAccountManagerCard.setAMbox(0);
					adminAccountManagerCard.setAMsearch(accountAddCard.getADsearch());
					cl.show(deck, "AdminAccountManager");
					adminAccountManagerCard.AMexecute();
				}
				if(executer==1){
					adminAccountManagerCard.setAMbox(1);
					adminAccountManagerCard.setAMsearch(accountAddCard.getADsearch());
					cl.show(deck, "AdminAccountManager");
					adminAccountManagerCard.AMexecute();
				}
				if(executer == 2){
					adminAccountManagerCard.setAMbox(2);
					adminAccountManagerCard.setAMsearch(accountAddCard.getADsearch());
					cl.show(deck, "AdminAccountManager");
					adminAccountManagerCard.AMexecute();
				}
				if(executer==4){
					accountUpdateCard.setAUbox(4);
					accountUpdateCard.setAUsearch(accountAddCard.getADsearch());
					cl.show(deck, "AccountUpdate");
				}
				if(executer==5){
					adminAccountManagerCard.setAMbox(1);
					adminAccountManagerCard.setAMsearch(accountAddCard.getADsearch());
					adminAccountManagerCard.AMexecute();
					adminAccountManagerCard.setAMbox(5);
					adminAccountManagerCard.setAMsearch(accountAddCard.getADsearch());
					cl.show(deck, "AdminAccountManager");
					adminAccountManagerCard.AMexecute();
				}
			}
		/*//Admin AM add
		if(e.getSource()==adminAccountManagerCard.getAMaddButton()){
			adminAccountManagerCard.AMaddUser();
		}
		
		//Admin AM delete
		if(e.getSource()==adminAccountManagerCard.getAMdeleteButton()){
			adminAccountManagerCard.AMdeleteUser();
		}
		
		//Admin AM view
		if(e.getSource()==adminAccountManagerCard.getAMviewButton()){
			cl.show(deck, "AccountView");
		}
			
			if(e.getSource()==accountViewCard.getAVsearchButton()){
				accountViewCard.AVviewResults();
			}
			if(e.getSource()==accountViewCard.getAVviewAllButton()){
				accountViewCard.AVviewAllResults();
			}
			if(e.getSource()==accountViewCard.getAVbackButton()){
				accountViewCard.AVclearBoard();
				cl.show(deck, "AdminAccountManager");
			}
			
		//Admin AM update
		if(e.getSource()==adminAccountManagerCard.getAMupdateButton()){
			adminAccountManagerCard.AMupdateUser();
		}
		
		//Admin AM back
		if(e.getSource()==adminAccountManagerCard.getAMbackButton()){
			cl.show(deck, "AdminAccount");
		}
		
		//Admin AM logout
		if(e.getSource()==adminAccountManagerCard.getAMlogoutButton()){
			cl.show(deck, "Welcome");
		}*/
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==accountUpdateCard.getCBID()){
			
		}
		
	}
}