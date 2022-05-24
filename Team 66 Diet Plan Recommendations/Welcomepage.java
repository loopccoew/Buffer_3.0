package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Welcomepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Welcomepage frame = new Welcomepage();
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
	public Welcomepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 565);
		contentPane = new JPanel();
		contentPane.setForeground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrWelcome = new JTextArea();
		txtrWelcome.setBackground(SystemColor.activeCaption);
		txtrWelcome.setFont(new Font("Century Gothic", Font.BOLD, 35));
		txtrWelcome.setText("WELCOME");
		txtrWelcome.setBounds(234, 88, 186, 48);
		contentPane.add(txtrWelcome);
		
		JTextArea txtrToA = new JTextArea();
		txtrToA.setBackground(SystemColor.activeCaption);
		txtrToA.setFont(new Font("Century Gothic", Font.BOLD, 35));
		txtrToA.setText("To  A");
		txtrToA.setBounds(277, 146, 105, 48);
		contentPane.add(txtrToA);
		
		JTextArea txtrHealthierYou = new JTextArea();
		txtrHealthierYou.setBackground(SystemColor.activeCaption);
		txtrHealthierYou.setFont(new Font("Century Gothic", Font.BOLD, 35));
		txtrHealthierYou.setText("Healthier  You!");
		
		txtrHealthierYou.setBounds(216, 209, 251, 62);
		contentPane.add(txtrHealthierYou);
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					   
					if(btnNewButton.isSelected()){    
						Loginpage dpt1=new Loginpage();
						dpt1.main(null);
						setVisible(false);
					
					}
					else
					{
						Loginpage dpt2=new Loginpage();
						dpt2.main(null);
						setVisible(false);
					
					}
			       
				
			}
		});
			
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(182, 345, 281, 62);
		contentPane.add(btnNewButton);
	}
		
		}
	
