package com.qulei.designPattern.decorator;

public class ManWrapper extends Man {

	private Person person;

	public ManWrapper(Person person) {
		this.person = person;
	}

	public void eat() {
		person.eat();
		System.out.println("over!");
	}

}
