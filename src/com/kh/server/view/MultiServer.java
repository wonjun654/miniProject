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
import com.kh.user.model.vo.User;
import com.kh.view.GameRoom;

public class MultiServer implements Serializable{
	public static final int PORT = 7771;
//	HashMap<String, ObjectOutputStream> clientMap;
	HashMap<String, DataOutputStream> clientMap;
//	HashMap<String, HashMap<String, ObjectOutputStream>> multiRoom;
	HashMap<String, HashMap<String, DataOutputStream>> multiRoom;
	ArrayList<Object> arrRoom;
	ServerSocket serverSocket;
	Socket socket;
	GameRoom game;
	UserManager um;
//	ObjectOutputStream out;
	DataOutputStream out;
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
//				out = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
				out = new DataOutputStream(socket.getOutputStream());
				Thread msr = new MultiServerRec(socket); // ������ ����.
				msr.start(); 							 // ������ �õ�.
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sendSignUp(String msg) {
		String[] tmpMsg = msg.split(":::");
		System.out.println(tmpMsg[1]);
		boolean result = um.signUp(tmpMsg[1]);
		
		try {
//			out = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("signUp:::" + result);
			out.flush();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendLogin(String msg) {
	      String[] tmpMsg = msg.split(":");
	      String userId = tmpMsg[0];
	      String userPw = tmpMsg[1];
	      String userCoin = tmpMsg[2];
	      String userItem2 = tmpMsg[3];
	      String userItem1 = tmpMsg[4];
	      String userMusicSet = tmpMsg[5];
	      
	      boolean result = um.login(userId + ":" + userPw);
	      try {
//	    	 out = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
	    	  out = new DataOutputStream(socket.getOutputStream());
	         out.writeUTF("login:::" + result + ":" + userId + ":" + userPw + ":" + userCoin + ":" 
	                  + userItem2 + ":" + userItem1 + ":" + userMusicSet);
	         out.flush();
	      } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	   }
	
	public void sendCoordinate(String msg) {
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
//				ObjectOutputStream iterOut = (ObjectOutputStream) multiRoom.get(roomName).get(key);
				DataOutputStream iterOut = (DataOutputStream) multiRoom.get(roomName).get(key);
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
//				ObjectOutputStream iterOut = (ObjectOutputStream) multiRoom.get(roomName).get(key);
				DataOutputStream iterOut = (DataOutputStream) multiRoom.get(roomName).get(key);
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
//				ObjectOutputStream iterOut = (ObjectOutputStream) multiRoom.get(roomName).get(key);
				DataOutputStream iterOut = (DataOutputStream) multiRoom.get(roomName).get(key);
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
				System.out.println(userId + "님이 게임방 " + roomName + "을 나오고 메인화면에 접속했습니다.");
				break;
			}
		}
		
		multiRoom.get(roomName).remove(userId);		//방에서 빠져나왔기 때문에 삭제
		
		if(multiRoom.get(roomName).size() == 0) {
			System.out.println("방에 인원이 없어서 삭제합니다.");
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
//				ObjectOutputStream iterOut = (ObjectOutputStream) clientMap.get(iter.next());
				DataOutputStream iterOut = (DataOutputStream) clientMap.get(iter.next());
				iterOut.writeUTF(userId + "����!!");
				iterOut.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendAllMsg(String msg) {
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
//				ObjectOutputStream iterOut = (ObjectOutputStream) multiRoom.get(roomName).get(key);
				DataOutputStream iterOut = (DataOutputStream) multiRoom.get(roomName).get(key);
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
	
	public void sendMainRoomMsg(String msg) {
		String[] tmpMsg = msg.split(":::");
		tmpMsg = tmpMsg[1].split(",/");
		String sendMsg = tmpMsg[0];
		String userId = tmpMsg[1];
		
		Iterator iter = clientMap.keySet().iterator();
		while(iter.hasNext()) {
			String key = (String) iter.next();
			if(key.equals(userId)) {
				continue;
			} else {
				DataOutputStream iterOut = (DataOutputStream) clientMap.get(key);
				try {
					iterOut.writeUTF("sendMainRoomMsg:::" + sendMsg + ",/" + userId);
					iterOut.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public void createMultiRoom(String msg) {
		String[] tmpMsg = msg.split(":::");		//1번 인덱스가 방이름
		tmpMsg = tmpMsg[1].split(",/"); 		//0번 : 방이름, 1번 : 아이디
		String roomName = tmpMsg[0];
		String userId = tmpMsg[1];
		if(multiRoom.containsKey(roomName)) {
			System.out.println("이미 존재하는 방입니다.");		//동일한 방이름으로 방 생성이 안됨
		} else {
			multiRoom.put(roomName, new HashMap<>());		//방이름에 대해 방생성
			Collections.synchronizedMap(multiRoom.get(roomName));
			multiRoom.get(roomName).put(userId, clientMap.get(userId));		//방생성한 유저의 정보 아이디와 출력스트림입력
			Iterator iter = multiRoom.keySet().iterator();
			exit: while(iter.hasNext()) {
				String key = (String) iter.next();		//방이름을 키값으로 저장
				System.out.println("생성된 방 이름 : " + key);
				if(key.equals(roomName)) {				//키값과 방이름이 같을때만 해당 방의 유저정보 관리
					Iterator iter2 = multiRoom.get(key).keySet().iterator();
					while(iter2.hasNext()) {
						String key2 = (String) iter2.next();	//유저아이디를 키2값으로 저장
						if(key2.equals(userId)) {
//							ObjectOutputStream iter2Out = (ObjectOutputStream) multiRoom.get(key).get(key2);
							DataOutputStream iter2Out = (DataOutputStream) multiRoom.get(key).get(key2);
							try {
								iter2Out.writeUTF("createRoom:::" + roomName);
								iter2Out.flush();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println(userId + "님이 게임방 " + key + "으로 입장했습니다.");
							clientMap.remove(userId);	//방에 들어가니깐 메인화면에서 정보 삭제
							break exit;
						}//key2(유저이름) if문--------
					}//iter2.hasNext() while문------
				}//key(방이름) if문-----------
			}//iter.hasNext() while문-------
		}//else문 (방이름 중복체크)-----------
	}//createMultiRoom 메소드 -----------
	
	public void enterMultiRoom(String msg) {
		String[] tmpMsg = msg.split(":::");		//1번 인덱스가 방이름
		tmpMsg = tmpMsg[1].split(",/"); 		//0번 : 방이름, 1번 : 아이디
		String roomName = tmpMsg[0];
		String userId = tmpMsg[1];
		
		if(multiRoom.containsKey(roomName)) {
			multiRoom.get(roomName).put(userId, clientMap.get(userId)); //만들어진 방에 입장
			clientMap.remove(userId);									//방에 입장해서 메인화면에서 삭제
			
			Iterator iter = multiRoom.keySet().iterator();	//��Ƽ�� Ű��
			exit: while(iter.hasNext()) {
				String key = (String) iter.next();
				if(key.equals(roomName)) {
					Iterator iter2 = multiRoom.get(key).keySet().iterator();
					while(iter2.hasNext()) {	//��Ƽ�� �ϳ��� �ִ� ������ Ű��
						String key2 = (String) iter2.next();
						if(key2.equals(userId)) {
//							ObjectOutputStream iter2Out = (ObjectOutputStream) multiRoom.get(key).get(key2);
							DataOutputStream iter2Out = (DataOutputStream) multiRoom.get(key).get(key2);
							try {
								iter2Out.writeUTF("enterRoom:::" + roomName);
								iter2Out.flush();
								break exit;
							} catch (IOException e) {
								e.printStackTrace();
							}
						}//key2(유저아이디)에 대한 if문------
					}//iter2.hasNext() while문------
				}//key(방이름)에 대한 if문------
			}//iter.hasNext() while문------
		} else {
			System.out.println("존재하지 않는 방입니다.");
		}
	}
	
	public void sendFailLogin() {
		try {
			out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF("failLogin:::");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	// ----// 내부 클래스 //--------//

		// 클라이언트로부터 읽어온 메시지를 다른 클라이언트(socket)에 보내는 역할을 하는 메서드
	class MultiServerRec extends Thread {
		String userId;
		Socket socket;
//		ObjectInputStream in;
		DataInputStream in;
//		ObjectOutputStream out;
		DataOutputStream out;
		
		// ������.
		public MultiServerRec(Socket socket) {
			this.socket = socket;
			try {
				// Socket���κ��� �Է½�Ʈ���� ��´�.
//				in = new ObjectInputStream(new DataInputStream(socket.getInputStream()));
				in = new DataInputStream(socket.getInputStream());
				
				// Socket���κ��� ��½�Ʈ���� ��´�.
//				out = new ObjectOutputStream(new DataOutputStream(socket.getOutputStream()));
				out = new DataOutputStream(socket.getOutputStream());
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
						String[] tmpMsg = msg.split(":::");
		                  tmpMsg = tmpMsg[1].split(":");
		                  String userId = tmpMsg[0];
		                  this.userId = userId;
		                  String userPw = tmpMsg[1];
		                  if(um.login(userId + ":" + userPw)) {
		                	  clientMap.put(userId, out);
			                  System.out.println(clientMap.get(userId));
			                  User connectUser = um.selectOneUser(userId);
			                  System.out.println(userId + ":" + userPw + ":" + connectUser.getCoin() + ":" + connectUser.getOwnItem2() + ":" + connectUser.getOwnItem1() + ":" + connectUser.getMusicSet());
			                  String msg2 = userId + ":" + userPw + ":" + connectUser.getCoin() + ":" + connectUser.getOwnItem2() + ":" + connectUser.getOwnItem1() + ":" + connectUser.getMusicSet();
			                  sendLogin(msg2);
		                  } else {
		                	  sendFailLogin();
		                  }
		                  
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
					} else if(msg.startsWith("sendMainRoomMsg")) {
						sendMainRoomMsg(msg);
					}
				} // while()---------
			} catch(SocketException e) {
				clientMap.remove(userId);
				System.out.println(userId + "퇴장 !");
			} catch(ArrayIndexOutOfBoundsException e) {
				sendFailLogin();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// run()------------
	}// class MultiServerRec-------------
}