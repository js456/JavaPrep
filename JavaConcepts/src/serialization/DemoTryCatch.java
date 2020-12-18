package serialization;

public class DemoTryCatch {
	
	public static int test() {
		
		try {
			int temp = 5/0;
		}catch(Exception e) {
			return 4;
		}finally {
			return 7;
		}
		
	}
	
	public static void main(String[] args) {
		System.out.println(test());;
	}
}
