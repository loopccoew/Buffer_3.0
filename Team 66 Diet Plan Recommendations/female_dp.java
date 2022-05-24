package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class female_dp extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					female_dp frame = new female_dp();
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
	String age = "18+";
	String weight ="30-40";
	public female_dp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 430);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnJjkkjj = new JTextPane();
		txtpnJjkkjj.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnJjkkjj.setBackground(SystemColor.control);
		txtpnJjkkjj.setText("Please enter your age:");
		txtpnJjkkjj.setBounds(98, 26, 243, 35);
		contentPane.add(txtpnJjkkjj);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"18+", "30-40", "40-50", "50-60", "60-70", "70 Above"}));
		comboBox.setBounds(157, 71, 90, 35);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				age = (String)comboBox.getSelectedItem();
				System.out.println(age);
			}
		});
		
		JTextPane txtpnPleaseEnterYour = new JTextPane();
		txtpnPleaseEnterYour.setBackground(SystemColor.control);
		txtpnPleaseEnterYour.setText("Please enter your weight(in Kg):");
		txtpnPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnPleaseEnterYour.setBounds(64, 134, 320, 35);
		contentPane.add(txtpnPleaseEnterYour);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"30-40", "40-50", "50-60", "60-70", "70-80", "80 Above"}));
		comboBox_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		comboBox_1.setBounds(157, 193, 90, 43);
		contentPane.add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				weight = (String)comboBox_1.getSelectedItem();
				System.out.println(weight);
			}
		});
		
		JButton btnNewButton = new JButton("Proceed");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					   
					if(btnNewButton.isSelected()){    
						Dietplan_1 dpt=new Dietplan_1();
						dpt.main(null);
						setVisible(false);
					
					}
					else
					{
						Dietplan_1 dpt=new Dietplan_1();
						dpt.main(null);
						setVisible(false);
					
					}
			       
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.setBounds(126, 287, 154, 58);
		contentPane.add(btnNewButton);
	}
	public String getAge()
	 {
		 return age;
	 }
	public String getWeight()
	 {
		 return weight;
	 }
}
