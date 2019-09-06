package com.kh.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kh.user.model.vo.User;

public class GameRoom extends JFrame {

	JLabel userImg = null;
	JLabel name = null;
	JLabel userName = null;
	JLabel ctn = null;
	JLabel userCtn = null;
	User u = new User();
	Font copyfont = new Font("고딕", Font.PLAIN, 10);
	
	public GameRoom() {
		this.setTitle("방번호 - 00");
		this.setLayout(null);
		this.setSize(1030, 768);
		this.setResizable(false);

		// 자리잡기용
		// 가운데 화면
		JPanel roomCenter = new JPanel();
		roomCenter.setLayout(null);
		roomCenter.setLocation(262, 0);
		roomCenter.setSize(500, 768);
		this.add(roomCenter);

		//그림판
		JPanel paint = new JPanel();
		paint.setLayout(null);
		paint.setSize(480, 480);
		paint.setLocation(10, 35);
		paint.setBackground(Color.BLACK);
		roomCenter.add(paint);
		
		JPanel toolPane = new JPanel();
		toolPane.setLayout(null);
		toolPane.setSize(480, 50);
		toolPane.setLocation(10, 520);
		toolPane.setBackground(Color.LIGHT_GRAY);
		roomCenter.add(toolPane);
		
		JButton tool = new JButton("도구");
		tool.setSize(60, 30);
		tool.setLocation(400, 10);
		toolPane.add(tool);
		
		JButton trash = new JButton();
		trash.setSize(30, 30);
		trash.setLocation(350, 10);
		toolPane.add(trash);
		
		JButton next = new JButton();
		next.setSize(30, 30);
		next.setLocation(300, 10);
		toolPane.add(next);
		
		JButton prev = new JButton();
		prev.setSize(30, 30);
		prev.setLocation(260, 10);
		toolPane.add(prev);
		
		trash.setBorderPainted(false);
//		trash.setContentAreaFilled(false);
		next.setBorderPainted(false);
		prev.setBorderPainted(false);
		
		JLabel timer = new JLabel("00:00");
		timer.setSize(150, 30);
		timer.setLocation(35, 10);
		toolPane.add(timer);
		
		//채팅----------------------------------------------------------------------
		JTextArea chatOutput = new JTextArea();
		chatOutput.setBackground(Color.WHITE);
		chatOutput.setEditable(false);
		roomCenter.add(chatOutput);

		JTextField chatInput = new JTextField(15);
		chatInput.setSize(500, 30);
		chatInput.setLocation(0, 690);
		roomCenter.add(chatInput);

		JButton chatOkbtn = new JButton("전송");
		chatOkbtn.setSize(60, 29);
		chatOkbtn.setLocation(440, 0);
		chatInput.add(chatOkbtn);

		JScrollPane chatScroll = new JScrollPane(chatOutput);
		chatScroll.setLocation(0, 576);
		chatScroll.setSize(501, 116);
		roomCenter.add(chatScroll);

		// 엔터 누를시 채팅넘기기
		chatInput.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = chatInput.getText();

				// 채팅입력 출력하기
				if (!text.isEmpty()) {
					chatOutput.append(text + "\n");
					chatOutput.setCaretPosition(chatOutput.getDocument().getLength());
					chatInput.setText(null);
					chatInput.requestFocus();
				}

			}
		});

		// 전송버튼 클릭시 채팅넘기기
		chatOkbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String text = chatInput.getText();

				if (!text.isEmpty()) {
					chatOutput.append(text + "\n");
					chatOutput.setCaretPosition(chatOutput.getDocument().getLength());
					chatInput.setText(null);
					chatInput.requestFocus();
				}
			}
		});

		// ---------------------------------------------------------------------
		// 오른쪽 화면
		JPanel roomRight = new JPanel();
		roomRight.setLayout(null);
		roomRight.setBackground(Color.ORANGE);
		roomRight.setLocation(762, 0);
		roomRight.setSize(262, 768);
		this.add(roomRight);

		//이미지, 닉네임, 게임 내 정답횟수
		JPanel user5 = new JPanel();
		user5.setLayout(null);
		user5.setSize(240, 120);
		user5.setLocation(12, 35);
//		userImg = new JLabel(new ImageIcon(new ImageIcon(u.getImgName()).getImage().getScaledInstance(100, 100, 0)));
		userImg = new JLabel("유저5 이미지");
		userImg.setSize(100, 100);
		userImg.setLocation(10, 15);
		user5.add(userImg);
		name = new JLabel("닉네임");
		name.setSize(100, 40);
		name.setLocation(140, 0);
		user5.add(name);
		userName = new JLabel("유저5");
		userName.setSize(100, 30);
		userName.setLocation(140, 30);
		ctn = new JLabel("정답 횟수");
		ctn.setSize(100, 40);
		ctn.setLocation(130, 55);
		user5.add(ctn);
		userCtn = new JLabel("횟수");
		userCtn.setSize(100, 40);
		userCtn.setLocation(157, 80);
		user5.add(userCtn);
		user5.add(userName);
		roomRight.add(user5);

		JPanel user6 = new JPanel();
		user6.setLayout(null);
		user6.setSize(240, 120);
		user6.setLocation(12, 175);
		userImg = new JLabel("유저6 이미지");
		userImg.setSize(100, 100);
		userImg.setLocation(10, 15);
		user6.add(userImg);
		name = new JLabel("닉네임");
		name.setSize(100, 40);
		name.setLocation(140, 0);
		user6.add(name);
		userName = new JLabel("유저6");
		userName.setSize(100, 30);
		userName.setLocation(140, 30);
		user6.add(userName);
		ctn = new JLabel("정답 횟수");
		ctn.setSize(100, 40);
		ctn.setLocation(130, 55);
		user6.add(ctn);
		userCtn = new JLabel("횟수");
		userCtn.setSize(100, 40);
		userCtn.setLocation(157, 80);
		user6.add(userCtn);
		roomRight.add(user6);

		JPanel user7 = new JPanel();
		user7.setLayout(null);
		user7.setSize(240, 120);
		user7.setLocation(12, 315);
		userImg = new JLabel("유저7 이미지");
		userImg.setSize(100, 100);
		userImg.setLocation(10, 15);
		user7.add(userImg);
		name = new JLabel("닉네임");
		name.setSize(100, 40);
		name.setLocation(140, 0);
		user7.add(name);
		userName = new JLabel("유저7");
		userName.setSize(100, 30);
		userName.setLocation(140, 30);
		user7.add(userName);
		ctn = new JLabel("정답 횟수");
		ctn.setSize(100, 40);
		ctn.setLocation(130, 55);
		user7.add(ctn);
		userCtn = new JLabel("횟수");
		userCtn.setSize(100, 40);
		userCtn.setLocation(157, 80);
		user7.add(userCtn);
		roomRight.add(user7);

		JPanel user8 = new JPanel();
		user8.setLayout(null);
		user8.setSize(240, 120);
		user8.setLocation(12, 455);
		userImg = new JLabel("유저8 이미지");
		userImg.setSize(100, 100);
		userImg.setLocation(10, 15);
		user8.add(userImg);
		name = new JLabel("닉네임");
		name.setSize(100, 40);
		name.setLocation(140, 0);
		user8.add(name);
		userName = new JLabel("유저8");
		userName.setSize(100, 30);
		userName.setLocation(140, 30);
		user8.add(userName);
		ctn = new JLabel("정답 횟수");
		ctn.setSize(100, 40);
		ctn.setLocation(130, 55);
		user8.add(ctn);
		userCtn = new JLabel("횟수");
		userCtn.setSize(100, 40);
		userCtn.setLocation(157, 80);
		user8.add(userCtn);
		roomRight.add(user8);

		JButton exitbtn = new JButton("나가기");
		exitbtn.setSize(80, 40);
		exitbtn.setLocation(150, 670);
		roomRight.add(exitbtn);

		JButton report = new JButton("신고하기");
		report.setSize(90, 40);
		report.setLocation(40, 670);
		roomRight.add(report);
		
		// 나가기 버튼 클릭
		exitbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});

		// ---------------------------------------------------------------------
		// 왼쪽 화면
		JPanel roomLeft = new JPanel();
		roomLeft.setLayout(null);
		roomLeft.setBackground(Color.CYAN);
		roomLeft.setLocation(0, 0);
		roomLeft.setSize(262, 768);
		// 블랙 시작지점 262
		this.add(roomLeft);

		JPanel user1 = new JPanel();
		user1.setLayout(null);
		user1.setSize(240, 120);
		user1.setLocation(12, 35);
		userImg = new JLabel("유저1 이미지");
		userImg.setSize(100, 100);
		userImg.setLocation(10, 15);
		user1.add(userImg);
		name = new JLabel("닉네임");
		name.setSize(100, 40);
		name.setLocation(140, 0);
		user1.add(name);
		userName = new JLabel("유저1");
		userName.setSize(100, 30);
		userName.setLocation(140, 30);
		user1.add(userName);
		ctn = new JLabel("정답 횟수");
		ctn.setSize(100, 40);
		ctn.setLocation(130, 55);
		user1.add(ctn);
		userCtn = new JLabel("횟수");
		userCtn.setSize(100, 40);
		userCtn.setLocation(157, 80);
		user1.add(userCtn);
		roomLeft.add(user1);

		JPanel user2 = new JPanel();
		user2.setLayout(null);
		user2.setSize(240, 120);
		user2.setLocation(12, 175);
		userImg = new JLabel("유저2 이미지");
		userImg.setSize(100, 100);
		userImg.setLocation(10, 15);
		user2.add(userImg);
		name = new JLabel("닉네임");
		name.setSize(100, 40);
		name.setLocation(140, 0);
		user2.add(name);
		userName = new JLabel("유저2");
		userName.setSize(100, 30);
		userName.setLocation(140, 30);
		user2.add(userName);
		ctn = new JLabel("정답 횟수");
		ctn.setSize(100, 40);
		ctn.setLocation(130, 55);
		user2.add(ctn);
		userCtn = new JLabel("횟수");
		userCtn.setSize(100, 40);
		userCtn.setLocation(157, 80);
		user2.add(userCtn);
		roomLeft.add(user2);

		JPanel user3 = new JPanel();
		user3.setLayout(null);
		user3.setSize(240, 120);
		user3.setLocation(12, 315);
		userImg = new JLabel("유저3 이미지");
		userImg.setSize(100, 100);
		userImg.setLocation(10, 15);
		user3.add(userImg);
		name = new JLabel("닉네임");
		name.setSize(100, 40);
		name.setLocation(140, 0);
		user3.add(name);
		userName = new JLabel("유저3");
		userName.setSize(100, 30);
		userName.setLocation(140, 30);
		user3.add(userName);
		ctn = new JLabel("정답 횟수");
		ctn.setSize(100, 40);
		ctn.setLocation(130, 55);
		user3.add(ctn);
		userCtn = new JLabel("횟수");
		userCtn.setSize(100, 40);
		userCtn.setLocation(157, 80);
		user3.add(userCtn);
		roomLeft.add(user3);

		JPanel user4 = new JPanel();
		user4.setLayout(null);
		user4.setSize(240, 120);
		user4.setLocation(12, 455);
		userImg = new JLabel("유저4 이미지");
		userImg.setSize(100, 100);
		userImg.setLocation(10, 15);
		user4.add(userImg);
		name = new JLabel("닉네임");
		name.setSize(100, 40);
		name.setLocation(140, 0);
		user4.add(name);
		userName = new JLabel("유저4");
		userName.setSize(100, 30);
		userName.setLocation(140, 30);
		user4.add(userName);
		ctn = new JLabel("정답 횟수");
		ctn.setSize(100, 40);
		ctn.setLocation(130, 55);
		user4.add(ctn);
		userCtn = new JLabel("횟수");
		userCtn.setSize(100, 40);
		userCtn.setLocation(157, 80);
		user4.add(userCtn);
		roomLeft.add(user4);

		Image icon = new ImageIcon("images/title.jpg").getImage().getScaledInstance(240, 120, 0);
		JLabel logo = new JLabel(new ImageIcon(icon));
		logo.setSize(240, 150);
		logo.setLocation(12, 580);
		roomLeft.add(logo);
		
		JLabel copyRight = new JLabel("CopyRighted by KH치마인드");
		copyRight.setFont(copyfont);
		copyRight.setSize(200, 20);
		copyRight.setLocation(170, 717);
		roomCenter.add(copyRight);
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GameRoom();
		
	}
}
