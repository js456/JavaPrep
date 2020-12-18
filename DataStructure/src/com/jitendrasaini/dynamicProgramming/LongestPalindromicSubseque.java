package com.jitendrasaini.dynamicProgramming;

public class LongestPalindromicSubseque {

	public static boolean isPalindrom(char[] arr) {

		int len = arr.length;
		for (int i = 0; i < arr.length / 2; i++) {

			if (arr[i] != arr[len - 1 - i])
				return false;
		}
		return true;

	}

	public static int longestPalidSubSeq(char[] seq, int i, int j) {

        if (i == j) { 
            return 1; 
        } 

		if (seq[i] == seq[j] && i == j-1)
			return 2;

		if (seq[i] == seq[j])
			return longestPalidSubSeq(seq, i + 1, j - 1) + 2;

		return Math.max(longestPalidSubSeq(seq, i + 1, j), longestPalidSubSeq(seq, i, j - 1));

	}

	public static void main(String[] args) {
		
		System.out.println(isPalindrom("eefffe2".toCharArray()));
		String s = "geeksforgeeks";
		System.out.println(longestPalidSubSeq(s.toCharArray(), 0, s.length()-1));
	}
}
