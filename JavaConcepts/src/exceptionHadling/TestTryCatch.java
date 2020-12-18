package exceptionHadling;

public class TestTryCatch {
	
	public void testTryCatch(){
		
		try {
			System.out.println("I am try block");
			throw new NumberFormatException();
		}catch (Exception e) {
			System.out.println("I am catch block");
			System.exit(0);
			return;
		}
		finally {
			System.out.println("I am finally block");
		}
	}

	public static void main(String[] args) {
		
		TestTryCatch tryCatch = new TestTryCatch();
		tryCatch.testTryCatch();
	}
}
