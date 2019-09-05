package com.kh.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameRoom extends JFrame{
	
	public GameRoom() {
		this.setTitle("GameRoom");
		this.setLayout(null);
		this.setSize(1024, 768);
		this.setResizable(false);
		
		//자리잡기용
		JPanel roomCenter = new JPanel();
		roomCenter.setBackground(Color.BLACK);
		roomCenter.setLocation(250, 0);
		roomCenter.setSize(500, 768);
		this.add(roomCenter);
		JPanel roomRight = new JPanel();
		roomRight.setBackground(Color.ORANGE);
		roomRight.setLocation(250, 0);
		roomRight.setSize(262, 768);
		this.add(roomRight);
		JPanel roomLeft = new JPanel();
		roomLeft.setBackground(Color.CYAN);
		roomLeft.setLocation(0, 0);
		roomLeft.setSize(262, 768);
		this.add(roomLeft);
		 
		
		
		
		
		
		
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		new GameRoom();
	}
}
