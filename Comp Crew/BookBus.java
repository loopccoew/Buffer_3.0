package pkg1;
//package winBuilder;

import java.util.*;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class BookBus
{
	static JLabel selected;
	static JLabel message;
	static JLabel ticketnum;
	static JLabel totalprice;
	static JLabel noselection;
	int ct=0;
	//queue containing booked seats
	static Queue<JButton> q = new LinkedList<JButton>();
	static Queue<JButton> tempq = new LinkedList<JButton>();
	
	static JFrame frame;
	BookBus(String from,String to,String date,String res,int key,double price)
	{
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 240, 240));
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    JLabel available = new JLabel("Available Seats :");
	    available.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    available.setBounds(31, 23, 292, 26);
	    frame.getContentPane().add(available);
	    
	    JButton b11 = new JButton("11");
	    b11.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		if(!q.contains(b11))
	    		{
	    			message.setText("Seat 11 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 11");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b11).setBackground(Color.BLUE);
		    		q.add(b11);
		    		tempq.add(b11);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b11.setBackground(new Color(50, 205, 50));
	    b11.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b11.setBounds(172, 34, 43, 43);
	    frame.getContentPane().add(b11);
	    
	    JButton b12 = new JButton("12");
	    b12.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b12))
	    		{
	    			message.setText("Seat 12 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 12");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b12).setBackground(Color.BLUE);
		    		q.add(b12);
		    		tempq.add(b12);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b12.setBackground(new Color(50, 205, 50));
	    b12.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b12.setBounds(225, 34, 43, 43);
	    frame.getContentPane().add(b12);	
	    
	    JButton b13 = new JButton("13");
	    b13.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b13))
	    		{
	    			message.setText("Seat 13 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 13");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b13).setBackground(Color.BLUE);
		    		q.add(b13);
		    		tempq.add(b13);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b13.setBackground(new Color(50, 205, 50));
	    b13.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b13.setBounds(278, 34, 43, 43);
	    frame.getContentPane().add(b13);
	    
	    JButton b14 = new JButton("14");
	    b14.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b14))
	    		{
	    			message.setText("Seat 14 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 14");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b14).setBackground(Color.BLUE);
		    		q.add(b14);
		    		tempq.add(b14);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b14.setBackground(new Color(50, 205, 50));
	    b14.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b14.setBounds(333, 34, 43, 43);
	    frame.getContentPane().add(b14);
	    
	    JButton b21 = new JButton("21");
	    b21.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b21))
	    		{
	    			message.setText("Seat 21 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 21");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b21).setBackground(Color.BLUE);
		    		q.add(b21);
		    		tempq.add(b21);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b21.setBackground(new Color(50, 205, 50));
	    b21.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b21.setBounds(172, 87, 43, 43);
	    frame.getContentPane().add(b21);
	    
	    JButton b22 = new JButton("22");
	    b22.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b22))
	    		{
	    			message.setText("Seat 22 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 22");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b22).setBackground(Color.BLUE);
		    		q.add(b22);
		    		tempq.add(b22);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b22.setBackground(new Color(50, 205, 50));
	    b22.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b22.setBounds(225, 87, 43, 43);
	    frame.getContentPane().add(b22);
	    
	    JButton b23 = new JButton("23");
	    b23.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		message.setText("Already Booked.");
	    	}
	    });
	    b23.setBackground(new Color(255, 0, 0));
	    b23.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b23.setBounds(280, 87, 43, 43);
	    frame.getContentPane().add(b23);
	    
	    JButton b24 = new JButton("24");
	    b24.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b22))
	    		{
	    			message.setText("Seat 24 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 24");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b24).setBackground(Color.BLUE);
		    		q.add(b24);
		    		tempq.add(b24);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b24.setBackground(new Color(50, 205, 50));
	    b24.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b24.setBounds(333, 87, 43, 43);
	    frame.getContentPane().add(b24);
	    
	    JButton b34 = new JButton("34");
	    b34.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b34))
	    		{
	    			message.setText("Seat 34 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 34");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b34).setBackground(Color.BLUE);
		    		q.add(b34);
		    		tempq.add(b34);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b34.setBackground(new Color(50, 205, 50));
	    b34.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b34.setBounds(333, 140, 43, 43);
	    frame.getContentPane().add(b34);
	    
	    JButton b33 = new JButton("33");
	    b33.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b33))
	    		{
	    			message.setText("Seat 33 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 33");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b33).setBackground(Color.BLUE);
		    		q.add(b33);
		    		tempq.add(b33);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b33.setBackground(new Color(50, 205, 50));
	    b33.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b33.setBounds(278, 140, 43, 43);
	    frame.getContentPane().add(b33);
	    
	    JButton b32 = new JButton("32");
	    b32.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b32))
	    		{
	    			message.setText("Seat 32 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 32");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b32).setBackground(Color.BLUE);
		    		q.add(b32);
		    		tempq.add(b32);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b32.setBackground(new Color(50, 205, 50));
	    b32.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b32.setBounds(225, 140, 43, 43);
	    frame.getContentPane().add(b32);
	    
	    JButton b31 = new JButton("31");
	    b31.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b31))
	    		{
	    			message.setText("Seat 31 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 31");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b31).setBackground(Color.BLUE);
		    		q.add(b31);
		    		tempq.add(b31);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b31.setBackground(new Color(50, 205, 50));
	    b31.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b31.setBounds(172, 140, 43, 43);
	    frame.getContentPane().add(b31);
	    
	    JButton b44 = new JButton("44");
	    b44.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b44))
	    		{
	    			message.setText("Seat 44 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 44");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b44).setBackground(Color.BLUE);
		    		q.add(b44);
		    		tempq.add(b44);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b44.setBackground(new Color(50, 205, 50));
	    b44.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b44.setBounds(333, 193, 43, 43);
	    frame.getContentPane().add(b44);
	    
	    JButton b43 = new JButton("43");
	    b43.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b43))
	    		{
	    			message.setText("Seat 43 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 43");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b43).setBackground(Color.BLUE);
		    		q.add(b43);
		    		tempq.add(b43);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b43.setBackground(new Color(50, 205, 50));
	    b43.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b43.setBounds(278, 193, 43, 43);
	    frame.getContentPane().add(b43);
	    
	    JButton b42 = new JButton("42");
	    b42.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b42))
	    		{
	    			message.setText("Seat 42 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 42");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b42).setBackground(Color.BLUE);
		    		q.add(b42);
		    		tempq.add(b42);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b42.setBackground(new Color(50, 205, 50));
	    b42.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b42.setBounds(225, 193, 43, 43);
	    frame.getContentPane().add(b42);
	    
	    JButton b41 = new JButton("41");
	    b41.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		message.setText("Already Booked.");
	    	}
	    });
	    b41.setBackground(new Color(255, 0, 0));
	    b41.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b41.setBounds(172, 193, 43, 43);
	    frame.getContentPane().add(b41);
	    
	    JButton b51 = new JButton("51");
	    b51.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b51))
	    		{
	    			message.setText("Seat 51 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 51");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b51).setBackground(Color.BLUE);
		    		q.add(b51);
		    		tempq.add(b51);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b51.setBackground(new Color(50, 205, 50));
	    b51.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b51.setBounds(172, 246, 43, 43);
	    frame.getContentPane().add(b51);
	    
	    JButton b52 = new JButton("52");
	    b52.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b52))
	    		{
	    			message.setText("Seat 52 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 52");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b52).setBackground(Color.BLUE);
		    		q.add(b52);
		    		tempq.add(b52);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b52.setBackground(new Color(50, 205, 50));
	    b52.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b52.setBounds(225, 246, 43, 43);
	    frame.getContentPane().add(b52);
	    
	    JButton b53 = new JButton("53");
	    b53.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		message.setText("Already Booked.");
	    	}
	    });
	    b53.setBackground(new Color(255, 0, 0));
	    b53.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b53.setBounds(280, 246, 43, 43);
	    frame.getContentPane().add(b53);
	    
	    JButton b54 = new JButton("54");
	    b54.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b54))
	    		{
	    			message.setText("Seat 54 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 54");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b54).setBackground(Color.BLUE);
		    		q.add(b54);
		    		tempq.add(b54);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b54.setBackground(new Color(50, 205, 50));
	    b54.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b54.setBounds(333, 246, 43, 43);
	    frame.getContentPane().add(b54);
	    
	    JButton b64 = new JButton("64");
	    b64.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b64))
	    		{
	    			message.setText("Seat 64 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 64");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b64).setBackground(Color.BLUE);
		    		q.add(b64);
		    		tempq.add(b64);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b64.setBackground(new Color(50, 205, 50));
	    b64.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b64.setBounds(333, 299, 43, 43);
	    frame.getContentPane().add(b64);
	    
	    JButton b63 = new JButton("63");
	    b63.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b63))
	    		{
	    			message.setText("Seat 63 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 63");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b63).setBackground(Color.BLUE);
		    		q.add(b63);
		    		tempq.add(b63);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b63.setBackground(new Color(50, 205, 50));
	    b63.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b63.setBounds(278, 299, 43, 43);
	    frame.getContentPane().add(b63);
	    
	    JButton b62 = new JButton("62");
	    b62.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b62))
	    		{
	    			message.setText("Seat 62 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 62");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b62).setBackground(Color.BLUE);
		    		q.add(b62);
		    		tempq.add(b62);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b62.setBackground(new Color(50, 205, 50));
	    b62.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b62.setBounds(225, 299, 43, 43);
	    frame.getContentPane().add(b62);
	    
	    JButton b61 = new JButton("61");
	    b61.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(!q.contains(b61))
	    		{
	    			message.setText("Seat 61 selected.");
		    		String res=selected.getText();
		    		selected.setText(res+", Seat 61");
		    		ct++;
		    		ticketnum.setText(Integer.toString(ct));
		    		double temp = ct*price;
		    		(b61).setBackground(Color.BLUE);
		    		q.add(b61);
		    		tempq.add(b61);
		    		totalprice.setText(Double.toString(temp));
	    		}
	    		else
	    		{
	    			message.setText("Already Booked.");
	    		}
	    	}
	    });
	    b61.setBackground(new Color(50, 205, 50));
	    b61.setFont(new Font("Tahoma", Font.BOLD, 9));
	    b61.setBounds(172, 299, 43, 43);
	    frame.getContentPane().add(b61);
	    
	    JLabel labelx = new JLabel("Selected Seats :");
	    labelx.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    labelx.setBounds(31, 375, 106, 26);
	    frame.getContentPane().add(labelx);
	    
	    selected = new JLabel("");
	    selected.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    selected.setBounds(147, 384, 292, 17);
	    frame.getContentPane().add(selected);
	    
	    message = new JLabel("");
	    message.setFont(new Font("Times New Roman", Font.PLAIN, 12));
	    message.setBounds(172, 352, 202, 17);
	    frame.getContentPane().add(message);
	    
	    JLabel lblNewLabel = new JLabel("No of Tickets: ");
	    lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    lblNewLabel.setBounds(31, 412, 106, 13);
	    frame.getContentPane().add(lblNewLabel);
	    
	    ticketnum = new JLabel("");
	    ticketnum.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    ticketnum.setBounds(147, 411, 57, 17);
	    frame.getContentPane().add(ticketnum);
	    
	    JLabel lblNewLabel_1 = new JLabel("Total Price:");
	    lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    lblNewLabel_1.setBounds(31, 447, 86, 13);
	    frame.getContentPane().add(lblNewLabel_1);
	    
	    totalprice = new JLabel("");
	    totalprice.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    totalprice.setBounds(147, 441, 68, 19);
	    frame.getContentPane().add(totalprice);
	    
	    JButton pay = new JButton("Confirm and Pay");
	    pay.setBackground(SystemColor.activeCaption);
	    pay.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		if(price!=ct)
	    		{
	    			while(!tempq.isEmpty())
	    			{
	    				(tempq.poll()).setBackground(Color.RED);
	    			}
	    			
	    			new DisplayTicket(from,to,date,res,key,ct,price,selected.getText());
	    		}
	    		else
	    			noselection.setText("Please Select Seats...!");
	    	}
	    });
	    pay.setBounds(31, 470, 202, 26);
	    frame.getContentPane().add(pay);
	    
	    noselection = new JLabel("");
	    noselection.setFont(new Font("Tahoma", Font.PLAIN, 14));
	    noselection.setForeground(new Color(255, 0, 0));
	    noselection.setBounds(31, 506, 304, 17);
	    frame.getContentPane().add(noselection);
	    
	    frame.setSize(463,585);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}