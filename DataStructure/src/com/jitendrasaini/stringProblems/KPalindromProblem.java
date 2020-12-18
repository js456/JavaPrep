package com.jitendrasaini.stringProblems;

public class KPalindromProblem {
	
	
	private static int l;
	private static int h;
	
	public static void stringKPalid(int low, int heigh, char[]arr) {
		if(arr[low]!= arr[heigh] && low>0 && heigh<arr.length-1) {
			l = low-1;
			h = heigh+1;
		}
		stringKPalid(low+1, heigh+1, arr);
	}
	public static void main(String[] args) {
		char []charArr= "abcdecba".toCharArray();
		stringKPalid(0,charArr.length-1,charArr);
		System.out.println("Low:"+l);
		System.out.println("heigh:"+h);
	}
	public static void isPalind(String str) {
		
	}

}
