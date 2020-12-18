package multithreading;

public class CustomSemaphore {
	
	private boolean signal = false;
	
	public synchronized void take() {
		signal = true;
		notify();
	}
	public synchronized void release(){
		while(!signal) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.signal = false;
	}

}
