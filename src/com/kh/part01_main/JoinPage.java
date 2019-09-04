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
		
		setTitle("KHġ ���ε� - ȸ������");
		try {
			this.setIconImage(ImageIO.read(new File("images\\logo.png")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.setBounds(250, 250, 1024, 768);
		this.setLayout(null);

		//ȸ������ �ΰ�
		JLabel nameCard = new JLabel("ȸ������");
		nameCard.setFont(new Font("����", Font.BOLD,40));
		nameCard.setBounds(70, 20, 292, 64);
		add(nameCard);
		
		//���̵�
		JLabel ldLabel = new JLabel("���̵� : ");
		ldLabel.setBounds(440, 245, 57, 15);
		add(ldLabel);

		//���̵� �Է¶�
		JTextField idtextField = new JTextField();
		idtextField.setBounds(500, 240, 263, 30);
		add(idtextField);
		idtextField.setColumns(10);

		//���̵� �ߺ�Ȯ��
		JButton btnNewButton = new JButton("ID Check");
		btnNewButton.setBounds(780, 240, 120, 31);
		add(btnNewButton);

		//��й�ȣ
		JLabel pwLabel = new JLabel("��й�ȣ : ");
		pwLabel.setBounds(425, 347, 72, 15);
		add(pwLabel);

		//��й�ȣ �Է¶�
		JPasswordField pwTextField = new JPasswordField();
		pwTextField.setColumns(10);
		pwTextField.setBounds(500, 340, 263, 30);
		add(pwTextField);

		//�г���
		JLabel nickLabel = new JLabel("�г��� : ");
		nickLabel.setBounds(439, 296, 57, 15);
		add(nickLabel);
		
		//�г��� �Է¶�
		JTextField nickField = new JTextField();
		nickField.setBounds(500, 290, 263, 30);
		add(nickField);
		nickField.setColumns(10);
				
		//��й�ȣ ��Ȯ��
		JLabel pwLabel2 = new JLabel("��й�ȣ ��Ȯ�� : ");
		pwLabel2.setBounds(385, 398, 200, 15);
		add(pwLabel2);
		
		//��й�ȣ ��Ȯ�� �Է¶�
		JPasswordField pwTextField2 = new JPasswordField();
		pwTextField2.setColumns(10);
		pwTextField2.setBounds(500, 390, 263, 30);
		add(pwTextField2);
		
		//��й�ȣ ��ġ����
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
					pwCheck.setText("��й�ȣ�� ��ġ�մϴ�.");
				}else {
					pwCheck.setText("��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
				}
			}
				

			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		
		  add(pwCheck);

		  
			//�̸���
			JLabel emailLabel = new JLabel("�̸��� : ");
			emailLabel.setBounds(440, 500, 57, 15);
			add(emailLabel);

			//�̸��� ���̵� �Է¶�
			JTextField emailTextField = new JTextField();
			emailTextField.setColumns(10);
			emailTextField.setBounds(500, 490, 150, 30);
			add(emailTextField);
			
			//@
			JLabel goalLabel = new JLabel(" @ ");
			goalLabel.setBounds(663, 495, 20, 15);
			add(goalLabel);
			
			//�̸��� �ۼ���
			JLabel emailEx = new JLabel(" ex) 1234@naver.com ");
			emailEx.setBounds(500,525, 200, 15);
			add(emailEx);
			
			//�̸��� �ּ��Է¶�
			JTextField emailTextField2 = new JTextField("");
			emailTextField2.setBounds(700, 490, 150, 30);
			emailTextField2.setEditable(false);
			add(emailTextField2);
			
			//�̸��� �ּ� ����
			String[] email = {"naver.com","hanmail.com",
					"yahoo.co.kr","nate.com","�����Է�"};
			
			JComboBox emails = new JComboBox(email);
			emails.setBounds(700, 540, 150, 30);
			
			emails.setSelectedIndex(0);
			emailTextField2.setText((String)emails.getSelectedItem());
			emails.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
			if(((String)emails.getSelectedItem()).equals("�����Է�")) {
				emailTextField2.setText(null);
				emailTextField2.setEditable(true);
			}else {
				
				emailTextField2.setText((String)emails.getSelectedItem());
				emailTextField2.setEditable(false);
			}
				}
			});
			
			this.add(emails);
			
		  
		
		

		//�̸�
		JLabel nameLabel = new JLabel("�̸� : ");
		nameLabel.setBounds(453, 449, 57, 15);
		add(nameLabel);

		//�̸� �Է¶�
		JTextField nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(500, 440, 263, 30);
		add(nameTextField);

		//�г��� �ߺ�Ȯ�� ��ư
		JButton nickBtn = new JButton("Name Check");
		nickBtn.setBounds(780, 290, 120, 31);
		add(nickBtn);
	

		//���ԿϷ� ��ư_���� �Ϸ� �˾�â �� �α���ȭ��
		JButton CompleteBtn = new JButton("���ԿϷ�");
		CompleteBtn.setBounds(700, 650, 118, 42);
		add(CompleteBtn);

		//������ _ �α���ȭ��
		JButton exitBtn = new JButton("������");
		exitBtn.setBounds(850, 650, 118, 42);
		add(exitBtn);
		
	
		
		
        
        CompleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "ȸ�����Կ� ����帳�ϴ�. \n ȯ���մϴ�!!!");
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
		this.setLocationRelativeTo(null);//���߾�
		}
	


}
