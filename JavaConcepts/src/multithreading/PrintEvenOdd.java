package multithreading;

public class PrintEvenOdd implements Runnable {

	// private static Lock lock = new ReentrantLock();

	private int max;
	private Printer print;
	private boolean isEvenNumber;

public PrintEvenOdd(Printer printer, int i, boolean isEvenNumber) {
		this.print = printer;
		this.max = i;
		this.isEvenNumber = isEvenNumber;
	}

// standard constructors

	@Override
	public void run() {
		int number = isEvenNumber ? 2 : 1;
		while (number <= max) {
			if (isEvenNumber) {
				print.printEven(number);
			} else {
				print.printOdd(number);
			}
			number += 2;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Printer printer = new Printer();
		// PrintEvenOdd test = new PrintEvenOdd(printer,20);
		Thread t1 = new Thread(new PrintEvenOdd(printer, 20, false), "odd");
		Thread t2 = new Thread(new PrintEvenOdd(printer, 20, true), "even");
		t1.start();
		t2.start();
		// t1.join();
		// t2.join();
	}
}

class Printer {
	private boolean isOdd;

	public synchronized void printEven(int number) {

		// synchronized (lock) {
		while (!isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify();
		isOdd = false;
		System.out.println("Print Even: " + Thread.currentThread().getName() + " - " + number);

		// }
	}

	public synchronized void printOdd(int number) {

		// synchronized (lock) {
		while (isOdd) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify();
		isOdd = true;
		System.out.println("Print Odd: "+Thread.currentThread().getName() + " - " + number);

		// }

	}
}
