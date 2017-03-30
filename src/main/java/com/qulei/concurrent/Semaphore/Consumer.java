package com.qulei.concurrent.Semaphore;

class Consumer extends Thread {
	Storage s;

	public Consumer(Storage s, String name) {
		super(name);
		this.s = s;
	}

	@Override
	public void run() {
		try {
			while (true) {
				s.remove();
				try {
					Thread.currentThread().sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
