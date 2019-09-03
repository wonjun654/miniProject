package com.kh.part03_password;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.part01_main.LoginPage;
import com.kh.user.controller.UserManager;

public class FindPassword extends JFrame{
	
public FindPassword() {
		
		UserManager um = new UserManager();
		
		JPanel pwPopup = new JPanel();

		
		
		setTitle("KHġ ���ε� - ��й�ȣ ã��");
		try {
			this.setIconImage(ImageIO.read(new File("images//logo.PNG")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		setSize(1024,768);
		pwPopup.setSize(1024,768);
		this.setLayout(null);// �����̼Ǻ��� ��ġ�� ������ ��������
		pwPopup.setLayout(null);
		
		
		//�ΰ�
		JLabel pwLogoLabel = new JLabel("��й�ȣ ã��");
		pwLogoLabel.setFont(new Font("����", Font.BOLD, 40));
		pwLogoLabel.setBounds(380,150, 300, 50);
		
		//����
		JLabel idText = new JLabel("ȸ�� ���Խ� �Էµ� ���̵�� �̸��� �ּҸ� �Է��Ͽ� �ּ���.");
		idText.setBounds(330, 200, 400, 200);
		
		//���Ծ��̵�
		JLabel idLabel = new JLabel("���̵�  : ");
		idLabel.setBounds(320,338, 100, 50);
		
		//���� ���̵� �ؽ�Ʈ
		JTextField idf = new JTextField();
		idf.setBounds(380, 350, 300	, 30);
		
		//�����̸���
		JLabel emailLabel = new JLabel("�̸���  : ");
		emailLabel.setBounds(320,390, 100, 50);
		
		//���� �̸��� �ؽ�Ʈ
		JTextField emailf = new JTextField();
		emailf.setBounds(380, 400, 300	, 30);
		
		
		//�̸��Ϸ� ������
		JButton checkBtn = new JButton("����");
		checkBtn.setBounds(380,480, 300	, 40);

		
		//�α��� ȭ������ ������
		JButton exitBtn = new JButton("������");
		exitBtn.setBounds(580,550, 80	, 50);

		
		pwPopup.add(pwLogoLabel);
		pwPopup.add(idText);
		pwPopup.add(idLabel);
		pwPopup.add(idf);
		pwPopup.add(emailLabel);
		pwPopup.add(emailf);
		pwPopup.add(checkBtn);
		pwPopup.add(exitBtn);	
		
	
	
		add(pwPopup);
		
		//�̸��Ϸ� ����
		checkBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showConfirmDialog(null, "�̸��� ���� �غ��� �Ф�");
				um.findPwd(idf.getText(), emailf.getText());
                JOptionPane.showMessageDialog(null, "�Է��Ͻ� �̸��Ϸ� ������ �Ϸ��Ͽ����ϴ�.");
				dispose();
			}
		});
		
		
		
		
		//������ : �α��� ȭ������
		exitBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	
}

}

