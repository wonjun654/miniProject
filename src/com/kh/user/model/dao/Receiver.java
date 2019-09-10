package com.kh.user.model.dao;

import java.awt.Color;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kh.model.vo.TempPoint;
import com.kh.part01_main.LoginPage;
import com.kh.user.model.vo.ClientUser;
import com.kh.view.GameRoom;
import com.kh.view.MainMenu;

public class Receiver extends Thread{
	Socket socket;
	Thread sender;
	String userId;
//	ObjectInputStream in;
	DataInputStream in;
	int sX, sY, eX, eY;
	Float stroke;
	Color color = Color.BLACK;
	Graphics g;
	GameRoom game;
	LoginPage lp;
	MainMenu mm;
	Vector<TempPoint> tmp = new Vector<TempPoint>(); 
	Vector<Vector> list = new Vector<Vector>();

	// Socket�� �Ű������� �޴� ������.
	public Receiver(Socket socket, Thread sender, LoginPage lp) {
		this.socket = socket;
		this.sender = sender;
		this.lp = lp;
		try {
//			in = new ObjectInputStream(new DataInputStream(this.socket.getInputStream()));
			in = new DataInputStream(this.socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {			// run()메소드 재정의
		
		try {
		while (in != null) { 	// 입력스트림이 null이 아니면..반복
				String msg = in.readUTF();
				System.out.println("receive");
				if (msg.startsWith("coordinate")) {
					String[] tmpMsg = msg.split(":::");
					tmpMsg = tmpMsg[1].split(",/");
					sX = Integer.parseInt(tmpMsg[0]);
					sY = Integer.parseInt(tmpMsg[1]);
					color = new Color(Integer.parseInt(tmpMsg[2]));
					stroke = Float.parseFloat(tmpMsg[3]);
					game.dragMouse(sX, sY, color, stroke);
					
				} else if (msg.startsWith("press")) {
					String[] tmpMsg = msg.split(":::");
					tmpMsg = tmpMsg[1].split(",/");
					eX = Integer.parseInt(tmpMsg[0]);
					eY = Integer.parseInt(tmpMsg[1]);

					game.pressMouse(eX, eY);
					
				} else if (msg.startsWith("login")) {
					String[] tmpMsg = msg.split(":::");
					tmpMsg = tmpMsg[1].split(":");
					
					boolean result = Boolean.parseBoolean(tmpMsg[0]);
					String userId = tmpMsg[1];
					this.userId = userId;
					String userPw = tmpMsg[2];
					String userName = tmpMsg[3];
					String userEmail = tmpMsg[4];
					String userCoin = tmpMsg[5];
					String userProfile = tmpMsg[6];
					String userMusicSet = tmpMsg[7];
					String userVictory = tmpMsg[8];
					String userAcceptQuest1 = tmpMsg[9];
					String userAcceptQuest2 = tmpMsg[10];
					String userAcceptQuest3 = tmpMsg[11];
					String userQuestClear1 = tmpMsg[12];
					String userQuestClear2 = tmpMsg[13];
					String userQusetClear3 = tmpMsg[14];
					String userItem1 = tmpMsg[15];
					String userItem2 = tmpMsg[16];
					System.out.println(result);
					ClientUser u = new ClientUser(userId, userPw, userName, userEmail, userCoin, userProfile, userMusicSet, userVictory
							, userAcceptQuest1, userAcceptQuest2, userAcceptQuest3, userQuestClear1, userQuestClear2, userQusetClear3
							, userItem1, userItem2);
					lp.resultLogin(result, userId, userPw, userName, userEmail, userCoin, userProfile, userMusicSet, userVictory
							, userAcceptQuest1, userAcceptQuest2, userAcceptQuest3, userQuestClear1, userQuestClear2, userQusetClear3
							, userItem1, userItem2, sender, this);

				}  else if (msg.startsWith("released")) {
					game.releaseMouse();
					
				} else if (msg.startsWith("createRoom")) {
					String[] tmpMsg = msg.split(":::");
					String roomName = tmpMsg[1];
					game = new GameRoom(sender, this, userId, roomName);
					System.out.println("방을 생성했습니다.");
					game.doGame(mm);

				} else if (msg.startsWith("enterRoom")) {
					String[] tmpMsg = msg.split(":::");
					String roomName = tmpMsg[1];
					game = new GameRoom(sender, this, userId, roomName);
					game.doGame(mm);

				} else if (msg.startsWith("sendAllMsg")) {
					String[] tmpMsg = msg.split(":::");
					tmpMsg = tmpMsg[1].split(",/");
					String receiveMsg = tmpMsg[0];
					String fromUserId = tmpMsg[1];
					game.appendChat(fromUserId + " >> " + receiveMsg);

				} else if(msg.startsWith("sendMainRoomMsg")) {
					String[] tmpMsg = msg.split(":::");
					tmpMsg = tmpMsg[1].split(",/");
					String receiveMsg = tmpMsg[0];
					String fromUserId = tmpMsg[1];
					mm.appendChat(fromUserId + " >> " + receiveMsg);
					
				} else if(msg.startsWith("signUp")) {
					String[] tmpMsg = msg.split(":::");
					boolean result = Boolean.parseBoolean(tmpMsg[1]);
					lp.resultSignUp(result);
				} else if(msg.startsWith("failLogin")) {
					JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 확인하세요!");
					
				}
			}  
		} catch (SocketException e) {
			JOptionPane.showMessageDialog(null, "서버와 연결이 끊어졌습니다. 접속을 종료합니다.");
			System.exit(0);
		} catch (Exception e) {
			
		}
	}// run()------
	public void getMainMenu(MainMenu mm) {
		this.mm = mm;
		
	}
}
