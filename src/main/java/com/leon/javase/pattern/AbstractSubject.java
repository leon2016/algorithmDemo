package com.leon.javase.pattern;

import java.util.Enumeration;
import java.util.Vector;

public abstract class AbstractSubject implements Subject {

	private Vector<Observe> obServes = new Vector<Observe>();

	public void add(Observe observe) {
		obServes.add(observe);

	}

	public void del(Observe observe) {
		obServes.remove(observe);

	}

	public void notifyObservers() {
		Enumeration<Observe> elements = obServes.elements();
		while (elements.hasMoreElements()) {
			elements.nextElement().update();
		}

	}

}
