package com.kh.part01_main;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.kh.user.controller.UserManager;


public class JoinPage extends JFrame {

	public JTextArea textArea;
	 public JRadioButton rbAgree;
	    public JRadioButton rbdisAgree;
	    UserManager um = new UserManager();
	    String str = "";
	    

	public JoinPage() {
		
		setTitle("KH치 마인드 - 회원가입");
		try {
			this.setIconImage(ImageIO.read(new File("images\\logo.png")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.setBounds(250, 250, 1024, 768);
		this.setLayout(null);

		//회원가입 로고
		JLabel nameCard = new JLabel("회원가입");
		nameCard.setFont(new Font("굴림", Font.BOLD,40));
		nameCard.setBounds(70, 20, 292, 64);
		add(nameCard);
		
		//아이디
		JLabel ldLabel = new JLabel("아이디 : ");
		ldLabel.setBounds(440, 245, 57, 15);
		add(ldLabel);

		//아이디 입력란
		JTextField idtextField = new JTextField();
		idtextField.setBounds(500, 240, 263, 30);
		add(idtextField);
		idtextField.setColumns(10);

		//아이디 중복확인
		JButton btnNewButton = new JButton("ID Check");
		btnNewButton.setBounds(780, 240, 120, 31);
		add(btnNewButton);

		//비밀번호
		JLabel pwLabel = new JLabel("비밀번호 : ");
		pwLabel.setBounds(425, 347, 72, 15);
		add(pwLabel);

		//비밀번호 입력란
		JPasswordField pwTextField = new JPasswordField();
		pwTextField.setColumns(10);
		pwTextField.setBounds(500, 340, 263, 30);
		add(pwTextField);

		//닉네임
		JLabel nickLabel = new JLabel("닉네임 : ");
		nickLabel.setBounds(439, 296, 57, 15);
		add(nickLabel);
		
		//닉네임 입력란
		JTextField nickField = new JTextField();
		nickField.setBounds(500, 290, 263, 30);
		add(nickField);
		nickField.setColumns(10);
				
		//비밀번호 재확인
		JLabel pwLabel2 = new JLabel("비밀번호 재확인 : ");
		pwLabel2.setBounds(385, 398, 200, 15);
		add(pwLabel2);
		
		//비밀번호 재확인 입력란
		JPasswordField pwTextField2 = new JPasswordField();
		pwTextField2.setColumns(10);
		pwTextField2.setBounds(500, 390, 263, 30);
		add(pwTextField2);
		
		//비밀번호 일치여부
		JLabel pwCheck = new JLabel();
		pwCheck.setBounds(500, 423, 200, 15);
		pwTextField2.addKeyListener(new KeyListener() {
	
			@Override
			public void keyTyped(KeyEvent e) {

			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				if(pwTextField.getText().equals(pwTextField2.getText())) {
					System.out.println(pwTextField.getText() + "\n"+pwTextField2.getText());
					pwCheck.setText("비밀번호가 일치합니다.");
				}else {
					pwCheck.setText("비밀번호가 일치하지 않습니다.");
				}
			}
				

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		  add(pwCheck);

		  
			//이메일
			JLabel emailLabel = new JLabel("이메일 : ");
			emailLabel.setBounds(440, 500, 57, 15);
			add(emailLabel);

			//이메일 아이디 입력란
			JTextField emailTextField = new JTextField();
			emailTextField.setColumns(10);
			emailTextField.setBounds(500, 490, 150, 30);
			add(emailTextField);
			
			//@
			JLabel goalLabel = new JLabel(" @ ");
			goalLabel.setBounds(663, 495, 20, 15);
			add(goalLabel);
			
			//이메일 작성예
			JLabel emailEx = new JLabel(" ex) 1234@naver.com ");
			emailEx.setBounds(500,525, 200, 15);
			add(emailEx);
			
			//이메일 주소입력란
			JTextField emailTextField2 = new JTextField("");
			emailTextField2.setBounds(700, 490, 150, 30);
			emailTextField2.setEditable(false);
			add(emailTextField2);
			
			//이메일 주소 종류
			String[] email = {"naver.com","hanmail.com",
					"yahoo.co.kr","nate.com","직접입력"};
			
			JComboBox emails = new JComboBox(email);
			emails.setBounds(700, 540, 150, 30);
			
			emails.setSelectedIndex(0);
			emailTextField2.setText((String)emails.getSelectedItem());
			emails.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
			if(((String)emails.getSelectedItem()).equals("직접입력")) {
				emailTextField2.setText(null);
				emailTextField2.setEditable(true);
			}else {
				
				emailTextField2.setText((String)emails.getSelectedItem());
				emailTextField2.setEditable(false);
			}
				}
			});
			
			this.add(emails);
			
		  
		
		

		//이름
		JLabel nameLabel = new JLabel("이름 : ");
		nameLabel.setBounds(453, 449, 57, 15);
		add(nameLabel);

		//이름 입력란
		JTextField nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(500, 440, 263, 30);
		add(nameTextField);

		//닉네임 중복확인 버튼
		JButton nickBtn = new JButton("Name Check");
		nickBtn.setBounds(780, 290, 120, 31);
		add(nickBtn);
	

		//가입완료 버튼_가입 완료 팝업창 후 로그인화면
		JButton CompleteBtn = new JButton("가입완료");
		CompleteBtn.setBounds(700, 650, 118, 42);
		add(CompleteBtn);

		//나가기 _ 로그인화면
		JButton exitBtn = new JButton("나가기");
		exitBtn.setBounds(850, 650, 118, 42);
		add(exitBtn);
		
	
		
		
        
        CompleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "회원가입에 감사드립니다. \n 환영합니다!!!");
				str += idtextField.getText() + ":";
				str += pwTextField.getText() + ":";
				str += nameTextField.getText() + ":";
				str += emailTextField.getText();
				System.out.println(str);
				um.signUp(str);
				dispose();
			}
		});


		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				dispose();
			}
		});

		
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);//정중앙
		}
	


}
