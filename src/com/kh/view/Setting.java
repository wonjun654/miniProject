package com.kh.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.kh.model.vo.MediaTest;
import com.kh.part03_password.PasswordChange;
import com.kh.user.controller.UserManager;
import com.kh.user.model.vo.ClientUser;
import com.kh.user.model.vo.Sender;
import com.kh.user.model.vo.User;

public class Setting extends JFrame {
	UserManager um = new UserManager();
	

	public Setting(ClientUser u) {
		Font font = new Font("고딕", Font.BOLD, 18);
		this.setResizable(false);
		this.setBounds(800, 300, 400, 400);
		
		try {
			this.setIconImage(ImageIO.read(new File("images//logo.PNG")));
		} catch (IOException e) {

			e.printStackTrace();
		}
		JPanel panel = new JPanel();
		panel.setBackground(new Color(195, 245, 230));
		
	
		panel.setSize(400, 400);

		JLabel label = new JLabel("배경음악");
		label.setLocation(20, 10);
		label.setSize(120, 120);
		label.setFont(font);

		JLabel label2 = new JLabel("프로필");
		label2.setLocation(20, 70);
		label2.setSize(120, 120);
		label2.setFont(font);
		
		JLabel pwdLabel = new JLabel("비밀번호 변경");
		pwdLabel.setLocation(20,130);
		pwdLabel.setSize(130,120);
		pwdLabel.setFont(font);
		
		RoundButton pwdBtn= new RoundButton("변경");
		pwdBtn.setSize(80,30);
		pwdBtn.setLocation(260,180);
		pwdBtn.setFont(font);
		
		RoundButton button = new RoundButton("확인");
		button.setSize(60, 50);
		button.setLocation(280, 250);
		///////////// 프로필 공개////////////////
		JRadioButton profileOn = new JRadioButton("On");
		JRadioButton profileOff = new JRadioButton("OFF");

		profileOn.setSize(50, 50);
		profileOn.setLocation(160, 110);
		profileOn.setBackground(new Color(195, 245, 230));

		profileOff.setSize(50, 50);
		profileOff.setLocation(260, 110);
		profileOff.setBackground(new Color(195, 245, 230));
		///////////// 배경음악 설정/////////////////
		JRadioButton musicOn = new JRadioButton("On");
		JRadioButton musicOff = new JRadioButton("OFF");

		musicOn.setSize(50, 50);
		musicOn.setLocation(160, 45);
		musicOn.setBackground(new Color(195, 245, 230));
		musicOn.isSelected();
		musicOff.setSize(50, 50);
		musicOff.setLocation(260, 45);
		musicOff.setBackground(new Color(195, 245, 230));
		
		if(u.isMusicSet()==true) {
			musicOn.setSelected(true);
		}else {
			musicOff.setSelected(true);
		}
		
		if(u.isProfile()==true) {
			profileOn.setSelected(true);
		}else {
			profileOff.setSelected(true);
		}
		
		
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

		/////////////////pwd 변경 //////////
		pwdBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PasswordChange pc = new PasswordChange(u);
				
				
			}
		});
		
		
		
		// 확인버튼 -----------------------------------------
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (musicOn.isSelected() == true) {
					u.setMusicSet(true);

				} else if (musicOn.isSelected() == false) {
					u.setMusicSet(false);

				}

				if (musicOn.isSelected() == true && u.isMusicSet() == true) {

				} else {
//					um.updateUser(u);
					
				}
				
				if (profileOn.isSelected() == true) {
					u.setProfile(true);

				} else if (profileOn.isSelected() == false) {
					u.setProfile(false);

				}

				if (profileOn.isSelected() == true && u.isProfile() == true) {

				} else {
				
					///asd///
				}
//				um.updateUser(u);
				
				dispose();
			}
		});

		this.setLayout(null);
		panel.setLayout(null);

		panel.add(button);

		panel.add(label);
		panel.add(label2);
		panel.add(pwdLabel);
		panel.add(pwdBtn);
		
		this.add(panel);
		
		this.setVisible(true);

		this.setLocationRelativeTo(null);

	}

}