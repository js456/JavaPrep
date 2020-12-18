package com.jitendrasaini.stringProblems;

public class StringPermutations {

	
	public static String swap(String str, int i, int j) {
		char[]charArr = str.toCharArray();
		char tempCh= charArr[i];
		charArr[i] = charArr[j];
		charArr[j] = tempCh;
		return String.valueOf(charArr);
	}
	public static void permute(String str, int low, int high) {
		if(low == high) {
			System.out.println(str);
		}
		int i;
		for(i = low; i<=high; i++) {
			str = swap(str, low, i);
			permute(str, low+1, high);
			str = swap(str, low, i);
		}
	}
	public static void main(String[] args) {
		String str = "abc";
		permute(str, 0, str.length()-1);
	}
}
