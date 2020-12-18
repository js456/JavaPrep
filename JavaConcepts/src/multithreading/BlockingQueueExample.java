package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {

	
	public static void main(String[] args) {
		
		BlockingQueue<Integer>queue = new ArrayBlockingQueue<Integer>(20);
		
		Thread t1 = new Thread(new Producer(queue));
		
		Thread t2 = new Thread(new Consumer(queue));
		
		t1.start();
		t2.start();
		
	}
	
}

class Producer implements Runnable{
	
	private BlockingQueue<Integer>queue;
	
	public Producer(BlockingQueue<Integer>queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		
		for(int i =1000;i<10000;i++) {
			queue.add(i);
			System.out.println("Writing:"+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class Consumer implements Runnable{
	
	private BlockingQueue<Integer>queue;
	
	public Consumer(BlockingQueue<Integer>queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
	
		while(true) {
			try {
				System.out.println("Reading: "+queue.take());
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}