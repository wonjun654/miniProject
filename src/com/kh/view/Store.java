package com.kh.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Store extends JFrame {

	Pay p;

	int hi1;
	int hi2;
	int hi3;
	int mcoin = 100;
	int time = 5;

	public Store() {

		this.setLayout(null);
		this.setSize(1024, 768);

		Dimension frameSize = this.getSize(); // ������ ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ������
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // ȭ�� �߾�

		
		// �����̸�
		JLabel store = new JLabel("����");
		Font font = new Font("���", Font.BOLD, 50);
		store.setFont(font);
		store.setSize(150, 80);
		store.setLocation(30, 10);
		this.add(store);

		// --------------------------------------------------------------------------------
		// �����۸��
		JLabel item = new JLabel("������ ���");
		item.setSize(100, 40);
		item.setLocation(20, 80);
		this.add(item);

		// ������1
		JPanel item1 = new JPanel();
		item1.setSize(150, 150);
		item1.setLocation(20, 130);
		item1.setBackground(Color.GRAY);

		JButton b1 = new JButton("����");
		b1.setSize(60, 40);
		b1.setLocation(110, 280);
		this.add(item1);
		this.add(b1);

		// ������2
		JPanel item2 = new JPanel();
		item2.setSize(150, 150);
		item2.setLocation(250, 130);
		item2.setBackground(Color.GRAY);

		JButton b2 = new JButton("����");
		b2.setSize(60, 40);
		b2.setLocation(340, 280);
		this.add(item2);
		this.add(b2);

		// ������3
		JPanel item3 = new JPanel();
		item3.setSize(150, 150);
		item3.setLocation(480, 130);
		item3.setBackground(Color.GRAY);

		JButton b3 = new JButton("����");
		b3.setSize(60, 40);
		b3.setLocation(570, 280);
		this.add(item3);
		this.add(b3);

		// �����ڽ�
		JPanel rb = new JPanel();
		rb.setSize(150, 150);
		rb.setLocation(710, 130);
		rb.setBackground(Color.GRAY);

		JButton b4 = new JButton("�̱�");
		b4.setSize(60, 40);
		b4.setLocation(800, 280);
		this.add(rb);
		this.add(b4);

		// �����ڽ��̱� ���
		Dialog rbd = new Dialog(this, "�����ڽ�");
		rbd.setLayout(null);
		rbd.setSize(300, 300);
		rbd.setLocation((screenSize.width - rbd.getWidth())/2, (screenSize.height - rbd.getHeight())/2);
		// �̱��� ������ �̹���
		JLabel rbl = new JLabel();
		rbl.setBounds(75, 60, 150, 140);
		rbd.add(rbl);

		// �̱� ��� ��� �� Ȯ�� ��ư
		JButton rbok = new JButton("Ȯ��");
		rbok.setBounds(120, 250, 60, 30);
		rbd.add(rbok);

		// ������ ȹ�� ���
		JLabel result = new JLabel();
		result.setBounds(120, 200, 200, 30);
		rbd.add(result);

		// --------------------------------------------------------------------------------
		// ����������
		JLabel hitem = new JLabel("����������");
		hitem.setSize(100, 40);
		hitem.setLocation(20, 400);
		this.add(hitem);

		// ����������1
		JPanel hitem1 = new JPanel();
		hitem1.setSize(150, 150);
		hitem1.setLocation(20, 450);
		hitem1.setBackground(Color.GRAY);
		this.add(hitem1);

		JLabel i1 = new JLabel("�������� : " + hi1);
		i1.setSize(100, 40);
		i1.setLocation(90, 600);
		this.add(i1);

		// ����������2
		JPanel hitem2 = new JPanel();
		hitem2.setSize(150, 150);
		hitem2.setLocation(250, 450);
		hitem2.setBackground(Color.GRAY);
		this.add(hitem2);

		JLabel i2 = new JLabel("�������� : " + hi2);
		i2.setSize(100, 40);
		i2.setLocation(320, 600);
		this.add(i2);

		// ����������3
		JPanel hitem3 = new JPanel();
		hitem3.setSize(150, 150);
		hitem3.setLocation(480, 450);
		hitem3.setBackground(Color.GRAY);
		this.add(hitem3);

		JLabel i3 = new JLabel("�������� : " + hi3);
		i3.setSize(100, 40);
		i3.setLocation(550, 600);
		this.add(i3);

		// --------------------------------------------------------------------------------
		// ���ΰ��� ���
		JLabel coinl = new JLabel("�� ���� : " + mcoin);
		coinl.setSize(100, 40);
		coinl.setLocation(200, 30);
		this.add(coinl);

		Dialog buy = new Dialog(this, "������ ����");
		buy.setLayout(null);
		buy.setSize(200, 160);
		buy.setLocation((screenSize.width - buy.getWidth())/2, (screenSize.height - buy.getHeight())/2);
		JLabel buyl = new JLabel("�����Ͻðڽ��ϱ�?");
		buyl.setSize(150, 40);
		buyl.setLocation(50, 50);
		buy.add(buyl);
		JButton buyb = new JButton("����");
		buyb.setSize(60, 40);
		buyb.setLocation(70, 100);
		buy.add(buyb);

		// --------------------------------------------------------------------------------
		// ������1 ���Ž�
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mcoin--;
				hi1++;
				buy.setVisible(true);
				// ���Ź�ư Ŭ����

				buyb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						i1.setText("�������� : " + hi1);
						coinl.setText("�� ���� : " + mcoin);
						buy.dispose();

					}
				});

			}
		});

		// ������2 ���Ž�
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mcoin--;
				hi2++;
				buy.setVisible(true);
				// ���Ź�ư Ŭ����

				buyb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						i2.setText("�������� : " + hi2);
						coinl.setText("�� ���� : " + mcoin);
						buy.dispose();

					}
				});

			}
		});

		// ������3 ���Ž�
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mcoin--;
				hi3++;
				buy.setVisible(true);
				// ���Ź�ư Ŭ����

				buyb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						i3.setText("�������� : " + hi3);
						coinl.setText("�� ���� : " + mcoin);
						buy.dispose();

					}
				});

			}
		});

		// �����ڽ� �̱� ��� â
		// ���������� ���� �������̹����� ����ؽ�Ʈ ���
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				rbd.setVisible(true);
				mcoin--;
				int rbn = (int) ((Math.random() * 3) + 1);
				if (rbn == 1) {
					Image icon = new ImageIcon("C:\\Users\\user2\\Desktop\\ĸó.png").getImage().getScaledInstance(150,
							140, 0);
					rbl.setIcon(new ImageIcon(icon));
					result.setText("��������");
					hi1++;
					i1.setText("�������� : " + hi1);
					coinl.setText("�� ���� : " + mcoin);
				} else if (rbn == 2) {
					Image icon = new ImageIcon("C:\\Users\\user2\\Desktop\\ĸó1.png").getImage().getScaledInstance(150,
							140, 0);
					rbl.setIcon(new ImageIcon(icon));
					result.setText("����� ����");
					hi2++;
					i2.setText("�������� : " + hi2);
					coinl.setText("�� ���� : " + mcoin);
				} else if (rbn == 3) {
					Image icon = new ImageIcon("C:\\Users\\user2\\Desktop\\ĸó2.png").getImage().getScaledInstance(150,
							140, 0);
					rbl.setIcon(new ImageIcon(icon));
					result.setText("���� ����");
					hi3++;
					i3.setText("�������� : " + hi3);
					coinl.setText("�� ���� : " + mcoin);
				}

				// �̱��� ��� �� Ȯ�� ��ư
				rbok.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						rbd.dispose();

					}
				});
			}
		});

		// --------------------------------------------------------------------------------
		// ������ư
		JButton payb = new JButton("�����ϱ�");
		payb.setSize(100, 30);
		payb.setLocation(300, 30);
		this.add(payb);

		payb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p = new Pay();

			}
		});

		// ����ȭ������
		JButton exit = new JButton("������");
		exit.setSize(100, 30);
		exit.setLocation(760, 650);
		this.add(exit);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		this.setVisible(true);

		this.setLocationRelativeTo(null);
	

	}
}
