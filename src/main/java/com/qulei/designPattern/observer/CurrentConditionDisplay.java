package com.qulei.designPattern.observer;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

	private Observable observable;
	private String name;
	private float temperature;
	private float humidity;
	private float pressure;

	public CurrentConditionDisplay(String name, Observable ob) {

		this.name = name;
		this.observable = ob;
		observable.addObserver(this);

	}

	@Override
	public void display() {
		System.out.println(String.format("%s : tmprature is %s, humidity is %s,pressure is %s;", name, temperature,
				humidity, pressure));

	}

	@Override
	public void update(Observable observable, Object arg1) {

		if (observable instanceof WeatherData) {

			WeatherData weatherData = (WeatherData) observable;

			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			this.pressure = weatherData.getPressure();
			display();
		}

	}

}
