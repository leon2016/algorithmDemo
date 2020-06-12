package com.leon.javase.pattern;

public interface Subject {

	void add(Observe observe);

	void del(Observe observe);

	void operation();

	void notifyObservers();
}
