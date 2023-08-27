package dailyPlanner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;


public class Login {

	public JFrame frame;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}
 
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.setTitle("Login");
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 16));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 840, 515);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(23, 122, 232));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 28));
		lblNewLabel.setBounds(545, 33, 81, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("User Name");
		lblUsername.setForeground(new Color(0, 0, 64));
		lblUsername.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblUsername.setBounds(380, 149, 123, 20);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(0, 0, 64));
		lblPassword.setFont(new Font("Calibri", Font.PLAIN, 23));
		lblPassword.setBounds(380, 212, 123, 20);
		frame.getContentPane().add(lblPassword);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Calibri", Font.ITALIC, 17));
		txtUsername.setBounds(545, 147, 195, 26);
		txtUsername.setToolTipText("Enter Your First Name Here");
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Calibri", Font.ITALIC, 17));
		txtPassword.setToolTipText("Enter Your Password Here");
		txtPassword.setBounds(545, 207, 195, 26);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setVerticalAlignment(SwingConstants.TOP);
		btnLogin.setBackground(new Color(13, 3, 133));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUsername.getText();
				String password = txtPassword.getText(); 
				
				if (password.contains("14856") && username.contains("sachini")){
				
					txtUsername.setText(null);
					txtPassword.setText(null);
					Time.main(null);
				}
				else{
					JOptionPane.showMessageDialog(null,"Invalid Login Details","Login Error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText(null);
					txtUsername.setText(null);
				}
			}
		});
		btnLogin.setBounds(380, 353, 102, 26);
		frame.getContentPane().add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setVerticalAlignment(SwingConstants.TOP);
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(13, 3, 133));
		btnReset.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);
			}
		});
		btnReset.setBounds(509, 353, 102, 26);
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit ");
		btnExit.setVerticalAlignment(SwingConstants.TOP);
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBackground(new Color(13, 3, 133));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit","Login",
				JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION){
				System.exit(0);	
				}
			}
		});
		btnExit.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnExit.setBounds(640, 353, 102, 26);
		frame.getContentPane().add(btnExit);
		
		JLabel lblImg1 = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img1.jpg")).getImage();
		lblImg1.setIcon(new ImageIcon(img));
		lblImg1.setBounds(0, 0, 336, 489);
		frame.getContentPane().add(lblImg1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setBounds(77, 440, 163, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Use your First Name as the User name & ");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setFont(new Font("Calibri", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(438, 77, 313, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Index as the Password");
		lblNewLabel_2_1.setForeground(new Color(128, 128, 128));
		lblNewLabel_2_1.setFont(new Font("Calibri", Font.ITALIC, 18));
		lblNewLabel_2_1.setBounds(509, 96, 195, 26);
		frame.getContentPane().add(lblNewLabel_2_1); 
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(192, 192, 192));
		separator.setBounds(438, 294, 242, 26);
		frame.getContentPane().add(separator);
	
	}
}
