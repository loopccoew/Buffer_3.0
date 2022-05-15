package pkg1;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayTicket 
{
	static JFrame frame;
	String ticket="";
	static JLabel successmsg;
	
	DisplayTicket(String from,String to,String date,String res,int key,int ct,double price,String seats)
	{
		frame = new JFrame();
		frame.setType(Type.POPUP);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(new Color(240, 240, 240));
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    ticket="Date: "+date+"|No.of Tickets: "+ct+"|Total Price = "+price+"|Seats: "+seats;
	    
	    //UserData obj = new UserData(key,res,ticket);
	    
	    JLabel lblNewLabel = new JLabel("Booked Ticket Successfully..!");
	    lblNewLabel.setBackground(new Color(240, 240, 240));
	    lblNewLabel.setForeground(new Color(50, 205, 50));
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
	    lblNewLabel.setBounds(53, 51, 366, 26);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JLabel reslabel = new JLabel(res);
	    reslabel.setBackground(new Color(0, 255, 255));
	    reslabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    reslabel.setBounds(53, 87, 671, 36);
	    frame.getContentPane().add(reslabel);
	    
	    JLabel ticketlabel = new JLabel(ticket);
	    ticketlabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    ticketlabel.setBackground(new Color(0, 255, 255));
	    ticketlabel.setBounds(53, 118, 671, 36);
	    frame.getContentPane().add(ticketlabel);
	    
	    JButton btnNewButton = new JButton("Your Bookings");
	    btnNewButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		if((UserData.hashtable[key].booking).equals("No Bookings"))
	    		{
	    			UserData.hashtable[key].booking = res;
		    		UserData.hashtable[key].ticket = ticket;
	    		}
	    		else
	    		{
	    			UserData.hashtable[key].booking = (UserData.hashtable[key].booking)+"  &&  "+res;
		    		UserData.hashtable[key].ticket = UserData.hashtable[key].ticket+"  &&  "+ticket;
	    		}
	    		new YourBookings(key);
	    		frame.dispose();
	    	}
	    });
	    btnNewButton.setBackground(SystemColor.activeCaption);
	    btnNewButton.setForeground(SystemColor.activeCaptionText);
	    btnNewButton.setBounds(53, 227, 133, 26);
	    frame.getContentPane().add(btnNewButton);
	    
	    JButton btnPrintTicket = new JButton("Print Ticket");
	    btnPrintTicket.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		successmsg.setText("Ticket Printed..!");
	    	}
	    });
	    btnPrintTicket.setForeground(Color.BLACK);
	    btnPrintTicket.setBackground(SystemColor.activeCaption);
	    btnPrintTicket.setBounds(53, 164, 133, 26);
	    frame.getContentPane().add(btnPrintTicket);
	    
	    successmsg = new JLabel("");
	    successmsg.setForeground(new Color(50, 205, 50));
	    successmsg.setBounds(53, 200, 414, 17);
	    frame.getContentPane().add(successmsg);
	    
		frame.setSize(788,500);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
