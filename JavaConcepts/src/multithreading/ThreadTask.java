package multithreading;

public class ThreadTask implements Runnable{

	@Override
	public void run() {
		
		System.out.println("Excuting thread task");
		
	}

	public static void main(String[] args) {
		
		String str = "A";
		
		System.out.println(str.charAt(0));
		
		String dsReferenceNumber = "3DS_LOA_DIS_GDCB_jk";
		
	       if (dsReferenceNumber.contains("3DS_LOA_DIS")) {
	          dsReferenceNumber = dsReferenceNumber.substring(0, 16);
	       }
	       System.out.println(dsReferenceNumber);
	}
}
