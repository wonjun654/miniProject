package com.kh.user.model.vo;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class User implements Serializable {
	/**
	 * 
	 */
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private int coin = 0;
	private String imgName;
	private boolean profile;
	private boolean musicSet;
	private int victory;

	public User() {
		this.coin = 0;
		this.profile = true;
		this.musicSet = true;
		this.victory = 0;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getCoin() {
		return coin;
	}

	public void setCoin(int coin) {
		this.coin = coin;
	}
	
	public boolean getProfile() {
		return profile;
	}

	public void setProfile(boolean profile) {
		this.profile = profile;
	}

	public boolean getMusicSet() {
		return musicSet;
	}

	public void setMusicSet(boolean musicSet) {
		this.musicSet = musicSet;
	}

	public int getVictory() {
		return victory;
	}

	public void setVictory(int victory) {
		this.victory = victory;
	}

	public User(String userId, String userPwd, String userName, String email) {
		this();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName + ", email=" + email
				+ ", imgName = " + imgName + ", coin=" + coin + ", profile=" + profile + ", musicSet=" + musicSet + ", victory="
				+ victory + "]";
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

}