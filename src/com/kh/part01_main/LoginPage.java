package com.kh.part01_main;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.kh.model.vo.MediaTest;
import com.kh.part03_ID.FindID;
import com.kh.part03_password.FindPassword;
import com.kh.user.controller.UserManager;
import com.kh.view.MainMenu;




public class LoginPage extends JFrame {
	 ImageIcon icon;
	 String str = "";
	 UserManager um = new UserManager();
	 
	public LoginPage() {
	

	
		this.setSize(1024, 768);
		setTitle("KHġ ���ε�");
		try {
			this.setIconImage(ImageIO.read(new File("images//logo.PNG")));
		} catch (IOException e) {

			e.printStackTrace();
		}

		setLayout(null);

		
		//��� �̹��� ����
		icon = new ImageIcon("images//login.PNG");
		JPanel panel = new JPanel() {
		 public void paintComponent(Graphics g) {
			 g.drawImage(icon.getImage(), 0, 0, null);
			 setOpaque(false); 
			 super.paintComponent(g);
		 }
		};
		 
		panel.setBounds(0, 0, 1024, 768);
		panel.setLayout(null);

		
		
		// ���̵�
		JLabel idLabel = new JLabel("���̵� : ");
		idLabel.setBounds(290, 460, 300, 100);
		JTextField idText = new JTextField();
		idText.setBounds(360, 495, 305, 30);
		panel.add(idLabel);
		panel.add(idText);

		// �н�����
		JLabel pwLabel = new JLabel("��� ��ȣ : ");
		pwLabel.setBounds(274, 503, 300, 100);
		JPasswordField pwField = new JPasswordField();
		pwField.setBounds(360, 540, 305, 30);
		panel.add(pwLabel);
		panel.add(pwField);

		// �α��� ��ư
		JButton loginbtn = new JButton("�α���");
		loginbtn.setBounds(680, 495, 120, 75);
		panel.add(idText);
		panel.add(loginbtn);

		// ȸ������ ��ư
		JButton joinbtn = new JButton("ȸ������");
		joinbtn.setBounds(360, 600, 90, 30);
		panel.add(joinbtn);

		// ���̵� ã�� ��ư
		JButton idbtn = new JButton("ID ã�� ");
		idbtn.setBounds(466, 600, 90, 30);
		panel.add(idbtn);

		// ��й�ȣ ã�� ��ư
		JButton pwbtn = new JButton("P/W ã�� ");
		pwbtn.setBounds(572, 600, 90, 30);
		panel.add(pwbtn);
		
		//�α��� ��ư
		loginbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
                
                
            	str += idText.getText() + ":";
        		str += pwField.getText();
        		System.out.println(str);
        		
        		
        		
        		
        		
        		if(um.login(str)) {
        			JOptionPane.showMessageDialog(null, "�α��� ���� !");
        			MainMenu menu = new MainMenu();
        			dispose();
        		} else {
        			JOptionPane.showMessageDialog(null, "ID/PW�� Ȯ���� �ּ���.");
        			str = "";
        		}
        		
        		       		
        			
			}
		});
		
		
		
		// ȸ������ ����
		joinbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JoinText jt = new JoinText();

			}
		});

		// ���̵� ã�� ��ư
		idbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FindID fi = new FindID();

			}
		});

		// ��й�ȣ ã�� ��ư
		pwbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FindPassword fp = new FindPassword();

			}
		});

		this.add(panel);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);// ���߾Ӥ�
		MediaTest mt = new MediaTest();
		mt.musicOn(1, true);
	
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	/*public static void main(String[] args) {
		new LoginPage();

	}*/

}
