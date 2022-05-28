package pkg1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dialog.ModalExclusionType;


public class Display_Train 
{
	static JFrame frame;
	JLabel label1;
	JButton btn1;
	JButton btn2;
	static JButton tr1;
	static JButton tr2;
	static JButton tr3;
	static JButton tr4;
	static JButton tr5;
	static JButton tr6;
	static JButton tr7;
	private JLabel datelabel;
	private JLabel message;
	static String res1="",res2="",res3="",res4="",res5="",res6="",res7="";
	static double price1=0,price2=0,price3=0,price4=0,price5=0,price6=0,price7=0;
	  
	Display_Train(String from,String to,String date,int key)
	{		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 240, 240));
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	        
	    label1 = new JLabel("Available Trains");
	    label1.setForeground(new Color(0, 0, 0));
	    label1.setBackground(new Color(255, 255, 255));
	    label1.setFont(new Font("Britannic Bold", Font.PLAIN, 30));
	    label1.setBounds(25, 10, 225, 45);
	    frame.getContentPane().add(label1); 
	    
	    JLabel routelabel = new JLabel("From "+from+" to "+to);
	    routelabel.setForeground(SystemColor.desktop);
	    routelabel.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
	    routelabel.setBounds(25, 53, 440, 42);
	    frame.getContentPane().add(routelabel);
	    
	    datelabel = new JLabel("Date : "+date);
	    datelabel.setForeground(SystemColor.desktop);
	    datelabel.setFont(new Font("Britannic Bold", Font.PLAIN, 18));
	    datelabel.setBounds(407, 56, 164, 36);
	    frame.getContentPane().add(datelabel);
	    
	    message = new JLabel("Click on train to book");
	    message.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    message.setBounds(25, 121, 285, 13);
	    frame.getContentPane().add(message);
	    
	    tr1 = new JButton("Not Available");
	    tr1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookRailway(from,to,date,res1,key,price1);
	    	}
	    });
	    tr1.setBackground(SystemColor.activeCaption);
	    tr1.setBounds(25, 143, 705, 21);
	    frame.getContentPane().add(tr1);
	    
	    tr2 = new JButton("Not Available");
	    tr2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookRailway(from,to,date,res2,key,price2);
	    	}
	    });
	    tr2.setForeground(new Color(0, 0, 0));
	    tr2.setBackground(SystemColor.activeCaption);
	    tr2.setBounds(25, 189, 705, 21);
	    frame.getContentPane().add(tr2);
	    
	    tr3 = new JButton("Not Available");
	    tr3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookRailway(from,to,date,res3,key,price3);
	    	}
	    });
	    tr3.setForeground(Color.BLACK);
	    tr3.setBackground(SystemColor.activeCaption);
	    tr3.setBounds(25, 236, 705, 21);
	    frame.getContentPane().add(tr3);
	    
	    tr4 = new JButton("Not Available");
	    tr4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookRailway(from,to,date,res4,key,price4);
	    	}
	    });
	    tr4.setForeground(Color.BLACK);
	    tr4.setBackground(SystemColor.activeCaption);
	    tr4.setBounds(25, 282, 705, 21);
	    frame.getContentPane().add(tr4);
	    
	    tr5 = new JButton("Not Available");
	    tr5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookRailway(from,to,date,res5,key,price5);
	    	}
	    });
	    tr5.setForeground(Color.BLACK);
	    tr5.setBackground(SystemColor.activeCaption);
	    tr5.setBounds(25, 329, 705, 21);
	    frame.getContentPane().add(tr5);
	    
	    tr6 = new JButton("Not Available");
	    tr6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookRailway(from,to,date,res6,key,price6);
	    	}
	    });
	    tr6.setForeground(Color.BLACK);
	    tr6.setBackground(SystemColor.activeCaption);
	    tr6.setBounds(25, 375, 705, 21);
	    frame.getContentPane().add(tr6);
	    
	    tr7 = new JButton("Not Available");
	    tr7.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookRailway(from,to,date,res7,key,price7);
	    	}
	    });
	    tr7.setForeground(Color.BLACK);
	    tr7.setBackground(SystemColor.activeCaption);
	    tr7.setBounds(25, 419, 705, 21);
	    frame.getContentPane().add(tr7);
	    
	    
	    CheckForBuses(from, to, date, key);
	    
	    frame.setSize(785,499);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	static void CheckForBuses(String from,String to,String date,int key)
	{
		Bus_Railway_Routes obj=new Bus_Railway_Routes();
		int ct=1;
		
		//code to display bus railway routes
		for(int i=0;i<9;i++)
		{
			Node ptr2 = obj.arr_routes[i];
			String start = ptr2.name;
			String fromtime = "";
			double fromprice=0;
			double toprice=0;
			String last="";
			int flag=0;
			
			while(ptr2!=null)
			{
				if((ptr2.name).equals(from))
				{
					fromtime=ptr2.time;
					fromprice = ptr2.price;
					flag=1;
				}
				if((ptr2.name).equals(to))
				{
					toprice = ptr2.price;
					flag=2;
				}
				
				last=ptr2.name;
				ptr2=ptr2.next;
			}
			
			if(flag==2)
			{
				if(ct==1)
				{
					res1="Train1 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price1=(toprice-fromprice);
					tr1.setText(res1);
					ct++;
				}
				else if(ct==2)
				{
					res2="Train2 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price2=(toprice-fromprice);
					tr2.setText(res2);
					ct++;
				}
				else if(ct==3)
				{
					res3="Train3 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price3=(toprice-fromprice);
					tr3.setText(res3);
					ct++;
				}
				else if(ct==4)
				{
					res4="Train4 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price4=(toprice-fromprice);
					tr4.setText(res4);
					ct++;
				}
				else if(ct==5)
				{
					res5="Train5 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price5=(toprice-fromprice);
					tr5.setText(res5);
					ct++;
				}
				else if(ct==6)
				{
					res6="Train6 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price6=(toprice-fromprice);
					tr6.setText(res6);
					ct++;
				}
				else if(ct==7)
				{
					res7="Train7 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price7=(toprice-fromprice);
					tr7.setText(res7);
					ct++;
				}
				else 
				{
					break;
				}
			}
		}
	}
}
