
package com.kh.user.controller;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.user.smtptest;
import com.kh.user.model.dao.UserDao;
import com.kh.user.model.vo.User;

public class UserManager {
	private UserDao ud = new UserDao();

	public boolean login(String str) {
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

	public synchronized boolean signUp(String str) {
		User u = null;

		String[] user = str.split(":");

		String userId = user[0];
		String userPwd = user[1];
		String userName = user[2];
		String email = user[3];

		u = new User(userId, userPwd, userName, email);
		
		return insertUser(u);
	}

	public synchronized boolean insertUser(User u) {
		ArrayList<User> list = ud.readUserList();

		if (list == null) {
			list = new ArrayList<User>();
		}
		list.add(u);

		int result = ud.addUserList(list);

		if (result > 0) {
			System.out.println("유저 추가 성공");
			return true;
		} else {
			System.out.println("유저 추가 실패");
			return false;
		}
	}

	public void updateUser(User u) {
		ArrayList<User> list = ud.readUserList();

		if (list == null) {
			list = new ArrayList<User>();
		}
		for(int i=0;i<list.size(); i++) {
			if(list.get(i).getUserId().equals(u.getUserId())) {
				list.remove(i);
				list.add(u);
				break;
			}
		}
		//list.add(u);

		int result = ud.addUserList(list);

		if (result > 0) {
			System.out.println("유저 정보 수정 성공");
		} else {
			System.out.println("유저 정보 수정 실패");
		}
	}
	
	public User selectOneUser(String userId) {
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
			System.out.println("해당 아이디가 없습니다.");
		} else {
			return selectedUser;
		}
		
		return null;
	}

	public boolean DuplicateCheck(String userId) {
		ArrayList<User> list = ud.readUserList();
		
		for(int i =0; i<list.size(); i++) {
			if(list.get(i).getUserId().equals(userId)) {
				return true;
			} 
		}
		
		return false;
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