package com.kh.model.vo;

import java.net.SocketAddress;
import java.util.List;

public class Member {
	private String userID;
	private String userPwd;
	private String name;        // 捞抚
	private String nickName;
	private String email;
    private SocketAddress socketAddress;    // 立加茄 ip客 port
    private int win;            
    private int joinRoomIndex;            // 立加吝牢 规
    

	public Member(String userID, String userPwd, String name, String nickName, String email, SocketAddress socketAddress,
			int win, int joinRoomIndex) {
		super();
		this.userID = userID;
		this.userPwd = userPwd;
		this.name = name;
		this.nickName = nickName;
		this.email = email;
		this.socketAddress = socketAddress;
		this.win = win;
		this.joinRoomIndex = joinRoomIndex;
	}


	public String getUserID() {
		return userID;
	}


	public void setUserID(String userID) {
		this.userID = userID;
	}


	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SocketAddress getSocketAddress() {
		return socketAddress;
	}

	public void setSocketAddress(SocketAddress socketAddress) {
		this.socketAddress = socketAddress;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getJoinRoomIndex() {
		return joinRoomIndex;
	}

	public void setJoinRoomIndex(int joinRoomIndex) {
		this.joinRoomIndex = joinRoomIndex;
	}
    
    
}
