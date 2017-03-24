package com.qulei.designPattern.observer;

public class ConcreteObserver implements Observer, DisplayElement {

	private String name;
	private float temprature;
	private float humidity;
	private float pressure;

	public ConcreteObserver(String name) {
		super();
		this.name = name;
	}

	@Override
	public void update(float temperature, float humidity, float pressure) {

		this.temprature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	@Override
	public void display() {

		System.out.println(String.format("%s : tmprature is %s, humidity is %s,pressure is %s;", name, temprature,
				humidity, pressure));

	}

}
