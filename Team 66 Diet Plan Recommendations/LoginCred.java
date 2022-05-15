package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class LoginCred extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginCred frame = new LoginCred();
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
	public LoginCred() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 856, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SUBMIT");
		
		
	
		
		JTextArea txtrLoginId = new JTextArea();
		txtrLoginId.setFont(new Font("Tahoma", Font.BOLD, 20));
		txtrLoginId.setText("Login ID");
		
		txtrLoginId.setBounds(49, 68, 101, 34);
		contentPane.add(txtrLoginId);
		
		JTextArea txtrPassword = new JTextArea();
		txtrPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtrPassword.setText("Password");
		
		txtrPassword.setBounds(48, 183, 109, 32);
		contentPane.add(txtrPassword);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(210, 182, 353, 33);
		contentPane.add(textArea_3);
		
		
		JTextPane textPane = new JTextPane();
		
		textPane.setBounds(211, 72, 351, 41);
		contentPane.add(textPane);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pass = textArea_3.getText();
				String id = textPane.getText();
				diet x = new diet();
				if(x.check(id, pass) == 1)
				{
					temperory dpt=new temperory ();
					dpt.main(null);
					setVisible(false);
				}
				else
				{
					JOptionPane.showMessageDialog(textArea_3, "please enter correct credentials");
					setVisible(true);
				
				}
				
			}
					
					
			       
				
			
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBounds(352, 338, 155, 52);
		contentPane.add(btnNewButton);
		
		
	}

}
