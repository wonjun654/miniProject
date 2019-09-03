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

		JLabel label = new JLabel("�������");
		label.setLocation(10, 40);
		label.setSize(120, 120);

		JLabel label2 = new JLabel("������");
		label2.setLocation(10, 120);
		label2.setSize(120, 120);

		JButton button = new JButton("Ȯ��");
		button.setSize(60, 50);
		button.setLocation(280, 250);
		///////////// ������ ����////////////////
		JRadioButton profileOn = new JRadioButton("On");
		JRadioButton profileOff = new JRadioButton("OFF");

		profileOn.setSize(50, 50);
		profileOn.setLocation(100, 155);

		profileOff.setSize(50, 50);
		profileOff.setLocation(200, 155);
		///////////// ������� ����/////////////////
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

		// ------------------�����ʿ���----------------
		profileOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setProfile(false);

			}
		});
		// -----------------------������ ��----------------

		profileOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setProfile(true);

			}
		});
		// ---------------���� on---------------
		musicOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setMusicSet(true);

			}
		});
		// --------------���� off-------------
		musicOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setMusicSet(false);
				MediaTest.musicOff();
			}
		});

		// Ȯ�ι�ư -----------------------------------------
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
