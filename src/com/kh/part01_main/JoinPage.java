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
		
		setTitle("KHġ ���ε� - ȸ������");
		try {
			this.setIconImage(ImageIO.read(new File("������.PNG")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		this.setBounds(250, 250, 800, 768);
		this.setLayout(null);

		//ȸ������ �ΰ�
		JLabel nameCard = new JLabel("ȸ������");
		nameCard.setFont(new Font("����", Font.BOLD, 22));
		nameCard.setBounds(330, 150, 292, 64);
		add(nameCard);
		
		//���̵�
		JLabel ldLabel = new JLabel("���̵� : ");
		ldLabel.setBounds(177, 248, 57, 15);
		add(ldLabel);

		JTextField idtextField = new JTextField();
		idtextField.setBounds(249, 241, 263, 30);
		add(idtextField);
		idtextField.setColumns(10);

		//���̵� �ߺ�Ȯ��
		JButton btnNewButton = new JButton("�ߺ�Ȯ��");
		btnNewButton.setBounds(525, 240, 97, 31);
		add(btnNewButton);

		//��й�ȣ
		JLabel pwLabel = new JLabel("��й�ȣ : ");
		pwLabel.setBounds(162, 301, 72, 15);
		add(pwLabel);

		JPasswordField pwTextField = new JPasswordField();
		pwTextField.setColumns(10);
		pwTextField.setBounds(249, 294, 263, 30);
		add(pwTextField);

		//��й�ȣ ��Ȯ��
		JLabel pwLabel2 = new JLabel("��й�ȣ ��Ȯ�� : ");
		pwLabel2.setBounds(119, 353, 200, 15);
		add(pwLabel2);

		JPasswordField pwTextField2 = new JPasswordField();
		pwTextField2.setColumns(10);
		pwTextField2.setBounds(249, 346, 263, 30);
		add(pwTextField2);
		
		//��й�ȣ ��ġ����
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

	
		
		

		//�̸�
		JLabel nameLabel = new JLabel("�̸� : ");
		nameLabel.setBounds(177, 411, 57, 15);
		add(nameLabel);

		JTextField nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(249, 404, 263, 30);
		add(nameTextField);

		//�̸���
		JLabel emailLabel = new JLabel("�̸��� : ");
		emailLabel.setBounds(177, 467, 57, 15);
		add(emailLabel);

		JTextField emailTextField = new JTextField();
		emailTextField.setColumns(10);
		emailTextField.setBounds(249, 460, 263, 30);
		add(emailTextField);

		//���ԿϷ� ��ư_���� �Ϸ� �˾�â �� �α���ȭ��
		JButton CompleteBtn = new JButton("���ԿϷ�");
		CompleteBtn.setBounds(254, 527, 118, 42);
		add(CompleteBtn);

		//������ _ �α���ȭ��
		JButton exitBtn = new JButton("������");
		exitBtn.setBounds(394, 527, 118, 42);
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
				//dispose();
				LoginPage lp = new LoginPage();
			}
		});

		
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);//���߾�
		}
	


}
