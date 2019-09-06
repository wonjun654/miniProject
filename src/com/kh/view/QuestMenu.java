package com.kh.view;

import java.awt.Color;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.user.controller.UserManager;
import com.kh.user.model.vo.User;

import javafx.scene.layout.Pane;

public class QuestMenu extends JFrame {

	ImageIcon background;


	public QuestMenu(User user) {
		String[] qusetList = new String[3];
		qusetList[0] = "코인100개소유";
		qusetList[1] = "주먹밥쿵야 10개 모으기";
		qusetList[2] = "처음으로 우승해보기";

		UserManager um = new UserManager();
		this.setBounds(420, 100, 600, 600);

		background = new ImageIcon("images/login.PNG");
		JPanel Panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(background.getImage(), 0, 0, null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};

		Panel.setLocation(30, 30);
		Panel.setSize(600, 600);
		/////////////////////////////////////////////////////

		JTextField questList1 = new JTextField(qusetList[0], 15);
		questList1.setEditable(false);
		questList1.setLocation(50, 70);
		questList1.setSize(300, 60);
		questList1.setBackground(Color.BLUE);

		JTextField questList2 = new JTextField(qusetList[1], 15);
		questList2.setEditable(false);
		questList2.setLocation(50, 190);
		questList2.setSize(300, 60);
		questList2.setBackground(Color.BLUE);

		JTextField questList3 = new JTextField(qusetList[2], 15);
		questList3.setEditable(false);
		questList3.setLocation(50, 310);
		questList3.setSize(300, 60);
		questList3.setBackground(Color.BLUE);

		JLabel title = new JLabel("퀘스트 목록");
		title.setSize(150, 60);
		title.setLocation(250, 0);

		JButton button = new JButton("확인");
		button.setSize(80, 30);
		button.setLocation(470, 480);

		JButton clearButton1 = new JButton("보상받기");
		clearButton1.setSize(80, 30);
		clearButton1.setLocation(470, 80);

		JButton clearButton2 = new JButton("보상받기");
		clearButton2.setSize(80, 30);
		clearButton2.setLocation(470, 200);

		JButton clearButton3 = new JButton("보상받기");
		clearButton3.setSize(80, 30);
		clearButton3.setLocation(470, 325);

		JButton acceptButton1 = new JButton("수락");
		acceptButton1.setSize(80, 30);
		acceptButton1.setLocation(380, 80);
		if(user.getAcceptQuest1()==true) {
			acceptButton1.setEnabled(false);
		}
		JButton acceptButton2 = new JButton("수락");
		acceptButton2.setSize(80, 30);
		acceptButton2.setLocation(380, 200);

		if(user.getAcceptQuest2()==true) {
			acceptButton2.setEnabled(false);
		}
		JButton acceptButton3 = new JButton("수락");
		acceptButton3.setSize(80, 30);
		acceptButton3.setLocation(380, 325);
		
		if(user.getAcceptQuest3()==true) {
			acceptButton3.setEnabled(false);
		}
		JButton sdButton = new JButton();
		sdButton.setSize(60,60);
		sdButton.setLocation(60, 60);
	
		
		Dialog sd = new Dialog(this,"^^");
		sd.setBounds(800, 250, 400, 500);
		sd.setLayout(null);
		sd.add(sdButton);
		
		sdButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					sd.setVisible(false);
			}
		});
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

		clearButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(user.getAcceptQuest1()==true&&um.selectOneUser("123").getCoin()>=100) {
					System.out.println("줌");
					sd.setVisible(true);
					
				}
			}
		});
		
		clearButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(user.getAcceptQuest2()==true&&um.selectOneUser("123").getOwnItem1()>=10) {
					System.out.println("줌");
					sd.setVisible(true);
					
				}

			}
		});

		clearButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(user.getAcceptQuest3()==true&&um.selectOneUser("123").getVictory()>=1) {
					System.out.println("3333줌");
					sd.setVisible(true);
				}
			}
		});

		acceptButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acceptButton1.setEnabled(false);
				user.setAcceptQuest1(true); 
				um.updateUser(user);
				
			

			}
		});
		
		acceptButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acceptButton2.setEnabled(false);
				user.setAcceptQuest2(true); 
				um.updateUser(user);

			}
		});

		acceptButton3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				acceptButton3.setEnabled(false);
				user.setAcceptQuest3(true); 
				um.updateUser(user);

			}
		});
		
		
		
		
		this.add(Panel);

		Panel.add(button);
		Panel.add(clearButton1);
		Panel.add(clearButton2);
		Panel.add(clearButton3);
		Panel.add(acceptButton1);
		Panel.add(acceptButton2);
		Panel.add(acceptButton3);

		Panel.add(title);
		Panel.add(questList1);
		Panel.add(questList2);
		Panel.add(questList3);
		Panel.setLayout(null);

		this.add(Panel);

	}

}
