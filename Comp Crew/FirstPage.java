package pkg1;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.event.ActionListener;

public class FirstPage
{
  JFrame frame;
  JLabel label1;
  JButton btn1;
  JButton btn2;
  private JTextField txtEnterId;
  private JTextField txtEnterPassword;
  JLabel signInRes;
  
  FirstPage()
  {
    frame = new JFrame();
    frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
    frame.getContentPane().setLayout(null);
        
    label1 = new JLabel("Welocome To Bus_Railway Reservation System..!!");
    label1.setForeground(new Color(0, 0, 0));
    label1.setBackground(new Color(255, 255, 255));
    label1.setFont(new Font("Britannic Bold", Font.PLAIN, 14));
    label1.setBounds(23, 0, 317, 44);
    frame.getContentPane().add(label1); 
    
    JLabel lblNewLabel = new JLabel("Email Id : ");
    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    lblNewLabel.setBounds(74, 54, 72, 35);
    frame.getContentPane().add(lblNewLabel);
    
    JLabel lblNewLabel_1 = new JLabel("Password : ");
    lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
    lblNewLabel_1.setBounds(74, 99, 72, 22);
    frame.getContentPane().add(lblNewLabel_1);
    
    txtEnterId = new JTextField();
    txtEnterId.setForeground(Color.GRAY);
    txtEnterId.setToolTipText("");
    txtEnterId.setBounds(159, 63, 96, 19);
    frame.getContentPane().add(txtEnterId);
    txtEnterId.setColumns(10);
    
    txtEnterPassword = new JTextField();
    txtEnterPassword.setForeground(Color.GRAY);
    txtEnterPassword.setBounds(159, 98, 96, 19);
    frame.getContentPane().add(txtEnterPassword);
    txtEnterPassword.setColumns(10);
    
    signInRes = new JLabel("");
    signInRes.setFont(new Font("Tahoma", Font.BOLD, 12));
    signInRes.setForeground(new Color(255, 0, 0));
    signInRes.setBounds(74, 172, 244, 30);
    frame.getContentPane().add(signInRes);
    
    JButton btnNewButton = new JButton("Sign In");
    btnNewButton.addActionListener(new ActionListener() 
    {
    	public void actionPerformed(ActionEvent e) 
    	{
    		String id= txtEnterId.getText();
    		String pw= txtEnterPassword.getText();
    		
    		UserData obj=new UserData();
    		int key = obj.Check(id,pw);
    		
    		if(key!=-1)
    		{
    			//call homepage
    			new Homepage(key);
    			frame.dispose();
    		}
    		else
    		{
    			signInRes.setText("Wrong Email-id or Password..!");
    		}
    	}
    });
    btnNewButton.setBackground(UIManager.getColor("Button.background"));
    btnNewButton.setBounds(72, 141, 85, 21);
    frame.getContentPane().add(btnNewButton);
    
    JButton btnNewButton_1 = new JButton("Sign Up");
    btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
    btnNewButton_1.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		new Registration();
    		frame.dispose();
    	}
    });
    btnNewButton_1.setBounds(170, 141, 85, 21);
    frame.getContentPane().add(btnNewButton_1);
    
    frame.setSize(378,249);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
  public static void main(String[] args)
  {
	new UserData();
    new FirstPage();
  }
}