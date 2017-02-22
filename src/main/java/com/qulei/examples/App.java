package com.qulei.examples;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.qulei.examples.util.CompleteFutureUtil;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");
		App app = new App();

		app.completableFutureTest();
	}

	public void completableFutureTest() {

		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
		CompleteFutureUtil.retry(this::makeError, 10, 1, TimeUnit.SECONDS, threadPool);
	}

	private void makeError() {

		System.out.println("1123123123");
		throw new NullPointerException("ssss");

	}
}
