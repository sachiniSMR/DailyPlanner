package dailyPlanner;

import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.SwingConstants;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static JLabel lblPercentage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
				int x;
					Main frame = new Main();
					frame.setVisible(true);
				try {
					for(x=0;x<=100;x++) {
						Main.progressBar.setValue(x);
						Thread.sleep(35);
						Main.lblPercentage.setText(Integer.toString(x)+"%");
						if (x==100) {
							frame.dispose();
							Login.main(null);
						}
					}
				}catch(InterruptedException e){
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 430);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(29, 29, 69));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int jframeWidth=this.getSize().width;
		int jframeHeight = this.getSize().height;
		
		int locationX = (dim.width-jframeWidth)/2;
		int locationY = (dim.height-jframeHeight)/2;
		this.setLocation(locationX, locationY);
		
		
				
		JLabel lblLogo = new JLabel("");
		ImageIcon icon =new ImageIcon(this.getClass().getResource("/img8.jpg"));
		lblLogo.setIcon(icon);
		lblLogo.setBounds(51, 10, 530, 285);
		contentPane.add(lblLogo);
		
		progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setBounds(140, 371, 358, 11);
		contentPane.add(progressBar);
		
		lblPercentage = new JLabel("");
		lblPercentage.setHorizontalAlignment(SwingConstants.CENTER);
		lblPercentage.setForeground(new Color(192, 192, 192));
		lblPercentage.setBounds(230, 321, 184, 28);
		contentPane.add(lblPercentage);
	}
}
