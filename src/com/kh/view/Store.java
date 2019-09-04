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

import com.kh.user.model.vo.User;

public class Store extends JFrame {

	Pay p;
	int ownItem1Number;
	int ownItem2Number;
	int ownItem3Number;

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
		store.setLocation(30, 10);
		this.add(store);

		// --------------------------------------------------------------------------------
		// 아이템목록
		JLabel itemList = new JLabel("아이템 목록");
		itemList.setSize(100, 40);
		itemList.setLocation(20, 80);
		this.add(itemList);

		// 아이템1
		JPanel item1 = new JPanel();
		item1.setSize(150, 150);
		item1.setLocation(20, 130);
		item1.setBackground(Color.GRAY);

		JButton item1BuyButton = new JButton("구매");
		item1BuyButton.setSize(60, 40);
		item1BuyButton.setLocation(110, 280);
		this.add(item1);
		this.add(item1BuyButton);

		// 아이템2
		JPanel item2 = new JPanel();
		item2.setSize(150, 150);
		item2.setLocation(250, 130);
		item2.setBackground(Color.GRAY);

		JButton item2BuyButton = new JButton("구매");
		item2BuyButton.setSize(60, 40);
		item2BuyButton.setLocation(340, 280);
		this.add(item2);
		this.add(item2BuyButton);

		// 아이템3
		JPanel item3 = new JPanel();
		item3.setSize(150, 150);
		item3.setLocation(480, 130);
		item3.setBackground(Color.GRAY);

		JButton item3BuyButton = new JButton("구매");
		item3BuyButton.setSize(60, 40);
		item3BuyButton.setLocation(570, 280);
		this.add(item3);
		this.add(item3BuyButton);

		// 랜덤박스
		JPanel randomBox = new JPanel();
		randomBox.setSize(150, 150);
		randomBox.setLocation(710, 130);
		randomBox.setBackground(Color.GRAY);

		JButton randomBoxBuyButton = new JButton("뽑기");
		randomBoxBuyButton.setSize(60, 40);
		randomBoxBuyButton.setLocation(800, 280);
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
		ownItemList.setLocation(20, 400);
		this.add(ownItemList);

		// 보유아이템1
		JPanel ownItem1 = new JPanel();
		ownItem1.setSize(150, 150);
		ownItem1.setLocation(20, 450);
		ownItem1.setBackground(Color.GRAY);
		this.add(ownItem1);

		JLabel ownItem1Label = new JLabel("보유개수 : " + ownItem1Number);
		ownItem1Label.setSize(100, 40);
		ownItem1Label.setLocation(90, 600);
		this.add(ownItem1Label);

		// 보유아이템2
		JPanel ownItem2 = new JPanel();
		ownItem2.setSize(150, 150);
		ownItem2.setLocation(250, 450);
		ownItem2.setBackground(Color.GRAY);
		this.add(ownItem2);

		JLabel ownItem2Label = new JLabel("보유개수 : " + ownItem2Number);
		ownItem2Label.setSize(100, 40);
		ownItem2Label.setLocation(320, 600);
		this.add(ownItem2Label);

		// 보유아이템3
		JPanel ownItem3 = new JPanel();
		ownItem3.setSize(150, 150);
		ownItem3.setLocation(480, 450);
		ownItem3.setBackground(Color.GRAY);
		this.add(ownItem3);

		JLabel ownItem3Label = new JLabel("보유개수 : " + ownItem3Number);
		ownItem3Label.setSize(100, 40);
		ownItem3Label.setLocation(550, 600);
		this.add(ownItem3Label);

		// --------------------------------------------------------------------------------
		// 코인개수 출력
		JLabel ownCoinLabel = new JLabel("내 코인 : " + u.getCoin());
		ownCoinLabel.setSize(100, 40);
		ownCoinLabel.setLocation(200, 30);
		this.add(ownCoinLabel);

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

		// --------------------------------------------------------------------------------
		// 결제버튼
		JButton payButton = new JButton("결제하기");
		payButton.setSize(86, 30);
		payButton.setLocation(300, 30);
		this.add(payButton);

		// 결제버튼 클릭시
		payButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 결제창 팝업 실행
				p = new Pay(u);
			}
		});

		// 이전화면으로
		JButton exit = new JButton("나가기");
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