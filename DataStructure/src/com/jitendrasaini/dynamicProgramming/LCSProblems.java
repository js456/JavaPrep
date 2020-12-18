package com.jitendrasaini.dynamicProgramming;

import java.util.Arrays;

public class LCSProblems {
	
	public static int lcs(char []x, char []y, int i, int j) {
		
		//adcef abcefj
		if(i ==0 || j == 0)
			return 0;
		if(x[i-1] == y[j-1]) {
			return 1+lcs(x, y, i-1, j-1);
		}
		else {
			return Math.max(lcs(x, y, i-1, j), lcs(x, y, i, j-1));
		}
	}
	public static int lcsubstring(char []x, char []y, int i, int j, int result) {
		
		//adcef abcefj
		if(i ==0 || j == 0)
			return result;
		if(x[i-1] == y[j-1]) {
			result =  lcsubstring(x, y, i-1, j-1, result+1);
		}
		return Math.max(result, Math.max(lcsubstring(x, y, i-1, j,0), lcsubstring(x, y, i, j-1,0)));

	}
	
	public static void main(String[] args) {
		String s1 = "adcec";
		String s2 = "abcefj";
		System.out.println(lcs(s1.toCharArray(), s2.toCharArray() , s1.length(), s2.length()));
		System.out.println(lcsubstring(s1.toCharArray(), s2.toCharArray() , s1.length(), s2.length(),0));
		System.out.println(newLcs(s1.toCharArray(), s2.toCharArray() , s1.length(), s2.length()));
	}
	
	public static int newLcs(char[] s1, char[] s2, int m, int n) {
		
		int dp[][] = new int[m+1][n+1];
		//Arrays.fill(dp, 0);
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				
				if(i ==0 || j==0)
					dp[i][j]=0;
				else if(s1[i-1]== s2[j-1]) {
					dp[i][j]= 1+dp[i-1][j-1];
				}else {
					dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return dp[m-1][n-1];
		
	}

}
