package multithreading;

import java.util.concurrent.Phaser;

public class PhaserExample {

	public static void makeZip() {
		System.out.println("Making Zip File...........");
	}
	public static void main(String[] args) {
		
		Phaser phaser = new Phaser(2);
		Thread config = new Thread(new CopyConfiguration(phaser));
		Thread images = new Thread(new CopyImages(phaser));
		Thread video = new Thread(new CopyVideoFile(phaser));
		
		config.start();
		images.start();
		video.start();
		int currentPhase = phaser.getPhase();
		System.out.println("Current Phase: "+currentPhase);
		
        phaser.arriveAndAwaitAdvance(); 
        System.out.println("Phase "
                           + currentPhase 
                           + " Complete"); 
        System.out.println("Phase One Ended"); 
  
        // Wait for all threads to complete phase two. 
        currentPhase = phaser.getPhase(); 
        phaser.arriveAndAwaitAdvance(); 
        System.out.println("Phase "
                           + currentPhase 
                           + " Complete"); 
        System.out.println("Phase Two Ended"); 
  
        currentPhase = phaser.getPhase(); 
        phaser.arriveAndAwaitAdvance(); 
        System.out.println("Phase "
                           + currentPhase 
                           + " Complete"); 
        System.out.println("Phase Three Ended"); 
  
        // Deregister the main thread. 
        phaser.arriveAndDeregister(); 
        if (phaser.isTerminated()) { 
            System.out.println("Phaser is terminated"); 
        } 
        
		makeZip();
	}
}

class CopyConfiguration implements Runnable {

	Phaser phaser;

	public CopyConfiguration(Phaser phaser) {
		this.phaser = phaser;
		phaser.register();
	}

	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		System.out.println("Copying Files.......");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phaser.arriveAndDeregister();
	}

}

class CopyImages implements Runnable {

	Phaser phaser;

	public CopyImages(Phaser phaser) {
		this.phaser = phaser;
		phaser.register();
	}

	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		System.out.println("Copying Files.......");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phaser.arriveAndDeregister();
	}

}

class CopyVideoFile implements Runnable {

	Phaser phaser;

	public CopyVideoFile(Phaser phaser) {
		this.phaser = phaser;
		phaser.register();
	}

	@Override
	public void run() {
		phaser.arriveAndAwaitAdvance();
		System.out.println("Copying Files.......");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phaser.arriveAndDeregister();
	}

}