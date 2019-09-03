package com.kh.view;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

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
	JTextField casht1 = null; // ���¹�ȣ �Է�

	public Pay() {
		// super("����â");
		
		this.setTitle("����â");
		this.setLayout(null);
		this.setBounds(300, 100, 400, 600);

		Dimension frameSize = this.getSize(); // ������ ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ������
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // ȭ�� �߾�
		
		// --------------------------------------------------------------------------------
		// �����ϱ�
		JLabel label = new JLabel("�����ϱ�");
		Font font = new Font("���", Font.BOLD, 30);
		label.setFont(font);
		label.setLocation(136, 30);
		label.setSize(150, 40);
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

		// --------------------------------------------------------------------------------
		// �����ϱ� �˾�â
		Dialog pd = new Dialog(this, "�����ϱ�");
		pd.setLayout(null);
		pd.setSize(300, 300);
		pd.setLocation((screenSize.width - pd.getWidth())/2, (screenSize.height - pd.getHeight())/2);

		JButton okbutton = new JButton("Ȯ��");
		JButton cbutton = new JButton("���");

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

		// -----------------------------------------------------
		// ī����� ���ý� ��ȣ �Է�
		Dialog cardnd = new Dialog(pd, "ī���ȣ �Է�");
		cardnd.setLayout(null);
		cardnd.setSize(400, 250);
		cardnd.setLocation((screenSize.width - cardnd.getWidth())/2, (screenSize.height - cardnd.getHeight())/2);
		JLabel cardnl = new JLabel("ī���ȣ �Է�");
		cardnl.setSize(150, 40);
		cardnl.setLocation(60, 50);
		JTextField cardt1 = new JTextField();
		cardt1.setSize(60, 40);
		cardt1.setLocation(60, 100);
		JTextField cardt2 = new JTextField();
		cardt2.setSize(60, 40);
		cardt2.setLocation(140, 100);
		JTextField cardt3 = new JTextField();
		cardt3.setSize(60, 40);
		cardt3.setLocation(220, 100);
		JTextField cardt4 = new JTextField();
		cardt4.setSize(60, 40);
		cardt4.setLocation(300, 100);
		JButton cardndb = new JButton("Ȯ��");
		cardndb.setSize(60, 40);
		cardndb.setLocation(200, 180);
		JButton cardndb2 = new JButton("���");
		cardndb2.setSize(60, 40);
		cardndb2.setLocation(280, 180);
		JLabel cardcancel = new JLabel("��ҹ�ư�� ������ ����ȭ������ ���ư��ϴ�.");
		cardcancel.setSize(300, 40);
		cardcancel.setLocation(70, 210);
		
		Dialog cardError = new Dialog(cardnd, "Error!");
		cardError.setModal(false);
		cardError.setLayout(null);
		cardError.setSize(200, 150);
		cardError.setLocation((screenSize.width - cardError.getWidth())/2, (screenSize.height - cardError.getHeight())/2);
		JLabel cardErrorl = new JLabel("ī���ȣ�� �Է����ּ���.");
		cardErrorl.setSize(150, 50);
		cardErrorl.setLocation(30, 40);
		JButton cardErrorb = new JButton("Ȯ��");
		cardErrorb.setSize(60, 40);
		cardErrorb.setLocation(72, 90);
		cardError.add(cardErrorl);
		cardError.add(cardErrorb);
		
		cardnd.add(cardnl);
		cardnd.add(cardt1);
		cardnd.add(cardt2);
		cardnd.add(cardt3);
		cardnd.add(cardt4);
		cardnd.add(cardndb);
		cardnd.add(cardndb2);
		cardnd.add(cardcancel);
		
		// ������ü ���ý� ��ȣ�Է�
		Dialog cashnd = new Dialog(pd, "���¹�ȣ �Է�");
		cashnd.setLayout(null);
		cashnd.setSize(400, 250);
		cashnd.setLocation((screenSize.width - cashnd.getWidth())/2, (screenSize.height - cashnd.getHeight())/2);
		JLabel cashndl = new JLabel("���¹�ȣ �Է�");
		cashndl.setSize(150, 40);
		cashndl.setLocation(60, 50);
		casht1 = new JTextField();
		casht1.setSize(200, 40);
		casht1.setLocation(120, 100);
		JButton cashndb = new JButton("Ȯ��");
		cashndb.setSize(60, 40);
		cashndb.setLocation(170, 180);
		JButton cashndb2 = new JButton("���");
		cashndb2.setSize(60, 40);
		cashndb2.setLocation(250, 180);
		JLabel cashcancel = new JLabel("��ҹ�ư�� ������ ����ȭ������ ���ư��ϴ�.");
		cashcancel.setSize(300, 40);
		cashcancel.setLocation(70, 210);
		
		Dialog cashError = new Dialog(cashnd, "Error!");
		cashError.setLayout(null);
		cashError.setSize(200, 150);
		cashError.setLocation((screenSize.width - cashError.getWidth())/2, (screenSize.height - cashnd.getHeight())/2);
		JLabel cashErrorl = new JLabel("���¹�ȣ�� �Է����ּ���.");
		cashErrorl.setSize(150, 50);
		cashErrorl.setLocation(30, 40);
		JButton cashErrorb = new JButton("Ȯ��");
		cashErrorb.setSize(60, 40);
		cashErrorb.setLocation(72, 90);
		cashError.add(cashErrorb);
		cashError.add(cashErrorl);

		// ���༱��
		String[] banks = { "����", "�ϳ�", "����", "īī��", "�뱸", "�λ�" };
		JComboBox banklist = new JComboBox(banks);
		// banklist.setSelectedIndex(0);
		banklist.setSize(60, 40);
		banklist.setLocation(60, 100);
		cashnd.add(cashndl);
		cashnd.add(cashndb);
		cashnd.add(cashndb2);
		cashnd.add(casht1);
		cashnd.add(banklist);
		cashnd.add(cashcancel);
		
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

		// --------------------------------------------------------------------------------
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
		nochoose.setSize(300, 150);
		nochoose.setLocation((screenSize.width - nochoose.getWidth())/2, (screenSize.height - nochoose.getHeight())/2);
		
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

					// ī�� ����
					if (card.isSelected()) {
						cardnd.setVisible(true);

						cardndb.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// ī���ȣ ���Է½�
								if (cardt1.getText().isEmpty() || cardt2.getText().isEmpty()
										|| cardt3.getText().isEmpty() || cardt4.getText().isEmpty()) {
									cardError.setVisible(true);

									// ī���ȣ �Է½�
								} else {
									cardnd.dispose();
									cl.setText("ī���ȣ : " + cardt1.getText() + "-" + cardt2.getText() + "-"
											+ cardt3.getText() + "-" + cardt4.getText());
									pl.setText(presult.getText());
									p1.setText(scoin + "�� �����Ͻðڽ��ϱ�?");
									pd.setVisible(true);
								}

								// �Էµ� �� �ʱ�ȭ
								cardt1.setText(null);
								cardt2.setText(null);
								cardt3.setText(null);
								cardt4.setText(null);

							}
						});
					}

					// ������ü ����
					if (cash.isSelected()) {
						cashnd.setVisible(true);

						// Ȯ�ι�ư Ŭ��
						cashndb.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// ���¹�ȣ �� �Է½�
								if (casht1.getText().isEmpty()) {
									cashError.setVisible(true);
								}
								
								// ���¹�ȣ �Է½�
								if(!casht1.getText().isEmpty()){
									cl.setText(banklist.getSelectedItem() + " - " + casht1.getText());
									pl.setText(presult.getText());
									p1.setText(scoin + "�� �����Ͻðڽ��ϱ�?");
									pd.setVisible(true);
									cashnd.dispose();
								}
								// �Էµ� �� �ʱ�ȭ
								casht1.setText(null);

							}
						});

					}

				}
			}
		});

		// ����Ȯ�ι�ư
		cbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				pd.dispose();

			}
		});

		// ī����� ���� Ȯ�ι�ư
		cardErrorb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardError.dispose();
			}
		});

		// ī���ȣ�Է� ��ҹ�ư
		cardndb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		// ������ü ���� Ȯ�ι�ư
		cashErrorb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cashError.dispose();
			}
		});

		// ���¹�ȣ�Է� ��ҹ�ư
		cashndb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				casht1.setText(null);
				dispose();
			}
		});

		// --------------------------------------------------------------------------------
		// ����Ȯ�ν� ���,�ݾ� Ȯ�� �˾�
		Dialog ok = new Dialog(this, "�����Ϸ�");
		ok.setLayout(null);
		ok.setSize(200, 150);
		ok.setLocation((screenSize.width - ok.getWidth()) / 2, (screenSize.height - ok.getHeight()) / 2);
		
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
				dispose();
			}
		});

		// �����Ϸ� Ȯ�� Ŭ�� �� �˾�
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

	}

}
