package recursion;

public class Staircase {
	public static int staircase(int n, int m) {
		  if(n<=0)
		    return 1;
		  int count =0;
		  for(int i=1; i<=m;i++) {
		    if(i <= n)
		      count += staircase(n-i, m);
		  }
		  return count;
	}
	public static void main(String[] args) {
		System.out.println(staircase(4, 2));
	}
}
