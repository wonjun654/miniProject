package com.kh.view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class MakeRoom extends JFrame {

	public MakeRoom() {
		this.setSize(600, 500);
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈

		setLayout(null);
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙

		JLabel roomName = new JLabel("방제목");
		JLabel roomPwd = new JLabel("방암호");
		JLabel roomPeople = new JLabel("인원수");

		roomName.setBounds(125, 150, 75, 35);
		roomPwd.setBounds(125, 200, 75, 35);
		roomPeople.setBounds(125, 250, 75, 35);

		JTextArea roomName2 = new JTextArea();
		JTextArea roomPwd2 = new JTextArea();
		JTextArea roomPeople2 = new JTextArea();
		roomName2.setBounds(175, 150, 175, 25);
		roomPwd2.setBounds(175, 200, 175, 25);
		roomPeople2.setBounds(175, 250, 175, 25);

		SpinnerModel numberModel = new SpinnerNumberModel(4, 4, 8, 1);
		JSpinner selectPeople = new JSpinner(numberModel);
		selectPeople.setBounds(175, 250, 175, 25);

		JButton btnOK = new JButton("확인");
		JButton btnCancel = new JButton("취소");
		btnOK.setBounds(250, 300, 100, 35);
		btnCancel.setBounds(375, 300, 100, 35);

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		this.add(roomPeople);
		this.add(roomPwd);
		this.add(roomName);
		this.add(roomName2);
		this.add(roomPwd2);
		this.add(selectPeople);
		this.add(btnOK);
		this.add(btnCancel);
		this.setVisible(true);

	}

}
