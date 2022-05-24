package client;

import java.util.HashMap;
import java.awt.BorderLayout;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
public class diet extends JFrame{
	private JPanel contentPane;
	private JTable table;
	private Object group;
	int flag=0;
	HashMap<String,String> hm = new HashMap<>();
	
	public int check(String id, String pass) {
		hm.put("khushi", "123");
		if(hm.containsKey(id))
		{
			if(pass.compareTo(hm.get(id))==0)
			{
				return 1;
			}
		}
		return 0;
	}
	public void add_u(String id, String pass)
	{
		hm.put(id, pass);
	}
}