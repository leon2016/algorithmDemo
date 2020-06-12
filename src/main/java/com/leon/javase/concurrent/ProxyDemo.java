package com.leon.javase.concurrent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
/**
 * 笔试题：写一个ArrayList的动态代理
 * 核心:Proxy.newProxyInstance(classLoader,infaces,invocationHander);
 * @author leon
 *
 */
public class ProxyDemo {
	public static void main(String[] args) {
		final List<String> list = new ArrayList<String>();
		@SuppressWarnings("unchecked")
		List<String> listProxy = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader(),
		        list.getClass().getInterfaces(), new InvocationHandler() {
			        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				        System.out.println("执行代理。。");
				        return method.invoke(list, args);
			        }

		        });
		listProxy.add("你好！");
		System.out.println(list);

	}
}
