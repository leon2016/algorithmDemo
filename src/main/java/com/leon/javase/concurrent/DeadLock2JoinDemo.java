package com.leon.javase.concurrent;

/**
 * 避免死锁方法2_1:线程按照一定顺序加锁（t.join:线程t执行完后才会执行t.join其后语句）
 * 
 * @author leon
 *
 */
public class DeadLock2JoinDemo implements Runnable {
	private int flag;
	private Thread t;
	private static Object o1 = new Object();
	private static Object o2 = new Object();

	public DeadLock2JoinDemo(int flag) {
		super();
		this.flag = flag;
	}

	public DeadLock2JoinDemo(int flag, Thread t) {
		super();
		this.flag = flag;
		this.t = t;
	}

	public void run() {

		if (flag == 0) {
			if (t != null) {
				try {
					t.join();// 关键代码：t执行完后才会执行本线程后续方法
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("执行任务t0.。");
			synchronized (o1) {
				System.out.println("t0获得资源o1.。");
				try {
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o2) {
					System.out.println("t0获得资源o2.。");
				}
			}
		} else if (flag == 1) {
			if (t != null) {
				try {
					t.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("执行任务t1.。");
			synchronized (o2) {
				System.out.println("t1获得资源o2.。");
				try {
					Thread.sleep(2000);

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				synchronized (o1) {
					System.out.println("t1获得资源o1.。");
				}
			}
		}

	}

	public static void main(String[] args) {
		Thread t0 = new Thread(new DeadLock2JoinDemo(0));
		// t1等待t0结束后执行
		Thread t1 = new Thread(new DeadLock2JoinDemo(1, t0));
		t0.start();
		t1.start();
	}

}
