package com.leon.javase.concurrent;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimeTaskCus extends TimerTask {

	private static volatile int count = 0;

	@Override
	public void run() {

		System.out.println("boob!");
		count = count % 2;
		new Timer().schedule(new TimeTaskCus(), 2000 + count * 2000);
		count++;

	}

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		Timer timer = new Timer();
		timer.schedule(new TimeTaskCus(), 4000);

		while (true) {
			System.out.println(calendar.get(Calendar.SECOND));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
