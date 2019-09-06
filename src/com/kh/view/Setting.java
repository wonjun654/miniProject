package com.kh.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.kh.model.vo.MediaTest;
import com.kh.user.controller.UserManager;
import com.kh.user.model.vo.User;

public class Setting extends JFrame {
	UserManager um = new UserManager();
	

	public Setting(User user) {

		this.setBounds(800, 300, 400, 400);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(195, 245, 230));
		
	
		panel.setSize(400, 400);

		JLabel label = new JLabel("배경음악");
		label.setLocation(10, 40);
		label.setSize(120, 120);

		JLabel label2 = new JLabel("프로필");
		label2.setLocation(10, 120);
		label2.setSize(120, 120);

		RoundButton button = new RoundButton("확인");
		button.setSize(60, 50);
		button.setLocation(280, 250);
		///////////// 프로필 공개////////////////
		JRadioButton profileOn = new JRadioButton("On");
		JRadioButton profileOff = new JRadioButton("OFF");

		profileOn.setSize(50, 50);
		profileOn.setLocation(100, 155);
		profileOn.setBackground(new Color(195, 245, 230));

		profileOff.setSize(50, 50);
		profileOff.setLocation(200, 155);
		profileOff.setBackground(new Color(195, 245, 230));
		///////////// 배경음악 설정/////////////////
		JRadioButton musicOn = new JRadioButton("On");
		JRadioButton musicOff = new JRadioButton("OFF");

		musicOn.setSize(50, 50);
		musicOn.setLocation(100, 75);
		musicOn.setBackground(new Color(195, 245, 230));

		musicOff.setSize(50, 50);
		musicOff.setLocation(200, 75);
		musicOff.setBackground(new Color(195, 245, 230));

		ButtonGroup profilegroup = new ButtonGroup();
		ButtonGroup musicgroup = new ButtonGroup();

		profilegroup.add(profileOn);
		profilegroup.add(profileOff);
		musicgroup.add(musicOn);
		musicgroup.add(musicOff);
		panel.add(musicOff);
		panel.add(musicOn);
		panel.add(profileOn);
		panel.add(profileOff);

		// ------------------프로필오프----------------
		profileOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setProfile(false);

			}
		});
		// -----------------------프로필 온----------------

		profileOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setProfile(true);

			}
		});
		// 확인버튼 -----------------------------------------
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (musicOn.isSelected() == true) {
					user.setMusicSet(true);

				} else if (musicOn.isSelected() == false) {
					user.setMusicSet(false);

				}

				if (musicOn.isSelected() == true && um.selectOneUser("123").getMusicSet() == true) {

				} else {
					um.updateUser(user);
					MediaTest.musicOn(1, um.selectOneUser("123").getMusicSet());
				}
				dispose();
			}
		});

		this.setLayout(null);
		panel.setLayout(null);

		panel.add(button);

		panel.add(label);
		panel.add(label2);
		
		this.add(panel);
		
		this.setVisible(true);

		this.setLocationRelativeTo(null);

	}

}