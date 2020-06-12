package com.leon.javase.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 避免死锁方法2_2:控制加锁时限，通过lock.tryLock(时间，时间单位)获取
 * 
 * @author leon
 *
 */
public class DeadLock2LockDemo implements Runnable {
	private final static Lock lock = new ReentrantLock();
	private int flag;
	private static Object o1 = new Object();
	private static Object o2 = new Object();

	public DeadLock2LockDemo(int flag) {
		super();
		this.flag = flag;
	}

	public void run() {
		String nowThreadName = Thread.currentThread().getName();
		System.out.println(nowThreadName + "尝试获取锁。。");
		boolean isUnlock = false;
		try {
			if (lock.tryLock(2000, TimeUnit.MILLISECONDS)) {
				isUnlock = true;
				System.out.println(nowThreadName + "获取到锁");
			} else {
				System.out.println(nowThreadName + "获取锁超时");
				return;
			}

			if (flag == 0) {
				System.out.println(nowThreadName + "执行任务t0.。");
				synchronized (o1) {
					System.out.println(nowThreadName + "获得资源o1.。");

					Thread.sleep(2000);

					synchronized (o2) {
						System.out.println(nowThreadName + "获得资源o2.。");
					}
				}
			} else if (flag == 1) {
				System.out.println(nowThreadName + "执行任务t1.。");
				synchronized (o2) {
					System.out.println(nowThreadName + "获得资源o2.。");

					Thread.sleep(2000);

					synchronized (o1) {
						System.out.println(nowThreadName + "获得资源o1.。");
					}
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("InterruptedException");
			e.printStackTrace();
		} finally {
			if (isUnlock) {
				System.out.println(nowThreadName + "释放锁");
				lock.unlock();
			}
		}

	}

	public static void main(String[] args) {

		Thread t0 = new Thread(new DeadLock2LockDemo(0));
		// t1等待t0结束后执行
		Thread t1 = new Thread(new DeadLock2LockDemo(1));
		t0.start();
		t1.start();
	}

}
