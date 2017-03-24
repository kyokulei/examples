package com.qulei.concurrent.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test {

	public static void main(String[] args) {

		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);

		Producer p1 = new Producer(queue, "PRODUCER1");
		Producer p2 = new Producer(queue, "PRODUCER2");

		Consumer c1 = new Consumer(queue, "CONSUMER1");
		Consumer c2 = new Consumer(queue, "CONSUMER2");

		p1.start();
		p2.start();

		c1.start();
		c2.start();

	}
}
