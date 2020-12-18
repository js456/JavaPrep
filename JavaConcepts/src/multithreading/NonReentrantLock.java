package multithreading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class NonReentrantLock {

	static Exception temp() {
		return new Exception();
		
	}
    public static void main(String args[]) {
    	
    	//int a = 123451234512345;
    	List list = new ArrayList();
    	
    	list.add("hello");
    	list.add(2);
    	System.out.println(list.get(0) instanceof Object);
    	System.out.println(list.get(1) instanceof Integer);
    	
    	System.out.println(temp());
		/*
		 * FileReader file = new FileReader("C:\\test\\a.txt"); BufferedReader fileInput
		 * = new BufferedReader(file);
		 * 
		 * // Print first 3 lines of file "C:\test\a.txt" for (int counter = 0; counter
		 * < 3; counter++) System.out.println(fileInput.readLine());
		 * 
		 * fileInput.close();
		 */
		/*
		 * NonReentrantLockClass nreLock = new NonReentrantLockClass();
		 * 
		 * // First locking would be successful nreLock.lock();
		 * System.out.println("Acquired first lock");
		 * 
		 * // Second locking results in a self deadlock
		 * System.out.println("Trying to acquire second lock"); nreLock.lock();
		 * System.out.println("Acquired second lock");
		 */
        
        
    }
}

class NonReentrantLockClass {
	
    boolean isLocked;

    public NonReentrantLockClass() {
        isLocked = false;
    }

    public synchronized void lock() throws InterruptedException {

        while (isLocked) {
            wait();
        }
        isLocked = true;
    }

    public synchronized void unlock() {
        isLocked = false;
        notify();
    }
}