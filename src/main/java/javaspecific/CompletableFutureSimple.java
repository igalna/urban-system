package main.java.javaspecific;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureSimple {

	public static void main(String[] args) {
		
		final long started = System.currentTimeMillis();
		
		CompletableFuture<Integer> futureCount = createCompletableFuture();
		
		System.out.println("Took " + (started - System.currentTimeMillis()) + " milliseconds");
		
		try {
			int count = futureCount.get();
			System.out.println("Completable Future took " + (started - System.currentTimeMillis()) + " milliseconds");
			System.out.println("Result " + count);
		} catch (InterruptedException | ExecutionException ex) {
			ex.printStackTrace();
		}
	}

	private static CompletableFuture<Integer> createCompletableFuture() {
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(
				() -> {
					try {
						Thread.sleep(5000);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					return 20;
				});
		
		return futureCount;
	}
}