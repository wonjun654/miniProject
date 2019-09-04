package com.kh.part03_ID;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.part01_main.LoginPage;
import com.kh.user.controller.UserManager;

public class FindID extends JFrame{
	UserManager um = new UserManager();
	
	public FindID() {
		
		
		JPanel idPopup = new JPanel();

		
		
		setTitle("KHġ ���ε� - ���̵� ã��");
		try {
			this.setIconImage(ImageIO.read(new File("images//logo.PNG")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		setSize(1024,768);
		idPopup.setSize(1024,768);
		this.setLayout(null);// �����̼Ǻ��� ��ġ�� ������ ��������
		idPopup.setLayout(null);
		
		
		JLabel forntLabel = new JLabel("���̵� ã��");
		forntLabel.setFont(new Font("����", Font.BOLD, 40));
		forntLabel.setBounds(380,150, 300, 50);
		
		
		JLabel idText = new JLabel("ȸ�� ���Խ� �Է��� �̸��� �ּҸ� �Է��ϼ���. ");
		idText.setBounds(400, 200, 400, 200);
		
		
	
		
		JLabel idText2 = new JLabel("�̸���  : ");
		idText2.setBounds(320,338, 100, 50);
		
		JTextField idf = new JTextField();
		idf.setBounds(380, 350, 300	, 30);
		
		JButton checkBtn = new JButton("Ȯ��");
		checkBtn.setBounds(500,420, 70	, 50);

		JButton exitBtn = new JButton("������");
		exitBtn.setBounds(580,420, 80	, 50);

		
		idPopup.add(forntLabel);
		idPopup.add(idText);
		idPopup.add(idText2);
		idPopup.add(idf);
		idPopup.add(checkBtn);
		idPopup.add(exitBtn);
	
		add(idPopup);

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		
		checkBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = um.FindId(idf.getText());
				if(str != null) {
					FindResult fr = new FindResult(str);
					dispose();
				}
				
			}
		});
		
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				dispose();
				
			}
		});

	}
	

}
