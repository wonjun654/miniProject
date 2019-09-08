package com.kh.room;

import java.util.ArrayList;

public class RoomManager {
	private RoomDao rd = new RoomDao();
	
	
	
	public void roomMake(String str) {
		Room m = null;
		
		String[] room = str.split(":");
		
		String roomName = room[0];
		String roomPwd = room[1];
		
		
		
		m = new Room(roomName, roomPwd);
		insertRoom(m);
		
	}
	
	
	public void insertRoom(Room r) {
		ArrayList<Room> list = rd.readRoomList();
		
		if(list == null) {
			list = new ArrayList<Room>();
		}
		list.add(r);
		
		int result = rd.addRoomList(list);
		
		if (result > 0) {
			System.out.println("방만들기 성공");
		} else {
			System.out.println("방만들기 실패");
		}
	}
}
