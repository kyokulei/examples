package com.qulei.concurrent.wait_notify;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<Integer> queue = new ArrayList<Integer>();
		Object lock = new Object();

		Producer p = new Producer(queue, lock);
		Consumer c = new Consumer(queue, lock);

		Thread thread1 = new Thread(p, "producer");
		Thread thread2 = new Thread(c, "consumer");

		thread1.start();
		thread2.start();
	}
}
