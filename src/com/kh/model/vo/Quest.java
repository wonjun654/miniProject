package com.kh.model.vo;

import com.kh.user.controller.UserManager;

public class Quest {
	UserManager um = new UserManager();

	public void startQuset() {
		String[] qusetList = new String[3];
		
		qusetList[0] = "코인100개소유";
		qusetList[1] = "주먹밥쿵야 10개 모으기";
		qusetList[2] = "처음으로 우승해보기";
		

		
	}

}
