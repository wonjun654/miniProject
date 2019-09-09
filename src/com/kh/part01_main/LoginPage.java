package com.kh.part01_main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.model.vo.MediaTest;
import com.kh.part03_ID.FindID;
import com.kh.part03_password.FindPassword;
import com.kh.part03_password.PasswordChange;
import com.kh.user.controller.UserManager;
import com.kh.user.model.vo.User;
import com.kh.view.MainMenu;
import com.kh.view.RoundButton;



public class LoginPage extends JFrame {
	ImageIcon icon;
	String str = "";
	UserManager um = new UserManager();
	JPanel bgPan = new JPanel();
	
	
	public LoginPage() {

		this.setSize(1024, 768);
		setTitle("KH치 마인드");
		try {
			this.setIconImage(ImageIO.read(new File("images//logo.PNG")));
		} catch (IOException e) {

			e.printStackTrace();
		}

		setLayout(null);

		bgPan.setLayout(null);
		bgPan.setSize(1024, 768);
		bgPan.setBackground(new Color(195, 245, 230));
		// 배경 이미지 삽입
		icon = new ImageIcon("images//login.png");
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		panel.setBounds(0, 0, 1024, 768);
		panel.setLayout(null);

		// 아이디
		JLabel idLabel = new JLabel("아이디 : ");
		idLabel.setBounds(290, 460, 300, 100);
		JTextField idText = new JTextField();
		idText.setBounds(360, 495, 305, 30);
		panel.add(idLabel);
		panel.add(idText);

		// 패스워드
		JLabel pwLabel = new JLabel("비밀 번호 : ");
		pwLabel.setBounds(274, 503, 300, 100);
		JPasswordField pwField = new JPasswordField();
		pwField.setBounds(360, 540, 305, 30);
		panel.add(pwLabel);
		panel.add(pwField);

		// 로그인 버튼
		RoundButton loginbtn = new RoundButton("로그인");
		loginbtn.setBounds(680, 495, 120, 75);
		panel.add(idText);
		panel.add(loginbtn);

		// 회원가입 버튼
		RoundButton joinbtn = new RoundButton("회원가입");
		joinbtn.setBounds(360, 600, 90, 30);
		panel.add(joinbtn);

		// 아이디 찾기 버튼
		RoundButton idbtn = new RoundButton("ID 찾기 ");
		idbtn.setBounds(466, 600, 90, 30);
		panel.add(idbtn);

		// 비밀번호 찾기 버튼
		RoundButton pwbtn = new RoundButton("P/W 찾기 ");
		pwbtn.setBounds(572, 600, 90, 30);
		panel.add(pwbtn);
		
		//
		
		
		
		
		

		// 로그인 버튼
		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				str += idText.getText() + ":";

				char[] tempPassword = pwField.getPassword();
				String pwd = "";

				for (int i = 0; i < tempPassword.length; i++) {
					pwd += tempPassword[i];

				}
				str += pwd;

				if (um.login(str)) {
					JOptionPane.showMessageDialog(null, "로그인 성공 !");
					if(um.selectOneUser("123").getTempPwd()==true) {
						PasswordChange pc = new PasswordChange(um.selectOneUser("123"));
						
					}else {
					dispose();
					MainMenu menu = new MainMenu();
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "ID/PW를 확인해 주세요.");
					str = "";
				}

			}
		});

		// 회원가입 연동
		joinbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JoinText jt = new JoinText();

			}
		});

		// 아이디 찾기 버튼
		idbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FindID fi = new FindID();

			}
		});

		// 비밀번호 찾기 버튼
		pwbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				FindPassword fp = new FindPassword();

			}
		});

		this.add(panel);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);// 정중앙ㅣ


		MediaTest.musicOn(2, true);


		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/*
	 * public static void main(String[] args) { new LoginPage(); }
	 */

}