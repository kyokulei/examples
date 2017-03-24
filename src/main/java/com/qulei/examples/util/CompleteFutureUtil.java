package com.qulei.examples.util;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

public class CompleteFutureUtil {

	private static final Logger LOGGER = Logger.getLogger(CompleteFutureUtil.class);

	/**
	 * Function to schedule a runnable and retry if if it fails. Will try as
	 * many times as maxTries.
	 * 
	 * @param task
	 * @param maxTries
	 * @param delay
	 * @param unit
	 * @param executor
	 * @return
	 */
	public static CompletableFuture<Void> retry(Runnable task, int maxTries, int delay, TimeUnit unit,
			ScheduledExecutorService executor) {
		CompletableFuture<Void> future = new CompletableFuture<>();
		Runnable command = new Runnable() {
			int tries = 0;

			@Override
			public void run() {
				try {
					doRun();
				} catch (Exception e) {
					future.completeExceptionally(e);
				}
			}

			void doRun() {
				tries += 1;
				try {
					task.run();
					future.complete(null);
				} catch (Exception e) {
					if (tries < maxTries) {
						executor.schedule(this, delay, unit);
					} else {
						future.completeExceptionally(e);
					}
				}
			}
		};
		executor.execute(command);
		return future;
	}

	/**
	 * Sleep between tasks
	 * 
	 * @param seconds
	 * @param executor
	 * @return
	 */
	public static CompletableFuture<Void> sleep(int seconds, ScheduledExecutorService executor) {
		CompletableFuture<Void> sleep = new CompletableFuture<>();
		executor.schedule(() -> sleep.complete(null), seconds, TimeUnit.SECONDS);
		return sleep;
	}

	/**
	 * Returns a new CompletableFuture that is completed when all of the given
	 * CompletableFutures completed.
	 * 
	 * @param futures
	 * @param <T>
	 * @return
	 */
	public static <T> CompletableFuture<Void> allOf(List<CompletableFuture<T>> futures) {
		return CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]));
	}

	public static CompletableFuture<Integer> compute(int i, ScheduledExecutorService executor) {

		return CompletableFuture.supplyAsync(() -> {

			if (i % 5 == 0) {
				return i;
			} else {
				throw new IllegalStateException("ssssss" + i);
			}

		}, executor);

	}
}
