package com.kh.view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class MainMenu extends JFrame{

	JTable table1;
	DefaultTableModel model1;
	JTextField tf;
	
	
	public MainMenu() {
		super("MainMenuPage");
			
		String col1[] = {"방이름", "상태", "인원"};
		String row1[][] = {{"a1","a2","a3"},
                {"b1","b2","b3"},
                {"c1","c2","c3"}};
		
		
		model1 = new DefaultTableModel(row1, col1) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		
		table1=new JTable(model1);
		JScrollPane js1 = new JScrollPane(table1);
		table1.getTableHeader().setReorderingAllowed(false);
		
		setLayout(null);
		js1.setBounds(80, 150, 700, 320);
		add(js1);
	
		
		this.setBounds(300, 200, 1024, 768);
		
		
		
					
		
		// Layout 지정 없이 위치 지정하면서 배치하는 방법이다.
		this.setLayout(null);
		Image profileimg = new ImageIcon("images\\profile.PNG").getImage().getScaledInstance(75, 75, 0);
		Image msgimg = new ImageIcon("images\\msg.PNG").getImage().getScaledInstance(75, 75, 0);
		Image makeimg = new ImageIcon("images\\make.PNG").getImage().getScaledInstance(75, 75, 0);
		Image optimg = new ImageIcon("images\\opt.PNG").getImage().getScaledInstance(75, 75, 0);
		Image shopimg = new ImageIcon("images\\shop.PNG").getImage().getScaledInstance(75, 75, 0);
		Image exitimg = new ImageIcon("images\\exit.PNG").getImage().getScaledInstance(75, 75, 0);
		
		
		JButton profilebtn = new JButton(new ImageIcon(profileimg));
		profilebtn.setLocation(10, 10);
		profilebtn.setSize(75, 75);

		JButton msgbtn = new JButton(new ImageIcon(msgimg));
		msgbtn.setLocation(925, 10);
		msgbtn.setSize(75, 75);
		
		JButton makebtn = new JButton(new ImageIcon(makeimg));
		makebtn.setLocation(765, 500);
		makebtn.setSize(75, 75);
		
		JButton optbtn = new JButton(new ImageIcon(optimg));
		optbtn.setLocation(885, 500);
		optbtn.setSize(75, 75);
		
		JButton shopbtn = new JButton(new ImageIcon(shopimg));
		shopbtn.setLocation(765, 600);
		shopbtn.setSize(75, 75);
		
		JButton exitbtn = new JButton(new ImageIcon(exitimg));
		exitbtn.setLocation(885, 600);
		exitbtn.setSize(75, 75);

		JTextArea ta = new JTextArea();
		ta.setBounds(0, 590, 400, 400);
		ta.setEditable(false);

		JTextField tf = new JTextField();
		tf.setBounds(0, 710, 400, 20);
		tf.requestFocus();
		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ta.append(tf.getText() + "\n");
				tf.setText("");
				tf.requestFocus();
				
			}
		});
		
		msgbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
							
			}
		});
		
		profilebtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Profile pf = new Profile();
				pf.setVisible(true);

				
			}
		});
		
		shopbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Store st = new Store();
				
				
			}
		});
		
		optbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Setting set = new Setting();
				
			}
		});
		

		this.add(tf);
		this.add(ta);
		this.add(profilebtn);
		this.add(msgbtn);
		this.add(exitbtn);
		this.add(shopbtn);
		this.add(optbtn);
		this.add(makebtn);
		

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
