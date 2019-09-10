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
					System.out.println("receive to login");
					String[] tmpMsg = msg.split(":::");
					tmpMsg = tmpMsg[1].split(":");

					boolean result = Boolean.parseBoolean(tmpMsg[0]);
					String userId = tmpMsg[1];
					this.userId = userId;
					String userPw = tmpMsg[2];
					String userCoin = tmpMsg[3];
					String userItem2 = tmpMsg[4];
					String userItem1 = tmpMsg[5];
					boolean userMusicSet = Boolean.parseBoolean(tmpMsg[6]);
					System.out.println(result);
					lp.resultLogin(result, userId, userPw, userCoin, userItem2, userItem1, userMusicSet,
							sender, this);

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
