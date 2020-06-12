package com.leon.javase.concurrent;

import java.util.concurrent.Semaphore;

/**
 * semaphore：控制同时访问的线程数
 * 
 * @author leon
 *
 */
public class SemaphoreTest {
	private static Semaphore semaphore = new Semaphore(5, true);

	public static void test() {
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "获得许可执行...start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		semaphore.release();
		System.out.println(Thread.currentThread().getName() + "释放许可...end");
	}

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable() {

				public void run() {
					test();
				}
			}).start();
		}
	}
}
