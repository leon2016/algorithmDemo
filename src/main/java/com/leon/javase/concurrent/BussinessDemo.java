package com.leon.javase.concurrent;

/**
 * 下面我们通过一道面试题来体会线程的交互。
 * 
 * 要求：子线程运行执行10次后，主线程再运行5次。这样交替执行三遍
 **/
public class BussinessDemo {
	public static void main(String[] args) {
		final Bussiness bussiness = new Bussiness();
		// 子线程
		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 3; i++) {
					bussiness.subMethod();
				}
			}
		}).start();
		// 主线程
		for (int i = 0; i < 3; i++) {
			bussiness.mainMethod();
		}
	}
}
