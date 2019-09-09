package com.kh.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
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
import com.kh.user.model.dao.Receiver;
import com.kh.user.model.vo.Sender;

public class MainMenu extends JFrame implements MouseListener{

	
	
	
	UserManager um = new UserManager();

	JPanel listPan = new JPanel();
	JPanel bgPan = new JPanel();
	
	JScrollPane sc;
	JTextArea textOutput;
	JTextField textInput;
	RoundButton rbtn;

	JList roomList;
	JList roomList2;
	JList roomList3;

	JLabel lblroom;
	JLabel lblsang;
	JLabel lblpeople;
	
	JTable table1;
	DefaultTableModel model1;
	MakeRoom mr;
	Socket socket;
	String userId;
	String userPw;
	String userCoin;
	String userItem2;
	String userItem1; 
	boolean userMusicSet;
	boolean profile;
	boolean tempPwd;
	
	Thread sender;
	Thread receiver;
	

//	String col1[] = { "안녕하세요", "반갑습니다", "수고하세요" };
//	String col2[] = { "게임중", "대기중", "대기중" };
//	String col3[] = { "4/4", "2/6", "3/8" };
	
	String header[] = {"방제목", "상태", "인원"};
	String contents[][] = {
			                { "안녕하세요", "게임중", "4/4" },
							{ "안녕하세요", "대기중", "3/8" },
							{ "안녕하세요", "대기중", "3/8" }};

	
	public MainMenu(Socket socket, String userId, String userPw, String userCoin, String userItem2, String userItem1, boolean userMusicSet, Thread sender, Thread receiver) {
		super("MainMenuPage");
		this.socket = socket;
		this.userId = userId;
		this.userPw = userPw;
		this.userCoin = userCoin;
		this.userItem2 = userItem2;
		this.userItem1 = userItem1;
		this.userMusicSet = userMusicSet;
		this.sender = sender;
		this.receiver = receiver;
		profile = true;
		tempPwd = false;
		((Receiver) receiver).getMainMenu(this);
		// Layout 지정 없이 위치 지정하면서 배치하는 방법이다.
	}
	
	public void doMain() {
		this.setLayout(null);
		this.setSize(1024, 768);
		bgPan.setLayout(null);
		bgPan.setSize(1024, 768);
		bgPan.setBackground(new Color(195, 245, 230));
		try {
			this.setIconImage(ImageIO.read(new File("images//logo.PNG")));
		} catch (IOException e) {

			e.printStackTrace();
		}
		
//		ta = new JTextArea(50, 50);
//		ta.setBounds(80, 150, 450, 500);
//		ta.setEditable(false);
//
//		sc = new JScrollPane(ta);
//		sc.setBounds(80, 150, 700, 320);
//
//		lblroom = new JLabel("방이름");
//		lblroom.setBounds(145, 100, 60, 60);
//
//		lblsang = new JLabel("상태");
//		lblsang.setBounds(385, 100, 60, 60);
//
//		lblpeople = new JLabel("인원");
//		lblpeople.setBounds(625, 100, 60, 60);
//
//		
//		roomList = new JList(col1);
//		roomList.setBounds(0, 0, 200, 360);
//
//		roomList2 = new JList(col2);
//		roomList2.setBounds(250, 0, 200, 360);
//
//		roomList3 = new JList(col3);
//		roomList3.setBounds(500, 0, 200, 360);
//
//		ta.add(roomList);
//		ta.add(roomList2);
//		ta.add(roomList3);

		
		model1 = new DefaultTableModel(contents, header) {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		
		JTable table1 = new JTable(model1);
		table1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scPanel = new JScrollPane(table1);
		scPanel.setBounds(80, 150, 700, 320);
		scPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scPanel);
		this.pack();
		

				
		
		
		
		this.setSize(1024, 768);
			
		//sc.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//sc.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

//		//roomList.addListSelectionListener(new ListSelectionListener() {
//			
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				if(roomList.getSelectedIndex() == 0) {
//					GameRoom gr = new GameRoom();
//					dispose();
//				}
//				
//			}
//		});

		Image profileimg = new ImageIcon("images\\profile.PNG").getImage().getScaledInstance(60, 60, 0);
		Image makeimg = new ImageIcon("images\\make.PNG").getImage().getScaledInstance(60, 60, 0);
		Image optimg = new ImageIcon("images\\opt.PNG").getImage().getScaledInstance(85, 70, 0);
		Image shopimg = new ImageIcon("images\\shop.PNG").getImage().getScaledInstance(60, 60, 0);
		Image exitimg = new ImageIcon("images\\exit.PNG").getImage().getScaledInstance(60, 60, 0);
		Image coinimg = new ImageIcon("images\\coin.jpg").getImage().getScaledInstance(60, 60, 0);
		Image questimg = new ImageIcon("images\\quest.PNG").getImage().getScaledInstance(85, 70, 0);
		Image chosungimg = new ImageIcon("images\\chosung.png").getImage().getScaledInstance(60, 60, 0);
		Image timerimg = new ImageIcon("images\\timer.png").getImage().getScaledInstance(60, 60, 0);
		

//		JLabel namelbl = new JLabel(um.selectOneUser("123").getUserId() + "");
		JLabel namelbl = new JLabel(userId);
		namelbl.setBounds(86, 10, 60, 60);

		JLabel coinImg = new JLabel(new ImageIcon(coinimg));
		coinImg.setBounds(200, 10, 60, 60);
		
//		JLabel coinlbl = new JLabel("내 코인 : " + um.selectOneUser("123").getCoin() + "");
		JLabel coinlbl = new JLabel("내 코인 : " + userCoin);
		coinlbl.setBounds(276, 10, 100, 60);

		
		JLabel chosungImg = new JLabel(new ImageIcon(chosungimg));
		chosungImg.setBounds(376, 10, 60, 60);
		
//		JLabel chosunglbl = new JLabel("내 아이템 : " + um.selectOneUser("123").getOwnItem2() + "");
		JLabel chosunglbl = new JLabel("내 아이템 : " + userItem2);
		chosunglbl.setBounds(437, 10, 100, 60);
		
		JLabel timerImg = new JLabel(new ImageIcon(timerimg));
		timerImg.setBounds(576, 10, 60, 60);
		
//		JLabel timerlbl = new JLabel("내 아이템 : " + um.selectOneUser("123").getOwnItem1() + "");
		JLabel timerlbl = new JLabel("내 아이템 : " + userItem1);
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
		
		RoundButton make = new RoundButton("방생성");
		make.setBounds(850, 200, 80, 30);
		make.setFocusPainted(false);
		make.setContentAreaFilled(false);
		
		make.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String roomName = JOptionPane.showInputDialog("방이름 입력");
				((Sender) sender).sendCreateRoom(roomName);
			}
		});
		RoundButton in = new RoundButton("방입장");
		in.setBounds(850, 250, 80, 30);
		in.setFocusPainted(false);
		in.setContentAreaFilled(false);
		
		in.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String roomName = JOptionPane.showInputDialog("방이름 입력");
				((Sender) sender).sendEnterRoom(roomName);
			}
		});

		JButton questbtn = new JButton(new ImageIcon(questimg));
		questbtn.setLocation(750, 600);
		questbtn.setSize(85, 70);
		questbtn.setFocusPainted(false);
		questbtn.setContentAreaFilled(false);
				
		textOutput = new JTextArea();
		textOutput.setBounds(0, 590, 600, 600);
		textOutput.setEditable(false);

		textInput = new JTextField();
		textInput.setBounds(0, 720, 600, 20);
		textInput.requestFocus();
		
		textInput.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = textInput.getText();
				if(!msg.isEmpty()) {
					((Sender) sender).sendMainRoomMsg(msg);
					textOutput.append(userId + " >> " + msg + "\n");
					textOutput.setCaretPosition(textOutput.getDocument().getLength());
					textInput.setText(null);
					textInput.requestFocus();
				}
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
				LoginPage login = new LoginPage(socket);

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


//		MediaTest.musicOn(1, um.selectOneUser("123").getMusicSet());
		MediaTest.musicOn(1, userMusicSet);
		this.add(listPan);

		this.add(textInput);
		this.add(textOutput);
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
		this.add(textOutput);
		//this.add(sc);
		this.add(questbtn);
		//this.add(lblroom);
		//this.add(lblsang);
		//this.add(lblpeople);
		this.add(chosungImg);
		this.add(timerImg);
		this.add(chosunglbl);
		this.add(timerlbl);
		this.add(make);
		this.add(in);
	
		this.add(bgPan);

		this.setResizable(false);
		this.setLocationRelativeTo(null);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	public void appendChat(String msg) {
		textOutput.append(msg + "\n");
		textOutput.setCaretPosition(textOutput.getDocument().getLength());
		textInput.setText(null);
		textInput.requestFocus();
	}
}
