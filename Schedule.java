package dailyPlanner;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.print.*;
import javax.swing.SwingConstants;


public class Schedule {

	public JFrame frame;
	private JPanel panel;
	public static String wakeTime;
	public static String sleepTime;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule window = new Schedule();
					window.frame.setVisible(true);
				} catch (Exception e) {
					System.out.println("Add Tasks to the Sustem....");
				}
			
			}
		});
	}


	public Schedule() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	}
	
	
	private void printTable(JPanel panel) {
		PrinterJob pj = PrinterJob.getPrinterJob();
		  pj.setJobName("Print Schedule");

		  pj.setPrintable (new Printable() {    
		    public int print(Graphics pg, PageFormat pf, int pageNum){
		      if (pageNum > 0){
		      return Printable.NO_SUCH_PAGE;
		      }

		      Graphics2D g2 = (Graphics2D) pg;
		      g2.translate(pf.getImageableX(), pf.getImageableY());
		      panel.paint(g2);
		      return Printable.PAGE_EXISTS;
		    }
		  });
		  if (pj.printDialog() == false)
		  return;

		  try {
		        pj.print();
		  } catch (PrinterException ex) {
		        // handle exception
		  }
		
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public Schedule(String wakeUp,String goSleep) {
		
		ArrayList<String> times = new ArrayList<>();
		
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Calibri", Font.PLAIN, 18));
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 658, 550);
		frame.setTitle("My Daily Planner");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setBounds(40, 93, 560, 313);
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		          //timePanel//                  
		
		JPanel timePanel = new JPanel();
		timePanel.setForeground(new Color(255, 255, 255));
		timePanel.setBackground(new Color(0, 0, 128));
		int panelNumber = Planner.list.size()/3+2;
		panel.add(timePanel);
		timePanel.setLayout(new GridLayout(panelNumber+1, 1, 0, 0));//
		
		JLabel microtimes = new JLabel("TIME:");
		microtimes.setHorizontalAlignment(SwingConstants.CENTER);
		microtimes.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		microtimes.setForeground(new Color(255, 255, 255));
		timePanel.add(microtimes);//
		String wakeTime = wakeUp; 
		times.add(wakeTime);
		JLabel wake = new JLabel("              " + wakeTime);
		wake.setFont(new Font("Calibri", Font.PLAIN, 15));
		wake.setForeground(new Color(255, 255, 255));
		timePanel.add(wake);
		
		try {
		String timeInNumsStr = "";
		if (wakeTime.charAt(5) == 'A') {
			 timeInNumsStr = wakeTime.substring(0,1) + wakeTime.substring(2,4);
		}
		else if (wakeTime.charAt(6) == 'A') {
			timeInNumsStr = wakeTime.substring(0,2) + wakeTime.substring(3,5);
		}
	int currentTime = Integer.parseInt(timeInNumsStr);
	int[] timeArray = new int[panelNumber-2];
	int i = 0;
	//timeArray[i] = currentTime;
	
	int lessThanListLength = 1;  ///
	while ( i < timeArray.length) {
		String taskLengthString = Planner.list.get(lessThanListLength);
		lessThanListLength = lessThanListLength + 3;
		int timeItemToInt = Integer.parseInt(taskLengthString);
		currentTime = currentTime + timeItemToInt;
		if (currentTime % 100 >= 60) {
			currentTime = currentTime + 40;
		}
		timeArray[i] =currentTime;
		i++;
	}
	
	String sleepTime = goSleep;

	
	
	for (int x = 0; x < timeArray.length; x++) {
		String AMPM = " A.M.";
		int clockTime = timeArray[x];
		if (clockTime >= 1200) {
			 AMPM = " P.M.";
		}
		if (clockTime >= 1300) {
			clockTime = clockTime - 1200;
		}
		int last_digits = clockTime%100;
		String last_digits_str = "";
		if (last_digits < 10) {
			last_digits_str = "0" + last_digits;
		}
		else
			last_digits_str += last_digits;
		String clockLabel = "   " + ((clockTime - (clockTime%100))/100) + ":" + (last_digits_str) + AMPM;
		times.add(clockLabel);
		
	}
	
	for (int g = 1; g < times.size(); g++) {
		String clockSpan = times.get(g-1) + " -" + times.get(g);
		JLabel clock = new JLabel("   " + clockSpan);
		clock.setForeground(new Color(255, 255, 255));
		clock.setFont(new Font("Calibri", Font.PLAIN, 15));

		//clock.setForeground(grayWhite);
		timePanel.add(clock);
	}
	JLabel sleep = new JLabel("              " + sleepTime);
	sleep.setFont(new Font("Calibri", Font.PLAIN, 15));
	sleep.setForeground(new Color(255, 255, 255));
	//sleep.setForeground(grayWhite);
	timePanel.add(sleep);
		}
		catch(NumberFormatException error) {
			System.out.println("Before Submit the Tasks Input Time in Minutes for Every tasks that You Added ");
		}
	                      //taskPanel//
	
	JPanel taskPanel = new JPanel();
	taskPanel.setForeground(new Color(255, 255, 255));
	taskPanel.setBackground(new Color(43, 17, 221));
	panel.add(taskPanel);
	taskPanel.setLayout(new GridLayout(panelNumber+1, 1, 0, 0));
	
	JLabel task = new JLabel("TASK:");
	task.setHorizontalAlignment(SwingConstants.CENTER);
	task.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
	task.setForeground(new Color(192, 192, 192));
	taskPanel.add(task);
	
	JLabel wakeywakey = new JLabel("   WAKE UP");
	wakeywakey.setHorizontalAlignment(SwingConstants.CENTER);
	wakeywakey.setFont(new Font("Calibri", Font.PLAIN, 18));
	wakeywakey.setForeground(new Color(192, 192, 192));
	taskPanel.add(wakeywakey);
	
	
	int z = 0;
	while (z < Planner.list.size()) {
		String microtask = "   " + Planner.list.get(z); 
		JLabel taskLabel = new JLabel(microtask);
		taskLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		taskLabel.setHorizontalAlignment(SwingConstants.CENTER);
		taskLabel.setForeground(new Color(192, 192, 192));
		taskPanel.add(taskLabel);
		z = z + 3;

	}
	
	JLabel sleepington = new JLabel("   SLEEP");
	sleepington.setHorizontalAlignment(SwingConstants.CENTER);
	sleepington.setFont(new Font("Calibri", Font.PLAIN, 18));
	sleepington.setForeground(new Color(192, 192, 192));
	taskPanel.add(sleepington);

	
	JPanel notePanel = new JPanel();
	notePanel.setBackground(new Color(130, 173, 238));
	panel.add(notePanel);
	notePanel.setLayout(new GridLayout(panelNumber+1, 1, 0, 0));
	
	
	JLabel additionalInfo = new JLabel("NOTES:");
	additionalInfo.setHorizontalAlignment(SwingConstants.CENTER);
	additionalInfo.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 18));
	notePanel.add(additionalInfo);
	
	JLabel getAfterIt = new JLabel("");
	getAfterIt.setFont(new Font("Calibri", Font.PLAIN, 18));
	notePanel.add(getAfterIt);
	
	
	int w = 2;
	while (w < Planner.list.size()) {
		String addInfo = Planner.list.get(w);
		JLabel infoLabel = new JLabel("   " + addInfo);
		infoLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		notePanel.add(infoLabel);
		w = w + 3;
	}
	

	panel.add(timePanel);
	panel.add(taskPanel);
	panel.add(notePanel);
	frame.getContentPane().add(panel);
	
	JButton btnPrint = new JButton("Print Schedule");
	btnPrint.setBackground(new Color(94, 184, 227));
	btnPrint.setForeground(new Color(0, 0, 128));
	btnPrint.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			printTable(panel);
			}
		
	});
	btnPrint.setFont(new Font("Calibri", Font.BOLD, 18));
	btnPrint.setBounds(203, 434, 194, 37);
	frame.getContentPane().add(btnPrint);
	
	JLabel lblNewLabel = new JLabel("MY DAILY SCHEDULE");
	lblNewLabel.setForeground(new Color(0, 0, 128));
	lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 22));
	lblNewLabel.setBounds(203, 31, 244, 47);
	frame.getContentPane().add(lblNewLabel);
	
	JLabel imgPlan = new JLabel("");
	Image img = new ImageIcon(this.getClass().getResource("/11.jpg")).getImage();
	imgPlan.setIcon(new ImageIcon(img));
	imgPlan.setBounds(112, -22, 117, 120);
	frame.getContentPane().add(imgPlan);
	
	}
}
