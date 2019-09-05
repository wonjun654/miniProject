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
	boolean acceptQuest1 = false;
	boolean acceptQuest2 = false;
	boolean acceptQuest3 = false;
	boolean questClear1 = false;
	boolean questClear2 = false;
	boolean questClear3 = false;

	public User() {
		this.coin = 0;
		this.profile = true;
		this.musicSet = true;
		this.victory = 0;
		this.acceptQuest1 = false;
		this.acceptQuest2 = false;
		this.acceptQuest3 = false;
		this.questClear1 = false;
		this.questClear2 = false;
		this.questClear3 = false;

	}

	
	public boolean getAcceptQuest1() {
		return acceptQuest1;
	}


	public void setAcceptQuest1(boolean acceptQuest1) {
		this.acceptQuest1 = acceptQuest1;
	}


	public boolean getAcceptQuest2() {
		return acceptQuest2;
	}


	public void setAcceptQuest2(boolean acceptQuest2) {
		this.acceptQuest2 = acceptQuest2;
	}


	public boolean getAcceptQuest3() {
		return acceptQuest3;
	}


	public void setAcceptQuest3(boolean acceptQuest3) {
		this.acceptQuest3 = acceptQuest3;
	}


	public boolean getQuestClear1() {
		return questClear1;
	}


	public void setQuestClear1(boolean questClear1) {
		this.questClear1 = questClear1;
	}


	public boolean getQuestClear2() {
		return questClear2;
	}


	public void setQuestClear2(boolean questClear2) {
		this.questClear2 = questClear2;
	}


	public boolean getQuestClear3() {
		return questClear3;
	}


	public void setQuestClear3(boolean questClear3) {
		this.questClear3 = questClear3;
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