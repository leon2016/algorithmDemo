package com.leon.javase.concurrent;

public class producerAndCustomerDemo {
	public static void main(String[] args) {
		Resources r = new Resources();
		Producer pro = new Producer(r);
		Consumer con = new Consumer(r);
		Thread t1 = new Thread(pro);
		Thread t2 = new Thread(con);
		t1.start();
		t2.start();
	}
}

class Resources {
	private String name;
	private int count = 0;
	private boolean flag = false;// 是否停止生产

	public synchronized void set(String name) {
		while (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.name = name + "----" + (++count);
		System.out.println(Thread.currentThread().getName() + "生产者" + this.name);
		this.flag = true;
		notifyAll();
	}

	public synchronized void out() {
		while (!flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + "消费者" + this.name);
		this.flag = false;
		notifyAll();

	}

}

// 生产者
class Producer implements Runnable {
	private Resources res;

	Producer(Resources res) {
		this.res = res;
	}

	public void run() {
		while (true) {
			res.set("商品");
		}
	}
}

// 消费者
class Consumer implements Runnable {
	private Resources res;

	Consumer(Resources res) {
		this.res = res;
	}

	public void run() {
		while (true) {
			res.out();
		}
	}
}