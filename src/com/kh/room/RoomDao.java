package com.kh.room;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class RoomDao {
	
	public RoomDao() {}
	
	
	public ArrayList<Room> readRoomList() {
		ObjectInputStream ois = null;
		ArrayList<Room> list = null;
		
		
			
			try {
				ois = new ObjectInputStream(new FileInputStream("RoomList.dat"));
				list = (ArrayList<Room>) ois.readObject();
			} catch (FileNotFoundException e) {
				System.out.println("파일이 없습니다.");
			} catch (ClassNotFoundException |IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (ois != null) {
					
						try {
							ois.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
			}
			return list;
	}
	
	public int addRoomList(ArrayList<Room> list) {
		ObjectOutputStream oos = null;
		int result = 0;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream("RoomList.dat"));
			oos.writeObject(list);
			result++;
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
		
	}
}
