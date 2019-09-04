package com.kh.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class User {
	private Image img = new ImageIcon("images/yangpa.PNG").getImage().getScaledInstance(150, 150, 0);
	private boolean profile = true;
	private boolean musicSet = true;
	private int victory = 0;
	private int coin = 0;
	private String id = "xxx";
	
	public User() {}

	
	public User(Image img, boolean profile,boolean musicSet,int victory,int coin,String id) {
		super();
		this.img = img;
		this.profile = profile;
		this.musicSet = musicSet;
		this.victory = victory;
		this.coin = coin;
		this.id = id;
		
	}


	public int getVictory() {
		return victory;
	}


	public void setVictory(int victory) {
		this.victory = victory;
	}


	public int getCoin() {
		return coin;
	}


	public void setCoin(int coin) {
		this.coin = coin;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public boolean getMusicSet() {
		return musicSet;
	}


	public void setMusicSet(boolean musicSet) {
		this.musicSet = musicSet;
	}


	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	public boolean getProfile() {
		return profile;
	}

	public void setProfile(boolean profile) {
		this.profile = profile;
	}

	

	

	
	
}