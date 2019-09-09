package com.kh.server.view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import com.kh.user.controller.UserManager;
import com.kh.view.GameRoom;

public class MultiServer implements Serializable{
	public static final int PORT = 7771;
	HashMap<String, ObjectOutputStream> clientMap;
	HashMap<String, HashMap<String, ObjectOutputStream>> multiRoom;
	ArrayList<Object> arrRoom;
	ServerSocket serverSocket;
	Socket socket;
	GameRoom game;
	UserManager um;
	ObjectOutputStream out;
	// ������
	public MultiServer() {
		um = new UserManager();
		clientMap = new HashMap<>(); 				// Ŭ���̾�Ʈ�� ��½�Ʈ���� ������ �ؽ��� ����.
		multiRoom = new HashMap<>();
		Collections.synchronizedMap(multiRoom);
		Collections.synchronizedMap(clientMap); // �ؽ��� ����ȭ ����.
		
	}// ������----

	public void init() {
		try {
			serverSocket = new ServerSocket(PORT); // 7771����Ʈ�� ������ü ����
			System.out.println("Run to Server...");
			
			while (true) { 															  // ������ ����Ǵ� ���� Ŭ���̾�Ʈ���� ������ ��ٸ�.
				socket = serverSocket.accept(); 									  // Ŭ���̾�Ʈ�� ������ ��ٸ��ٰ� ������ �Ǹ� Socket��ü�� ����.
				System.out.println(socket.getInetAddress() + ":" + socket.getPort()); // Ŭ���̾�Ʈ ���� (ip, ��Ʈ) ���
				Thread msr = new MultiServerRec(socket); // ������ ����.
				msr.start(); 							 // ������ �õ�.
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendCoordinate(String msg) {
		/*Iterator iter = clientMap.keySet().iterator();

		while (iter.hasNext()) {
			String key = (String) iter.next();
			if (key.equals(userId)) {
				continue;	//�ڱ��ڽ��� �����ϰ� �� ����
			} else {
				try {
					ObjectOutputStream iterOut = (ObjectOutputStream) clientMap.get(key);
					iterOut.writeUTF(msg);
					iterOut.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}*/
		String[] tmpMsg = msg.split(":::");
		tmpMsg = tmpMsg[1].split(",/");		//0�� x, 1�� y, 2�� �÷�, 3�� stroke, 4�� ��, 5�� userId
		String x = tmpMsg[0];
		String y = tmpMsg[1];
		String color = tmpMsg[2];
		String stroke = tmpMsg[3];
		String roomName = tmpMsg[4];
		String userId = tmpMsg[5];
		
		Iterator iter = multiRoom.get(roomName).keySet().iterator();
		while(iter.hasNext()){
			String key = (String) iter.next();
			if(key.equals(userId)) {
				continue;
			} else {
				ObjectOutputStream iterOut = (ObjectOutputStream) multiRoom.get(roomName).get(key);
				try {
					iterOut.writeUTF("coordinate:::" + x + ",/" + y + ",/" + color + ",/" + stroke);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void sendPress(String msg) {
		String[] tmpMsg = msg.split(":::");
		tmpMsg = tmpMsg[1].split(",/");
		String x = tmpMsg[0];
		String y = tmpMsg[1];
		String roomName = tmpMsg[2];
		String userId = tmpMsg[3];
		
		Iterator iter = multiRoom.get(roomName).keySet().iterator();
		while(iter.hasNext()) {
			String key = (String) iter.next();
			if(key.equals(userId)) {
				continue;
			} else {
				ObjectOutputStream iterOut = (ObjectOutputStream) multiRoom.get(roomName).get(key);
				try {
					iterOut.writeUTF("press:::" + x + ",/" + y);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void sendRelease(String msg) {
		String[] tmpMsg = msg.split(":::");
		tmpMsg = tmpMsg[1].split(",/");
		String roomName = tmpMsg[0];
		String userId = tmpMsg[1];
		
		Iterator iter = multiRoom.get(roomName).keySet().iterator();
		while(iter.hasNext()){
			String key = (String) iter.next();
			if(key.equals(userId)) {
				continue;
			} else {
				ObjectOutputStream iterOut = (ObjectOutputStream) multiRoom.get(roomName).get(key);
				try {
					iterOut.writeUTF("released:::");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public void exitRoom(String msg) {
		String[] tmpMsg = msg.split(":::");
		tmpMsg = tmpMsg[1].split(",/");
		String roomName = tmpMsg[0];
		String userId = tmpMsg[1];
		
		Iterator iter = multiRoom.get(roomName).keySet().iterator();
		while(iter.hasNext()) {	//�濡�� ������ ����ȭ������ ���ư��� ������ clientMap�� ����
			String iterId = (String) iter.next();
			if(iterId.equals(userId)) {
				clientMap.put(userId, multiRoom.get(roomName).get(iterId));
				System.out.println(userId + "���� ���ӹ� " + roomName + "�� ������ ����ȭ�鿡 �����߽��ϴ�.");
				break;
			}
		}
		
		multiRoom.get(roomName).remove(userId);		//�濡�� �������Ա� ������ ����
		
		if(multiRoom.get(roomName).size() == 0) {
			System.out.println("�濡 �ο��� ��� �����մϴ�.");
			multiRoom.remove(roomName);
		}
	}
	
	public void login(String msg) {
		String[] tmpMsg = msg.split(":::");
		tmpMsg = tmpMsg[1].split(",/");
		String userId = tmpMsg[0];
		try {
			Iterator iter = clientMap.keySet().iterator();
			while(iter.hasNext()) {
				ObjectOutputStream iterOut = (ObjectOutputStream) clientMap.get(iter.next());
				iterOut.writeUTF(userId + "����!!");
				iterOut.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendAllMsg(String msg) {
		System.out.println("sendAllMsg �޼ҵ� ����");
		String[] tmpMsg = msg.split(":::");
		tmpMsg = tmpMsg[1].split(",/");
		String sendMsg = tmpMsg[0];
		String roomName = tmpMsg[1];
		String userId = tmpMsg[2];
		
		Iterator iter = multiRoom.get(roomName).keySet().iterator();
		
		while(iter.hasNext()) {
			String key = (String) iter.next();
			if(key.equals(userId)) {
				continue;
			} else {
				ObjectOutputStream iterOut = (ObjectOutputStream) multiRoom.get(roomName).get(key);
				System.out.println("iterOut : " + iterOut);
				try {
					iterOut.writeUTF("sendAllMsg:::" + sendMsg + ",/" + userId);
					iterOut.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void createMultiRoom(String msg) {
		String[] tmpMsg = msg.split(":::");		//1�� �ε����� ���̸�
		tmpMsg = tmpMsg[1].split(",/"); 		//0�� : ���̸�, 1�� : ���̵�
		String roomName = tmpMsg[0];
		String userId = tmpMsg[1];
		if(multiRoom.containsKey(roomName)) {
			System.out.println("�̹� �����ϴ� ���Դϴ�.");		//������ ���̸����� �� ������ �ȵ�
		} else {
			multiRoom.put(roomName, new HashMap<>());		//���̸��� ���� �����
			Collections.synchronizedMap(multiRoom.get(roomName));
			multiRoom.get(roomName).put(userId, clientMap.get(userId));		//������� ������ ���� ���̵�� ��½�Ʈ���Է�
			Iterator iter = multiRoom.keySet().iterator();
			exit: while(iter.hasNext()) {
				String key = (String) iter.next();		//���̸��� Ű������ ����
				System.out.println("������ �� �̸� : " + key);
				if(key.equals(roomName)) {				//Ű���� ���̸��� �������� �ش� ���� �������� ����
					Iterator iter2 = multiRoom.get(key).keySet().iterator();
					while(iter2.hasNext()) {
						String key2 = (String) iter2.next();	//�������̵� Ű2������ ����
						if(key2.equals(userId)) {
							ObjectOutputStream iter2Out = (ObjectOutputStream) multiRoom.get(key).get(key2);
							try {
								iter2Out.writeUTF("createRoom:::" + roomName);
								iter2Out.flush();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("���� ���̵� : " + key2);
							System.out.println("���� ��½�Ʈ�� : " + multiRoom.get(key).get(key2));
							System.out.println(userId + "���� ���ӹ� " + key + "���� �����߽��ϴ�.");
							clientMap.remove(userId);	//�濡 ���ϱ� ����ȭ�鿡�� ���� ����
							break exit;
						}//key2(�����̸�) if��--------
					}//iter2.hasNext() while��------
				}//key(���̸�) if��-----------
			}//iter.hasNext() while��-------
		}//else�� (���̸� �ߺ�üũ)-----------
	}//createMultiRoom �޼ҵ� -----------
	
	public void enterMultiRoom(String msg) {
		String[] tmpMsg = msg.split(":::");		//1�� �ε����� ���̸�
		tmpMsg = tmpMsg[1].split(",/"); 		//0�� : ���̸�, 1�� : ���̵�
		String roomName = tmpMsg[0];
		String userId = tmpMsg[1];
		
		if(multiRoom.containsKey(roomName)) {
			multiRoom.get(roomName).put(userId, clientMap.get(userId)); //������� �濡 ����
			clientMap.remove(userId);									//�濡 �����ؼ� ����ȭ�鿡�� ����
			
			Iterator iter = multiRoom.keySet().iterator();	//��Ƽ�� Ű��
			exit: while(iter.hasNext()) {
				String key = (String) iter.next();
				if(key.equals(roomName)) {
					System.out.println("������ �� �̸� : " + key);
					Iterator iter2 = multiRoom.get(key).keySet().iterator();
					while(iter2.hasNext()) {	//��Ƽ�� �ϳ��� �ִ� ������ Ű��
						String key2 = (String) iter2.next();
						if(key2.equals(userId)) {
							ObjectOutputStream iter2Out = (ObjectOutputStream) multiRoom.get(key).get(key2);
							try {
								iter2Out.writeUTF("enterRoom:::" + roomName);
								iter2Out.flush();
								break exit;
							} catch (IOException e) {
								e.printStackTrace();
							}
							
							System.out.println("���� ���̵� : " + key2);
							System.out.println("���� ��½�Ʈ�� : " + multiRoom.get(key).get(key2));
						}//key2(�������̵�)�� ���� if��------
					}//iter2.hasNext() while��------
				}//key(���̸�)�� ���� if��------
			}//iter.hasNext() while��------
		} else {
			System.out.println("���¹� ���� �ǤǤǤ� ��� �ĵ������ϳ�! ���߷Ҿ�!");
		}
	}
	
	public void sendSignUp(String msg) {
		String[] tmpMsg = msg.split(":::");
		System.out.println(tmpMsg[1]);
		boolean result = um.signUp(tmpMsg[1]);
		
		try {
			out = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
			out.writeUTF("signUp:::" + result);
			out.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	// ----// ���� Ŭ���� //--------//

	// Ŭ���̾�Ʈ�κ��� �о�� �޽����� �ٸ� Ŭ���̾�Ʈ(socket)�� ������ ������ �ϴ� �޼���
	class MultiServerRec extends Thread {
		String userId;
		Socket socket;
		ObjectInputStream in;
		ObjectOutputStream out;
		
		// ������.
		public MultiServerRec(Socket socket) {
			this.socket = socket;
			try {
				// Socket���κ��� �Է½�Ʈ���� ��´�.
				in = new ObjectInputStream(new DataInputStream(socket.getInputStream()));
				
				// Socket���κ��� ��½�Ʈ���� ��´�.
				out = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
			} catch (IOException e) {
				System.out.println("����123");
				e.printStackTrace();
			}
		}// ������ ------------

		@Override
		public void run() {
			try {
				while (in != null) { // �Է½�Ʈ���� null�� �ƴϸ� �ݺ�.
					String msg = in.readUTF();
					if(msg.startsWith("coordinate")) {			//��ǥ
						sendCoordinate(msg);
					} else if(msg.startsWith("login")) {		//�α���
						System.out.println(msg);
						String[] tmp = msg.split(":::");
						userId = tmp[1];
						clientMap.put(userId, out);
						login(msg);
					} else if(msg.startsWith("createRoom")) {	//���ӹ����
						System.out.println(msg);
						createMultiRoom(msg);
					} else if(msg.startsWith("enterRoom")) {	//������
						System.out.println(msg);
						enterMultiRoom(msg);
					} else if(msg.startsWith("press")) {		//��ǥ
//						sendCoordinate(msg);
						sendPress(msg);
					} else if(msg.startsWith("released")) {		//��ǥ
						sendRelease(msg);
					} else if(msg.startsWith("exitRoom")) {		//���ӹ�����
						System.out.println(msg);
						exitRoom(msg);
					} else if(msg.startsWith("sendAllMsg")) {	//���ӹ�޼���
						System.out.println(msg);
						sendAllMsg(msg);
					} else if(msg.startsWith("signUp")) {
						sendSignUp(msg);
					}
				} // while()---------
			} catch(SocketException e) {
				clientMap.remove(userId);
				System.out.println(userId + "����!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// run()------------
	}// class MultiServerRec-------------
}