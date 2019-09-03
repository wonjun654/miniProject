package com.kh.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.kh.model.vo.MediaTest;
import com.kh.model.vo.User;

public class Setting extends JFrame {
	User user = new User();

	public Setting() {

		this.setBounds(800, 300, 400, 400);

		JPanel panel = new JPanel();

		panel.setLocation(30, 20);
		panel.setSize(400, 400);

		JLabel label = new JLabel("배경음악");
		label.setLocation(10, 40);
		label.setSize(120, 120);

		JLabel label2 = new JLabel("프로필");
		label2.setLocation(10, 120);
		label2.setSize(120, 120);

		JButton button = new JButton("확인");
		button.setSize(60, 50);
		button.setLocation(280, 250);
		///////////// 프로필 공개////////////////
		JRadioButton profileOn = new JRadioButton("On");
		JRadioButton profileOff = new JRadioButton("OFF");

		profileOn.setSize(50, 50);
		profileOn.setLocation(100, 155);

		profileOff.setSize(50, 50);
		profileOff.setLocation(200, 155);
		///////////// 배경음악 설정/////////////////
		JRadioButton musicOn = new JRadioButton("On");
		JRadioButton musicOff = new JRadioButton("OFF");

		musicOn.setSize(50, 50);
		musicOn.setLocation(100, 75);

		musicOff.setSize(50, 50);
		musicOff.setLocation(200, 75);

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
		// ---------------음악 on---------------
		musicOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setMusicSet(true);

			}
		});
		// --------------음악 off-------------
		musicOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setMusicSet(false);
				MediaTest.musicOff();
			}
		});

		// 확인버튼 -----------------------------------------
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

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
