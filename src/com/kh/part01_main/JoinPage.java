package com.kh.part01_main;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
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
			this.setIconImage(ImageIO.read(new File("아이콘.PNG")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.setBounds(250, 250, 800, 768);
		this.setLayout(null);

		//회원가입 로고
		JLabel nameCard = new JLabel("회원가입");
		nameCard.setFont(new Font("굴림", Font.BOLD, 22));
		nameCard.setBounds(330, 150, 292, 64);
		add(nameCard);
		
		//아이디
		JLabel ldLabel = new JLabel("아이디 : ");
		ldLabel.setBounds(177, 248, 57, 15);
		add(ldLabel);

		JTextField idtextField = new JTextField();
		idtextField.setBounds(249, 241, 263, 30);
		add(idtextField);
		idtextField.setColumns(10);

		//아이디 중복확인
		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.setBounds(525, 240, 97, 31);
		add(btnNewButton);

		//비밀번호
		JLabel pwLabel = new JLabel("비밀번호 : ");
		pwLabel.setBounds(162, 301, 72, 15);
		add(pwLabel);

		JPasswordField pwTextField = new JPasswordField();
		pwTextField.setColumns(10);
		pwTextField.setBounds(249, 294, 263, 30);
		add(pwTextField);

		//비밀번호 재확인
		JLabel pwLabel2 = new JLabel("비밀번호 재확인 : ");
		pwLabel2.setBounds(119, 353, 200, 15);
		add(pwLabel2);

		JPasswordField pwTextField2 = new JPasswordField();
		pwTextField2.setColumns(10);
		pwTextField2.setBounds(249, 346, 263, 30);
		add(pwTextField2);
		
		//비밀번호 일치여부
		JLabel pwCheck = new JLabel();
		pwCheck.setBounds(250, 380, 200, 15);
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

	
		
		

		//이름
		JLabel nameLabel = new JLabel("이름 : ");
		nameLabel.setBounds(177, 411, 57, 15);
		add(nameLabel);

		JTextField nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(249, 404, 263, 30);
		add(nameTextField);

		//이메일
		JLabel emailLabel = new JLabel("이메일 : ");
		emailLabel.setBounds(177, 467, 57, 15);
		add(emailLabel);

		JTextField emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(249, 460, 263, 30);
		add(emailTextField);

		//가입완료 버튼_가입 완료 팝업창 후 로그인화면
		JButton CompleteBtn = new JButton("가입완료");
		CompleteBtn.setBounds(254, 527, 118, 42);
		add(CompleteBtn);

		//나가기 _ 로그인화면
		JButton exitBtn = new JButton("나가기");
		exitBtn.setBounds(394, 527, 118, 42);
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
				//dispose();
				LoginPage lp = new LoginPage();
			}
		});

		
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);//정중앙
		}
	


}
