package com.qulei.designPattern.singleton;

public class SingletonLazy {

	private static SingletonLazy singleton = null;

	private SingletonLazy() {

	}

	public static SingletonLazy getInstance() {

		if (singleton == null) {

			singleton = new SingletonLazy();
		}

		return singleton;
	}
}
