package com.kh.user.model.vo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Sender extends Thread {
	Socket socket;
	ObjectOutputStream out;
	String userId;
	String roomName;
	
	public Sender(Socket socket) { // Ŭ���̾�Ʈ�� ���ϰ� ���̵�
		this.socket = socket;
		try {
			out = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
		} catch (IOException e) {
			System.out.println("Sender ������ Exception �߻�");
			e.printStackTrace();
		}
	}

	@Override
	public void run() { // run()�޼ҵ� ������
		// ������ �Է��� ������̸��� �����ش�.
		/*try {
			out.writeUTF("login:::" + userId);
			out.flush();
		} catch (IOException e) {
			System.out.println("�α��� Exception!!! : ");
			e.printStackTrace();
		}*/
	}// run()------

	public void sendCoordinate(int x, int y, int sendColor, float stroke, String roomName) {
		try {
			out.writeUTF("coordinate:::" + x + ",/" + y + ",/" + sendColor + ",/" + stroke + ",/" + roomName + ",/" + userId);
			out.flush();
		} catch (IOException e) {
			System.out.println("��ǥ Exception!!!");
			e.printStackTrace();
		}
	}
	
	public void sendPress(int x, int y, String roomName) {
		try {
			out.writeUTF("press:::" + x + ",/" + y + ",/" + roomName + ",/" + userId);
			out.flush();
		} catch (IOException e) {
			System.out.println("��ǥpress Exception!!!");
			e.printStackTrace();
		}
	}

	public void sendRelease(String roomName) {
		try {
			out.writeUTF("released:::" + roomName + ",/" + userId);
			out.flush();
		} catch (IOException e) {
			System.out.println("��ǥ Released Exception!!!");
		}
	}
	
	
	public void sendAllMsg(String msg, String roomName) {
    	try {
			out.writeUTF("sendAllMsg:::" + msg + ",/" + roomName + ",/" + userId);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void exitRoom(String roomName, String userId) {
    	try {
			out.writeUTF("exitRoom:::" + roomName + ",/" + userId);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void sendColor(int color) {
		try {
			out.writeUTF("color:::" + color);
			out.flush();
		} catch (IOException e) {
			System.out.println("color exception");
			e.printStackTrace();
		}
	}

	public void searchClient() {
		try {
			out.writeUTF("search");
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sendCreateRoom(String roomName) {
		try {
			out.writeUTF("createRoom:::" + roomName + ",/" + userId);
			out.flush();
		} catch (IOException e) {
			System.out.println("�游��� Exception!!!");
			e.printStackTrace();
		}
	}

	public void sendEnterRoom(String roomName) {
		try {
			out.writeUTF("enterRoom:::" + roomName + ",/" + userId);
			out.flush();
		} catch (IOException e) {
			System.out.println("������ Exception!!!");
			e.printStackTrace();
		}
	}
	
	public void sendSignUp(String msg) {
		try {
			out.writeUTF("signUp:::" + msg);
			out.flush();
		} catch(IOException e) {
			System.out.println("회원가입 Exception");
			e.printStackTrace();
		}
	}

}// class Sender-------