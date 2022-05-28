package pkg1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Dialog.ModalExclusionType;


public class Display_Bus 
{
	static JFrame frame;
	JLabel label1;
	JButton btn1;
	JButton btn2;
	static JButton bus1;
	static JButton bus2;
	static JButton bus3;
	static JButton bus4;
	static JButton bus5;
	static JButton bus6;
	static JButton bus7;
	private JLabel datelabel;
	private JLabel message;
	static String res1="",res2="",res3="",res4="",res5="",res6="",res7="";
	static double price1=0,price2=0,price3=0,price4=0,price5=0,price6=0,price7=0;
	static int key;  
	
	Display_Bus(String from,String to,String date,int key)
	{		
		this.key=key;
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 240, 240));
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	        
	    label1 = new JLabel("Available Buses");
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
	    
	    message = new JLabel("Click on bus to book");
	    message.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	    message.setBounds(25, 121, 285, 13);
	    frame.getContentPane().add(message);
	    
	    bus1 = new JButton("Not Available");
	    bus1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		new BookBus(from,to,date,res1,key,price1);
	    	}
	    });
	    bus1.setBackground(SystemColor.activeCaption);
	    bus1.setBounds(25, 143, 705, 21);
	    frame.getContentPane().add(bus1);
	    
	    bus2 = new JButton("Not Available");
	    bus2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookBus(from,to,date,res2,key,price2);
	    	}
	    });
	    bus2.setForeground(new Color(0, 0, 0));
	    bus2.setBackground(SystemColor.activeCaption);
	    bus2.setBounds(25, 189, 705, 21);
	    frame.getContentPane().add(bus2);
	    
	    bus3 = new JButton("Not Available");
	    bus3.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookBus(from,to,date,res3,key,price3);
	    	}
	    });
	    bus3.setForeground(Color.BLACK);
	    bus3.setBackground(SystemColor.activeCaption);
	    bus3.setBounds(25, 236, 705, 21);
	    frame.getContentPane().add(bus3);
	    
	    bus4 = new JButton("Not Available");
	    bus4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookBus(from,to,date,res4,key,price4);
	    	}
	    });
	    bus4.setForeground(Color.BLACK);
	    bus4.setBackground(SystemColor.activeCaption);
	    bus4.setBounds(25, 282, 705, 21);
	    frame.getContentPane().add(bus4);
	    
	    bus5 = new JButton("Not Available");
	    bus5.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookBus(from,to,date,res5,key,price5);
	    	}
	    });
	    bus5.setForeground(Color.BLACK);
	    bus5.setBackground(SystemColor.activeCaption);
	    bus5.setBounds(25, 329, 705, 21);
	    frame.getContentPane().add(bus5);
	    
	    bus6 = new JButton("Not Available");
	    bus6.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookBus(from,to,date,res6,key,price6);
	    	}
	    });
	    bus6.setForeground(Color.BLACK);
	    bus6.setBackground(SystemColor.activeCaption);
	    bus6.setBounds(25, 375, 705, 21);
	    frame.getContentPane().add(bus6);
	    
	    bus7 = new JButton("Not Available");
	    bus7.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		new BookBus(from,to,date,res7,key,price7);
	    	}
	    });
	    bus7.setForeground(Color.BLACK);
	    bus7.setBackground(SystemColor.activeCaption);
	    bus7.setBounds(25, 419, 705, 21);
	    frame.getContentPane().add(bus7);
	    
	    
	    CheckForBuses(from, to, date, key);
	    
	    frame.setSize(785,499);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	static void CheckForBuses(String from,String to,String date,int key)
	{
		Bus_Routes obj=new Bus_Routes();
		Bus_Railway_Routes obj2=new Bus_Railway_Routes();
		int ct=1;
		
		//Code to display bus routes
		for(int i=0;i<35;i++)
		{
			if( (obj.arr_routes[i].name).equals(from) )
			{
				Node ptr = obj.arr_routes[i];
				while(ptr.next!=null)
				{
					if((ptr.next.name).equals(to))
					{
						res1 = "Bus1 : "+from+" To "+to+"   |   Time: "+ptr.next.time+"   |   Ticket Price : 100";
						price1=100;
						bus1.setText(res1);
						ct++;
					    break;
					}
					ptr = ptr.next;
				}
			}
		}
		
		//code to display bus railway routes
		for(int i=0;i<9;i++)
		{
			Node ptr2 = obj2.arr_routes[i];
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
				if(ct==2)
				{
					res2="Bus2 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price2=(toprice-fromprice);
					bus2.setText(res2);
					ct++;
				}
				else if(ct==3)
				{
					res3 = "Bus3 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price3=(toprice-fromprice);
					bus3.setText(res3);
					ct++;
				}
				else if(ct==4)
				{
					res4="Bus4 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price4=(toprice-fromprice);
					bus4.setText(res4);
					ct++;
				}
				else if(ct==5)
				{
					res5="Bus5 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price5=(toprice-fromprice);
					bus5.setText(res5);
					ct++;
				}
				else if(ct==6)
				{
					res6="Bus6 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price6=(toprice-fromprice);
					bus6.setText(res6);
					ct++;
				}
				else if(ct==7)
				{
					res7="Bus7 : "+start+" To "+last+"   |   Time: "+fromtime+"("+from+")   |   Ticket Price : "+(toprice-fromprice);
					price7=(toprice-fromprice);
					bus7.setText(res7);
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
