package com.kh.view;

import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.kh.view.Store;

public class Pay extends JDialog {

	JLabel pl = new JLabel(); // �����ݾ�Ȯ��
	JLabel cl = new JLabel(); // ������ļ���Ȯ��
	JLabel presult = new JLabel(); // �����ݾ�
	JLabel cresult = new JLabel(); // �������
	int scoin; // ���ΰ���
	JLabel p1 = null; // ������������Ȯ��
	ButtonGroup c = null;
	JRadioButton card = null;
	JRadioButton cash = null;
	JRadioButton empty = null;

	public Pay() {
		// super("����â");

		this.setTitle("����â");
		this.setLayout(null);
		this.setBounds(100, 50, 400, 600);

		// �����ϱ�
		JLabel label = new JLabel("�����ϱ�");
		label.setLocation(166, 30);
		label.setSize(80, 30);
		this.add(label);

		// ���� ��� ����
		JLabel choose = new JLabel("���� ���");
		choose.setLocation(166, 80);
		choose.setSize(100, 30);
		this.add(choose);

		card = new JRadioButton("ī�� ����");
		cash = new JRadioButton("���� ��ü");

		c = new ButtonGroup();
		c.add(card);
		c.add(cash);

		card.setLocation(100, 110);
		card.setSize(100, 30);
		cash.setLocation(200, 110);
		cash.setSize(100, 30);

		this.add(card);
		this.add(cash);

		// ���� �ݾ� ����
		JLabel price = new JLabel("���� �ݾ�");
		price.setLocation(166, 150);
		price.setSize(100, 30);
		this.add(price);

		JRadioButton b1 = new JRadioButton("5,000�� : 50��");
		b1.setLocation(130, 180);
		b1.setSize(200, 30);
		JRadioButton b2 = new JRadioButton("10,000�� : 105��");
		b2.setLocation(130, 210);
		b2.setSize(200, 30);
		JRadioButton b3 = new JRadioButton("20,000�� : 210��");
		b3.setLocation(130, 240);
		b3.setSize(200, 30);
		JRadioButton b4 = new JRadioButton("30,000�� : 315��");
		b4.setLocation(130, 270);
		b4.setSize(200, 30);
		JRadioButton b5 = new JRadioButton("50,000�� : 550��");
		b5.setLocation(130, 300);
		b5.setSize(200, 30);
		ButtonGroup p = new ButtonGroup();
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(b4);
		p.add(b5);

		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);

		// �����ϱ� �˾�â
		Dialog pd = new Dialog(this, "�����ϱ�");
		pd.setLayout(null);
		pd.setSize(300, 300);
		pd.setLocation(150, 150);

		JButton okbutton = new JButton("Ȯ��");
		JButton cbutton = new JButton("���");
		// ButtonGroup b = new ButtonGroup();
		// b.add(okbutton);
		// b.add(cbutton);

		okbutton.setLocation(100, 250);
		okbutton.setSize(75, 30);
		cbutton.setLocation(200, 250);
		cbutton.setSize(75, 30);
		// m.setLocation(75, 100);
		// m.setSize(150, 150);

		pd.add(cbutton);
		pd.add(okbutton);

		this.cresult.setText("����� �������� �ʾҽ��ϴ�.");
		this.cresult.setLocation(100, 350);
		this.cresult.setSize(300, 30);
		this.add(this.cresult);

		this.presult.setText("�ݾ��� �������� �ʾҽ��ϴ�.");
		this.presult.setLocation(100, 400);
		this.presult.setSize(300, 30);
		this.add(this.presult);

		// ī����� ���� ��
		card.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cresult.setText("ī�� ���� ���õǾ����ϴ�.");

			}
		});

		// ������ü ���� ��
		cash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cresult.setText("���� ��ü ���õǾ����ϴ�.");

			}
		});

		// �����ݾ� ���� ��
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 50;
				presult.setText("5,000�� ���õǾ����ϴ�.");

			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 105;
				presult.setText("10,000�� ���õǾ����ϴ�.");

			}
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 210;
				presult.setText("20,000�� ���õǾ����ϴ�.");

			}
		});
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 315;
				presult.setText("30,000�� ���õǾ����ϴ�.");

			}
		});
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 550;
				presult.setText("50,000�� ���õǾ����ϴ�.");

			}
		});

		// �����ϱ� ��ư
		JButton pay = new JButton("�����ϱ�");
		pay.setLocation(180, 500);
		pay.setSize(90, 30);
		this.add(pay);

		this.cl = new JLabel(this.cresult.getText());
		cl.setLocation(75, 80);
		cl.setSize(200, 30);
		this.pl = new JLabel(this.presult.getText());
		this.pl.setLocation(75, 120);
		this.pl.setSize(200, 30);
		p1 = new JLabel();
		p1.setLocation(80, 180);
		p1.setSize(150, 30);
		pd.add(cl);
		pd.add(pl);
		pd.add(p1);

		// �ƹ��͵� �������� �ʾ����� ���â
		Dialog nochoose = new Dialog(this, "Error!");
		nochoose.setLayout(null);
		nochoose.setBounds(150, 150, 300, 150);
		JLabel error = new JLabel("������İ� �ݾ��� �������ּ���!");
		error.setSize(200, 100);
		error.setLocation(60, 20);
		JButton eb = new JButton("Ȯ��");
		eb.setSize(70, 30);
		eb.setLocation(120, 100);
		nochoose.add(error);
		nochoose.add(eb);

		// �����ϱ� Ŭ���� �˾�
		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��������� ���õ��� �ʾ��� ��
				if (!cash.isSelected() && !card.isSelected()) {

					nochoose.setVisible(true);

					eb.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							nochoose.dispose();

						}
					});

					// �����ݾ��� ���õ��� �ʾ��� ��
				} else if (!b1.isSelected() && !b2.isSelected() && !b3.isSelected() && !b4.isSelected()
						&& !b5.isSelected()) {
					nochoose.setVisible(true);

					eb.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							nochoose.dispose();

						}
					});
					// ������� �����ݾ� ��� ���� �Ǿ��� ��
				} else {
					cl.setText(cresult.getText());
					pl.setText(presult.getText());
					p1.setText(scoin + "�� �����Ͻðڽ��ϱ�?");
					pd.setVisible(true);

				}
			}
		});

		cbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pd.dispose();

			}
		});

		// ����Ȯ�ν� ���,�ݾ� Ȯ�� �˾�
		Dialog ok = new Dialog(this, "�����ϱ�");
		ok.setLayout(null);
		ok.setBounds(200, 200, 200, 150);

		JLabel result = new JLabel("������ �Ϸ�Ǿ����ϴ�.");
		result.setSize(150, 100);
		result.setLocation(35, 20);
		ok.add(result);
		JButton ob = new JButton("Ȯ��");
		ob.setSize(60, 30);
		ob.setLocation(70, 100);
		ok.add(ob);

		// �����Ϸ� Ȯ�� Ŭ��
		ob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ok.dispose();
				pd.dispose();

			}
		});
		// �����ϱ� Ȯ�� Ŭ�� �� �˾�
		okbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(true);

			}

		});

		JButton exit = new JButton("��������");
		exit.setLocation(280, 500);
		exit.setSize(90, 30);
		this.add(exit);

		// �������� Ŭ���� �˾�
		exit.addActionListener(new ActionListener() {
			// �� �ؽ�Ʈ �ʱ�ȭ
			// ��ư Ŭ�� �ʱ�ȭ
			@Override
			public void actionPerformed(ActionEvent e) {

				dispose(); // â ����
			}
		});
		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

}
