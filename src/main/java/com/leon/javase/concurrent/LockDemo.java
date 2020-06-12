package com.leon.javase.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
	private int count = 0;
	private Lock lock = new ReentrantLock();// 设置lock锁
	// 方法1
	public Runnable run1 = new Runnable() {
		public void run() {
			System.out.println("执行方法run1...准备加锁");
			lock.lock();// 加锁
			System.out.println("执行方法run1...成功加锁");
			while (count < 50) {
				try {
					// 打印是否执行该方法
					System.out.println(Thread.currentThread().getName() + " run1: " + count++);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("执行完方法run1...准备释放锁");
			lock.unlock();
			System.out.println("执行完方法run1...成功释放锁");
		}
	};

	// 方法2
	public Runnable run2 = new Runnable() {
		public void run() {
			System.out.println("执行方法run2...准备加锁");
			lock.lock();
			System.out.println("执行方法run2...成功加锁");
			while (count < 100) {
				try {
					System.out.println(Thread.currentThread().getName() + " run2: " + count++);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			System.out.println("执行完方法run2...准备释放锁");
			lock.unlock();
			System.out.println("执行完方法run2...成功释放锁");
		}
	};

	public static void main(String[] args) throws InterruptedException {
		LockDemo t = new LockDemo(); // 创建一个对象
		new Thread(t.run1).start();// 获取该对象的方法1
		new Thread(t.run2).start();// 获取该对象的方法2
	}

}
