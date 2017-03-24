package com.qulei.examples;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.qulei.examples.util.CompleteFutureUtil;
import com.qulei.examples.util.TimedEventSupport;
import com.sun.istack.internal.logging.Logger;

/**
 * Hello world!
 *
 */
public class App {
	private static final Logger LOGGER = Logger.getLogger(App.class);

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		

		
		System.out.println("Hello World!");
		// App app = new App();

		// app.completableFutureTest();
		// runNonblocking();

		ScheduledExecutorService schedule = Executors.newSingleThreadScheduledExecutor();

		schedule.scheduleWithFixedDelay(() -> System.out.println(System.currentTimeMillis()), 0, 2, TimeUnit.SECONDS);

		final List<Integer> listI = new ArrayList<Integer>();
		final List<Throwable> listE = new ArrayList<Throwable>();

		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);

		App app = new App();

		Runnable run = () -> System.out.println("sss");
		Consumer<String> consumer = x -> System.out.println(x);
		Supplier<String> supplier = () -> "sss";
		Function<String, String> fn = x -> x + "ddd";
		BiFunction<String, String, Boolean> bifn = (x, y) -> x.equals(y);
		BiConsumer<String, String> biConsumer = (x, y) -> System.out.println(x + y);

		System.out.println(bifn.apply("test", "test"));

		CompletableFuture.runAsync(() -> System.out.println("runAsync test1!"));
		CompletableFuture.runAsync(app::printMsg);
		CompletableFuture.runAsync(() -> app.printMsg());

		CompletableFuture.runAsync(new Runnable() {
			@Override
			public void run() {
				System.out.println("runAsync test1!");
			}
		});

		CompletableFuture.runAsync(() -> System.out.println("runAsync test1!"), threadPool);

		CompletableFuture.supplyAsync(() -> 2).thenAccept(x -> System.out.println("runAsync test" + x + "!"));
		CompletableFuture.supplyAsync(() -> {
			return 2;
		}).thenAccept(x -> System.out.println("runAsync test" + x + "!"));

		List<CompletableFuture<Integer>> tasks = IntStream.range(1, 100).mapToObj(i -> {
			return CompletableFuture.supplyAsync(() -> i).thenComposeAsync(x -> {
				return CompleteFutureUtil.compute(x, threadPool);
			});

		}).collect(Collectors.toList());

		Map<Integer, Exception> errors = new HashMap<Integer, Exception>();

		CompleteFutureUtil.allOf(tasks).handle((x, e) -> {

			for (int i = 0; i < tasks.size(); i++) {
				try {

					CompletableFuture<Integer> task = tasks.get(i);
					System.out.println(task.getNow(9_9999_9999));
				} catch (Exception e1) {

					errors.put(i, e1);
				}

			}

			for (Map.Entry<Integer, Exception> entry : errors.entrySet()) {

				System.out.println(entry.getKey());
				System.out.println(entry.getValue());

			}

			return null;

		});

		System.out.println("over");
		// for (CompletableFuture<Throwable> future : futures) {
		// future.handle((x, e) -> {
		//
		// System.out.println(x);
		// System.out.println(e);
		// return null;
		// });
		//
		// }

		// CompleteFutureUtil.allOf(futures).join();
		// System.out.println("over");

		// futures.stream().forEach(future -> {
		// future.handle((x, e) -> {
		// if (x != null) {
		// System.out.println(x);
		// listI.add(x);
		// }
		// if (e != null) {
		// System.out.println(e);
		// listE.add(e);
		// }
		//
		// return null;
		// });
		// });

		//
		// listI.stream().filter(i -> i != null).forEach(System.out::println);
		// listE.stream().filter(e -> e != null).forEach(x ->
		// System.out.println(x.getMessage()));
		//
		// futures.stream().forEach(future -> {
		// future.thenAccept(x -> {
		// System.out.println(x);
		//
		// });
		// });
		//
		// System.out.println("over!");
		//
		// CompleteFutureUtil.allOf(futures).thenAccept(x ->
		// threadPool.shutdown()).complete(null);

	}

	public void completableFutureTest() {

		ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
		CompleteFutureUtil.retry(this::makeError, 10, 1, TimeUnit.SECONDS, threadPool);
	}

	private void makeError() {

		System.out.println("1123123123");
		throw new NullPointerException("ssss");

	}

	private void printMsg() {

		System.out.println("success!!");
	}

	// task1 -> task2,task3 run at the same time -> task4

	private static CompletableFuture<Integer> runNonblocking() {
		return task1(1)
				.thenCompose(i1 -> ((CompletableFuture<Integer>) task2(i1).thenCombine(task3(i1), (i2, i3) -> i2 + i3)))
				.thenCompose(i4 -> task4(i4));
	}

	// task definitions
	private static CompletableFuture<Integer> task1(int input) {
		return TimedEventSupport.delayedSuccess(1, input + 1);
	}

	private static CompletableFuture<Integer> task2(int input) {
		return TimedEventSupport.delayedSuccess(2, input + 2);
	}

	private static CompletableFuture<Integer> task3(int input) {
		return TimedEventSupport.delayedSuccess(3, input + 3);
	}

	private static CompletableFuture<Integer> task4(int input) {
		return TimedEventSupport.delayedSuccess(1, input + 4);
	}
}
