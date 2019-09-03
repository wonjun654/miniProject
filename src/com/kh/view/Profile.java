package com.kh.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.model.vo.User;

public class Profile extends JFrame {
	Image icon = null;
	Image img = null;
	User user = new User();

	public Profile() {
		// 기본 프로필창-----------------------------------------------

		this.setSize(600, 300);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙

		JPanel panel = new JPanel();

		panel.setLocation(30, 20);
		panel.setSize(600, 300);

		// 프로필설정창 ------------------------------------------------
		Dialog sd = new Dialog(this, "프로필 화면 변경");
		sd.setSize(400, 500);
		sd.setLocation((screenSize.width - sd.getWidth()) / 2, (screenSize.height - sd.getHeight()) / 2); // 화면 중앙
		sd.add(new JLabel("이름"));
		sd.setLayout(null);

		//////

		icon = user.getImg();

		JLabel label = new JLabel(new ImageIcon(icon));
		label.setLocation(10, 10);
		label.setSize(150, 150);
		label.setBackground(Color.black);

		JLabel label2 = new JLabel("우승");
		label2.setLocation(250, 30);
		label2.setSize(80, 30);

		JLabel label3 = new JLabel("코인");
		label3.setLocation(450, 30);
		label3.setSize(80, 30);

		JLabel label4 = new JLabel("닉네임");
		label4.setLocation(70, 170);
		label4.setSize(80, 30);

		JLabel label5 = new JLabel();
		label5.setSize(200, 200);
		label5.setLocation(120, 60);

		JLabel label6 = new JLabel("victory");
		label6.setSize(80, 30);
		label6.setLocation(245, 80);

		JLabel label7 = new JLabel("coin");
		label7.setSize(80, 30);
		label7.setLocation(450, 80);

		JButton button = new JButton("프로필 설정");
		button.setLocation(200, 130);
		button.setSize(120, 30);

		JButton button2 = new JButton("나가기");
		button2.setLocation(400, 130);
		button2.setSize(120, 30);

		JButton button3 = new JButton("확인");
		sd.add(button3);
<<<<<<< HEAD
		button3.setSize(80,50);
		button3.setLocation(180, 400);
		
		JButton btnOut = new JButton("취소");
		sd.add(btnOut);
		btnOut.setSize(80,50);
		btnOut.setLocation(280, 400);
		
		
=======
		button3.setSize(80, 50);
		button3.setLocation(280, 400);
>>>>>>> refs/remotes/origin/master

		// 쪽지함 버튼2

		// 이미지 바꾸기
		String[] character = { "yangpa", "jumuk", "baechu" };

		JComboBox charlist = new JComboBox(character);
		charlist.setBounds(200, 280, 150, 30);

		charlist.setSelectedIndex(1);

		String name = null;
		charlist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

<<<<<<< HEAD
				 img = new ImageIcon("images\\"+name+".PNG").getImage().getScaledInstance(150, 150, 0);
=======
				JComboBox cb = (JComboBox) e.getSource();
				String name = (String) cb.getSelectedItem();

				img = new ImageIcon("hello\\" + name + ".PNG").getImage().getScaledInstance(150, 150, 0);
>>>>>>> refs/remotes/origin/master

				label5.setIcon(new ImageIcon(img));

			}
		});

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sd.setVisible(true);
			}
		});

		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
<<<<<<< HEAD
				dispose();
				
=======

>>>>>>> refs/remotes/origin/master
			}
		});

		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				icon = img;
				user.setImg(img);
				label.setIcon(new ImageIcon(icon));
				sd.dispose();

			}
<<<<<<< HEAD
			});
		
		btnOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				sd.dispose();
				
			}
		});
		
	
		
=======
		});

>>>>>>> refs/remotes/origin/master
		sd.add(charlist);
		sd.add(label5);

		//
		panel.setLayout(null);
		panel.add(label);
		panel.add(label2);
		panel.add(label3);
		panel.add(label4);
		panel.add(label6);
		panel.add(label7);
		panel.add(button);
		panel.add(button2);
		this.add(panel);
		this.setLocationRelativeTo(null);

	}

}
