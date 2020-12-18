
public class StringTest {

	
	public static void main(String[] args) {
		String str = "3DS_LOA_DIS_CATE_020100_00052";

		System.out.println(str.substring(0, str.indexOf("_",12)));
	}
}
