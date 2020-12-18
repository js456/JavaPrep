package multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletlableFuture {
	
	
	public static Future<String> calculateAsync(){
		
		CompletableFuture<String> future = new CompletableFuture<String>();
		
		Executors.newCachedThreadPool().submit(()-> {
			try {
				Thread.sleep(500);
				future.complete("Hello");
				return null;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		});
		
		return future;
	}
	
	public static void test() throws InterruptedException, ExecutionException {
		
		Future<String>future = calculateAsync();
		System.out.println(future.get());
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		calculateAsync();
		test();
	}

}
