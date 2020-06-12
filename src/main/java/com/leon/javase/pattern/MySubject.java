package com.leon.javase.pattern;

/**
 * 观察者模式：被观察者变化后，会通知所有相关的观察者
 * 
 * 实现机制：被观察者里维护一个观察者集合
 * 
 * @author leon
 *
 */
public class MySubject extends AbstractSubject {

	public void operation() {
		System.out.println("被观察者更新了。。");
		notifyObservers();

	}

	public static void main(String[] args) {
		Observe obj1 = new Observe1();
		Observe obj2 = new Observe2();
		MySubject sub = new MySubject();
		// 订阅
		sub.add(obj1);
		sub.add(obj2);
		// 更新
		sub.operation();
		Integer a = 10;// 自动装箱缓存在-128~127
		Integer b = 10;
		System.out.println(a == b);// true;发生自动装箱，且会利用Integer缓存
		Integer a2 = 128;//
		Integer b2 = 128;
		System.out.println(a2 == b2);
		Integer a3 = new Integer(100);
		Integer b3 = new Integer(100);
		System.out.println(a3 == b3);
		Integer a4 = 10;
		Integer b4 = new Integer(10);
		System.out.println(a4 == b4);
		int a5 = 10; 
		Integer b5 = new Integer(10);
		System.out.println(a5 == b5);// true原因：包装类会自动拆箱变成大小比较

	}
}
