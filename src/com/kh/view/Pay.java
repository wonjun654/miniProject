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

import com.kh.user.model.vo.User;

public class Pay extends JDialog {

	JLabel paySelect = new JLabel(); // 결제금액확인
	JLabel chooseSelect = new JLabel(); // 결제방식선택확인
	JLabel presult = new JLabel(); // 결제금액
	JLabel cresult = new JLabel(); // 결제방식
	int buyCoin; // 코인개수
	JLabel chargeCoinNum = null; // 코인충전개수확인
	ButtonGroup c = null;
	JRadioButton card = null;
	JRadioButton cash = null;
	int mcoin;
	User u = new User();
	
	public Pay(User u) {
		this.setTitle("결제창");
		this.setLayout(null);
		this.setBounds(300, 100, 400, 600);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙

		// --------------------------------------------------------------------------------
		// 결제하기
		JLabel payLabel = new JLabel("결제하기");
		Font font = new Font("고딕", Font.BOLD, 30);
		payLabel.setFont(font);
		payLabel.setLocation(136, 30);
		payLabel.setSize(150, 40);
		this.add(payLabel);

		// 결제 방식 설정
		JLabel payChoose = new JLabel("결제 방식");
		payChoose.setLocation(166, 80);
		payChoose.setSize(100, 30);
		this.add(payChoose);

		card = new JRadioButton("카드 결제");
		cash = new JRadioButton("계좌 이체");

		c = new ButtonGroup();
		c.add(card);
		c.add(cash);

		card.setLocation(100, 110);
		card.setSize(100, 30);
		cash.setLocation(200, 110);
		cash.setSize(100, 30);

		this.add(card);
		this.add(cash);

		// 결제 금액 설정
		JLabel price = new JLabel("결제 금액");
		price.setLocation(166, 150);
		price.setSize(100, 30);
		this.add(price);

		JRadioButton priceButton1 = new JRadioButton("5,000원 : 50개");
		priceButton1.setLocation(130, 180);
		priceButton1.setSize(200, 30);
		JRadioButton priceButton2 = new JRadioButton("10,000원 : 105개");
		priceButton2.setLocation(130, 210);
		priceButton2.setSize(200, 30);
		JRadioButton priceButton3 = new JRadioButton("20,000원 : 210개");
		priceButton3.setLocation(130, 240);
		priceButton3.setSize(200, 30);
		JRadioButton priceButton4 = new JRadioButton("30,000원 : 315개");
		priceButton4.setLocation(130, 270);
		priceButton4.setSize(200, 30);
		JRadioButton priceButton5 = new JRadioButton("50,000원 : 550개");
		priceButton5.setLocation(130, 300);
		priceButton5.setSize(200, 30);
		ButtonGroup p = new ButtonGroup();
		p.add(priceButton1);
		p.add(priceButton2);
		p.add(priceButton3);
		p.add(priceButton4);
		p.add(priceButton5);

		this.add(priceButton1);
		this.add(priceButton2);
		this.add(priceButton3);
		this.add(priceButton4);
		this.add(priceButton5);

		// --------------------------------------------------------------------------------
		// 충전하기 팝업창
		Dialog payDialog = new Dialog(this, "충전하기");
		payDialog.setLayout(null);
		payDialog.setSize(300, 300);
		payDialog.setLocation((screenSize.width - payDialog.getWidth()) / 2,
				(screenSize.height - payDialog.getHeight()) / 2);

		JButton payDialogOkButton = new JButton("확인");
		JButton payDialogCancelButton = new JButton("취소");

		payDialogOkButton.setLocation(100, 250);
		payDialogOkButton.setSize(75, 30);
		payDialogCancelButton.setLocation(200, 250);
		payDialogCancelButton.setSize(75, 30);

		payDialog.add(payDialogCancelButton);
		payDialog.add(payDialogOkButton);

		this.cresult.setText("방식이 설정되지 않았습니다.");
		this.cresult.setLocation(100, 350);
		this.cresult.setSize(300, 30);
		this.add(this.cresult);

		this.presult.setText("금액이 설정되지 않았습니다.");
		this.presult.setLocation(100, 400);
		this.presult.setSize(300, 30);
		this.add(this.presult);

		// -----------------------------------------------------
		// 카드결제 선택시 번호 입력
		Dialog cardNumberInput = new Dialog(payDialog, "카드번호 입력");
		cardNumberInput.setLayout(null);
		cardNumberInput.setSize(400, 250);
		cardNumberInput.setLocation((screenSize.width - cardNumberInput.getWidth()) / 2,
				(screenSize.height - cardNumberInput.getHeight()) / 2);
		JLabel cardNumberLabel = new JLabel("카드번호 입력");
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
		JButton cardNumberInputOkButton = new JButton("확인");
		cardNumberInputOkButton.setSize(60, 40);
		cardNumberInputOkButton.setLocation(200, 180);
		JButton cardNumberInputCalcelButton = new JButton("취소");
		cardNumberInputCalcelButton.setSize(60, 40);
		cardNumberInputCalcelButton.setLocation(280, 180);
		JLabel cardNumberInputCancelMsg = new JLabel("취소버튼을 누르면 상점화면으로 돌아갑니다.");
		cardNumberInputCancelMsg.setSize(300, 40);
		cardNumberInputCancelMsg.setLocation(70, 210);

		Dialog cardNumberError = new Dialog(cardNumberInput, "nochooseLabel!");
		cardNumberError.setModal(false);
		cardNumberError.setLayout(null);
		cardNumberError.setSize(200, 150);
		cardNumberError.setLocation((screenSize.width - cardNumberError.getWidth()) / 2,
				(screenSize.height - cardNumberError.getHeight()) / 2);
		JLabel cardNumberErrorLabel = new JLabel("카드번호를 입력해주세요.");
		cardNumberErrorLabel.setSize(150, 50);
		cardNumberErrorLabel.setLocation(30, 40);
		JButton cardNumberErrorOkButton = new JButton("확인");
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

		// 계좌이체 선택시 번호입력
		Dialog cashNumberInput = new Dialog(payDialog, "계좌번호 입력");
		cashNumberInput.setLayout(null);
		cashNumberInput.setSize(400, 250);
		cashNumberInput.setLocation((screenSize.width - cashNumberInput.getWidth()) / 2,
				(screenSize.height - cashNumberInput.getHeight()) / 2);
		JLabel cashNumberLabel = new JLabel("계좌번호 입력");
		cashNumberLabel.setSize(150, 40);
		cashNumberLabel.setLocation(60, 50);
		JTextField cashText = new JTextField();
		cashText.setSize(200, 40);
		cashText.setLocation(120, 100);
		JButton cashNumberInputOkButton = new JButton("확인");
		cashNumberInputOkButton.setSize(60, 40);
		cashNumberInputOkButton.setLocation(170, 180);
		JButton cashNumberInputCancelButton = new JButton("취소");
		cashNumberInputCancelButton.setSize(60, 40);
		cashNumberInputCancelButton.setLocation(250, 180);
		JLabel cashNumberInputCancelMsg = new JLabel("취소버튼을 누르면 상점화면으로 돌아갑니다.");
		cashNumberInputCancelMsg.setSize(300, 40);
		cashNumberInputCancelMsg.setLocation(70, 210);

		Dialog cashNumberError = new Dialog(cashNumberInput, "nochooseLabel!");
		cashNumberError.setLayout(null);
		cashNumberError.setSize(200, 150);
		cashNumberError.setLocation((screenSize.width - cashNumberError.getWidth()) / 2,
				(screenSize.height - cashNumberInput.getHeight()) / 2);
		JLabel cashNumberErrorLabel = new JLabel("계좌번호를 입력해주세요.");
		cashNumberErrorLabel.setSize(150, 50);
		cashNumberErrorLabel.setLocation(30, 40);
		JButton cashNumberErrorOkButton = new JButton("확인");
		cashNumberErrorOkButton.setSize(60, 40);
		cashNumberErrorOkButton.setLocation(72, 90);
		cashNumberError.add(cashNumberErrorOkButton);
		cashNumberError.add(cashNumberErrorLabel);

		// 은행선택
		String[] banks = { "신한", "하나", "농협", "카카오", "대구", "부산" };
		JComboBox banklist = new JComboBox(banks);
		banklist.setSize(60, 40);
		banklist.setLocation(60, 100);
		cashNumberInput.add(cashNumberLabel);
		cashNumberInput.add(cashNumberInputOkButton);
		cashNumberInput.add(cashNumberInputCancelButton);
		cashNumberInput.add(cashText);
		cashNumberInput.add(banklist);
		cashNumberInput.add(cashNumberInputCancelMsg);

		// 카드결제 선택 시
		card.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 카드결제 선택 출력
				cresult.setText("카드 결제 선택되었습니다.");

			}
		});

		// 계좌이체 선택 시
		cash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 계좌이체 선택 출력
				cresult.setText("계좌 이체 선택되었습니다.");

			}
		});

		// 결제금액 선택 시
		// 구매할 코인개수 넘겨준 후, 결제금액 출력
		priceButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 50;
				presult.setText("5,000원 선택되었습니다.");

			}
		});
		priceButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 105;
				presult.setText("10,000원 선택되었습니다.");

			}
		});
		priceButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 210;
				presult.setText("20,000원 선택되었습니다.");

			}
		});
		priceButton4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 315;
				presult.setText("30,000원 선택되었습니다.");

			}
		});
		priceButton5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				buyCoin = 550;
				presult.setText("50,000원 선택되었습니다.");

			}
		});

		// --------------------------------------------------------------------------------
		// 충전하기 버튼
		JButton payButton = new JButton("충전하기");
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

		// 아무것도 선택하지 않았을때 경고창
		Dialog nochooseDialog = new Dialog(this, "nochooseLabel!");
		nochooseDialog.setLayout(null);
		nochooseDialog.setSize(300, 150);
		nochooseDialog.setLocation((screenSize.width - nochooseDialog.getWidth()) / 2,
				(screenSize.height - nochooseDialog.getHeight()) / 2);

		JLabel nochooseLabel = new JLabel("결제방식과 금액을 선택해주세요!");
		nochooseLabel.setSize(200, 100);
		nochooseLabel.setLocation(60, 20);
		JButton nochooseOkButton = new JButton("확인");
		nochooseOkButton.setSize(70, 30);
		nochooseOkButton.setLocation(120, 100);
		nochooseDialog.add(nochooseLabel);
		nochooseDialog.add(nochooseOkButton);

		// 충전하기 클릭시 팝업

		payButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 결제방식이 선택되지 않았을 때
				if (!cash.isSelected() && !card.isSelected()) {
					// 경고창 띄움
					nochooseDialog.setVisible(true);

					// 경고창 확인버튼 클릭시
					nochooseOkButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// 경고창 사라짐
							nochooseDialog.dispose();

						}
					});

					// 결제금액이 선택되지 않았을 때
				} else if (!priceButton1.isSelected() && !priceButton2.isSelected() && !priceButton3.isSelected() && !priceButton4.isSelected()
						&& !priceButton5.isSelected()) {
					// 경고창 띄움
					nochooseDialog.setVisible(true);

					// 경고창 확인버튼 클릭시
					nochooseOkButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// 경고창 사라짐
							nochooseDialog.dispose();

						}
					});
					// 결제방식 결제금액 모두 선택 되었을 때
				} else {

					// 카드 선택
					if (card.isSelected()) {
						// 카드번호 입력 팝업 출력
						cardNumberInput.setVisible(true);

						// 카드번호 입력 팝업 확인 버튼 클릭
						cardNumberInputOkButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// 카드번호 미입력시
								if (cardNumberText1.getText().isEmpty() || cardNumberText2.getText().isEmpty()
										|| cardNumberText3.getText().isEmpty() || cardNumberText4.getText().isEmpty()) {
									// 카드번호 미입력 에러 팝업 출력
									cardNumberError.setVisible(true);

									// 카드번호 입력시
								} else {
									// 카드번호 입력 팝업 사라짐
									cardNumberInput.dispose();
									// 입력된 카드번호 가져와서 출력
									chooseSelect.setText("카드번호 : " + cardNumberText1.getText() + "-"
											+ cardNumberText2.getText() + "-" + cardNumberText3.getText() + "-"
											+ cardNumberText4.getText());
									// 선택된 결제방식 가져와서 출력
									paySelect.setText(presult.getText());
									// 충전할 코인개수 가져와서 출력
									chargeCoinNum.setText(buyCoin + "개 충전하시겠습니까?");
									u.setCoin(u.getCoin() + buyCoin);
									payDialog.setVisible(true);
								}

								// 입력된 값 초기화
								cardNumberText1.setText(null);
								cardNumberText2.setText(null);
								cardNumberText3.setText(null);
								cardNumberText4.setText(null);

							}
						});
					}

					// 계좌이체 선택
					if (cash.isSelected()) {
						// 계좌번호 입력 팝업 출력
						cashNumberInput.setVisible(true);

						// 확인버튼 클릭
						cashNumberInputOkButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// 계좌번호 미 입력시
								if (cashText.getText().isEmpty()) {
									// 계좌번호 미입력 에러 팝업 출력
									cashNumberError.setVisible(true);
								}

								// 계좌번호 입력시
								if (!cashText.getText().isEmpty()) {
									// 계좌번호 입력 팝업 사라짐
									cashNumberInput.dispose();
									// 입력된 계좌번호 가져와서 출력
									chooseSelect.setText(banklist.getSelectedItem() + " - " + cashText.getText());
									// 선택된 결제방식 가져와서 출력
									paySelect.setText(presult.getText());
									// 충전할 코인계수 가져와서 출력
									chargeCoinNum.setText(buyCoin + "개 충전하시겠습니까?");
									u.setCoin(u.getCoin() + buyCoin);
									payDialog.setVisible(true);
								}
								// 입력된 값 초기화
								cashText.setText(null);

							}
						});

					}

				}
			}
		});

		// 충전확인버튼
		payDialogCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 충전하기 팝업 사라짐
				payDialog.dispose();

			}
		});

		// 카드결제 에러 확인버튼
		cardNumberErrorOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 카드번호 입력 에러 팝업 사라짐
				cardNumberError.dispose();
			}
		});

		// 카드번호입력 취소버튼
		cardNumberInputCalcelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 결제창 종료
				cardNumberText1.setText(null);
				cardNumberText2.setText(null);
				cardNumberText3.setText(null);
				cardNumberText4.setText(null);
				dispose();

			}
		});

		// 계좌이체 에러 확인버튼
		cashNumberErrorOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 계좌번호 입력 에러 팝업 사라짐
				cashNumberError.dispose();
			}
		});

		// 계좌번호입력 취소버튼
		cashNumberInputCancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 입력된 카드번호 초기화 후 결제창 종료
				cashText.setText(null);
				dispose();
			}
		});

		// --------------------------------------------------------------------------------
		// 충전확인시 방식,금액 확인 팝업
		Dialog payCompleteDialog = new Dialog(this, "충전완료");
		payCompleteDialog.setLayout(null);
		payCompleteDialog.setSize(200, 150);
		payCompleteDialog.setLocation((screenSize.width - payCompleteDialog.getWidth()) / 2,
				(screenSize.height - payCompleteDialog.getHeight()) / 2);

		JLabel payCompleteLabel = new JLabel("결제가 완료되었습니다.");
		payCompleteLabel.setSize(150, 100);
		payCompleteLabel.setLocation(35, 20);
		payCompleteDialog.add(payCompleteLabel);
		JButton payCompleteOkButton = new JButton("확인");
		payCompleteOkButton.setSize(60, 30);
		payCompleteOkButton.setLocation(70, 100);
		payCompleteDialog.add(payCompleteOkButton);

		// 결제완료 확인 클릭
		payCompleteOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 결제창 종료
				dispose();
			}
		});

		// 충전완료 확인 클릭 시 팝업
		payDialogOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 결제 완료 팝업 출력
				payCompleteDialog.setVisible(true);
				u.setCoin(u.getCoin());
			}

		});

		JButton exit = new JButton("상점으로");
		exit.setLocation(280, 500);
		exit.setSize(90, 30);
		this.add(exit);

		// 상점으로 클릭시 팝업
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 창 종료
			}
		});

		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}

}
