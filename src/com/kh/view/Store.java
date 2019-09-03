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

	int ownItem1Number;
	int ownItem2Number;
	int ownItem3Number;
	int mcoin = 100;
	
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
		JLabel itemList = new JLabel("������ ���");
		itemList.setSize(100, 40);
		itemList.setLocation(20, 80);
		this.add(itemList);

		// ������1
		JPanel item1 = new JPanel();
		item1.setSize(150, 150);
		item1.setLocation(20, 130);
		item1.setBackground(Color.GRAY);

		JButton item1BuyButton = new JButton("����");
		item1BuyButton.setSize(60, 40);
		item1BuyButton.setLocation(110, 280);
		this.add(item1);
		this.add(item1BuyButton);

		// ������2
		JPanel item2 = new JPanel();
		item2.setSize(150, 150);
		item2.setLocation(250, 130);
		item2.setBackground(Color.GRAY);

		JButton item2BuyButton = new JButton("����");
		item2BuyButton.setSize(60, 40);
		item2BuyButton.setLocation(340, 280);
		this.add(item2);
		this.add(item2BuyButton);

		// ������3
		JPanel item3 = new JPanel();
		item3.setSize(150, 150);
		item3.setLocation(480, 130);
		item3.setBackground(Color.GRAY);

		JButton item3BuyButton = new JButton("����");
		item3BuyButton.setSize(60, 40);
		item3BuyButton.setLocation(570, 280);
		this.add(item3);
		this.add(item3BuyButton);

		// �����ڽ�
		JPanel randomBox = new JPanel();
		randomBox.setSize(150, 150);
		randomBox.setLocation(710, 130);
		randomBox.setBackground(Color.GRAY);

		JButton randomBoxBuyButton = new JButton("�̱�");
		randomBoxBuyButton.setSize(60, 40);
		randomBoxBuyButton.setLocation(800, 280);
		this.add(randomBox);
		this.add(randomBoxBuyButton);

		// �����ڽ��̱� ���
		Dialog randomBoxResultDialog = new Dialog(this, "�����ڽ�");
		randomBoxResultDialog.setLayout(null);
		randomBoxResultDialog.setSize(300, 300);
		randomBoxResultDialog.setLocation((screenSize.width - randomBoxResultDialog.getWidth())/2, (screenSize.height - randomBoxResultDialog.getHeight())/2);
		// �̱��� ������ �̹���
		JLabel randomBoxLabel = new JLabel();
		randomBoxLabel.setBounds(75, 60, 150, 140);
		randomBoxResultDialog.add(randomBoxLabel);

		// �̱� ��� ��� �� Ȯ�� ��ư
		JButton randomBoxDialogOkButton = new JButton("Ȯ��");
		randomBoxDialogOkButton.setBounds(120, 250, 60, 30);
		randomBoxResultDialog.add(randomBoxDialogOkButton);

		// ������ ȹ�� ���
		JLabel randomBoxResultLabel = new JLabel();
		randomBoxResultLabel.setBounds(120, 200, 200, 30);
		randomBoxResultDialog.add(randomBoxResultLabel);

		// --------------------------------------------------------------------------------
		// ����������
		JLabel ownItemList = new JLabel("����������");
		ownItemList.setSize(100, 40);
		ownItemList.setLocation(20, 400);
		this.add(ownItemList);

		// ����������1
		JPanel ownItem1 = new JPanel();
		ownItem1.setSize(150, 150);
		ownItem1.setLocation(20, 450);
		ownItem1.setBackground(Color.GRAY);
		this.add(ownItem1);

		JLabel ownItem1Label = new JLabel("�������� : " + ownItem1Number);
		ownItem1Label.setSize(100, 40);
		ownItem1Label.setLocation(90, 600);
		this.add(ownItem1Label);

		// ����������2
		JPanel ownItem2 = new JPanel();
		ownItem2.setSize(150, 150);
		ownItem2.setLocation(250, 450);
		ownItem2.setBackground(Color.GRAY);
		this.add(ownItem2);

		JLabel ownItem2Label = new JLabel("�������� : " + ownItem2Number);
		ownItem2Label.setSize(100, 40);
		ownItem2Label.setLocation(320, 600);
		this.add(ownItem2Label);

		// ����������3
		JPanel ownItem3 = new JPanel();
		ownItem3.setSize(150, 150);
		ownItem3.setLocation(480, 450);
		ownItem3.setBackground(Color.GRAY);
		this.add(ownItem3);

		JLabel ownItem3Label = new JLabel("�������� : " + ownItem3Number);
		ownItem3Label.setSize(100, 40);
		ownItem3Label.setLocation(550, 600);
		this.add(ownItem3Label);

		// --------------------------------------------------------------------------------
		// ���ΰ��� ���
		JLabel ownCoinLabel = new JLabel("�� ���� : " + mcoin);
		ownCoinLabel.setSize(100, 40);
		ownCoinLabel.setLocation(200, 30);
		this.add(ownCoinLabel);

		Dialog itemBuyDialog = new Dialog(this, "������ ����");
		itemBuyDialog.setLayout(null);
		itemBuyDialog.setSize(200, 160);
		itemBuyDialog.setLocation((screenSize.width - itemBuyDialog.getWidth())/2, (screenSize.height - itemBuyDialog.getHeight())/2);
		JLabel itemBuyDialogLabel = new JLabel("�����Ͻðڽ��ϱ�?");
		itemBuyDialogLabel.setSize(150, 40);
		itemBuyDialogLabel.setLocation(50, 50);
		itemBuyDialog.add(itemBuyDialogLabel);
		JButton itemBuyDialogBuyButton = new JButton("����");
		itemBuyDialogBuyButton.setSize(60, 40);
		itemBuyDialogBuyButton.setLocation(70, 100);
		itemBuyDialog.add(itemBuyDialogBuyButton);

		// --------------------------------------------------------------------------------
		// ������1 ���Ž�
		item1BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mcoin--;
				ownItem1Number++;
				itemBuyDialog.setVisible(true);
				// ���Ź�ư Ŭ����

				itemBuyDialogBuyButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ownItem1Label.setText("�������� : " + ownItem1Number);
						ownCoinLabel.setText("�� ���� : " + mcoin);
						itemBuyDialog.dispose();

					}
				});

			}
		});

		// ������2 ���Ž�
		item2BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mcoin--;
				ownItem2Number++;
				itemBuyDialog.setVisible(true);
				// ���Ź�ư Ŭ����

				itemBuyDialogBuyButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ownItem2Label.setText("�������� : " + ownItem2Number);
						ownCoinLabel.setText("�� ���� : " + mcoin);
						itemBuyDialog.dispose();

					}
				});

			}
		});

		// ������3 ���Ž�
		item3BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				mcoin--;
				ownItem3Number++;
				itemBuyDialog.setVisible(true);
				// ���Ź�ư Ŭ����

				itemBuyDialogBuyButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						ownItem3Label.setText("�������� : " + ownItem3Number);
						ownCoinLabel.setText("�� ���� : " + mcoin);
						itemBuyDialog.dispose();

					}
				});

			}
		});

		// �����ڽ� �̱� ��� â
		// ���������� ���� �������̹����� ����ؽ�Ʈ ���
		randomBoxBuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				randomBoxResultDialog.setVisible(true);
				mcoin--;
				int rbn = (int) ((Math.random() * 3) + 1);
				if (rbn == 1) {
					Image icon = new ImageIcon("C:\\Users\\user2\\Desktop\\ĸó.png").getImage().getScaledInstance(150,
							140, 0);
					randomBoxLabel.setIcon(new ImageIcon(icon));
					randomBoxResultLabel.setText("��������");
					ownItem1Number++;
					ownItem1Label.setText("�������� : " + ownItem1Number);
					ownCoinLabel.setText("�� ���� : " + mcoin);
				} else if (rbn == 2) {
					Image icon = new ImageIcon("C:\\Users\\user2\\Desktop\\ĸó1.png").getImage().getScaledInstance(150,
							140, 0);
					randomBoxLabel.setIcon(new ImageIcon(icon));
					randomBoxResultLabel.setText("����� ����");
					ownItem2Number++;
					ownItem2Label.setText("�������� : " + ownItem2Number);
					ownCoinLabel.setText("�� ���� : " + mcoin);
				} else if (rbn == 3) {
					Image icon = new ImageIcon("C:\\Users\\user2\\Desktop\\ĸó2.png").getImage().getScaledInstance(150,
							140, 0);
					randomBoxLabel.setIcon(new ImageIcon(icon));
					randomBoxResultLabel.setText("���� ����");
					ownItem3Number++;
					ownItem3Label.setText("�������� : " + ownItem3Number);
					ownCoinLabel.setText("�� ���� : " + mcoin);
				}

				// �̱��� ��� �� Ȯ�� ��ư
				randomBoxDialogOkButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						randomBoxResultDialog.dispose();

					}
				});
			}
		});

		// --------------------------------------------------------------------------------
		// ������ư
		JButton payButton = new JButton("�����ϱ�");
		payButton.setSize(100, 30);
		payButton.setLocation(300, 30);
		this.add(payButton);

		payButton.addActionListener(new ActionListener() {

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
