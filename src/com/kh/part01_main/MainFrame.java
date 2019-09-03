package com.kh.part01_main;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class MainFrame extends JFrame{
	public MainFrame() {
		this.setBounds(470, 150, 1024, 768);
		this.setTitle("KH치 마인드");
		try {
			this.setIconImage(ImageIO.read(new File("아이콘.PNG")));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
		
		
		this.add(new LoginPage());
		
		
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
