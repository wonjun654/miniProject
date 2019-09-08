package com.kh.room;

import java.io.Serializable;

public class Room implements Serializable{
	
	private String roomName;
	private String roomPwd;
	
	
	public Room(String roomName, String roomPwd
			) {
		super();
		this.roomName = roomName;
		this.roomPwd = roomPwd;
		
		
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getRoomPwd() {
		return roomPwd;
	}
	public void setRoomPwd(String roomPwd) {
		this.roomPwd = roomPwd;
	}
	
		

}
