package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemoCallable {

	public static void main(String[] args) {
		
		ExecutorService executer = Executors.newFixedThreadPool(2);
		
		ThreadTask task = new ThreadTask();
	}
}


