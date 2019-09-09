package com.kh.user.view;

import java.io.IOException;
import java.net.Socket;

import com.kh.part01_main.LoginPage;

public class UserMenu {
	public static final String SERVER_IP = "localhost";
	public static final int PORT = 7771;
	Socket socket;
	
	public UserMenu() {
		try {
			socket = new Socket(SERVER_IP, PORT);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void mainMenu() {
		new LoginPage(socket);
	}

}
