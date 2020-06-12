package com.leon.javase.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 回环栅栏：适用于要求一组线程等待到某一个状态后再全部同时执行后续操作。
 * 
 * @author leon
 *
 */
public class CyclicBarrierDemo {
	public static void main(String[] args) {
		final CyclicBarrier cb = new CyclicBarrier(4);

		for (int i = 0; i < 4; i++) {
			new Thread(new Runnable() {

				public void run() {
					System.out.println(Thread.currentThread().getName() + "到达指定点等待");
					try {
						cb.await();
						System.out.println(Thread.currentThread().getName() + "继续执行");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}).start();
		}
	}
}
