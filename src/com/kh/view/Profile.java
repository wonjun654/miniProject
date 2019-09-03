package com.kh.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.Image;
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
	User user = new User();
	Image icon = null;
	Image img = user.getImg();

	public Profile() {
		// 기본 프로필창-----------------------------------------------

		this.setBounds(700, 300, 600, 300);

		JPanel panel = new JPanel();

		panel.setLocation(30, 20);
		panel.setSize(600, 300);

		// 프로필설정창 ------------------------------------------------
		Dialog sd = new Dialog(this, "프로필 화면 변경");
		sd.setBounds(800, 250, 400, 500);
		sd.add(new JLabel("이름"));
		sd.setLayout(null);

		//////

		JLabel label = new JLabel(new ImageIcon(img));
		label.setLocation(10, 10);
		label.setSize(150, 150);
		label.setBackground(Color.black);

		JLabel label2 = new JLabel("우승");
		label2.setLocation(250, 30);
		label2.setSize(80, 30);

		JLabel label3 = new JLabel("코인");
		label3.setLocation(450, 30);
		label3.setSize(80, 30);

		JLabel label4 = new JLabel(user.getId());
		label4.setLocation(75, 170);
		label4.setSize(80, 30);

		JLabel label5 = new JLabel();
		label5.setSize(200, 200);
		label5.setLocation(120, 60);

		JLabel label6 = new JLabel(user.getVictory() + "");
		label6.setSize(80, 30);
		label6.setLocation(260, 80);

		JLabel label7 = new JLabel(user.getCoin() + "");
		label7.setSize(80, 30);
		label7.setLocation(460, 80);

		JButton button = new JButton("프로필 설정");
		button.setLocation(200, 130);
		button.setSize(120, 30);

		JButton button3 = new JButton("확인");
		sd.add(button3);

		button3.setSize(80, 50);
		button3.setLocation(280, 400);

		JButton button4 = new JButton("확인");
		button4.setSize(80, 40);
		button4.setLocation(440, 190);

		// 이미지 바꾸기
		String[] character = { "yangpa", "jumuk", "baechu" };

		JComboBox charlist = new JComboBox(character);
		charlist.setBounds(200, 280, 150, 30);

		charlist.setSelectedIndex(0);
		icon = new ImageIcon("images/yangpa.PNG").getImage().getScaledInstance(150, 150, 0);
		label5.setIcon(new ImageIcon(icon));
		String name = null;
		charlist.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JComboBox cb = (JComboBox) e.getSource();
				String name = (String) cb.getSelectedItem();

				icon = new ImageIcon("images/" + name + ".PNG").getImage().getScaledInstance(150, 150, 0);

				label5.setIcon(new ImageIcon(icon));

			}
		});

		/// 프로필설정
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sd.setVisible(true);
			}
		});

		// sd 확인
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				img = icon;
				user.setImg(icon);
				label.setIcon(new ImageIcon(img));
				sd.dispose();

			}

		});
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

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
		panel.add(button4);
		this.add(panel);

	}

}
