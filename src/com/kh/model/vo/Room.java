package com.kh.model.vo;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable{
	private String roomTitle;
	private String pwd;
	private List<Member> joiner;
	private boolean gameStart;
	
	public Room(String roomTitle, String pwd, List<Member> joiner, boolean gameStart) {
		super();
		this.roomTitle = roomTitle;
		this.pwd = pwd;
		this.joiner = joiner;
		this.gameStart = gameStart;
	}

	public String getRoomTitle() {
		return roomTitle;
	}

	public void setRoomTitle(String roomTitle) {
		this.roomTitle = roomTitle;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public List<Member> getJoiner() {
		return joiner;
	}

	public void setJoiner(List<Member> joiner) {
		this.joiner = joiner;
	}

	public boolean isGameStart() {
		return gameStart;
	}

	public void setGameStart(boolean gameStart) {
		this.gameStart = gameStart;
	}
	
}
