package com.qulei.concurrent.lock;

class Producer extends Thread {
	Storage s;

	public Producer(Storage s,String name) {
		super(name);
		this.s = s;
	}

	@Override
	public void run() {
		try {
			while (true) {
				s.put();
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
