package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JButton;

public class Signup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 728);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrFullName = new JTextArea();
		txtrFullName.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtrFullName.setText("Full Name");
		txtrFullName.setBounds(49, 36, 156, 35);
		contentPane.add(txtrFullName);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(328, 36, 478, 35);
		contentPane.add(textPane);
		
		JTextPane txtpnEmailId = new JTextPane();
		txtpnEmailId.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnEmailId.setText("User ID");
		txtpnEmailId.setBounds(54, 152, 151, 35);
		contentPane.add(txtpnEmailId);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(325, 148, 478, 35);
		String id = textPane_1.getText();
		contentPane.add(textPane_1);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtpnPassword.setText("Password");
		txtpnPassword.setBounds(49, 274, 156, 35);
		contentPane.add(txtpnPassword);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(328, 272, 478, 37);
		String pass = textPane_2.getText();
		contentPane.add(textPane_2);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					   
				diet d = new diet();
				d.add_u(id, pass);
				temperory dpt1=new temperory ();
				dpt1.main(null);
//				LoginCred l = new LoginCred();
//				l.main(null);
				setVisible(false);
					
					
			       
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(347, 484, 163, 80);
		contentPane.add(btnNewButton);
	}

}
