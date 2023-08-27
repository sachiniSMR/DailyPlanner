package dailyPlanner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Time {

	private JFrame frame;
	static String wakeTransfer, sleepTransfer;
	public JComboBox cmbx1,cmbx2;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Time window = new Time();
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
	public Time() {
		initialize();
	}
	public void setWakeTransfer(String wakeTransfer) {
		this.wakeTransfer = wakeTransfer;
	}
	
	public static String getWakeTransfer() {
		//System.out.println(this.wakeTransfer);
		return wakeTransfer;
	}
	
	public void setSleepTransfer(String sleepTransfer) {
		this.sleepTransfer = sleepTransfer;
	}
	
	public static String getSleepTransfer() {
		return sleepTransfer;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 803, 369);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Set Time");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("WAKE-UP TIME :");
		lblNewLabel.setBounds(217, 109, 132, 26);
		lblNewLabel.setForeground(new Color(23, 122, 232));
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 18));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblBedtime = new JLabel("BEDTIME :");
		lblBedtime.setBounds(217, 167, 132, 26);
		lblBedtime.setForeground(new Color(23, 122, 232));
		lblBedtime.setFont(new Font("Calibri", Font.BOLD, 18));
		frame.getContentPane().add(lblBedtime);
		
		String [] wakeUpTime= {
//				" ",
				 "5:00 A.M.",
				 "5:30 A.M.",
				 "6:00 A.M.",
				 "6:30 A.M.",
				 "7:00 A.M.",
			     "7:30 A.M.",
				 "8:00 A.M.",
				 "8:30 A.M.",
		         "9:00 A.M.",
				 "9:30 A.M.",
				 "10:00 A.M.",
				 "10:30 A.M.",
				 "11:00 A.M."		
		};
		cmbx1 = new JComboBox(wakeUpTime);
		cmbx1.setBounds(381, 111, 169, 21);
		cmbx1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedWake = cmbx1.getSelectedItem().toString();
				wakeTransfer = selectedWake;
			}
		});
		cmbx1.setForeground(new Color(13, 3, 133));
		frame.getContentPane().add(cmbx1);
		
		String [] sleepTime= {
//				 " ",
				 "9:00 P.M.",
				 "9:30 P.M.",
				 "10:00 P.M.",
				 "10:30 P.M.",
				 "11:00 P.M.",
				 "11:30 P.M.",
				 "12:00 A.M.",
				 "12:30 A.M."		
		};
		cmbx2 = new JComboBox(sleepTime);
		cmbx2.setBounds(381, 169, 169, 21);
		cmbx2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedSleep = cmbx2.getSelectedItem().toString();
				sleepTransfer = selectedSleep;
				
			}
		});
		cmbx2.setForeground(new Color(13, 3,133));
		frame.getContentPane().add(cmbx2);
		
		btnNewButton = new JButton("Next");
		btnNewButton.setBounds(346, 250, 85, 26);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Planner.main(null);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(13, 3, 133));
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 16));
		frame.getContentPane().add(btnNewButton);
		
		JLabel imgWakeUp = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/img6.jpg")).getImage();
		imgWakeUp.setIcon(new ImageIcon(img));
		imgWakeUp.setBounds(27, 69, 159, 207);
		frame.getContentPane().add(imgWakeUp);
		
		JLabel imgSleep = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/img5.jpg")).getImage();
		imgSleep.setIcon(new ImageIcon(img1));
		imgSleep.setBounds(607, 69, 159, 207);
		frame.getContentPane().add(imgSleep);
		
		JLabel lblNewLabel_1 = new JLabel("Hey Set Here Your Wake-Up time & BedTime ...!");
		lblNewLabel_1.setForeground(new Color(115, 115, 115));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(187, 23, 492, 36);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
