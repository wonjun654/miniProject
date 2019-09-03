package com.kh.view;

import java.awt.Dimension;
import java.awt.Toolkit;
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

import com.kh.model.vo.User;

public class Setting extends JFrame {
	User user = new User();

	public Setting() {

		this.setSize(400, 400);
		Dimension frameSize = this.getSize(); // ������ ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ������

		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // ȭ�� �߾�

		JPanel panel = new JPanel();

		panel.setLocation(30, 20);
		panel.setSize(400, 400);
		// panel.setBackground(Color.black);

		JLabel label = new JLabel("�������");
		label.setLocation(10, 40);
		label.setSize(120, 120);

		JLabel label2 = new JLabel("������");
		label2.setLocation(10, 120);
		label2.setSize(120, 120);

		JSlider slider = new JSlider(0, 100, 50); // �ּҰ� , �ִ밪 ,�⺻��
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSize(200, 60);
		slider.setLocation(70, 80);

		panel.add(slider);

		JButton button = new JButton("Ȯ��");
		button.setSize(60, 50);
		button.setLocation(180, 250);
		
		JButton btnOut = new JButton("���");
		btnOut.setSize(60, 50);
		btnOut.setLocation(280, 250);
		
		/////////////////////////////
		JRadioButton profileOn = new JRadioButton("On");
		JRadioButton profileOff = new JRadioButton("OFF");

		profileOn.setSize(50, 50);
		profileOn.setLocation(100, 155);

		profileOff.setSize(50, 50);
		profileOff.setLocation(200, 155);

		ButtonGroup group = new ButtonGroup();

		group.add(profileOn);
		group.add(profileOff);

		panel.add(profileOn);
		panel.add(profileOff);

		slider.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				user.setMusicVolume(slider.getValue());

			}
		});

		profileOff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setProfile(false);

			}
		});

		profileOn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user.setProfile(true);

			}
		});

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				System.out.println(user.getProfile());
			}
		});
		
		btnOut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});

		this.setLayout(null);
		panel.setLayout(null);

		panel.add(button);
		panel.add(btnOut);
		panel.add(label);
		panel.add(label2);

		this.add(panel);

		this.setVisible(true);
<<<<<<< HEAD
		this.setLocationRelativeTo(null);
		
=======

>>>>>>> refs/remotes/origin/master
	}

}
