package com.kh.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

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
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.kh.model.vo.MediaTest;
import com.kh.part01_main.LoginPage;
import com.kh.user.controller.UserManager;

import javafx.scene.input.MouseEvent;

public class MainMenu extends JFrame implements MouseListener {

	JTable table1;
	DefaultTableModel model1;
	JTextField tf;
	UserManager um = new UserManager();

	JPanel listPan = new JPanel();
	JPanel bgPan = new JPanel();
	JTextArea ta;
	JScrollPane sc;

	RoundButton rbtn;

	JList roomList;
	JList roomList2;
	JList roomList3;

	JLabel lblroom;
	JLabel lblsang;
	JLabel lblpeople;

	String col1[] = { "안녕하세요", "반갑습니다", "수고하세요" };
	String col2[] = { "게임중", "대기중", "대기중" };
	String col3[] = { "4/4", "2/6", "3/8" };

	Color color;

	public MainMenu() {

		super("MainMenuPage");

		// Layout 지정 없이 위치 지정하면서 배치하는 방법이다.
		this.setLayout(null);
		this.setSize(1024, 768);
		bgPan.setLayout(null);
		bgPan.setSize(1024, 768);
		bgPan.setBackground(new Color(195, 245, 230));

		ta = new JTextArea(50, 50);
		ta.setBounds(80, 150, 450, 500);
		ta.setEditable(false);

		sc = new JScrollPane(ta);
		sc.setBounds(80, 150, 700, 320);

		lblroom = new JLabel("방이름");
		lblroom.setBounds(145, 100, 60, 60);

		lblsang = new JLabel("상태");
		lblsang.setBounds(385, 100, 60, 60);

		lblpeople = new JLabel("인원");
		lblpeople.setBounds(625, 100, 60, 60);

		
		roomList = new JList(col1);
		roomList.setBounds(0, 0, 200, 360);

		roomList2 = new JList(col2);
		roomList2.setBounds(250, 0, 200, 360);

		roomList3 = new JList(col3);
		roomList3.setBounds(500, 0, 200, 360);

		ta.add(roomList);
		ta.add(roomList2);
		ta.add(roomList3);

		sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		roomList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(roomList.getSelectedIndex() == 0) {
					GameRoom gr = new GameRoom();
					dispose();
				}
				
			}
		});

		Image profileimg = new ImageIcon("images\\profile.PNG").getImage().getScaledInstance(60, 60, 0);
		Image makeimg = new ImageIcon("images\\make.PNG").getImage().getScaledInstance(60, 60, 0);
		Image optimg = new ImageIcon("images\\opt.PNG").getImage().getScaledInstance(85, 70, 0);
		Image shopimg = new ImageIcon("images\\shop.PNG").getImage().getScaledInstance(60, 60, 0);
		Image exitimg = new ImageIcon("images\\exit.PNG").getImage().getScaledInstance(60, 60, 0);
		Image coinimg = new ImageIcon("images\\coin.jpg").getImage().getScaledInstance(60, 60, 0);
		Image questimg = new ImageIcon("images\\login.PNG").getImage().getScaledInstance(85, 70, 0);
		Image chosungimg = new ImageIcon("images\\chosung.png").getImage().getScaledInstance(60, 60, 0);
		Image timerimg = new ImageIcon("images\\timer.png").getImage().getScaledInstance(60, 60, 0);
		

		JLabel namelbl = new JLabel(um.selectOneUser("123").getUserId() + "");
		namelbl.setBounds(86, 10, 60, 60);

		JLabel coinImg = new JLabel(new ImageIcon(coinimg));
		coinImg.setBounds(200, 10, 60, 60);
		
		JLabel coinlbl = new JLabel("내 코인 : " + um.selectOneUser("123").getCoin() + "");
		coinlbl.setBounds(276, 10, 100, 60);

		
		JLabel chosungImg = new JLabel(new ImageIcon(chosungimg));
		chosungImg.setBounds(376, 10, 60, 60);
		
		JLabel chosunglbl = new JLabel("내 아이템 : " + um.selectOneUser("123").getOwnItem1() + "");
		chosunglbl.setBounds(437, 10, 100, 60);
		
		JLabel timerImg = new JLabel(new ImageIcon(timerimg));
		timerImg.setBounds(576, 10, 60, 60);
		
		JLabel timerlbl = new JLabel("내 아이템 : " + um.selectOneUser("123").getOwnItem2() + "");
		timerlbl.setBounds(637, 10, 100, 60);

		JButton profilebtn = new JButton(new ImageIcon(profileimg));
		profilebtn.setLocation(10, 10);
		profilebtn.setSize(60, 60);

		JButton makebtn = new JButton(new ImageIcon(makeimg));
		makebtn.setLocation(765, 10);
		makebtn.setSize(60, 60);

		JButton optbtn = new JButton(new ImageIcon(optimg));
		optbtn.setLocation(885, 600);
		optbtn.setSize(85, 70);

		JButton shopbtn = new JButton(new ImageIcon(shopimg));
		shopbtn.setLocation(885, 10);
		shopbtn.setSize(60, 60);
		shopbtn.setFocusPainted(false);
		shopbtn.setContentAreaFilled(false);

		rbtn = new RoundButton("E     X     I     T");
		rbtn.setLocation(750, 680);
		rbtn.setSize(235, 48);
		rbtn.setFocusPainted(false);
		rbtn.setContentAreaFilled(false);

		JButton questbtn = new JButton(new ImageIcon(questimg));
		questbtn.setLocation(750, 600);
		questbtn.setSize(85, 70);
		questbtn.setFocusPainted(false);
		questbtn.setContentAreaFilled(false);
		
		
		JTextArea ta = new JTextArea();
		ta.setBounds(0, 590, 600, 600);
		ta.setEditable(false);

		JTextField tf = new JTextField();
		tf.setBounds(0, 720, 600, 20);
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
		rbtn.addActionListener(new ActionListener() {

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
		this.add(rbtn);
		this.add(shopbtn);
		this.add(optbtn);
		this.add(makebtn);
		this.add(namelbl);
		// this.add(jsp);
		// this.add(table1);
		// this.add(js1);
		this.add(ta);
		this.add(sc);
		this.add(questbtn);
		this.add(lblroom);
		this.add(lblsang);
		this.add(lblpeople);
		this.add(chosungImg);
		this.add(timerImg);
		this.add(chosunglbl);
		this.add(timerlbl);
	
		this.add(bgPan);

		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainMenu();
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
