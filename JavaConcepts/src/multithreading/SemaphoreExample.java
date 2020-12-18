package multithreading;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

import org.junit.Test;

public class SemaphoreExample {
	
	@Test
	public void testSemaphore() {
		
		ExecutorService executer = Executors.newFixedThreadPool(10);
		
		LoginSemaphore login = new LoginSemaphore(5);
		IntStream.range(0, 10).forEach(user ->executer.execute(login::tryLogin));
		executer.shutdown();
		
		System.out.println(login.availableSlots());
		System.out.println(login.tryLogin());
		assertEquals(0, login.availableSlots());
		assertFalse(login.tryLogin());
		
		login.logout();
		System.out.println(login.availableSlots());
		System.out.println(login.tryLogin());
	}

	public static void main(String[] args) {
		//testSemaphore();
	}
}

class LoginSemaphore {

	private Semaphore semaphore;

	public LoginSemaphore(int count) {
		this.semaphore = new Semaphore(count);
	}

	boolean tryLogin() {
		return this.semaphore.tryAcquire();
	}

	void logout() {
		this.semaphore.release();
	}

	int availableSlots() {
		return this.semaphore.availablePermits();
	}
}