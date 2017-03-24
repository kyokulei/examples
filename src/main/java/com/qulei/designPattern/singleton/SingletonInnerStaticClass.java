package com.qulei.designPattern.singleton;

public class SingletonInnerStaticClass {

	public SingletonInnerStaticClass() {
	}

	public static SingletonInnerStaticClass getInstance() {
		return InnerClass.INSTATNCE;
	}

	private static class InnerClass {
		private static SingletonInnerStaticClass INSTATNCE = new SingletonInnerStaticClass();
	}

}
