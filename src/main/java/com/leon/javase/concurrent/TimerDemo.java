package com.leon.javase.concurrent;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo extends TimerTask {

	private static int count = 0;

	@Override
	public void run() {
		System.out.println("执行定时任务。。");
		count = (count + 1) % 2;
		new Timer().schedule(new TimerDemo(), 2000 + 2000 * count);

	}

	public static void main(String[] args) {

		Calendar calendar = Calendar.getInstance();
		new Timer().schedule(new TimerDemo(), 2000);
		while (true) {
			System.out.println(calendar.get(Calendar.SECOND));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
