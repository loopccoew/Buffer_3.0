package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;

public class Loginpage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage frame = new Loginpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Loginpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					   
					if(btnNewButton.isSelected()){    
						LoginCred dpt3=new LoginCred();
						dpt3.main(null);
						setVisible(false);
					
					}
					else
					{
						LoginCred dpt4=new LoginCred();
						dpt4.main(null);
						setVisible(false);
					
					}
			       
				
			}
		});
		btnNewButton.setBackground(SystemColor.control);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(318, 59, 149, 42);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OR");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBounds(350, 121, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("SIGN UP");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					   
					if(btnNewButton_2.isSelected()){    
						Signup dpt5=new Signup();
						dpt5.main(null);
						setVisible(false);
					
					}
					else
					{
						Signup dpt5=new Signup();
						dpt5.main(null);
						setVisible(false);
					
					}
			       
				
			}
		});
		btnNewButton_2.setBackground(SystemColor.control);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_2.setBounds(293, 162, 213, 69);
		contentPane.add(btnNewButton_2);
	}
}
