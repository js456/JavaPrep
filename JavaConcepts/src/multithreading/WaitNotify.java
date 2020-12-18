package multithreading;

import java.util.concurrent.ThreadLocalRandom;

import org.junit.Test;

public class WaitNotify {

	public static void main(String[] args) {
		WaitNotifyDemo demo1 = new WaitNotifyDemo();
		//demo1.start();
		
		Data data = new Data();
	    Thread sender = new Thread(new Sender(data));
	    Thread receiver = new Thread(new Receiver(data));
	    
	    sender.start();
	    receiver.start();
	}
}

class WaitNotifyDemo extends Thread {

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println("Thread: " + Thread.currentThread().getName() + " value" + i);
		}
	}
}

class Data {

	private String packet;
	private boolean transfer;

	@Test
	public synchronized void sender(String packet) {
		while (!transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		transfer = false;
		this.packet = packet;
		notifyAll();
	}
	
	@Test
	public synchronized String receiver() {
		while(transfer) {
			try {
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
		}
		//System.out.println(this.packet);
		transfer = true;	
		notifyAll();
		return packet;
	}

}

class Sender implements Runnable {
    private Data data;
 
    
 
    public Sender(Data data) {
		super();
		this.data = data;
	}



	public void run() {
        String packets[] = {
          "First packet",
          "Second packet",
          "Third packet",
          "Fourth packet",
          "End"
        };
 
        for (String packet : packets) {
            data.sender(packet);
 
            // Thread.sleep() to mimic heavy server-side processing
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                //Log.error("Thread interrupted", e); 
            }
        }
    }
}

class Receiver implements Runnable {
    private Data load;
 
    
 
    public Receiver(Data load) {
		super();
		this.load = load;
	}



	public void run() {
        for(String receivedMessage = load.receiver();
          !"End".equals(receivedMessage);
          receivedMessage = load.receiver()) {
            
            System.out.println(receivedMessage);
 
            // ...
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); 
                //Log.error("Thread interrupted", e); 
            }
        }
    }
}
