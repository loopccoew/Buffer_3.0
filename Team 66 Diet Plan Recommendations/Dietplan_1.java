package client;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JLabel;

public class Dietplan_1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dietplan_1 frame = new Dietplan_1();
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
	public Dietplan_1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnYourDietPlan = new JTextPane();
		txtpnYourDietPlan.setBackground(SystemColor.control);
		txtpnYourDietPlan.setText("YOUR DIET PLAN IS READY!!!!");
		txtpnYourDietPlan.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtpnYourDietPlan.setBounds(78, 24, 318, 46);
		contentPane.add(txtpnYourDietPlan);
		
		DietPlanClient dpc = new DietPlanClient();
		String p_plan = dpc.getPlan();
		System.out.println(p_plan);
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(171, 110, 119, 28);
		lblNewLabel.setText(p_plan);
		contentPane.add(lblNewLabel);
		
		
	
		
		
		
	}
}
