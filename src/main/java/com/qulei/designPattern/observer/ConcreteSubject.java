package com.qulei.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {

	private List<Observer> observers = new ArrayList<Observer>();
	private float temperature;
	private float humidity;
	private float pressure;

	@Override
	public void registerObserver(Observer observer) {

		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {

		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {

		for (Observer observer : observers) {
			observer.update(temperature, humidity, pressure);
		}

	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = temperature;

		measurementsChanged();

	}

}
