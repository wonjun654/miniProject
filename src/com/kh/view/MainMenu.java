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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.kh.model.vo.MediaTest;
import com.kh.part01_main.LoginPage;

public class MainMenu extends JFrame {

	JTable table1;
	DefaultTableModel model1;
	JTextField tf;
	User u = new User();
	
	public List<JButton> btList;
	public String row1[][];

	public MainMenu() {

		super("MainMenuPage");

		String col1[] = { "방이름", "상태", "인원" };

		String row1[][] = { { "a1", "a2", "a3" }, { "b1", "b2", "b3" }, { "c1", "c2", "c3" } };

		model1 = new DefaultTableModel(row1, col1) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		table1 = new JTable(model1);
		JScrollPane js1 = new JScrollPane(table1);
		table1.getTableHeader().setReorderingAllowed(false);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈

		setLayout(null);

		js1.setBounds(80, 150, 700, 320);
		add(js1);

		setLayout(null);

		this.setBounds(300, 200, 1024, 768);

		this.setSize(1024, 768);
		this.setLocation((screenSize.width - this.getWidth()) / 2, (screenSize.height - this.getHeight()) / 2);

		// Layout 지정 없이 위치 지정하면서 배치하는 방법이다.
		this.setLayout(null);
		Image profileimg = new ImageIcon("images\\profile.PNG").getImage().getScaledInstance(75, 75, 0);
		Image makeimg = new ImageIcon("images\\make.PNG").getImage().getScaledInstance(75, 75, 0);
		Image optimg = new ImageIcon("images\\opt.PNG").getImage().getScaledInstance(75, 75, 0);
		Image shopimg = new ImageIcon("images\\shop.PNG").getImage().getScaledInstance(75, 75, 0);
		Image exitimg = new ImageIcon("images\\exit.PNG").getImage().getScaledInstance(75, 75, 0);

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
		makebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MakeRoom mr = new MakeRoom();

			}
		});
		exitbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginPage login = new LoginPage();
				
			}
		});
		MediaTest mt = new MediaTest();
		mt.musicOn(0,true);
		this.add(tf);
		this.add(ta);
		this.add(profilebtn);
		// this.add(panel);
		this.add(exitbtn);
		this.add(shopbtn);
		this.add(optbtn);
		this.add(makebtn);

		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
