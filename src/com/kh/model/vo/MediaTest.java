package com.kh.model.vo;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JFrame;

public class MediaTest {
	static Clip clip;

	public static void musicOn(int i, boolean b) {
		File bgm, bgm2;
		AudioInputStream stream;
		AudioFormat format;
		DataLine.Info info;
		JFrame mf = new JFrame();

		String[] bgmarr = new String[2];
		bgmarr[0] = "c:/CatchMind1.wav";
		bgmarr[1] = "c:/CatchMind2.wav";
		// bgm = new File("c:/CatchMind1.wav"); // 사용시에는 개별 폴더로 변경할 것
		// bgm2= new File("c:/CatchMind2.wav");

		if (b) {

			try {
				bgm = new File(bgmarr[i]);
				stream = AudioSystem.getAudioInputStream(bgm);
				format = stream.getFormat();
				info = new DataLine.Info(Clip.class, format);
				clip = (Clip) AudioSystem.getLine(info);
				clip.open(stream);
				clip.start();
				clip.loop(-1);
			} catch (Exception e) {
				System.out.println("err : " + e);
			}

		}
	}

	public static void musicOff() {
		clip.stop();
		clip.close();
	}
}
