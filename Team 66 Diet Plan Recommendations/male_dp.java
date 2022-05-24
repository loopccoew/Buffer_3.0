package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class male_dp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					male_dp frame = new male_dp();
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
	public male_dp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 452);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please enter your age:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(86, 19, 286, 29);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"18+", "30-40", "40-50", "50-60", "60-70", "70 Above"}));
		comboBox.setBounds(122, 58, 81, 38);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"30-40", "40-50", "50-60", "60-70", "70-80", "80 Above"}));
		comboBox_1.setBounds(130, 183, 92, 38);
		contentPane.add(comboBox_1);
		
		JTextPane txtpnPleaseEnterYour = new JTextPane();
		txtpnPleaseEnterYour.setBackground(SystemColor.control);
		txtpnPleaseEnterYour.setText("Please enter your weight:");
		txtpnPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnPleaseEnterYour.setBounds(85, 132, 274, 48);
		contentPane.add(txtpnPleaseEnterYour);
		
		JButton btnNewButton = new JButton("PROCEED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					   
					if(btnNewButton.isSelected()){    
						Dietplan_1 dpt=new Dietplan_1();
						dpt.main(null);
					   setVisible(false);
					}   
					else {
						Dietplan_1 dpt=new Dietplan_1();
						dpt.main(null);
					   setVisible(false);
					}
			       
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(130, 292, 142, 53);
		contentPane.add(btnNewButton);
	}
}
