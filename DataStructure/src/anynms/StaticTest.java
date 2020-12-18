package anynms;

public class StaticTest {

	public static void main(String[] args) {
		System.out.println(Math.pow(2, 3));
		/*
		 * Intialize x = new Intialize(); x.init();
		 * System.out.println(Temp.PWCALLBACKKEYPASSWORDVAL); Intialize1 y = new
		 * Intialize1(); y.init(); System.out.println(Temp.PWCALLBACKKEYPASSWORDVAL);
		 */
		System.out.println(24 % 1000000007);
	}
    static long Maximum_Product(int[][] ar){
        
        int maxProduct = Integer.MIN_VALUE;
        
        for(int i =0 ; i<ar.length;i++) {
        	
        	int temp = 0;
        	for(int j=0; j<ar[0].length;j++) {
        		temp += j%(10^9+7);
        	}
        	if(maxProduct<temp)
        		maxProduct = temp;
        }
        return maxProduct;
    
    }

}



class Temp{
	public static String PWCALLBACKKEYPASSWORDVAL;
}
class Intialize{
	
	public void init() {
		Temp.PWCALLBACKKEYPASSWORDVAL="password";
	}
	
}
class Intialize1{
	
	public void init() {
		Temp.PWCALLBACKKEYPASSWORDVAL="changed";
	}
	
}