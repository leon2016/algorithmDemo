package com.leon.javase.concurrent;
/**synchronize实现死锁实例
 * 1.互斥条件：共享资源 o1，o2
 * 2.不剥夺条件：只能主动释放
 * 3.请求和保持条件：持有o1，请求o2
 * 4.循环等待：任务t0等待t1释放资源o2，任务t1等待t0释放资源o1
 * @author leon
 *
 */
public class DeadLockDemo implements Runnable {
	private int flag;
	private static Object o1 = new Object();
	private static Object o2 = new Object();

	DeadLockDemo(int flag) {
		this.flag = flag;
	}

	public void run() {

		if (flag == 0) {
			synchronized (o1) {
				System.out.println("t0获得资源o1,请求资源o2...");
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
			synchronized (o2) {
				System.out.println("t1获得资源o2,请求资源o1...");
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
		Thread t0 = new Thread(new DeadLockDemo(0));
		Thread t1 = new Thread(new DeadLockDemo(1));
		t0.start();
		t1.start();
	}

}
