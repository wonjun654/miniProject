package com.kh.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class MakeRoom extends JFrame {
	public JTextArea roomName2;
	public JTextArea roomPwd2;
	public JButton btnOK;
	public MainMenu mm;

	public MakeRoom() {

		this.setBounds(600, 500, 600, 500);
		setLayout(null);

		JLabel roomName = new JLabel("방제목");
		JLabel roomPwd = new JLabel("방암호");
		JLabel roomPeople = new JLabel("인원수");

		roomName.setBounds(125, 150, 75, 35);
		roomPwd.setBounds(125, 200, 75, 35);
		roomPeople.setBounds(125, 250, 75, 35);

		roomName2 = new JTextArea();
		JTextArea roomPwd2 = new JTextArea();
		JTextArea roomPeople2 = new JTextArea();
		roomName2.setBounds(175, 150, 175, 25);
		roomPwd2.setEnabled(false);
		roomPwd2.setEditable(false);
		roomPwd2.setBounds(175, 200, 175, 25);
		roomPeople2.setBounds(175, 250, 175, 25);

		SpinnerModel numberModel = new SpinnerNumberModel(4, 4, 8, 1);
		JSpinner selectPeople = new JSpinner(numberModel);
		selectPeople.setBounds(175, 250, 175, 25);

		btnOK = new JButton("확인");
		JButton btnCancel = new JButton("취소");
		btnOK.setBounds(250, 300, 100, 35);
		btnCancel.setBounds(375, 300, 100, 35);

		JCheckBox checkSecret = new JCheckBox();
		checkSecret.setBounds(360, 185, 50, 50);

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		checkSecret.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkSecret.isSelected()) {
					roomPwd2.setEditable(true);
					roomPwd2.setEnabled(true);

				} else {
					roomPwd2.setEditable(false);
					roomPwd2.setEnabled(false);
				}

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
		this.add(checkSecret);
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

}
