package com.qulei.designPattern.observer;

public class ObserverTest {

	public static void main(String[] args) {

		ConcreteSubject subject = new ConcreteSubject();

		Observer observer1 = new ConcreteObserver("ob1");
		Observer observer2 = new ConcreteObserver("ob2");

		subject.registerObserver(observer1);
		subject.registerObserver(observer2);

		subject.setMeasurements(1.1f, 2.1f, 3.1f);

		WeatherData wd = new WeatherData();

		CurrentConditionDisplay o1 = new CurrentConditionDisplay("ob3", wd);
		CurrentConditionDisplay o2 = new CurrentConditionDisplay("ob4", wd);

		wd.setMeasurements(1.1f, 2.1f, 3.1f);

	}

}
