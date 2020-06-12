package com.leon.javase.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceDemo {
	public static void main(String[] args) {
		// 创建一个可重用固定线程数的线程池
//		 ExecutorService pool = Executors.newFixedThreadPool(2);
		// 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
		 ExecutorService pool = Executors.newSingleThreadExecutor();
		// 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
		// 创建缓存大小的线程池(线程数可变)
		ExecutorService pool2 = Executors.newCachedThreadPool();
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		Thread t3 = new MyThread();
		Thread t4 = new MyThread();
		Thread t5 = new MyThread();
		// 将线程放入池中进行执行
		pool.execute(t1);
		pool2.execute(t2);
		pool.execute(t3);
		pool2.execute(t4);
		pool.execute(t5);
		// 关闭线程池
		pool.shutdown();
		pool2.shutdown();
	}
}
