package com.kh.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.kh.model.vo.GameRoomInfo;
import com.kh.model.vo.MediaTest;
import com.kh.model.vo.MyMusicPlayer;
import com.kh.part01_main.LoginPage;
import com.kh.user.controller.UserManager;
import com.kh.user.model.vo.ClientUser;
import com.kh.user.model.vo.Sender;

public class MainMenu extends JFrame implements MouseListener {

	UserManager um = new UserManager();

	JPanel north_p, center_p, south_p;
	
	JPanel listPan = new JPanel();
	JPanel bgPan = new JPanel();
	
	

	JTextArea textOutput;
	JTextField textInput;
	RoundButton rbtn;

	
	JScrollPane gameRoomListScrollPane, waitingRoomUserListScrollPane, waitingRoomChatScrollPane;
	JList<String> gameRoomList, waitingRoomUserList;
	
	JLabel lblroom;
	JLabel lblsang;
	JLabel lblpeople;

	public JTable table1;
	public DefaultTableModel model1;
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
	MainMenu mm;
	ClientUser u;

	

	/*public MainMenu(Socket socket, ClientUser u, Thread sender, Thread receiver) {
		super("MainMenuPage");
		this.socket = socket;
		this.u = u;
		this.sender = sender;
		this.receiver = receiver;
		profile = true;
		tempPwd = false;
//		((Receiver) receiver).getMainMenu(this);
		// Layout 지정 없이 위치 지정하면서 배치하는 방법이다.
	}*/




	public MainMenu(Socket socket, ClientUser u, Thread sender, Thread receiver) {
		super("MainMenuPage");
		this.socket = socket;
		this.u = u;
		this.sender = sender;
		this.receiver = receiver;
	}
	





	public void doMain() {
		this.mm = this;
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

		
		
		
		
		
		
		

		this.setSize(1024, 768);

		Image profileimg = new ImageIcon("images\\프로필.PNG").getImage().getScaledInstance(85, 75, 0);
		Image makeimg = new ImageIcon("images\\make.PNG").getImage().getScaledInstance(60, 60, 0);
		Image optimg = new ImageIcon("images\\설정.PNG").getImage().getScaledInstance(85, 75, 0);
		Image shopimg = new ImageIcon("images\\상점.PNG").getImage().getScaledInstance(85, 75, 0);
		Image exitimg = new ImageIcon("images\\exit.PNG").getImage().getScaledInstance(60, 60, 0);
		Image coinimg = new ImageIcon("images\\coin.jpg").getImage().getScaledInstance(60, 60, 0);
		Image questimg = new ImageIcon("images\\퀘스트.PNG").getImage().getScaledInstance(85, 75, 0);
		Image chosungimg = new ImageIcon("images\\chosung.png").getImage().getScaledInstance(60, 60, 0);
		Image timerimg = new ImageIcon("images\\timer.png").getImage().getScaledInstance(60, 60, 0);

		// JLabel namelbl = new JLabel(um.selectOneUser("123").getUserId() + "");
		JLabel namelbl = new JLabel(u.getUserId());
		namelbl.setBounds(86, 10, 60, 60);

		JLabel coinImg = new JLabel(new ImageIcon(coinimg));
		coinImg.setBounds(200, 10, 60, 60);

		// JLabel coinlbl = new JLabel("내 코인 : " + um.selectOneUser("123").getCoin() +
		// "");
		JLabel coinlbl = new JLabel("내 코인 : " + u.getCoin());
		coinlbl.setBounds(276, 10, 100, 60);

		JLabel chosungImg = new JLabel(new ImageIcon(chosungimg));
		chosungImg.setBounds(376, 10, 60, 60);

		// JLabel chosunglbl = new JLabel("내 아이템 : " +
		// um.selectOneUser("123").getOwnItem2() + "");
		JLabel chosunglbl = new JLabel("내 아이템 : " + u.getOwnItem2());
		chosunglbl.setBounds(437, 10, 100, 60);

		JLabel timerImg = new JLabel(new ImageIcon(timerimg));
		timerImg.setBounds(576, 10, 60, 60);

		// JLabel timerlbl = new JLabel("내 아이템 : " +
		// um.selectOneUser("123").getOwnItem1() + "");
		JLabel timerlbl = new JLabel("내 아이템 : " + u.getOwnItem1());
		timerlbl.setBounds(637, 10, 100, 60);

		JButton profilebtn = new JButton(new ImageIcon(profileimg));
		profilebtn.setLocation(10, 10);
		profilebtn.setSize(85, 75);
		profilebtn.setFocusPainted(false);
		profilebtn.setContentAreaFilled(false);

		JButton makebtn = new JButton(new ImageIcon(makeimg));
		makebtn.setLocation(765, 10);
		makebtn.setSize(60, 60);

		JButton optbtn = new JButton(new ImageIcon(optimg));
		optbtn.setLocation(885, 600);
		optbtn.setSize(85, 75);

		JButton shopbtn = new JButton(new ImageIcon(shopimg));
		shopbtn.setLocation(885, 10);
		shopbtn.setSize(85, 75);
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

		// make.addActionListener(new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		// String roomName = JOptionPane.showInputDialog("방이름 입력");
		// if(roomName == null) {
		// JOptionPane.showMessageDialog(null, "방이름을 입력하세요!");
		// } else {
		// ((Sender) sender).sendCreateRoom(roomName);
		// }
		// }
		// });

		RoundButton in = new RoundButton("방입장");
		in.setBounds(850, 250, 80, 30);
		in.setFocusPainted(false);
		in.setContentAreaFilled(false);

		Dialog makeRoomDialog = new Dialog(this, "방만들기", true);
		makeRoomDialog.setLayout(null);
		makeRoomDialog.setBounds(600, 500, 600, 500);

		JLabel roomName = new JLabel("방제목");
		JLabel roomPwd = new JLabel("방암호");
		JLabel roomPeople = new JLabel("인원수");

		roomName.setBounds(125, 150, 75, 35);
		roomPwd.setBounds(125, 200, 75, 35);
		roomPeople.setBounds(125, 250, 75, 35);

		JTextArea roomName2 = new JTextArea();
		JTextArea roomPwd2 = new JTextArea();
		JTextArea roomPeople2 = new JTextArea();
		roomName2.setBounds(175, 150, 175, 25);
		roomPwd2.setEnabled(false);
		roomPwd2.setEditable(false);
		roomPwd2.setBounds(175, 200, 175, 25);
		roomPeople2.setBounds(175, 250, 175, 25);

		SpinnerModel numberModel = new SpinnerNumberModel(4, 4, 8, 1);
		JSpinner selectPeople = new JSpinner(numberModel);
		selectPeople.setBounds(175, 250, 175, 25);

		RoundButton btnOK = new RoundButton("확인");
		RoundButton btnCancel = new RoundButton("취소");
		btnOK.setBounds(250, 300, 100, 35);
		btnCancel.setBounds(375, 300, 100, 35);

		JCheckBox checkSecret = new JCheckBox();
		checkSecret.setBounds(360, 185, 50, 50);

		makeRoomDialog.add(roomPeople);
		makeRoomDialog.add(roomPwd);
		makeRoomDialog.add(roomName);
		makeRoomDialog.add(roomName2);
		makeRoomDialog.add(roomPwd2);
		makeRoomDialog.add(selectPeople);
		makeRoomDialog.add(btnOK);
		makeRoomDialog.add(btnCancel);
		makeRoomDialog.add(checkSecret);

		makeRoomDialog.setLocationRelativeTo(null);
		
		
		
		JTextArea roomState = new JTextArea();
		roomState.setBounds(450, 150, 350, 200);
		roomState.setEditable(false);
	
		JScrollPane scPanel2 = new JScrollPane(roomState);
		scPanel2.setBounds(450, 150, 350, 200);
		scPanel2.setBorder(new TitledBorder("방 정보"));
		
		DefaultListModel<String>  model1 = new DefaultListModel<String>();
		JList roomList = new JList(model1);
		JScrollPane scPanel = new JScrollPane(roomList);
		scPanel.setBorder(new TitledBorder("방 목록"));
		scPanel.setBounds(80, 150, 350, 200);
		
		roomList.addMouseListener(new MouseListener() {
			
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
				String roomName = roomName2.getText();
				if (roomList.getSelectedIndex() != -1) {
					if (roomName == null) {
						JOptionPane.showMessageDialog(null, "방이름을 입력하세요!");
					} else {
						((Sender) sender).sendEnterRoom(roomName);
					}
				
				}
			}
		});



		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				makeRoomDialog.dispose();

			}
		});
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String roomName = roomName2.getText();
				String roomPw = roomPwd2.getText();
				String people = selectPeople.getValue() + "";
				model1.addElement(roomName + " : " + people); 
				((Sender) sender).sendCreateRoom(roomName, roomPw, people);
				makeRoomDialog.dispose();
				roomName2.setText("");
				
				

			}
		});

		checkSecret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkSecret.isSelected()) {
					roomPwd2.setEditable(true);
					roomPwd2.setEnabled(true);

				} else {
					roomPwd2.setEditable(false);
					roomPwd2.setEnabled(false);
				}

			}
		});

		make.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				makeRoomDialog.setVisible(true);
			}
		});

		in.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String roomName = JOptionPane.showInputDialog("방이름 입력");
				if (roomName == null) {
					JOptionPane.showMessageDialog(null, "방이름을 입력하세요!");
				} else {
					((Sender) sender).sendEnterRoom(roomName);
				}
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
		textInput.setBounds(0, 710, 600, 28);
		textInput.requestFocus();
		this.add(textInput);

		JScrollPane chatScroll = new JScrollPane(textOutput);
		chatScroll.setLocation(0, 590);
		chatScroll.setSize(600, 122);
		this.add(chatScroll);

		JButton textOkbtn = new JButton("전송");
		textOkbtn.setSize(60, 28);
		textOkbtn.setLocation(538, 0);
		textInput.add(textOkbtn);

		// 전송 버튼
		textOkbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = textInput.getText();
				if (!msg.isEmpty()) {
					((Sender) sender).sendMainRoomMsg(msg);
					textOutput.append(userId + " >> " + msg + "\n");
					textOutput.setCaretPosition(textOutput.getDocument().getLength());
					textInput.setText(null);
					textInput.requestFocus();
				}
			}
		});
		// 엔터
		textInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = textInput.getText();
				if (!msg.isEmpty()) {
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

//				Profile pf = new Profile(um.selectOneUser("123"));
				Profile pf = new Profile(u);
				pf.setVisible(true);

			}
		});

		shopbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Store st = new Store(u, getMainMenu());
			}

		});

		optbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Setting set = new Setting(u);

			}
		});
		makebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// MakeRoom mr = new MakeRoom(null);

			}
		});
		questbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				QuestMenu qm = new QuestMenu(u);
				qm.setVisible(true);
			}
		});

		MediaTest.musicOff();

		// MediaTest.musicOn(1, um.selectOneUser("123").getMusicSet());

		MediaTest.musicOn(1, u.isMusicSet());


		rbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((Sender) sender).sendLogOut(u.getUserId());
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				dispose();
				

				LoginPage login = new LoginPage(socket);
				((Sender) sender).sendUserInfo(u);
			
			}
		});


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
		// this.add(sc);
		this.add(questbtn);
		// this.add(lblroom);
		// this.add(lblsang);
		// this.add(lblpeople);
		this.add(chosungImg);
		this.add(timerImg);
		this.add(chosunglbl);
		this.add(timerlbl);
		this.add(make);
		this.add(in);
		this.add(scPanel);
		this.add(scPanel2);
		//this.add(roomState);
		
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
		textInput.requestFocus();
	}
	public MainMenu getMainMenu() {
		return mm;
	}
}
