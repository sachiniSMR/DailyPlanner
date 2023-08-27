package dailyPlanner;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;



public class Planner {

	private JFrame frame;
	/**l
	 * @wbp.nonvisual location=-37,124
	 */
	private final JPanel panel = new JPanel();
	private static JTextField txtTask;
	private JLabel lblDate;
	protected String[] row;
	protected Object model;
	private JTextField txtNote;
	private JTextField txtTime;
	public static ArrayList<String> list = new ArrayList<>();
	public JButton btnGenSchedule;
	public JButton btnSubmitTask;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Planner window = new Planner();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void date() {
		
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dd = sdf.format(d);
		lblDate.setText(dd);
	}

	/**
	 * Create the application.
	 */
	public Planner() {
		initialize();
		date();
	}
		public static void appendTask(String appendage) {
		txtTask.setText(appendage);
		System.out.println(txtTask.getText());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(41, 41, 177));
		frame.getContentPane().setBackground(new Color(94, 184, 227));
		frame.setTitle("Daily Planner");
		frame.setBounds(100, 100, 988, 700);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel pnlTask = new JPanel();
		pnlTask.setBackground(new Color(255, 255, 255));
		pnlTask.setBounds(477, 90, 431, 284);
		frame.getContentPane().add(pnlTask);
		pnlTask.setLayout(null);
		
		JLabel lblTask = new JLabel("Task  :");
		lblTask.setForeground(new Color(0, 0, 160));
		lblTask.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTask.setBounds(41, 38, 98, 23);
		pnlTask.add(lblTask);
		
		JLabel lblTime = new JLabel("Time(Minutes)  :");
		lblTime.setForeground(new Color(0, 0, 160));
		lblTime.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblTime.setBounds(41, 81, 128, 23);
		pnlTask.add(lblTime);
		
		JLabel lblNotes = new JLabel("Notes : ");
		lblNotes.setForeground(new Color(0, 0, 160));
		lblNotes.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblNotes.setBounds(41, 141, 98, 23);
		pnlTask.add(lblNotes);
		
		txtTask = new JTextField();
		txtTask.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtTask.setBounds(197, 39, 96, 22);
		txtTask.setToolTipText("You must fill this field");
	
		pnlTask.add(txtTask);
		txtTask.setColumns(10);
		
		btnSubmitTask = new JButton("Submit Task");
		btnSubmitTask.setBackground(new Color(94, 184, 227));
		btnSubmitTask.setForeground(new Color(0, 0, 128));
		btnSubmitTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				list.add(txtTask.getText());
				list.add(txtTime.getText());
				if (txtNote.getText().equals("")) {
					list.add("   ");
				}
				else {
				list.add(txtNote.getText());
				}
				txtTask.setText("");
				txtTime.setText("");
				txtNote.setText("");
				
			}
				
		});
		btnSubmitTask.setFont(new Font("Calibri", Font.BOLD, 20));
		btnSubmitTask.setBounds(210, 209, 157, 37);
		pnlTask.add(btnSubmitTask);
		
		
		txtNote = new JTextField();
		txtNote.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtNote.setBounds(197, 141, 145, 23);
		pnlTask.add(txtNote);
		txtNote.setColumns(10);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBackground(new Color(94, 184, 227));
		btnClear.setForeground(new Color(0, 0, 128));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText("");
				txtTime.setText("");
				txtNote.setText("");
			}
		});
		btnClear.setFont(new Font("Calibri", Font.BOLD, 20));
		btnClear.setBounds(28, 210, 141, 35);
		pnlTask.add(btnClear);
		
		txtTime = new JTextField();
		txtTime.setFont(new Font("Calibri", Font.PLAIN, 16));
		txtTime.setBounds(197, 82, 98, 22);
		pnlTask.add(txtTime);
		txtTime.setColumns(10);
		txtTime.setToolTipText("You must fill this field with a number");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 423, 449, 208);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(4, 4, 0, 0));
		
		JButton btn1 = new JButton("Breakfast");
		btn1.setBackground(new Color(196, 196, 196));
		btn1.setForeground(new Color(41, 41, 177));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn1.getText();
				txtTask.setText(EnterTask);
			}
		});
		btn1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn1);
		
		JButton btn2 = new JButton("Lunch");
		btn2.setBackground(new Color(196, 196, 196));
		btn2.setForeground(new Color(41, 41, 177));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn2.getText();
				txtTask.setText(EnterTask);
			}
		});
		btn2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn2);
		
		JButton btn3 = new JButton("Dinner");
		btn3.setBackground(new Color(196, 196, 196));
		btn3.setForeground(new Color(41, 41, 177));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn3.getText();
				txtTask.setText(EnterTask);
			}
		});
		btn3.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn3);
		
		JButton btn4 = new JButton("Lecture Time");
		btn4.setBackground(new Color(196, 196, 196));
		btn4.setForeground(new Color(41, 41, 177));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn4.getText();
				txtTask.setText(EnterTask);
			}
		});
		btn4.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn4);
		
		JButton btn5 = new JButton("Self Study");
		btn5.setBackground(new Color(196, 196, 196));
		btn5.setForeground(new Color(41, 41, 177));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn5.getText();
				txtTask.setText(EnterTask);
			}
		});
		btn5.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn5);
		
		JButton btn6 = new JButton("Exercise");
		btn6.setBackground(new Color(196, 196, 196));
		btn6.setForeground(new Color(41, 41, 177));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn6.getText();
				txtTask.setText(EnterTask);
			}
		});
		
		JButton btn11 = new JButton("Assignments");
		btn11.setBackground(new Color(196, 196, 196));
		btn11.setForeground(new Color(41, 41, 177));
		btn11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn11.getText();
				txtTask.setText(EnterTask);
			}
		});
		btn11.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn11);
		
		JButton btn12 = new JButton("Reading");
		btn12.setBackground(new Color(196, 196, 196));
		btn12.setForeground(new Color(41, 41, 177));
		btn12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn12.getText();
				txtTask.setText(EnterTask);
			}
		});
		btn12.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn12);
		btn6.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn6);
		
		JButton btn10 = new JButton("Social Media");
		btn10.setBackground(new Color(196, 196, 196));
		btn10.setForeground(new Color(41, 41, 177));
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn10.getText();
				txtTask.setText(EnterTask);
			}
		});
		
		JButton btn7 = new JButton("Take a Bath");
		btn7.setBackground(new Color(196, 196, 196));
		btn7.setForeground(new Color(41, 41, 177));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn7.getText();
				txtTask.setText(EnterTask);
			}
		});
		
		JButton btn8 = new JButton("Rest");
		btn8.setBackground(new Color(196, 196, 196));
		btn8.setForeground(new Color(41, 41, 177));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn8.getText();
				txtTask.setText(EnterTask);
			}
		});
		btn8.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn8);
		btn7.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn7);
		btn10.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn10);
		
		JButton btn9 = new JButton("Tv/Netflix");
		btn9.setBackground(new Color(196, 196, 196));
		btn9.setForeground(new Color(41, 41, 177));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTask.setText(null);
				String EnterTask = txtTask.getText()+ btn9.getText();
				txtTask.setText(EnterTask);
			}
		});
		btn9.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		panel_1.add(btn9);
		
		JLabel lblNewLabel = new JLabel("Default Tasks");
		lblNewLabel.setBounds(169, 388, 124, 25);
		frame.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 20));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(94, 184, 227));
		panel_2.setBounds(507, 505, 457, 83);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		btnGenSchedule = new JButton("GENERATE SCHEDULE");
		btnGenSchedule.setBounds(22, 10, 409, 63);
		panel_2.add(btnGenSchedule);
		btnGenSchedule.setBackground(new Color(196, 196, 196));
		btnGenSchedule.setForeground(new Color(0, 0, 128));
		btnGenSchedule.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent event) {
				
				try {
					String wake = Time.getWakeTransfer();
					String sleep = Time.getSleepTransfer();
					Schedule s = new Schedule(wake, sleep);
				}
				catch(NullPointerException e) {
					System.out.println("Hey First Set Your Wake-Up time & BedTime...");
				};
				
			}
		
		});
		btnGenSchedule.setFont(new Font("Calibri", Font.BOLD, 35));
		
		JLabel lblTodayIs = new JLabel("Today is ");
		lblTodayIs.setForeground(new Color(0, 0, 128));
		lblTodayIs.setBackground(new Color(0, 0, 128));
		lblTodayIs.setBounds(29, 22, 64, 23);
		frame.getContentPane().add(lblTodayIs);
		lblTodayIs.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(0, 0, 128));
		lblDate.setBounds(103, 22, 118, 23);
		frame.getContentPane().add(lblDate);
		lblDate.setFont(new Font("Calibri", Font.PLAIN, 18));
		
		JLabel lblNewLabel_1 = new JLabel("Now List Down Your Tasks Here");
		lblNewLabel_1.setForeground(new Color(90, 90, 90));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel_1.setBounds(79, 52, 250, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(67, 90, 277, 247);
		frame.getContentPane().add(scrollPane);
		
		JEditorPane editorPane = new JEditorPane();
		scrollPane.setViewportView(editorPane);
		editorPane.setFont(new Font("Calibri", Font.PLAIN, 16));
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(new Color(196, 196, 196));
		btnNewButton.setForeground(new Color(0, 0, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Time.main(null);
			}
		});
		btnNewButton.setFont(new Font("Calibri", Font.BOLD, 20));
		btnNewButton.setBounds(626, 404, 148, 39);
		frame.getContentPane().add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(90, 90, 90));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(402, 129, 18, 168);
		frame.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(90, 90, 90));
		separator_1.setBounds(123, 362, 182, 16);
		frame.getContentPane().add(separator_1);
		
		JLabel lblNewLabel_2 = new JLabel("Add Your Daily Tasks Here");
		lblNewLabel_2.setBounds(536, 51, 298, 25);
		frame.getContentPane().add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(90, 90, 90));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 17));
	}
}
