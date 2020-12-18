package com.jitendrasaini.dynamicProgramming;

public class Abbreviation {

	public static boolean[][] dp;
	public static boolean abbreviation(String source, String target, int n, int k) {

		if (k == 0) {
			return true;
		}
		if(dp[n][k])
			return true;	
		if (source.charAt(n - 1) == target.charAt(k - 1)) {
			return abbreviation(source, target, n - 1, k - 1);
		} else if (source.charAt(n - 1) - 32 == (int) target.charAt(k - 1)) {
			return abbreviation(source, target, n - 1, k - 1) || abbreviation(source, target, n - 1, k);
		} else if (Character.isLowerCase(source.charAt(n - 1))) {
			return abbreviation(source, target, n - 1, k);
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		String source = "AbcDE";
		String target = "ABDE";
		dp = new boolean[source.length()][target.length()];
		System.out.println(abbreviation(source, target, source.length(), target.length()));
	}
}
