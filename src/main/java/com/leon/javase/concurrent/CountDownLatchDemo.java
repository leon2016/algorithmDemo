package com.leon.javase.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch: 适用于要求线程A在其他若干线程完成后继续执行的场景
 * 
 * @author leon
 *
 */
public class CountDownLatchDemo {
	public static void main(String[] args) {
		final CountDownLatch cdl = new CountDownLatch(2);
		new Thread(new Runnable() {

			public void run() {
				try {
					System.out.println("线程1准备执行");
					Thread.sleep(2000);
					System.out.println("线程1执行");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cdl.countDown();
			}
		}).start();

		new Thread(new Runnable() {

			public void run() {
				try {
					System.out.println("线程2准备执行");
					Thread.sleep(3000);
					System.out.println("线程2执行");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cdl.countDown();
			}
		}).start();

		System.out.println("主线程准备执行。。");
		try {
			cdl.await();
			System.out.println("主线程执行。。");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
