package com.kh.user.view;

import java.util.Scanner;

import com.kh.part01_main.LoginPage;
import com.kh.user.controller.UserManager;
import com.kh.user.model.vo.User;

public class UserMenu {
	private UserManager um = new UserManager();
	Scanner sc = new Scanner(System.in);
	
	public void mainMenu() {
		new LoginPage();
	}

	

}
