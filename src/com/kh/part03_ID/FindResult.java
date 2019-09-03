package com.kh.part03_ID;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.part01_main.LoginPage;

public class FindResult extends JFrame {

	public FindResult(String str) {

		JPanel idResultPop = new JPanel();

		setTitle("KHġ ���ε� - ���̵� ã�� ���");
		try {
			this.setIconImage(ImageIO.read(new File("images//logo.PNG")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		setSize(1024, 768);
		idResultPop.setSize(1024, 768);
		this.setLayout(null);// �����̼Ǻ��� ��ġ�� ������ ��������
		idResultPop.setLayout(null);

		JLabel idText = new JLabel("�����Ͻ� ���̵�� ");
		idText.setBounds(400, 200, 400, 200);

		JTextField idf = new JTextField();
		idf.setBounds(350, 350, 300, 30);
		idf.setText(str);

		JLabel idText2 = new JLabel("�Դϴ�.");
		idText2.setBounds(650, 350, 300, 30);

		JButton checkBtn = new JButton("�α���");
		checkBtn.setBounds(350, 420, 80, 50);

		JButton exitBtn = new JButton("������");
		exitBtn.setBounds(580, 420, 80, 50);

		idResultPop.add(idText);
		idResultPop.add(idf);
		idResultPop.add(checkBtn);
		idResultPop.add(exitBtn);
		idResultPop.add(idText2);

		add(idResultPop);

		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);

		checkBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();

			}
		});

		exitBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();

			}
		});

	}

}
