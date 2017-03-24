package com.qulei.concurrent.wait_notify;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

	private List<Integer> queue;
	private Object lock;

	public Producer(List<Integer> queue, Object lock) {
		this.queue = queue;
		this.lock = lock;
	}

	@Override
	public void run() {

		for (;;) {
			synchronized (lock) {
				while (queue.size() > 5) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				int i = new Random().nextInt();
				queue.add(i);
				System.out.println(Thread.currentThread().getName() + "--Producing value : " + i);
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				lock.notifyAll();
			}
		}
	}

}
