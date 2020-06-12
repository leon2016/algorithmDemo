package com.leon.javase.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 实现定时器Timer和TimerTask
 * 
 * 请模拟写出双重定时器（面试题）
 * 
 * 要求：使用定时器,间隔4秒执行一次，再间隔2秒执行一次，以此类推执行。
 **/
public class DoubleTimer extends TimerTask {
	private static volatile int count = 1;

	@Override
	public void run() {
		count = (count + 1) % 2;
		System.err.println("Boob boom ");
		new Timer().schedule(new DoubleTimer(), 2000 + 2000 * count);
	}

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new DoubleTimer(), 4000 );
		while (true) {
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
