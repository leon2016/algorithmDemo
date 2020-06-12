package com.leon.javase.concurrent;

public class Bussiness1 {
	private boolean subflag = true;

	// 子线程
	public synchronized void subMethod() {
		if (!subflag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("开始执行子线程" + i);
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subflag = false;
		notify();
	}

	// 主线程
	public synchronized void mainMethod() {
		if (subflag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			for (int i = 0; i < 5; i++) {
				System.out.println("开始执行主线程" + i);
				Thread.sleep(1000);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subflag = true;
		notify();
	}

	public static void main(String[] args) {
		final Bussiness1 bus = new Bussiness1();
		// 子线程
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 3; i++) {
					bus.subMethod();
				}
			}
		}).start();

		// 主线程
		for (int i = 0; i < 3; i++) {
			bus.mainMethod();
		}
	}
}
