package com.qulei.designPattern.singleton;

public class SingletonLazyDoubleCheck {

	private volatile static SingletonLazyDoubleCheck singleton = null;

	private SingletonLazyDoubleCheck() {

	}

	public static SingletonLazyDoubleCheck getInstance() {
		if (singleton == null) {
			synchronized (SingletonLazyDoubleCheck.class) {
				if (singleton == null) {
					singleton = new SingletonLazyDoubleCheck();
				}
			}
		}
		return singleton;
	}
}
