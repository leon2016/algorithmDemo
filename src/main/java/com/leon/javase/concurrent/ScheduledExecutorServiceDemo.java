package com.leon.javase.concurrent;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceDemo {
	public static void main(String[] args) {
		
		// 创建延迟连接池
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
		Thread t1 = new MyThread();
		Thread t2 = new MyThread();
		Thread t3 = new MyThread();
		Thread t4 = new MyThread();
		Thread t5 = new MyThread();
		// 将线程放入池中进行执行
		pool.execute(t1);
		pool.execute(t2);
		pool.execute(t3);
		pool.schedule(t4, 2000, TimeUnit.MILLISECONDS);
		pool.schedule(t5, 4000, TimeUnit.MILLISECONDS);
		// 关闭线程池
		pool.shutdown();
	}
}
