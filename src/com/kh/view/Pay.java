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

	JLabel paySelect = new JLabel(); // �����ݾ�Ȯ��
	JLabel chooseSelect = new JLabel(); // ������ļ���Ȯ��
	JLabel presult = new JLabel(); // �����ݾ�
	JLabel cresult = new JLabel(); // �������
	int buyCoin; // ���ΰ���
	JLabel chargeCoinNum = null; // ������������Ȯ��
	ButtonGroup c = null;
	JRadioButton card = null;
	JRadioButton cash = null;

	public Pay() {
		this.setTitle("����â");
		this.setLayout(null);
		this.setBounds(300, 100, 400, 600);

		Dimension frameSize = this.getSize(); // ������ ������
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // ����� ������
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // ȭ�� �߾�

		// --------------------------------------------------------------------------------
		// �����ϱ�
		JLabel payLabel = new JLabel("�����ϱ�");
		Font font = new Font("���", Font.BOLD, 30);
		payLabel.setFont(font);
		payLabel.setLocation(136, 30);
		payLabel.setSize(150, 40);
		this.add(payLabel);

		// ���� ��� ����
		JLabel payChoose = new JLabel("���� ���");
		payChoose.setLocation(166, 80);
		payChoose.setSize(100, 30);
		this.add(payChoose);

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
		Dialog payDialog = new Dialog(this, "�����ϱ�");
		payDialog.setLayout(null);
		payDialog.setSize(300, 300);
		payDialog.setLocation((screenSize.width - payDialog.getWidth()) / 2,
				(screenSize.height - payDialog.getHeight()) / 2);

		JButton payDialogOkButton = new JButton("Ȯ��");
		JButton payDialogCancelButton = new JButton("���");

		payDialogOkButton.setLocation(100, 250);
		payDialogOkButton.setSize(75, 30);
		payDialogCancelButton.setLocation(200, 250);
		payDialogCancelButton.setSize(75, 30);
		// m.setLocation(75, 100);
		// m.setSize(150, 150);

		payDialog.add(payDialogCancelButton);
		payDialog.add(payDialogOkButton);

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
		Dialog cardNumberInput = new Dialog(payDialog, "ī���ȣ �Է�");
		cardNumberInput.setLayout(null);
		cardNumberInput.setSize(400, 250);
		cardNumberInput.setLocation((screenSize.width - cardNumberInput.getWidth()) / 2,
				(screenSize.height - cardNumberInput.getHeight()) / 2);
		JLabel cardNumberLabel = new JLabel("ī���ȣ �Է�");
		cardNumberLabel.setSize(150, 40);
		cardNumberLabel.setLocation(60, 50);
		JTextField cardNumberText1 = new JTextField();
		cardNumberText1.setSize(60, 40);
		cardNumberText1.setLocation(60, 100);
		JTextField cardNumberText2 = new JTextField();
		cardNumberText2.setSize(60, 40);
		cardNumberText2.setLocation(140, 100);
		JTextField cardNumberText3 = new JTextField();
		cardNumberText3.setSize(60, 40);
		cardNumberText3.setLocation(220, 100);
		JTextField cardNumberText4 = new JTextField();
		cardNumberText4.setSize(60, 40);
		cardNumberText4.setLocation(300, 100);
		JButton cardNumberInputOkButton = new JButton("Ȯ��");
		cardNumberInputOkButton.setSize(60, 40);
		cardNumberInputOkButton.setLocation(200, 180);
		JButton cardNumberInputCalcelButton = new JButton("���");
		cardNumberInputCalcelButton.setSize(60, 40);
		cardNumberInputCalcelButton.setLocation(280, 180);
		JLabel cardNumberInputCancelMsg = new JLabel("��ҹ�ư�� ������ ����ȭ������ ���ư��ϴ�.");
		cardNumberInputCancelMsg.setSize(300, 40);
		cardNumberInputCancelMsg.setLocation(70, 210);

		Dialog cardNumberError = new Dialog(cardNumberInput, "nochooseLabel!");
		cardNumberError.setModal(false);
		cardNumberError.setLayout(null);
		cardNumberError.setSize(200, 150);
		cardNumberError.setLocation((screenSize.width - cardNumberError.getWidth()) / 2,
				(screenSize.height - cardNumberError.getHeight()) / 2);
		JLabel cardNumberErrorLabel = new JLabel("ī���ȣ�� �Է����ּ���.");
		cardNumberErrorLabel.setSize(150, 50);
		cardNumberErrorLabel.setLocation(30, 40);
		JButton cardNumberErrorOkButton = new JButton("Ȯ��");
		cardNumberErrorOkButton.setSize(60, 40);
		cardNumberErrorOkButton.setLocation(72, 90);
		cardNumberError.add(cardNumberErrorLabel);
		cardNumberError.add(cardNumberErrorOkButton);

		cardNumberInput.add(cardNumberLabel);
		cardNumberInput.add(cardNumberText1);
		cardNumberInput.add(cardNumberText2);
		cardNumberInput.add(cardNumberText3);
		cardNumberInput.add(cardNumberText4);
		cardNumberInput.add(cardNumberInputOkButton);
		cardNumberInput.add(cardNumberInputCalcelButton);
		cardNumberInput.add(cardNumberInputCancelMsg);

		// ������ü ���ý� ��ȣ�Է�
		Dialog cashNumberInput = new Dialog(payDialog, "���¹�ȣ �Է�");
		cashNumberInput.setLayout(null);
		cashNumberInput.setSize(400, 250);
		cashNumberInput.setLocation((screenSize.width - cashNumberInput.getWidth()) / 2,
				(screenSize.height - cashNumberInput.getHeight()) / 2);
		JLabel cashNumberLabel = new JLabel("���¹�ȣ �Է�");
		cashNumberLabel.setSize(150, 40);
		cashNumberLabel.setLocation(60, 50);
		JTextField cashText = new JTextField();
		cashText.setSize(200, 40);
		cashText.setLocation(120, 100);
		JButton cashNumberInputOkButton = new JButton("Ȯ��");
		cashNumberInputOkButton.setSize(60, 40);
		cashNumberInputOkButton.setLocation(170, 180);
		JButton cashNumberInputCancelButton = new JButton("���");
		cashNumberInputCancelButton.setSize(60, 40);
		cashNumberInputCancelButton.setLocation(250, 180);
		JLabel cashNumberInputCancelMsg = new JLabel("��ҹ�ư�� ������ ����ȭ������ ���ư��ϴ�.");
		cashNumberInputCancelMsg.setSize(300, 40);
		cashNumberInputCancelMsg.setLocation(70, 210);

		Dialog cashNumberError = new Dialog(cashNumberInput, "nochooseLabel!");
		cashNumberError.setLayout(null);
		cashNumberError.setSize(200, 150);
		cashNumberError.setLocation((screenSize.width - cashNumberError.getWidth()) / 2,
				(screenSize.height - cashNumberInput.getHeight()) / 2);
		JLabel cashNumberErrorLabel = new JLabel("���¹�ȣ�� �Է����ּ���.");
		cashNumberErrorLabel.setSize(150, 50);
		cashNumberErrorLabel.setLocation(30, 40);
		JButton cashNumberErrorOkButton = new JButton("Ȯ��");
		cashNumberErrorOkButton.setSize(60, 40);
		cashNumberErrorOkButton.setLocation(72, 90);
		cashNumberError.add(cashNumberErrorOkButton);
		cashNumberError.add(cashNumberErrorLabel);

		// ���༱��
		String[] banks = { "����", "�ϳ�", "����", "īī��", "�뱸", "�λ�" };
		JComboBox banklist = new JComboBox(banks);
		banklist.setSize(60, 40);
		banklist.setLocation(60, 100);
		cashNumberInput.add(cashNumberLabel);
		cashNumberInput.add(cashNumberInputOkButton);
		cashNumberInput.add(cashNumberInputCancelButton);
		cashNumberInput.add(cashText);
		cashNumberInput.add(banklist);
		cashNumberInput.add(cashNumberInputCancelMsg);

		// ī����� ���� ��
		card.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ī����� ���� ���
				cresult.setText("ī�� ���� ���õǾ����ϴ�.");

			}
		});

		// ������ü ���� ��
		cash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ������ü ���� ���
				cresult.setText("���� ��ü ���õǾ����ϴ�.");

			}
		});

		// �����ݾ� ���� ��
		// ������ ���ΰ��� �Ѱ��� ��, �����ݾ� ���
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 50;
				presult.setText("5,000�� ���õǾ����ϴ�.");

			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 105;
				presult.setText("10,000�� ���õǾ����ϴ�.");

			}
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 210;
				presult.setText("20,000�� ���õǾ����ϴ�.");

			}
		});
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 315;
				presult.setText("30,000�� ���õǾ����ϴ�.");

			}
		});
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 550;
				presult.setText("50,000�� ���õǾ����ϴ�.");

			}
		});

		// --------------------------------------------------------------------------------
		// �����ϱ� ��ư
		JButton payButton = new JButton("�����ϱ�");
		payButton.setLocation(180, 500);
		payButton.setSize(90, 30);
		this.add(payButton);

		this.chooseSelect = new JLabel(this.cresult.getText());
		chooseSelect.setLocation(75, 80);
		chooseSelect.setSize(200, 30);
		this.paySelect = new JLabel(this.presult.getText());
		this.paySelect.setLocation(75, 120);
		this.paySelect.setSize(200, 30);
		chargeCoinNum = new JLabel();
		chargeCoinNum.setLocation(80, 180);
		chargeCoinNum.setSize(150, 30);
		payDialog.add(chooseSelect);
		payDialog.add(paySelect);
		payDialog.add(chargeCoinNum);

		// �ƹ��͵� �������� �ʾ����� ���â
		Dialog nochooseDialog = new Dialog(this, "nochooseLabel!");
		nochooseDialog.setLayout(null);
		nochooseDialog.setSize(300, 150);
		nochooseDialog.setLocation((screenSize.width - nochooseDialog.getWidth()) / 2,
				(screenSize.height - nochooseDialog.getHeight()) / 2);

		JLabel nochooseLabel = new JLabel("������İ� �ݾ��� �������ּ���!");
		nochooseLabel.setSize(200, 100);
		nochooseLabel.setLocation(60, 20);
		JButton nochooseOkButton = new JButton("Ȯ��");
		nochooseOkButton.setSize(70, 30);
		nochooseOkButton.setLocation(120, 100);
		nochooseDialog.add(nochooseLabel);
		nochooseDialog.add(nochooseOkButton);

		// �����ϱ� Ŭ���� �˾�

		payButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ��������� ���õ��� �ʾ��� ��
				if (!cash.isSelected() && !card.isSelected()) {
					// ���â ���
					nochooseDialog.setVisible(true);

					// ���â Ȯ�ι�ư Ŭ����
					nochooseOkButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// ���â �����
							nochooseDialog.dispose();

						}
					});

					// �����ݾ��� ���õ��� �ʾ��� ��
				} else if (!b1.isSelected() && !b2.isSelected() && !b3.isSelected() && !b4.isSelected()
						&& !b5.isSelected()) {
					// ���â ���
					nochooseDialog.setVisible(true);

					// ���â Ȯ�ι�ư Ŭ����
					nochooseOkButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// ���â �����
							nochooseDialog.dispose();

						}
					});
					// ������� �����ݾ� ��� ���� �Ǿ��� ��
				} else {

					// ī�� ����
					if (card.isSelected()) {
						// ī���ȣ �Է� �˾� ���
						cardNumberInput.setVisible(true);

						// ī���ȣ �Է� �˾� Ȯ�� ��ư Ŭ��
						cardNumberInputOkButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// ī���ȣ ���Է½�
								if (cardNumberText1.getText().isEmpty() || cardNumberText2.getText().isEmpty()
										|| cardNumberText3.getText().isEmpty() || cardNumberText4.getText().isEmpty()) {
									// ī���ȣ ���Է� ���� �˾� ���
									cardNumberError.setVisible(true);

									// ī���ȣ �Է½�
								} else {
									// ī���ȣ �Է� �˾� �����
									cardNumberInput.dispose();
									// �Էµ� ī���ȣ �����ͼ� ���
									chooseSelect.setText("ī���ȣ : " + cardNumberText1.getText() + "-"
											+ cardNumberText2.getText() + "-" + cardNumberText3.getText() + "-"
											+ cardNumberText4.getText());
									// ���õ� ������� �����ͼ� ���
									paySelect.setText(presult.getText());
									// ������ ���ΰ��� �����ͼ� ���
									chargeCoinNum.setText(buyCoin + "�� �����Ͻðڽ��ϱ�?");
									payDialog.setVisible(true);
								}

								// �Էµ� �� �ʱ�ȭ
								cardNumberText1.setText(null);
								cardNumberText2.setText(null);
								cardNumberText3.setText(null);
								cardNumberText4.setText(null);

							}
						});
					}

					// ������ü ����
					if (cash.isSelected()) {
						// ���¹�ȣ �Է� �˾� ���
						cashNumberInput.setVisible(true);

						// Ȯ�ι�ư Ŭ��
						cashNumberInputOkButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// ���¹�ȣ �� �Է½�
								if (cashText.getText().isEmpty()) {
									// ���¹�ȣ ���Է� ���� �˾� ���
									cashNumberError.setVisible(true);
								}

								// ���¹�ȣ �Է½�
								if (!cashText.getText().isEmpty()) {
									// ���¹�ȣ �Է� �˾� �����
									cashNumberInput.dispose();
									// �Էµ� ���¹�ȣ �����ͼ� ���
									chooseSelect.setText(banklist.getSelectedItem() + " - " + cashText.getText());
									// ���õ� ������� �����ͼ� ���
									paySelect.setText(presult.getText());
									// ������ ���ΰ�� �����ͼ� ���
									chargeCoinNum.setText(buyCoin + "�� �����Ͻðڽ��ϱ�?");
									payDialog.setVisible(true);
								}
								// �Էµ� �� �ʱ�ȭ
								cashText.setText(null);

							}
						});

					}

				}
			}
		});

		// ����Ȯ�ι�ư
		payDialogCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �����ϱ� �˾� �����
				payDialog.dispose();

			}
		});

		// ī����� ���� Ȯ�ι�ư
		cardNumberErrorOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ī���ȣ �Է� ���� �˾� �����
				cardNumberError.dispose();
			}
		});

		// ī���ȣ�Է� ��ҹ�ư
		cardNumberInputCalcelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����â ����
				cardNumberText1.setText(null);
				cardNumberText2.setText(null);
				cardNumberText3.setText(null);
				cardNumberText4.setText(null);
				dispose();

			}
		});

		// ������ü ���� Ȯ�ι�ư
		cashNumberErrorOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ���¹�ȣ �Է� ���� �˾� �����
				cashNumberError.dispose();
			}
		});

		// ���¹�ȣ�Է� ��ҹ�ư
		cashNumberInputCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// �Էµ� ī���ȣ �ʱ�ȭ �� ����â ����
				cashText.setText(null);
				dispose();
			}
		});

		// --------------------------------------------------------------------------------
		// ����Ȯ�ν� ���,�ݾ� Ȯ�� �˾�
		Dialog payCompleteDialog = new Dialog(this, "�����Ϸ�");
		payCompleteDialog.setLayout(null);
		payCompleteDialog.setSize(200, 150);
		payCompleteDialog.setLocation((screenSize.width - payCompleteDialog.getWidth()) / 2,
				(screenSize.height - payCompleteDialog.getHeight()) / 2);

		JLabel payCompleteLabel = new JLabel("������ �Ϸ�Ǿ����ϴ�.");
		payCompleteLabel.setSize(150, 100);
		payCompleteLabel.setLocation(35, 20);
		payCompleteDialog.add(payCompleteLabel);
		JButton payCompleteOkButton = new JButton("Ȯ��");
		payCompleteOkButton.setSize(60, 30);
		payCompleteOkButton.setLocation(70, 100);
		payCompleteDialog.add(payCompleteOkButton);

		// �����Ϸ� Ȯ�� Ŭ��
		payCompleteOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ����â ����
				dispose();
			}
		});

		// �����Ϸ� Ȯ�� Ŭ�� �� �˾�
		payDialogOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// ���� �Ϸ� �˾� ���
				payCompleteDialog.setVisible(true);

			}

		});

		JButton exit = new JButton("��������");
		exit.setLocation(280, 500);
		exit.setSize(90, 30);
		this.add(exit);

		// �������� Ŭ���� �˾�
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // â ����
			}
		});

		this.setVisible(true);

	}

}
