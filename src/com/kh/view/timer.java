package com.kh.view;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timer extends Thread {
	private int t = 180;
	// private int m = t / 60;
	// private int s = t % 60;
	private String result = "";

	// String sf = String.format("%02d");

	@Override
	public void run() {

		while (true) {

			try {
				showSec();

				sleep(1000);

				if (t > 0) {
					t--;

				} else {
					break;
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getT() {
		return t;
	}

	public void setT(int t) {
		this.t = t;
	}

	public String showSec() {
		result = (t / 60 + " : " + t % 60);
		setResult(result);
		System.out.print(t / 60 + " : ");
		System.out.printf("%02d\n", t % 60);
		// System.out.println(result);
		return getResult();
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public static void main(String[] args) {
		Thread th = new timer();

		th.start();

	}
}
