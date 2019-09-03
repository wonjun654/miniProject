package com.kh.model.vo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class User {
	private Image img = new ImageIcon("images\\yangpa.PNG").getImage().getScaledInstance(150, 150, 0);
	private boolean profile = true;
	private int musicVolume = 30;
	
	public User() {}

	
	public User(Image img, boolean profile, int musicVolume) {
		super();
		this.img = img;
		this.profile = profile;
		this.musicVolume = musicVolume;
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

	

	public int getMusicVolume() {
		return musicVolume;
	}

	public void setMusicVolume(int musicVolume) {
		this.musicVolume = musicVolume;
	}
	
	

	
	
}
