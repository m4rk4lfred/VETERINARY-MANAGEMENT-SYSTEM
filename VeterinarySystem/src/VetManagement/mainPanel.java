package VetManagement;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.CardLayout;

public class mainPanel extends JFrame {
    private JTabbedPane tabbedPane;
	private JPanel homeButton = new JPanel();
	private JPanel appointmentButton = new JPanel();
	private JPanel inventoryButton = new JPanel();
	private JPanel patientButton = new JPanel();
	private JPanel staffButton = new JPanel();
	private JLabel homeLabel;
	private JLabel appointmentLabel;
	private JLabel inventoryLabel;
	private JLabel patientLabel;
	private JLabel staffLabel;
	private home home = new home();
	private appointments appointment = new appointments();
	private inventory inventory = new inventory();
	private patientList patient = new patientList();
	private staffMembers staff = new staffMembers();
	JPanel cardLayoutPanel;
    String imageLocation;
    
	
	buttonHandle handle;
	JLabel homeLogo = new JLabel();
	public mainPanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 931, 685); //the 4 parameter of set bounds is (X-Axis , Y-Axis, Width , Height)
		this.setLocationRelativeTo(null);//putting the Frame in the center of the screen
		getContentPane().setLayout(null);
		
		
		//MAIN PANEL
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(SystemColor.inactiveCaption);
		mainPanel.setForeground(SystemColor.inactiveCaption);
		mainPanel.setBounds(0, 0, 917, 648);
		getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		
		//TOP PANEL 
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(90,197,149));
		topPanel.setBounds(0, 0, 917, 56);
		mainPanel.add(topPanel);
		topPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("VETMANAGEMENT");
		lblNewLabel_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(27, 0, 156, 56);
		topPanel.add(lblNewLabel_1);
		
		
		//NAVIGATION PANEL
		JPanel navigationPanel = new JPanel();
		navigationPanel.setBackground(new Color(245, 245, 245));
		navigationPanel.setBounds(0, 55, 181, 593);
		mainPanel.add(navigationPanel);
		navigationPanel.setLayout(null);
		
		
		//SETTING ALL THE BUTTONS
		homeButton.setBounds(0, 60, 181, 43);
		homeButton.setLayout(null);//SETTING THE LAYOUT TO NULL TO FREELY MOVE THE LABELS
		homeButton.setBackground(new Color(255, 255, 255));
		appointmentButton.setBackground(new Color(255, 255, 255));
		appointmentButton.setBounds(0, 101, 181, 43);
		appointmentButton.setLayout(null);//SETTING THE LAYOUT TO NULL TO FREELY MOVE THE LABELS
		inventoryButton.setBackground(new Color(255, 255, 255));
		inventoryButton.setBounds(0, 143, 181, 43);
		inventoryButton.setLayout(null);//SETTING THE LAYOUT TO NULL TO FREELY MOVE THE LABELS
		patientButton.setBackground(new Color(255, 255, 255));
		patientButton.setBounds(0, 183, 181, 43);
		patientButton.setLayout(null);//SETTING THE LAYOUT TO NULL TO FREELY MOVE THE LABELS
		staffButton.setBackground(new Color(255, 255, 255));
		staffButton.setBounds(0, 223, 181, 43);
		staffButton.setLayout(null);//SETTING THE LAYOUT TO NULL TO FREELY MOVE THE LABELS
		
		
		//TEXT FOR THE BUTTONS
		JLabel lblNewLabel = new JLabel("MAIN NAVIGATION");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 136, 49);
	    
		//ADDING THE TEXT TO THE NAVIGATION PANEL(the main navigation label)
		navigationPanel.add(lblNewLabel);
		
		//CALENDARLABEL
		JLabel calendarLabel = new JLabel("CLINIC CALENDAR");
		calendarLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		calendarLabel.setBounds(45, 0, 139, 43);
		
		//APPOINTMENTLABEL
		JLabel appointmentLabel = new JLabel("APPOINTMENT LIST");
		appointmentLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		appointmentLabel.setBounds(36, 0, 149, 43);
		
		//INVENTORYLABEL
		JLabel inventoryLabel = new JLabel("INVENTORY");
		inventoryLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		inventoryLabel.setBounds(45, 0, 107, 43);
		
		//PATIENTLABEL
		JLabel patientLabel = new JLabel("PATIENT LIST");
		patientLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		patientLabel.setBounds(48, 0, 98, 43);
		
		//STAFFLABEL
		JLabel staffLabel = new JLabel("STAFF MEMBERS");
		staffLabel.setFont(new Font("Calibri", Font.BOLD, 13));
		staffLabel.setBounds(44, 0, 107, 43);
		appointmentButton.add(appointmentLabel);
		inventoryButton.add(inventoryLabel);
		patientButton.add(patientLabel);
		staffButton.add(staffLabel);
		
		//ADDING THE BUTTONS TO THE NAVIGATION PANEL
		navigationPanel.add(homeButton);
		
		homeLogo.setBounds(64, 11, 25, 32);
		
		
		
		//NAVIGATION LOGO

		imageResizer("C:\\Users\\Lenovo\\Pictures\\homeIcon.png",homeLogo , homeButton );
		
		//HOMELABEL
		JLabel homeLabel_1 = new JLabel("HOME");
		homeLabel_1.setBounds(57, 15, 60, 21);
		homeButton.add(homeLabel_1);
		homeLabel_1.setFont(new Font("Calibri", Font.BOLD, 19));
		navigationPanel.add(appointmentButton);
		navigationPanel.add(inventoryButton);
		navigationPanel.add(patientButton);
		navigationPanel.add(staffButton);
		
		//CARD LAYOUT PANEL
		CardLayout cardLayout = new CardLayout(0, 0);
		cardLayoutPanel = new JPanel();
		cardLayoutPanel.setBounds(184, 67, 723, 570);
		mainPanel.add(cardLayoutPanel);
		cardLayoutPanel.setLayout(cardLayout);

		cardLayoutPanel.add(home, "home");
		cardLayoutPanel.add(appointment, "appointment");
		cardLayoutPanel.add(inventory, "inventory");
		cardLayoutPanel.add(patient, "patient");
		cardLayoutPanel.add(staff, "staff");
		
					
		//SETTING LISTENERS FOR THE BUTTONS
		
		homeButton.addMouseListener(new buttonHandle(this,cardLayoutPanel,cardLayout,"home"));		
		appointmentButton.addMouseListener(new buttonHandle(this,cardLayoutPanel,cardLayout,"appointment"));				
		inventoryButton.addMouseListener(new buttonHandle(this,cardLayoutPanel,cardLayout,"inventory"));
		patientButton.addMouseListener(new buttonHandle(this,cardLayoutPanel,cardLayout,"patient"));
		staffButton.addMouseListener(new buttonHandle(this,cardLayoutPanel,cardLayout,"staff"));
		
        this.setVisible(true);
	}
	public void imageResizer(String imageLocation , JLabel label , JPanel panel) {
		ImageIcon icon = new ImageIcon(imageLocation);
		Image resize = icon.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		icon = new ImageIcon(resize);
		label = new JLabel(icon);
		label.setBounds(10, 0, 44, 43); // Set bounds for the resized label
		panel.add(label);
	}
}


