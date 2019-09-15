package com.kh.user.view;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.kh.part01_main.LoginPage;

public class UserMenu {
	public static final String SERVER_IP = "localhost";
	public static final int PORT = 7771;
	Socket socket;
	
	public UserMenu() {
		try {
			socket = new Socket(SERVER_IP, PORT);
		} catch (ConnectException e) {
			JOptionPane.showMessageDialog(null, "서버와 연결을 실패했습니다. 잠시 후 다시 시도해주시기 바랍니다.");
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void mainMenu() {
		new LoginPage(socket);
	}

	
}
