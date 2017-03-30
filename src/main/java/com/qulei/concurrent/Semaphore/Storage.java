package com.qulei.concurrent.Semaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Storage {

	private final Random theRandom = new Random();
	private final List<Integer> queue = new ArrayList<Integer>();
	private final Semaphore notFull = new Semaphore(10);
	private final Semaphore notEmpty = new Semaphore(0);
	private final Semaphore mutex = new Semaphore(1);

	public void put() throws InterruptedException {

		notFull.acquire();
		mutex.acquire();
		try {

			int number = theRandom.nextInt();
			queue.add(number);
			System.out.printf("%s added %d into queue %n", Thread.currentThread().getName(), number);

		} finally {
			mutex.release();
			notEmpty.release();
		}
	}

	public void remove() throws InterruptedException {
		notEmpty.acquire();
		mutex.acquire();
		try {
			Integer value = queue.remove(0);
			System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), value);

		} finally {
			mutex.release();
			notFull.release();

		}
	}

}
