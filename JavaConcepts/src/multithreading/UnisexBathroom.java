package multithreading;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnisexBathroom {

	public static void main(String[] args) {
		BathroomInterface bathroom = new BathroomInterfaceImpl();
		
		Thread t1 = new Thread(new ManUsingBathroom(bathroom),"man");
		Thread t2 = new Thread(new WomenUsingBathroom(bathroom),"women");
		
		t1.start();
		t2.start();
	}
}


interface BathroomInterface{
    public static final int BATHROOM_SIZE = 3; //3 is just example
    void manEnter();
    void manExit();
    void womanEnter();
    void womanExit();
}

class BathroomInterfaceImpl implements BathroomInterface{

	
	private Semaphore semaphore;
	private boolean isMaleUsing = false;
	private volatile int currentCount;
	private int womenWaitingN = 0;
	private int menWaitingN = 0;
	private int womenUsingN = 0;
	private int menUsingN = 0;
	private Lock lock = new ReentrantLock();
	
	public BathroomInterfaceImpl() {
		semaphore = new Semaphore(BathroomInterface.BATHROOM_SIZE);
	}
	@Override
	public void manEnter() {
		if(!isMaleUsing) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		try {
			semaphore.acquire();
			currentCount++;
			if(currentCount>=BathroomInterface.BATHROOM_SIZE) {
				isMaleUsing=false;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void manExit() {
		semaphore.release();
		
	}

	@Override
	public void womanEnter() {
		if(isMaleUsing) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		try {
			semaphore.acquire();
			currentCount++;
			if(currentCount>=BathroomInterface.BATHROOM_SIZE) {
				isMaleUsing=true;
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void womanExit() {
		semaphore.release();
	}
	
}

class ManUsingBathroom implements Runnable{

	
	private BathroomInterface bathroom;
	
	public ManUsingBathroom(BathroomInterface bathroom) {
		this.bathroom = bathroom;
	}
	
	@Override
	public void run() {
		for(int i=0;i<5;i++) {
			bathroom.manEnter();
		}
		
	}
	
}

class WomenUsingBathroom implements Runnable{

	private BathroomInterface bathroom;
	
	
	
	public WomenUsingBathroom(BathroomInterface bathroom) {
		super();
		this.bathroom = bathroom;
	}



	@Override
	public void run() {
		
		for(int i=0;i<5;i++) {
			bathroom.womanEnter();
		}
		
	}
	
}