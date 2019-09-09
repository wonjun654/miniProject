package com.kh.user.model.dao;

import java.awt.Color;
import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.kh.model.vo.TempPoint;
import com.kh.part01_main.LoginPage;
import com.kh.view.GameRoom;

public class Receiver extends Thread{
	Socket socket;
	Thread sender;
	String userId;
	ObjectInputStream in;
	int sX, sY, eX, eY;
	Float stroke;
	Color color = Color.BLACK;
	Graphics g;
	GameRoom game;
	LoginPage lp;
	JFrame mf;
	Vector<TempPoint> tmp = new Vector<TempPoint>(); 
	Vector<Vector> list = new Vector<Vector>();

	// Socket�� �Ű������� �޴� ������.
	public Receiver(Socket socket, Thread sender, LoginPage lp) {
		this.socket = socket;
		this.sender = sender;
		this.lp = lp;
		
		
	}// ������ --------------------
	
	@Override
	public void run() { // run()�޼ҵ� ������
			try {
				while (in != null) { // �Է½�Ʈ���� null�� �ƴϸ�..�ݺ�
				String msg = in.readUTF();
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
					/*color = new Color(Integer.parseInt(tmpMsg[2]));
					stroke = Float.parseFloat(tmpMsg[3]);*/
					game.pressMouse(eX, eY);
					
				} else if (msg.startsWith("login")) {
					System.out.println("success to login");
					
				} else if (msg.startsWith("login#ok")) {
					System.out.println("�α��μ���");
					
				} else if (msg.startsWith("search")) {
					System.out.println(msg);
					
				} else if (msg.startsWith("released")) {
					game.releaseMouse();
					
				} else if (msg.startsWith("createRoom")) {
					String[] tmpMsg = msg.split(":::");
					String roomName = tmpMsg[1];
					game = new GameRoom(sender, this, userId, roomName);
					System.out.println("���ӹ��� �����߽��ϴ�.");
					game.doGame(mf);

				} else if (msg.startsWith("enterRoom")) {
					String[] tmpMsg = msg.split(":::");
					String roomName = tmpMsg[1];
					game = new GameRoom(sender, this, userId, roomName);
					game.doGame(mf);

				} else if (msg.startsWith("sendAllMsg")) {
					String[] tmpMsg = msg.split(":::");
					tmpMsg = tmpMsg[1].split(",/");
					String receiveMsg = tmpMsg[0];
					String fromUserId = tmpMsg[1];
					game.appendChat(fromUserId + " >> " + receiveMsg);

				} else if(msg.startsWith("signUp")) {
					String[] tmpMsg = msg.split(":::");
					boolean result = Boolean.parseBoolean(tmpMsg[1]);
					if(result) {
						JOptionPane.showMessageDialog(null, "회원가입 성공");
					} else {
						JOptionPane.showMessageDialog(null, "회원가입 실패");
					}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		} // while----
	}// run()------
}
