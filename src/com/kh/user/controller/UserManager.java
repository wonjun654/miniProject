package com.kh.user.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.user.smtptest;
import com.kh.user.model.dao.UserDao;
import com.kh.user.model.vo.User;

public class UserManager {
	private UserDao ud = new UserDao();

	public boolean login(String str) {
		Scanner sc = new Scanner(System.in);
		ArrayList<User> list = ud.readUserList();
		String[] user = str.split(":");
		String userId = user[0];
		String userPwd = user[1];

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getUserName().equals(userId) && list.get(i).getUserPwd().equals(userPwd)) {
					return true;
				}
			}
		}

		return false;
	}

	public void signUp(String str) {
		User u = null;

		String[] user = str.split(":");

		String userId = user[0];
		String userPwd = user[1];
		String userName = user[2];
		String email = user[3];

		u = new User(userId, userPwd, userName, email);

		insertUser(u);
	}

	public void insertUser(User u) {
		ArrayList<User> list = ud.readUserList();

		if (list == null) {
			list = new ArrayList<User>();
		}
		list.add(u);

		int result = ud.addUserList(list);

		if (result > 0) {
			System.out.println("���� �߰� ����");
		} else {
			System.out.println("���� �߰� ����");
		}
	}

	public void selectOneUser(String userId) {
		ArrayList<User> list = ud.readUserList();
		User selectedUser = null;

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getUserId().equals(userId)) {
					selectedUser = list.get(i);
					break;
				}
			}
		}
		if (selectedUser == null) {
			System.out.println("�ش� ���̵� �����ϴ�.");
		} else {
			System.out.println(selectedUser);
		}
	}

	public String FindId(String email) {
		ArrayList<User> list = ud.readUserList();

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getEmail().equals(email)) {
					return list.get(i).getUserId();
				}
			}
		}
		return null;
	}

	public void findPwd(String userId, String email) {
		ArrayList<User> list = ud.readUserList();

		if (list != null) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getUserId().equals(userId)) {
					if (list.get(i).getEmail().equals(email)) {
						smtptest.gmailSend(email);
					}
				}
			}
		}
	}
}
