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

	JLabel pl = new JLabel(); // 결제금액확인
	JLabel cl = new JLabel(); // 결제방식선택확인
	JLabel presult = new JLabel(); // 결제금액
	JLabel cresult = new JLabel(); // 결제방식
	int scoin; // 코인개수
	JLabel p1 = null; // 코인충전개수확인
	ButtonGroup c = null;
	JRadioButton card = null;
	JRadioButton cash = null;

	public Pay() {
		// super("결제창");

		this.setTitle("결제창");
		this.setLayout(null);
		this.setBounds(100, 50, 400, 600);

		// 결제하기
		JLabel label = new JLabel("결제하기");
		label.setLocation(166, 30);
		label.setSize(80, 30);
		this.add(label);

		// 결제 방식 설정
		JLabel choose = new JLabel("결제 방식");
		choose.setLocation(166, 80);
		choose.setSize(100, 30);
		this.add(choose);

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

		JRadioButton b1 = new JRadioButton("5,000원 : 50개");
		b1.setLocation(130, 180);
		b1.setSize(200, 30);
		JRadioButton b2 = new JRadioButton("10,000원 : 105개");
		b2.setLocation(130, 210);
		b2.setSize(200, 30);
		JRadioButton b3 = new JRadioButton("20,000원 : 210개");
		b3.setLocation(130, 240);
		b3.setSize(200, 30);
		JRadioButton b4 = new JRadioButton("30,000원 : 315개");
		b4.setLocation(130, 270);
		b4.setSize(200, 30);
		JRadioButton b5 = new JRadioButton("50,000원 : 550개");
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

		// 충전하기 팝업창
		Dialog pd = new Dialog(this, "충전하기");
		pd.setLayout(null);
		pd.setSize(300, 300);
		pd.setLocation(150, 150);

		JButton okbutton = new JButton("확인");
		JButton cbutton = new JButton("취소");
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

		this.cresult.setText("방식이 설정되지 않았습니다.");
		this.cresult.setLocation(100, 350);
		this.cresult.setSize(300, 30);
		this.add(this.cresult);

		this.presult.setText("금액이 설정되지 않았습니다.");
		this.presult.setLocation(100, 400);
		this.presult.setSize(300, 30);
		this.add(this.presult);

		// 카드결제 선택 시
		card.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cresult.setText("카드 결제 선택되었습니다.");

			}
		});

		// 계좌이체 선택 시
		cash.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cresult.setText("계좌 이체 선택되었습니다.");

			}
		});

		// 결제금액 선택 시
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 50;
				presult.setText("5,000원 선택되었습니다.");

			}
		});
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 105;
				presult.setText("10,000원 선택되었습니다.");

			}
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 210;
				presult.setText("20,000원 선택되었습니다.");

			}
		});
		b4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 315;
				presult.setText("30,000원 선택되었습니다.");

			}
		});
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				scoin = 550;
				presult.setText("50,000원 선택되었습니다.");

			}
		});

		// 충전하기 버튼
		JButton pay = new JButton("충전하기");
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

		// 아무것도 선택하지 않았을때 경고창
		Dialog nochoose = new Dialog(this, "Error!");
		nochoose.setLayout(null);
		nochoose.setBounds(150, 150, 300, 150);
		JLabel error = new JLabel("결제방식과 금액을 선택해주세요!");
		error.setSize(200, 100);
		error.setLocation(60, 20);
		JButton eb = new JButton("확인");
		eb.setSize(70, 30);
		eb.setLocation(120, 100);
		nochoose.add(error);
		nochoose.add(eb);

		// 충전하기 클릭시 팝업
		pay.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 결제방식이 선택되지 않았을 때
				if (!cash.isSelected() && !card.isSelected()) {

					nochoose.setVisible(true);

					eb.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							nochoose.dispose();

						}
					});

					// 결제금액이 선택되지 않았을 때
				} else if (!b1.isSelected() && !b2.isSelected() && !b3.isSelected() && !b4.isSelected()
						&& !b5.isSelected()) {
					nochoose.setVisible(true);

					eb.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							nochoose.dispose();

						}
					});
					// 결제방식 결제금액 모두 선택 되었을 때
				} else {
					cl.setText(cresult.getText());
					pl.setText(presult.getText());
					p1.setText(scoin + "개 충전하시겠습니까?");
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

		// 충전확인시 방식,금액 확인 팝업
		Dialog ok = new Dialog(this, "충전하기");
		ok.setLayout(null);
		ok.setBounds(200, 200, 200, 150);

		JLabel result = new JLabel("결제가 완료되었습니다.");
		result.setSize(150, 100);
		result.setLocation(35, 20);
		ok.add(result);
		JButton ob = new JButton("확인");
		ob.setSize(60, 30);
		ob.setLocation(70, 100);
		ok.add(ob);

		// 결제완료 확인 클릭
		ob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		// 충전하기 확인 클릭 시 팝업
		okbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ok.setVisible(true);
			}

		});

		JButton exit = new JButton("상점으로");
		exit.setLocation(280, 500);
		exit.setSize(90, 30);
		this.add(exit);

		// 상점으로 클릭시 팝업
		exit.addActionListener(new ActionListener() {
			// 라벨 텍스트 초기화
			// 버튼 클릭 초기화
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose(); // 창 종료
			}
		});
		this.setVisible(true);

	}

}
