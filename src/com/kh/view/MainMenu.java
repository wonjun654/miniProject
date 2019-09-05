package com.kh.view;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.kh.model.vo.MediaTest;
import com.kh.user.controller.UserManager;
import com.kh.user.model.vo.User;
import com.kh.part01_main.LoginPage;
import com.kh.user.controller.UserManager;

public class MainMenu extends JFrame{

	JTable table1;
	DefaultTableModel model1;
	JTextField tf;
	UserManager um = new UserManager();

	JPanel listPan = new JPanel();
	JTextArea ta;
	JScrollPane sc;

	JList roomList;
	JList roomList2;
	JList roomList3;
	String col1[] = { "방이름", "상태", "인원", "상태", "인원", "상태", "인원", "상태", "인원", "상태", "인원", "상태", "인원", "상태", "인원", "상태", "인원", "상태", "인원", "상태", "인원" };
	String col2[] = { "방이름", "상태", "인원" };
	String col3[] = { "방이름", "상태", "인원" };


	public MainMenu() {

		super("MainMenuPage");

		// String row1[][] = new String[0][3];

		// model1 = new DefaultTableModel(col1) {
		// public boolean isCellEditable(int row, int column) {
		// return false;
		// }
		// };

		// table1 = new JTable(model1);
		// table1.setBounds(80, 150, 750, 320);
		// JScrollPane js1 = new JScrollPane(table1);
		// table1.getTableHeader().setReorderingAllowed(false);
		// js1.setBounds(x, y, width, height);
		//

		// listPan.setBounds(80, 150, 750, 100);
		// JScrollPane jsp = new JScrollPane(listPan);
		// jsp.setSize(80, 150);
		//
		// roomList = new JList(col1);
		// roomList.setBounds(80, 150, 250, 20);
		//
		//
		//
		// roomList2 = new JList(col1);
		// roomList2.setBounds(330, 150, 250, 20);
		//
		//
		// roomList3 = new JList(col1);
		// roomList3.setBounds(580, 150, 250, 20);
		//
		//
		// listPan.add(roomList);
		// listPan.add(roomList2);
		// listPan.add(roomList3);
		//

		// jsp.setHorizontalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		// listPan.add(jsp);

		//

		//

		// Layout 지정 없이 위치 지정하면서 배치하는 방법이다.
		this.setLayout(null);
		this.setSize(1024, 768);

		ta = new JTextArea(50, 50);
		ta.setBounds(80, 150, 500, 500);
		ta.setEditable(false);
		

		sc = new JScrollPane(ta);
		sc.setBounds(80, 150, 750, 320);
		
		
		roomList = new JList(col1);
		roomList.setBounds(0, 0, 250, 360);

		roomList2 = new JList(col1);
		roomList2.setBounds(250, 0, 250, 360);

		roomList3 = new JList(col1);
		roomList3.setBounds(500, 0, 250, 360);

		ta.add(roomList);
		ta.add(roomList2);
		ta.add(roomList3);

		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		roomList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				
			}
		});
		
		

		Image profileimg = new ImageIcon("images\\profile.PNG").getImage().getScaledInstance(75, 75, 0);
		Image makeimg = new ImageIcon("images\\make.PNG").getImage().getScaledInstance(75, 75, 0);
		Image optimg = new ImageIcon("images\\opt.PNG").getImage().getScaledInstance(75, 75, 0);
		Image shopimg = new ImageIcon("images\\shop.PNG").getImage().getScaledInstance(75, 75, 0);
		Image exitimg = new ImageIcon("images\\exit.PNG").getImage().getScaledInstance(75, 75, 0);
		Image coinimg = new ImageIcon("images\\coin.jpg").getImage().getScaledInstance(75, 75, 0);
		Image questimg = new ImageIcon("images\\login.PNG").getImage().getScaledInstance(75, 75, 0);
		
		JLabel namelbl = new JLabel(um.selectOneUser("123").getUserId() + "");
		namelbl.setBounds(86, 10, 75, 75);

		JLabel coinlbl = new JLabel("내 코인 : " + um.selectOneUser("123").getCoin() + "");
		coinlbl.setBounds(276, 10, 200, 75);

		JLabel coinImg = new JLabel(new ImageIcon(coinimg));
		coinImg.setBounds(200, 10, 75, 75);

		JButton profilebtn = new JButton(new ImageIcon(profileimg));
		profilebtn.setLocation(10, 10);
		profilebtn.setSize(75, 75);

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
		
		JButton questbtn = new JButton(new ImageIcon(questimg));
		questbtn.setLocation(600, 500);
		questbtn.setSize(75,75);

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

		profilebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				Profile pf = new Profile(um.selectOneUser("123"));
				pf.setVisible(true);

			}
		});

		shopbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Store st = new Store(um.selectOneUser("123"));
			}

		});

		optbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Setting set = new Setting(um.selectOneUser("123"));

			}
		});
		makebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MakeRoom mr = new MakeRoom(null);

			}
		});
		exitbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				MediaTest.musicOff();
				LoginPage login = new LoginPage();

			}
		});
		questbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				QuestMenu qm = new QuestMenu(um.selectOneUser("123"));
				qm.setVisible(true);
			}
		});


		MediaTest.musicOff();

		MediaTest.musicOn(1, um.selectOneUser("123").getMusicSet());
		this.add(listPan);

		this.add(tf);
		this.add(ta);
		this.add(profilebtn);
		this.add(coinlbl);
		this.add(coinImg);
		// this.add(panel);
		this.add(exitbtn);
		this.add(shopbtn);
		this.add(optbtn);
		this.add(makebtn);
		this.add(namelbl);
		this.add(questbtn);
		// this.add(jsp);
		// this.add(table1);
		// this.add(js1);
		this.add(ta);
		this.add(sc);

		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainMenu();
	}

	
}
