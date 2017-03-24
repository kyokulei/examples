package com.qulei.concurrent.lock;

public class Test {

	public static void main(String[] args) {
		Storage s = new Storage();

		Producer p1 = new Producer(s,"PRODUCER1");
		Producer p2 = new Producer(s,"PRODUCER2");

		Consumer c1 = new Consumer(s,"CONSUMER1");
		Consumer c2 = new Consumer(s,"CONSUMER2");

		p1.start();
		p2.start();

		c1.start();
		c2.start();

	}
}
