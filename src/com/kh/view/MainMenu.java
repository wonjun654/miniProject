package com.kh.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.imageio.ImageIO;
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
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.kh.model.vo.MediaTest;
import com.kh.part01_main.LoginPage;
import com.kh.user.controller.UserManager;

public class MainMenu extends JFrame implements MouseListener {

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

	JTable table1;
	DefaultTableModel model1;
	
	
	
	// String col1[] = { "안녕하세요", "반갑습니다", "수고하세요" };
	// String col2[] = { "게임중", "대기중", "대기중" };
	// String col3[] = { "4/4", "2/6", "3/8" };
	
	
	
	String header[] = { "방제목", "상태", "인원" };
	
	


	public MainMenu() {

		super("MainMenuPage");
		try {
			this.setIconImage(ImageIO.read(new File("images//logo.PNG")));
		} catch (IOException e) {

			e.printStackTrace();
		}

		// Layout 지정 없이 위치 지정하면서 배치하는 방법이다.
		this.setLayout(null);
		this.setSize(1024, 768);
		bgPan.setLayout(null);
		bgPan.setSize(1024, 768);
		bgPan.setBackground(new Color(195, 245, 230));
		
		
		ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("ㅅㅂ", "1234");
		HashMap<String, String> map2 = new HashMap<String, String>();
		map.put("ㅈ까", "4567");
		
		list.add(map);
		list.add(map2);
		
//		Iterator iter = list.get(0).it
//		Iterator<HashMap<String, String>> itr = list.iterator();
		
	
		
		
	
		
		
		


		

		model1 = new DefaultTableModel() {
			

			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		model1.addColumn("방제목");
		model1.addColumn("상태");
		model1.addColumn("비밀번호");

		JTable table1 = new JTable(model1);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JScrollPane scPanel = new JScrollPane(table1);
		scPanel.setBounds(80, 150, 850, 320);
		scPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scPanel);
		this.pack();
		
		
		
		table1.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					GameRoom gr = new GameRoom();
				}

			}
		});
		
		
		

		this.setSize(1024, 768);

		// sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		// //roomList.addListSelectionListener(new ListSelectionListener() {
		//
		// @Override
		// public void valueChanged(ListSelectionEvent e) {
		// if(roomList.getSelectedIndex() == 0) {
		// GameRoom gr = new GameRoom();
		// dispose();
		// }
		//
		// }
		// });

		Image profileimg = new ImageIcon("images\\profile.PNG").getImage().getScaledInstance(60, 60, 0);
		Image makeimg = new ImageIcon("images\\make.PNG").getImage().getScaledInstance(60, 60, 0);
		Image optimg = new ImageIcon("images\\opt.PNG").getImage().getScaledInstance(85, 70, 0);
		Image shopimg = new ImageIcon("images\\shop.PNG").getImage().getScaledInstance(60, 60, 0);
		Image exitimg = new ImageIcon("images\\exit.PNG").getImage().getScaledInstance(60, 60, 0);
		Image coinimg = new ImageIcon("images\\coin.jpg").getImage().getScaledInstance(60, 60, 0);
		Image questimg = new ImageIcon("images\\quest.PNG").getImage().getScaledInstance(85, 70, 0);
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

		JLabel chosunglbl = new JLabel("내 아이템 : " + um.selectOneUser("123").getOwnItem2() + "");
		chosunglbl.setBounds(437, 10, 100, 60);

		JLabel timerImg = new JLabel(new ImageIcon(timerimg));
		timerImg.setBounds(576, 10, 60, 60);

		JLabel timerlbl = new JLabel("내 아이템 : " + um.selectOneUser("123").getOwnItem1() + "");
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
		ta.setBounds(0, 550, 600, 750);
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
				MakeRoom mr = new MakeRoom();
				

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
		// this.add(sc);
		this.add(questbtn);
		// this.add(lblroom);
		// this.add(lblsang);
		// this.add(lblpeople);
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
