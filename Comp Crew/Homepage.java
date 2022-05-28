package pkg1;
//package winBuilder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;

public class Homepage implements ActionListener 
{

	//private static final AbstractButton success = null;
	private JFrame frame;
	private JTextField fromtext;
	private JTextField totext;
	private JTextField datetext;
	JLabel emptyfrom;
	JLabel emptyto;
	JLabel emptydate;
	static int key=-1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try {
					Homepage window = new Homepage();
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
	public Homepage(int key) {
		this.key=key;
		new Homepage();
	}
	
	public Homepage()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize () 
	{
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.setBounds(100, 100, 610, 466);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton DisplayBusBtn = new JButton("Bus");
		DisplayBusBtn.setForeground(new Color(0, 0, 0));
		DisplayBusBtn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		DisplayBusBtn.setBackground(new Color(153, 180, 209));
		DisplayBusBtn.setBounds(31, 348, 119, 34);
		DisplayBusBtn.addActionListener(this);
		frame.getContentPane().add(DisplayBusBtn);
		
		JLabel lblNewLabel = new JLabel("BOOK TICKET");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(160, 0, 246, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JButton DisplayTrainBtn = new JButton("Train\r\n");
		DisplayTrainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String From =fromtext.getText();
				String To=totext.getText();
				String Date=datetext.getText();
				new Display_Train(From,To,Date,key);
			}
		});
		DisplayTrainBtn.setBackground(SystemColor.activeCaption);
		DisplayTrainBtn.setFont(new Font("Tahoma", Font.ITALIC, 25));
		DisplayTrainBtn.setBounds(172, 348, 132, 34);
		frame.getContentPane().add(DisplayTrainBtn);
		
		JLabel lblNewLabel_1 = new JLabel("From* :");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(59, 90, 142, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To* :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(59, 158, 72, 50);
		frame.getContentPane().add(lblNewLabel_2);
		
		fromtext = new JTextField();
		fromtext.setToolTipText("");
		fromtext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fromtext.setForeground(Color.GRAY);
		fromtext.setText("e.g. Mumbai");
		fromtext.setBounds(172, 100, 362, 34);
		frame.getContentPane().add(fromtext);
		fromtext.setColumns(10);
		
		totext = new JTextField();
		totext.setText("e.g. Satara");
		totext.setForeground(Color.GRAY);
		totext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		totext.setBounds(172, 171, 362, 34);
		frame.getContentPane().add(totext);
		totext.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Date* :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(59, 242, 102, 40);
		frame.getContentPane().add(lblNewLabel_3);
		
		datetext = new JTextField();
		datetext.setForeground(Color.GRAY);
		datetext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		datetext.setText("DD/MM/YYYY");
		datetext.setBounds(172, 250, 362, 34);
		frame.getContentPane().add(datetext);
		datetext.setColumns(10);
		
		JButton YourBookingsBtn = new JButton("Your Bookings");
		YourBookingsBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				new YourBookings(key);
			}
		});
		YourBookingsBtn.setBackground(SystemColor.activeCaption);
		YourBookingsBtn.setFont(new Font("Tahoma", Font.ITALIC, 25));
		YourBookingsBtn.setBounds(327, 348, 209, 34);
		frame.getContentPane().add(YourBookingsBtn);
		
		JLabel success =new JLabel("");
		success.setBounds(10,20,300,45);
		frame.getContentPane().add(success);
		
		emptyfrom = new JLabel("");
		emptyfrom.setForeground(new Color(255, 0, 0));
		emptyfrom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emptyfrom.setBounds(172, 142, 266, 19);
		frame.getContentPane().add(emptyfrom);
		
		emptyto = new JLabel("");
		emptyto.setForeground(new Color(255, 0, 0));
		emptyto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emptyto.setBounds(172, 204, 266, 27);
		frame.getContentPane().add(emptyto);
		
		emptydate = new JLabel("");
		emptydate.setForeground(new Color(255, 0, 0));
		emptydate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		emptydate.setBounds(172, 294, 45, 13);
		frame.getContentPane().add(emptydate);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String From =fromtext.getText();
		String To=totext.getText();
		String Date=datetext.getText();
		
		if(From.equals(""))
			emptyfrom.setText("Required field");
		if(To.equals(""))
			emptyto.setText("Required field");
		if(Date.equals(""))
			emptydate.setText("Required field");
		
		if(!From.equals("") && !To.equals("") && !Date.equals(""))	
			new Display_Bus(From,To,Date,key);
	}
}