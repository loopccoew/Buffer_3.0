package pkg1;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Registration
{
	JFrame frame;
	 
	String name,id,pw;
	int key=1;
	private JTextField nameinput;
	private JTextField idinput;
	private JTextField pwinput;
	JLabel reslabel;
	
	Registration()
	{
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
	    frame.getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel = new JLabel("Create Account");
	    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
	    lblNewLabel.setBounds(51, 25, 147, 20);
	    frame.getContentPane().add(lblNewLabel);
	    
	    JLabel lblNewLabel_1 = new JLabel("Name :");
	    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblNewLabel_1.setBounds(51, 55, 45, 13);
	    frame.getContentPane().add(lblNewLabel_1);
	    
	    JLabel lblNewLabel_2 = new JLabel("Email id :");
	    lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblNewLabel_2.setBounds(51, 84, 67, 13);
	    frame.getContentPane().add(lblNewLabel_2);
	    
	    JLabel lblNewLabel_3 = new JLabel("Set Password :");
	    lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
	    lblNewLabel_3.setBounds(51, 114, 90, 13);
	    frame.getContentPane().add(lblNewLabel_3);
	    
	    JButton createAccBtn = new JButton("Create Account");
	    createAccBtn.addActionListener(new ActionListener() 
	    {
	    	public void actionPerformed(ActionEvent e) 
	    	{
	    		name= nameinput.getText();
	    		id= idinput.getText();
	    		pw= pwinput.getText();
	    		
	    		UserData obj=new UserData();
	    		int flag = obj.UserDataStorage(name,id,pw,key);
	    		
	    		if(flag==0)
	    		{
	    			reslabel.setText("Account Created Successfully..!");
	    			new Homepage(key);
	    		}
	    		else
	    			reslabel.setText("Account already exists.\nPlease sign in or use another Email-id\nto create new account.");
	    		key++;
	    		frame.dispose();
	    	}
	    });
	    createAccBtn.setBackground(SystemColor.activeCaption);
	    createAccBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
	    createAccBtn.setBounds(51, 149, 123, 21);
	    frame.getContentPane().add(createAccBtn);
	    
	    nameinput = new JTextField();
	    nameinput.setBounds(106, 53, 186, 19);
	    frame.getContentPane().add(nameinput);
	    nameinput.setColumns(10);
	    
	    idinput = new JTextField();
	    idinput.setBounds(106, 82, 186, 19);
	    frame.getContentPane().add(idinput);
	    idinput.setColumns(10);
	    
	    pwinput = new JTextField();
	    pwinput.setBounds(140, 112, 152, 19);
	    frame.getContentPane().add(pwinput);
	    pwinput.setColumns(10);
	    
	    reslabel = new JLabel("");
	    reslabel.setForeground(new Color(60, 179, 113));
	    reslabel.setFont(new Font("Tahoma", Font.BOLD, 12));
	    reslabel.setBounds(51, 180, 301, 57);
	    frame.getContentPane().add(reslabel);
	    
	    
	    frame.setSize(376,284);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String args[])
	{
		new Registration();
	}
}