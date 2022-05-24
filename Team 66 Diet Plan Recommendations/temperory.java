package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;

public class temperory extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private Object group;
	int flag=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					temperory frame = new temperory();
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
	public temperory() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 539);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("FEMALE");
//		rdbtnNewRadioButton.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyPressed(KeyEvent e) {
//				System.out.println("female");
//			}
//		});
		
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("MALE");
//		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
////				display_dietplan d = new display_dietplan();
//				flag=1;
//			}
//		});
		ButtonGroup bg=new ButtonGroup();    
		bg.add(rdbtnNewRadioButton);bg.add(rdbtnNewRadioButton_1);
		
		JCheckBox chckbxNewCheckBox_10= new JCheckBox("40-50");
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("50-60");
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("60-70");
		
		JCheckBox chckbxNewCheckBox_= new JCheckBox("70 Above");
		
		table = new JTable();
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("welcome");
		tglbtnNewToggleButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
	    
	   int[] arr1= {18,};
		
		JButton btnNewButton = new JButton("START");
		
		JButton tb2 = new JButton("Major");
		
		JLabel lblNewLabel = new JLabel("DIET PLAN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JLabel lblNewLabel_1 = new JLabel("PLEASE CHOOSE YOUR GENDER");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_1 = new JButton("SUBMIT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					   
					if(rdbtnNewRadioButton_1.isSelected()){    
						male_dp md = new male_dp();
						md.main(null);
						setVisible(false);
					}   
			       if(rdbtnNewRadioButton.isSelected())
			       {
			    	   female_dp fdp=new female_dp();
			    	   fdp.main(null);
			    	   setVisible(false);
			       }
				
			}
		});
		btnNewButton_1.setBackground(SystemColor.control);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(163)
					.addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addGap(94)
					.addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(283, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(184, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
							.addComponent(tglbtnNewToggleButton, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)))
					.addGap(331)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(189)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(293))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(269)
					.addComponent(btnNewButton_1)
					.addContainerGap(390, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(tglbtnNewToggleButton)
					.addGap(14)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton))
					.addGap(38)
					.addComponent(btnNewButton_1)
					.addGap(66)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)
					.addGap(199)
					.addComponent(btnNewButton)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
