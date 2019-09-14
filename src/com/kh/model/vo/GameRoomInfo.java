package com.kh.model.vo;

import java.io.Serializable;

public class GameRoomInfo implements Serializable{
	
	String roomName;
	int gameUserNum;
	boolean isPlayingGame;
	
	public GameRoomInfo(String roomName, int gameUserNum) {
		this.roomName = roomName;
		this.gameUserNum = gameUserNum;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public int getGameUserNum() {
		return gameUserNum;
	}
	public void setGameUserNum(int gameUserNum) {
		this.gameUserNum = gameUserNum;
	}
	public boolean isPlayingGame() {
		return isPlayingGame;
	}
	public void setPlayingGame(boolean isPlayingGame) {
		this.isPlayingGame = isPlayingGame;
	}
}
