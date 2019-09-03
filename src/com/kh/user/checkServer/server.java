package com.kh.user.checkServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public static void main(String[] args) {
		ServerSocket s_socket = null;
		Socket c_socket = null;
		BufferedReader in = null;
		PrintWriter out = null;
		
		try {
			s_socket = new ServerSocket(8888);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		try {
			System.out.println("run server");
			c_socket = s_socket.accept();
			
			in = new BufferedReader(new InputStreamReader(c_socket.getInputStream()));
			out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(c_socket.getOutputStream())));
			String str = null;
			str = in.readLine();
			
			System.out.println(str);
			
			out.write(str);
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
