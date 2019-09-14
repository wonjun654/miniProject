package com.kh.model.vo;



import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

import com.kh.user.controller.UserManager;

public class MyMusicPlayer extends Thread {
   Clip clip;
   Thread bgmThread;
   boolean flag = true;

   public MyMusicPlayer(boolean flag) {
	   this.flag = flag;
   }

   private void bgmSnd(int i) {

      File bgm;

      AudioInputStream stream;

      AudioFormat format;
      DataLine.Info info;
      String[] bgmarr = new String[3];
      bgmarr[0] = "bgm/CatchMind1.wav";
      bgmarr[1] = "bgm/CatchMind2.wav";
      bgmarr[2] = "bgm/CatchMind3.wav";

      bgm = new File(bgmarr[i]);

      try {

         // 1) 파일을 가져와서 AudioSystem을 통해 InputStream에 넣음
         stream = AudioSystem.getAudioInputStream(bgm);
         // 2) 파일이 저장된 스트림에서 오디오 형식을 가져와 해당 오디오의 정보 오브젝트를 구축
         format = stream.getFormat();
         info = new DataLine.Info(Clip.class, format);
         // 3) 오디오 정보 오브젝트의 정보를 읽어와
         clip = (Clip) AudioSystem.getLine(info);
         // 4) clip을 통해 음악파일을 불러옴
         clip.open(stream);
         // 6) clip실행
         clip.start();
      } catch (Exception e) {

      }

   }

   @Override

   public void run() {

      try {
       if(flag) {
            bgmSnd(0);
       }else {
    	   clip.stop();
       }
       
         if (clip.getFrameLength() == clip.getFramePosition());

      } catch (Exception e) {
      }
   }
}