package com.qulei.concurrent.wait_notify;

import java.util.List;

public class Consumer implements Runnable {

	private List<Integer> queue;
	private Object lock;

	public Consumer(List<Integer> queue, Object lock) {
		this.queue = queue;
		this.lock = lock;
	}

	@Override
	public void run() {

		for (;;) {
			synchronized (lock) {
				while (queue.size() == 0) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

				int i = queue.remove(0);
				System.out.println(Thread.currentThread().getName() + "--Consuming value : " + i);
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				lock.notifyAll();
			}
		}
	}
}
