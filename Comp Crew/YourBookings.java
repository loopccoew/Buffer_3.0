package pkg1;
//package winBuilder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import java.awt.SystemColor;

public class YourBookings 
{
	static JFrame frame = new JFrame();
	
	
	public YourBookings(int key)
	{
		frame.setType(Type.POPUP);
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setBackground(new Color(240, 240, 240));
	    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Your Bookings:");
	    lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 30));
	    lblNewLabel.setBounds(32, 36, 650, 39);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JButton bookingbtn = new JButton("Click on the button to see booking");
	    bookingbtn.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		bookingbtn.setText(UserData.hashtable[key].booking);
	    	}
	    });
	    bookingbtn.setBackground(SystemColor.activeCaption);
	    bookingbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
	    bookingbtn.setBounds(10, 99, 888, 51);
	    frame.getContentPane().add(bookingbtn);
	    
	    JButton back = new JButton("Back");
	    back.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		bookingbtn.setText("Click on the button to see booking");
	    		frame.dispose();
	    	}
	    });
	    back.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    back.setBounds(10, 160, 109, 28);
	    frame.getContentPane().add(back);
	    
	    frame.setSize(922,499);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}