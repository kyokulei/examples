package com.qulei.concurrent.blockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

class Producer extends Thread {
	private final Random random = new Random();
	private BlockingQueue<Integer> queue;

	public Producer(BlockingQueue<Integer> queue, String name) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {

			try {
				int i = random.nextInt();
				System.out.printf("%s added %d into queue %n", Thread.currentThread().getName(), i);
				queue.put(i);

			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

			try {
				Thread.currentThread().sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
