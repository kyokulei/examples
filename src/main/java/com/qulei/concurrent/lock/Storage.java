package com.qulei.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {

	private static int CAPACITY = 10;
	private final Random theRandom = new Random();

	private final Lock aLock = new ReentrantLock();
	private final List<Integer> queue = new ArrayList<Integer>();
	private final Condition notEmpty = aLock.newCondition();
	private final Condition notFull = aLock.newCondition();

	public void put() throws InterruptedException {
		aLock.lock();

		try {
			while (queue.size() == CAPACITY) {
				System.out.println(Thread.currentThread().getName() + " : Queue is full, waiting");
				notFull.await();
			}

			int number = theRandom.nextInt();
			queue.add(number);
			System.out.printf("%s added %d into queue %n", Thread.currentThread().getName(), number);
			notEmpty.signalAll();

		} finally {
			aLock.unlock();
		}
	}

	public void remove() throws InterruptedException {
		aLock.lock();

		try {
			while (queue.size() == 0) {
				System.out.println(Thread.currentThread().getName() + " : Queue is empty, waiting");
				notEmpty.await();
			}
			Integer value = queue.remove(0);
			System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), value);
			notFull.signalAll();

		} finally {
			aLock.unlock();
		}
	}

}
