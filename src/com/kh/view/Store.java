package com.kh.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.kh.user.controller.UserManager;
import com.kh.user.model.vo.User;

public class Store extends JFrame {

	int ownItem1Number;
	int ownItem2Number;
	int ownItem3Number;

	JLabel paySelect = new JLabel(); // 결제금액확인
	JLabel chooseSelect = new JLabel(); // 결제방식선택확인
	JLabel presult = new JLabel(); // 결제금액
	JLabel cresult = new JLabel(); // 결제방식
	int buyCoin; // 코인개수
	JLabel chargeCoinNum = null; // 코인충전개수확인
	ButtonGroup c = null;
	JRadioButton card = null;
	JRadioButton cash = null;
	UserManager um = new UserManager();
	
	public Store(User u) {
		this.setLayout(null);
		this.setSize(1024, 768);
		this.setResizable(false);
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙
		
		// 상점이름
		JLabel store = new JLabel("상점");
		Font font = new Font("고딕", Font.BOLD, 50);
		store.setFont(font);
		store.setSize(150, 80);
		store.setLocation(60, 10);
		this.add(store);

		// --------------------------------------------------------------------------------
		// 아이템목록
		JLabel itemList = new JLabel("아이템 목록");
		itemList.setSize(100, 40);
		itemList.setLocation(60, 80);
		this.add(itemList);

		// 아이템1
		JPanel item1 = new JPanel();
		item1.setSize(150, 150);
		item1.setLocation(60, 130);
		item1.setBackground(Color.GRAY);

		JButton item1BuyButton = new JButton("구매");
		item1BuyButton.setSize(60, 40);
		item1BuyButton.setLocation(150, 280);
		this.add(item1);
		this.add(item1BuyButton);

		// 아이템2
		JPanel item2 = new JPanel();
		item2.setSize(150, 150);
		item2.setLocation(290, 130);
		item2.setBackground(Color.GRAY);

		JButton item2BuyButton = new JButton("구매");
		item2BuyButton.setSize(60, 40);
		item2BuyButton.setLocation(380, 280);
		this.add(item2);
		this.add(item2BuyButton);

		// 아이템3
		JPanel item3 = new JPanel();
		item3.setSize(150, 150);
		item3.setLocation(520, 130);
		item3.setBackground(Color.GRAY);

		JButton item3BuyButton = new JButton("구매");
		item3BuyButton.setSize(60, 40);
		item3BuyButton.setLocation(610, 280);
		this.add(item3);
		this.add(item3BuyButton);

		// 랜덤박스
		JPanel randomBox = new JPanel();
		randomBox.setSize(150, 150);
		randomBox.setLocation(750, 130);
		randomBox.setBackground(Color.GRAY);

		JButton randomBoxBuyButton = new JButton("뽑기");
		randomBoxBuyButton.setSize(60, 40);
		randomBoxBuyButton.setLocation(840, 280);
		this.add(randomBox);
		this.add(randomBoxBuyButton);

		// 랜덤박스뽑기 결과
		Dialog randomBoxResultDialog = new Dialog(this, "랜덤박스");
		randomBoxResultDialog.setResizable(false);
		randomBoxResultDialog.setLayout(null);
		randomBoxResultDialog.setSize(300, 300);
		randomBoxResultDialog.setLocation((screenSize.width - randomBoxResultDialog.getWidth()) / 2,
				(screenSize.height - randomBoxResultDialog.getHeight()) / 2);
		// 뽑기결과 아이템 이미지
		JLabel randomBoxLabel = new JLabel();
		randomBoxLabel.setBounds(75, 60, 150, 140);
		randomBoxResultDialog.add(randomBoxLabel);

		// 뽑기 결과 출력 후 확인 버튼
		JButton randomBoxDialogOkButton = new JButton("확인");
		randomBoxDialogOkButton.setBounds(120, 250, 60, 30);
		randomBoxResultDialog.add(randomBoxDialogOkButton);

		// 아이템 획득 결과
		JLabel randomBoxResultLabel = new JLabel();
		randomBoxResultLabel.setBounds(120, 200, 200, 30);
		randomBoxResultDialog.add(randomBoxResultLabel);

		// --------------------------------------------------------------------------------
		// 보유아이템
		JLabel ownItemList = new JLabel("보유아이템");
		ownItemList.setSize(100, 40);
		ownItemList.setLocation(60, 400);
		this.add(ownItemList);

		// 보유아이템1
		JPanel ownItem1 = new JPanel();
		ownItem1.setSize(150, 150);
		ownItem1.setLocation(60, 450);
		ownItem1.setBackground(Color.GRAY);
		this.add(ownItem1);

		JLabel ownItem1Label = new JLabel("보유개수 : " + ownItem1Number);
		ownItem1Label.setSize(100, 40);
		ownItem1Label.setLocation(150, 600);
		this.add(ownItem1Label);

		// 보유아이템2
		JPanel ownItem2 = new JPanel();
		ownItem2.setSize(150, 150);
		ownItem2.setLocation(290, 450);
		ownItem2.setBackground(Color.GRAY);
		this.add(ownItem2);

		JLabel ownItem2Label = new JLabel("보유개수 : " + ownItem2Number);
		ownItem2Label.setSize(100, 40);
		ownItem2Label.setLocation(360, 600);
		this.add(ownItem2Label);

		// 보유아이템3
		JPanel ownItem3 = new JPanel();
		ownItem3.setSize(150, 150);
		ownItem3.setLocation(520, 450);
		ownItem3.setBackground(Color.GRAY);
		this.add(ownItem3);

		JLabel ownItem3Label = new JLabel("보유개수 : " + ownItem3Number);
		ownItem3Label.setSize(100, 40);
		ownItem3Label.setLocation(590, 600);
		this.add(ownItem3Label);

		// --------------------------------------------------------------------------------
		// 코인개수 출력
		JLabel ownCoinLabel = new JLabel("내 코인 : " + u.getCoin());
		ownCoinLabel.setSize(100, 40);
		ownCoinLabel.setLocation(300, 50);
		this.add(ownCoinLabel);
		
		Image icon = new ImageIcon("images/coin.jpg").getImage().getScaledInstance(75, 75, 0);
		JLabel coinimg = new JLabel(new ImageIcon(icon));
		coinimg.setSize(75, 75);
		coinimg.setLocation(215, 30);
		this.add(coinimg);
		
		Dialog itemBuyDialog = new Dialog(this, "아이템 구매");
		itemBuyDialog.setResizable(false);
		itemBuyDialog.setLayout(null);
		itemBuyDialog.setSize(200, 160);
		itemBuyDialog.setLocation((screenSize.width - itemBuyDialog.getWidth()) / 2,
				(screenSize.height - itemBuyDialog.getHeight()) / 2);
		JLabel itemBuyDialogLabel = new JLabel("구매하시겠습니까?");
		itemBuyDialogLabel.setSize(150, 40);
		itemBuyDialogLabel.setLocation(50, 50);
		itemBuyDialog.add(itemBuyDialogLabel);
		JButton itemBuyDialogBuyButton = new JButton("구매");
		itemBuyDialogBuyButton.setSize(60, 40);
		itemBuyDialogBuyButton.setLocation(70, 100);
		itemBuyDialog.add(itemBuyDialogBuyButton);

		// --------------------------------------------------------------------------------
		// 아이템1 구매시
		item1BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 보유코인 아이템구매에 필요한 코인만큼 감소후
				// 아이템1의 개수 1 증가

				u.setCoin(u.getCoin() - 1);
				ownItem1Number++;
				itemBuyDialog.setVisible(true);

				// 구매버튼 클릭시
				itemBuyDialogBuyButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 아이템1 보유개수 출력
						ownItem1Label.setText("보유개수 : " + ownItem1Number);
						// 보유코인개수 출력
						ownCoinLabel.setText("내 코인 : " + u.getCoin());
						itemBuyDialog.dispose();

					}
				});

			}
		});

		// 아이템2 구매시
		item2BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 보유코인 아이템구매에 필요한 코인만큼 감소후
				// 아이템2의 개수 1 증가
				u.setCoin(u.getCoin() - 1);
				ownItem2Number++;
				itemBuyDialog.setVisible(true);

				// 구매버튼 클릭시
				itemBuyDialogBuyButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 아이템2 보유개수 출력
						ownItem2Label.setText("보유개수 : " + ownItem2Number);
						// 보유코인개수 출력
						ownCoinLabel.setText("내 코인 : " + u.getCoin());
						itemBuyDialog.dispose();

					}
				});

			}
		});

		// 아이템3 구매시
		item3BuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 보유코인 아이템구매에 필요한 코인만큼 감소후
				// 아이템3의 개수 1 증가
				u.setCoin(u.getCoin() - 1);
				ownItem3Number++;
				itemBuyDialog.setVisible(true);

				// 구매버튼 클릭시
				itemBuyDialogBuyButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 아이템3 보유개수 출력
						ownItem3Label.setText("보유개수 : " + ownItem3Number);
						// 보유코인개수 출력
						ownCoinLabel.setText("내 코인 : " + u.getCoin());
						itemBuyDialog.dispose();

					}
				});

			}
		});

		// 랜덤박스 뽑기 결과 창
		// 랜덤변수에 따른 아이템이미지와 결과텍스트 출력
		randomBoxBuyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 랜덤박스 결과창 출력
				randomBoxResultDialog.setVisible(true);
				// 보유코인 랜덤박스 구매에 필요한 개수만큼 감소
				u.setCoin(u.getCoin() - 1);
				// 랜덤박스를 위한 변수 설정
				int rbn = (int) ((Math.random() * 3) + 1);
				// 변수에 따른 아이템 이미지 및 개수증가 설정
				// 변수 1이 나왔을 때
				if (rbn == 1) {
					Image icon = new ImageIcon("C:\\Users\\user2\\Desktop\\캡처.png").getImage().getScaledInstance(150,
							140, 0);
					randomBoxLabel.setIcon(new ImageIcon(icon));
					randomBoxResultLabel.setText("양파쿵야");
					// 아이템1의 개수 1 증가
					ownItem1Number++;
					// 아이템1 개수 출력
					ownItem1Label.setText("보유개수 : " + ownItem1Number);
					// 코인개수 출력
					ownCoinLabel.setText("내 코인 : " + u.getCoin());
					// 변수 2 나왔을 때
				} else if (rbn == 2) {
					Image icon = new ImageIcon("C:\\Users\\user2\\Desktop\\캡처1.png").getImage().getScaledInstance(150,
							140, 0);
					randomBoxLabel.setIcon(new ImageIcon(icon));
					randomBoxResultLabel.setText("양배추 쿵야");
					// 아이템2 개수 1증사
					ownItem2Number++;
					// 아이템2 개수 출력
					ownItem2Label.setText("보유개수 : " + ownItem2Number);
					// 코인개수 출력
					ownCoinLabel.setText("내 코인 : " + u.getCoin());
					// 변수 3 나왔을 때
				} else if (rbn == 3) {
					Image icon = new ImageIcon("C:\\Users\\user2\\Desktop\\캡처2.png").getImage().getScaledInstance(150,
							140, 0);
					randomBoxLabel.setIcon(new ImageIcon(icon));
					randomBoxResultLabel.setText("무시 쿵야");
					// 아이템3 개수 1 증가
					ownItem3Number++;
					// 아이템3 개수 출력
					ownItem3Label.setText("보유개수 : " + ownItem3Number);
					// 코인개수 출력
					ownCoinLabel.setText("내 코인 : " + u.getCoin());
				}

				// 뽑기결과 출력 후 확인 버튼
				randomBoxDialogOkButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 뽑기결과 종료
						randomBoxResultDialog.dispose();

					}
				});
			}
		});

		// 결제창-------------------------------------------------------------------------
		// ------------------------------------------------------------------------------
		Dialog pay = new Dialog(this, "결제창");
		pay.setLayout(null);
		pay.setBounds(300, 100, 400, 600);
		pay.setResizable(false);

		pay.setLocation((screenSize.width - pay.getWidth()) / 2, (screenSize.height - pay.getHeight()) / 2); // 화면 중앙

		// --------------------------------------------------------------------------------
		// 결제하기
		JLabel payLabel = new JLabel("결제하기");
		Font payfont = new Font("고딕", Font.BOLD, 30);
		payLabel.setFont(payfont);
		payLabel.setLocation(136, 30);
		payLabel.setSize(150, 40);
		pay.add(payLabel);

		// 결제 방식 설정
		JLabel payChoose = new JLabel("결제 방식");
		payChoose.setLocation(166, 80);
		payChoose.setSize(100, 30);
		pay.add(payChoose);

		card = new JRadioButton("카드 결제");
		cash = new JRadioButton("계좌 이체");

		c = new ButtonGroup();
		c.add(card);
		c.add(cash);

		card.setLocation(100, 110);
		card.setSize(100, 30);
		cash.setLocation(200, 110);
		cash.setSize(100, 30);

		pay.add(card);
		pay.add(cash);

		// 결제 금액 설정
		JLabel price = new JLabel("결제 금액");
		price.setLocation(166, 150);
		price.setSize(100, 30);
		pay.add(price);

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

		pay.add(priceButton1);
		pay.add(priceButton2);
		pay.add(priceButton3);
		pay.add(priceButton4);
		pay.add(priceButton5);

		// --------------------------------------------------------------------------------
		// 충전하기 팝업창
		Dialog payDialog = new Dialog(pay, "충전하기");
		payDialog.setResizable(false);
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
		pay.add(this.cresult);

		this.presult.setText("금액이 설정되지 않았습니다.");
		this.presult.setLocation(100, 400);
		this.presult.setSize(300, 30);
		pay.add(this.presult);

		// -----------------------------------------------------
		// 카드결제 선택시 번호 입력
		Dialog cardNumberInput = new Dialog(payDialog, "카드번호 입력");
		cardNumberInput.setResizable(false);
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
		cardNumberError.setResizable(false);
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
		cashNumberInput.setResizable(false);
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

		Dialog cashNumberError = new Dialog(cashNumberInput, "Error!");
		cashNumberError.setResizable(false);
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
		JButton payDialogPayButton = new JButton("충전하기");
		payDialogPayButton.setLocation(180, 500);
		payDialogPayButton.setSize(90, 30);
		pay.add(payDialogPayButton);

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
		Dialog nochooseDialog = new Dialog(payDialog, "Error!");
		nochooseDialog.setResizable(false);
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

		payDialogPayButton.addActionListener(new ActionListener() {

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
				} else if (!priceButton1.isSelected() && !priceButton2.isSelected() && !priceButton3.isSelected()
						&& !priceButton4.isSelected() && !priceButton5.isSelected()) {
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
									um.updateUser(u);
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
									um.updateUser(u);
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

		// 충전취소버튼
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
				payDialog.dispose();

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
				payDialog.dispose();
			}
		});

		// --------------------------------------------------------------------------------
		// 충전확인시 방식,금액 확인 팝업
		Dialog payCompleteDialog = new Dialog(pay, "충전완료");
		payCompleteDialog.setResizable(false);
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

		// payCompleteDialog.setBackground(Color.GREEN); //팝업창 배경색
		// payCompleteLabel.setForeground(Color.WHITE); //라벨 글씨색
		// payCompleteOkButton.setBackground(Color.CYAN); //버튼 배경색
		// payCompleteOkButton.setForeground(Color.WHITE); //버튼 글씨색

		// 충전하기 확인 클릭 시 팝업
		payDialogOkButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 충전 완료 팝업 출력
				payCompleteDialog.setVisible(true);

				// 충전완료 확인 클릭
				payCompleteOkButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// 결제창 종료
						pay.dispose();
						//보유코인개수 수정
						ownCoinLabel.setText("내 코인 : " + u.getCoin());
						um.updateUser(u);
						System.out.println(u.getCoin());
					}
				});
			}

		});

		JButton payexit = new JButton("상점으로");
		payexit.setLocation(280, 500);
		payexit.setSize(90, 30);
		pay.add(payexit);

		// 상점으로 클릭시 팝업
		payexit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				um.updateUser(u);
				pay.dispose(); // 창 종료
			}
		});
		// --------------------------------------------------------------------------------
		// 결제버튼
		JButton payButton = new JButton("결제하기");
		payButton.setSize(86, 30);
		payButton.setLocation(400, 50);
		this.add(payButton);

		// 결제버튼 클릭시
		payButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 결제창 팝업 실행
				um.updateUser(u);
				pay.setVisible(true);
			}
		});

		// 이전화면으로
		JButton exit = new JButton("나가기");
		exit.setSize(100, 30);
		exit.setLocation(800, 650);
		this.add(exit);

		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				um.updateUser(u);
				dispose();
			}
		});

		this.setVisible(true);
		this.setLocationRelativeTo(null);

	}
}
