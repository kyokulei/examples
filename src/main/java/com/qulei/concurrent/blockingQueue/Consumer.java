package com.qulei.concurrent.blockingQueue;

import java.util.concurrent.BlockingQueue;

class Consumer extends Thread {
	private BlockingQueue<Integer> queue;

	public Consumer(BlockingQueue<Integer> queue, String name) {
		super(name);
		this.queue = queue;
	}

	@Override
	public void run() {
		while (true) {

			try {
				int i = queue.take();
				System.out.printf("%s consumed %d from queue %n", Thread.currentThread().getName(), i);

			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
