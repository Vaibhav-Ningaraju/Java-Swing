
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * This class is worked when user opened the system and ask for log in/sign up
 */
public class LoginView extends View {

	private static final long serialVersionUID = 1L;
	
	///////
	private JRadioButton Customer;
	private JRadioButton Admin;
	private JPanel panel_identity;
	
	private JTextField username;
	private JPasswordField password;
	private JButton loginButton, newAccButton;
	private JPanel panel_2;
	private JPanel panel_1;
	private JLabel lblUserId;
	private JPanel panel_3;
	private JLabel lblPassword;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JLabel lblNewLabel;
	private Component verticalStrut;

	public LoginView() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		panel_5 = new JPanel();
		panel.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		panel_6 = new JPanel();
		panel_5.add(panel_6);
		
		lblNewLabel = new JLabel();
		//lblNewLabel.setIcon(ShopController.LOGO_ICON);
		panel_6.add(lblNewLabel);
		
		panel_4 = new JPanel();
		panel_5.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		verticalStrut = Box.createVerticalStrut(20);
		panel_4.add(verticalStrut);
		
		
		panel_identity = new JPanel();
		Customer = new JRadioButton("Customer");
		Admin=new JRadioButton("Admin");  
		ButtonGroup bg=new ButtonGroup();  
		bg.add(Customer);
		bg.add(Admin);
		Customer.setSelected(true);
		panel_identity.add(Customer);
		Customer.setFocusable(false);
		panel_identity.add(Admin);
		Admin.setFocusable(false);
		
		panel_1 = new JPanel();
		panel_4.add(panel_identity);
		panel_4.add(panel_1);
		
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		lblUserId = new JLabel("User ID");
		panel_1.add(lblUserId);
		
		username = new JTextField();
		panel_4.add(username);
		username.setColumns(10);
		
		panel_3 = new JPanel();
		panel_4.add(panel_3);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setVgap(0);
		flowLayout_1.setHgap(0);
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		
		lblPassword = new JLabel("Password");
		panel_3.add(lblPassword);
		
		password = new JPasswordField();
		panel_4.add(password);
		password.setColumns(10);
		
		panel_2 = new JPanel();
		panel_4.add(panel_2);
		
		newAccButton = new JButton("Create an account");
		panel_2.add(newAccButton);
		newAccButton.setFocusable(false);
		newAccButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				getController().setView(new SignupView());
			}
		});
		
		loginButton = new JButton("Login");
		panel_2.add(loginButton);
		loginButton.setFocusable(false);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		panel_4.setMaximumSize( new Dimension(300, 200) );
		
		
				
	}
	
	public void initialize(){
		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String loginIdentity = Customer.isSelected()? "CUSTOMER":"ADMIN";
				getController().attemptLogin(username.getText(), new String(password.getPassword()),loginIdentity);
			}
		});
	}

}