package com.kh.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameRoom extends JFrame {

	public GameRoom() {
		this.setTitle("GameRoom");
		this.setLayout(null);
		this.setSize(1024, 768);
		this.setResizable(false);

		// 유저정보
		// 이미지, 닉네임, 게임 내 정답횟수

		// 자리잡기용

		JPanel roomCenter = new JPanel();
		roomCenter.setLayout(null);
		roomCenter.setBackground(Color.BLACK);
		roomCenter.setLocation(262, 0);
		roomCenter.setSize(500, 768);
		//오렌지시작지점 762
		this.add(roomCenter);
		
		JPanel chat = new JPanel();
		chat.setBackground(Color.WHITE);
		chat.setLocation(0, 540);
		chat.setSize(500, 200);
		roomCenter.add(chat);

		JPanel roomRight = new JPanel();
		roomRight.setLayout(null);
		roomRight.setBackground(Color.ORANGE);
		roomRight.setLocation(762, 0);
		roomRight.setSize(262, 768);
		this.add(roomRight);

		JPanel user5 = new JPanel();
		user5.setSize(240, 120);
		user5.setLocation(12, 15);
		roomRight.add(user5);

		JPanel user6 = new JPanel();
		user6.setSize(240, 120);
		user6.setLocation(12, 150);
		roomRight.add(user6);
		
		JPanel user7 = new JPanel();
		user7.setSize(240, 120);
		user7.setLocation(12, 285);
		roomRight.add(user7);
		
		JPanel user8 = new JPanel();
		user8.setSize(240, 120);
		user8.setLocation(12, 420);
		roomRight.add(user8);
		
		JPanel roomLeft = new JPanel();
		roomLeft.setLayout(null);
		roomLeft.setBackground(Color.CYAN);
		roomLeft.setLocation(0, 0);
		roomLeft.setSize(262, 768);
		//블랙 시작지점 262
		this.add(roomLeft);

		JPanel user1 = new JPanel();
		user1.setSize(240, 120);
		user1.setLocation(12, 15);
		roomLeft.add(user1);

		JPanel user2 = new JPanel();
		user2.setSize(240, 120);
		user2.setLocation(12, 150);
		roomLeft.add(user2);
		
		JPanel user3 = new JPanel();
		user3.setSize(240, 120);
		user3.setLocation(12, 285);
		roomLeft.add(user3);
		
		JPanel user4 = new JPanel();
		user4.setSize(240, 120);
		user4.setLocation(12, 420);
		roomLeft.add(user4);
		
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new GameRoom();
	}
}
