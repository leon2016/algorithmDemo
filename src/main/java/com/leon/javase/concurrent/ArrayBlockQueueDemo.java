package com.leon.javase.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue示例
 * 
 * 需求：在多线程操作下，一个数组中最多只能存入3个元素。多放入不可以存入数组，
 * 或等待某线程对数组中某个元素取走才能放入，要求使用java的多线程来实现。（面试）
 **/
public class ArrayBlockQueueDemo {

	public static void main(String[] args) {
		final BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
		for (int i = 0; i < 2; i++) {
			new Thread() {
				@Override
				public void run() {
					while (true) {
						try {
							Thread.sleep(3000);
							System.out.println(Thread.currentThread().getName() + "准备放数据!");
							queue.put(1);
							System.out.println(
							        Thread.currentThread().getName() + "已经放了数据，" + "队列目前有" + queue.size() + "个数据");
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}.start();
		}
		new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						// 将此处的睡眠时间分别改为100和1000，观察运行结果
						Thread.sleep(1000);
						System.err.println(Thread.currentThread().getName() + "准备取数据!");
						Integer temp = queue.take();
						System.err.println(
						        Thread.currentThread().getName() + "已经取走数据:" + temp + " 队列目前有" + queue.size() + "个数据");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
