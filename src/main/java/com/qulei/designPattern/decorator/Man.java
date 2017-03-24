package com.qulei.designPattern.decorator;

public class Man implements Person {

	@Override
	public void eat() {
		System.out.println("main is eatting");
	}

	@Override
	public void sleep() {
		System.out.println("sleep!");
	}

}
