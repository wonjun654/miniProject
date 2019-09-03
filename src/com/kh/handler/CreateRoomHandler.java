package com.kh.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.kh.view.MakeRoom;

public class CreateRoomHandler implements ActionListener{
	MakeRoom target;
	 public CreateRoomHandler(MakeRoom m) {
		target = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String title = target.roomName2.getText().trim();
		String pw = "";
		
		if(target.btnOK.isSelected()) {
			
		}
		
		
	}
	
	
}
