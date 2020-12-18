package multithreading;

public class ThreadLoalExample {
	
	public static void testLamda() {
		
		int a =5;
		
		TestFunctionInterface test  = (int b) ->{
			return a+b;
		};
		
		System.out.println(test.add(8));
		
	}

	public static void main(String[] args) {

		Thread t1 = new Thread(new ThreadLocalContext(1));
		Thread t2 = new Thread(new ThreadLocalContext(2));

		t1.start();

		t2.start();
		
		testLamda();
	}
}

interface TestFunctionInterface{
	int add(int a);
}

class Context {
	private String userName;

	public Context(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "Context{" + "userNameSecret='" + userName + '\'' + '}';
	}
}

class ThreadLocalContext implements Runnable {

	ThreadLocal<Context> thLocalContext = new ThreadLocal<Context>();

	private Integer userId;

	public ThreadLocalContext(Integer userId) {
		this.userId = userId;
	}

	@Override
	public void run() {

		Context context = new Context(UserRepository.getUserName(userId));
		thLocalContext.set(context);
		System.out.println("thread context for given userId: " + userId + " is: " + thLocalContext.get());
	}

}

class UserRepository {

	public static String getUserName(Integer userId) {
		String username;
		switch (userId) {
		case 1:
			username = "john";
			break;
		case 2:
			username = "Rock";
			break;

		default:
			username = "Peter";
			break;
		}
		return username;
	}
}