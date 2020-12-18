package amazonPractive.dp;

import java.util.Arrays;

public class DynamicProgrammingProblems {

	public static String getMaskedMobile(String plainData) {

		if (plainData != null && !"".equals(plainData) && plainData.length() >= 4) {
			return plainData.replaceAll("[+]?\\b(\\d{0})\\d+(\\d{4})", "$1*******$2");
		} else {
			return "";
		}
	}

	static int subsequenceCount(String S, String T) {
		int arr[][] = new int[S.length() + 1][T.length() + 1];
		for (int[] i : arr) {
			Arrays.fill(i, -1);
		}
		return subSeqCount(S.toCharArray(), T.toCharArray(), S.length(), T.length(), arr);
		// Your code here
	}

	public static int subSeqCount(char[] str, char[] subStr, int i, int j, int[][] arr) {
		if (j == 0)
			return 1;
		if (i <= 0 && j >= 0)
			return 0;

		if (arr[i][j] != -1)
			return arr[i][j];
		if (str[i - 1] == subStr[j - 1]) {
			arr[i][j] = subSeqCount(str, subStr, i - 1, j - 1, arr) + subSeqCount(str, subStr, i - 1, j, arr);
			return arr[i][j];
		} else {
			arr[i][j] = subSeqCount(str, subStr, i - 1, j, arr);
			return arr[i][j];
		}

	}

	public static long minimumNumberOfCoins(int coins[], int numberOfCoins, int value) {

		if (numberOfCoins <= 0 && value >= 0) {
			return Integer.MAX_VALUE - 1;
		}
		if (value <= 0)
			return 0;

		if (coins[numberOfCoins - 1] <= value) {
			return Math.min(1 + minimumNumberOfCoins(coins, numberOfCoins, value - coins[numberOfCoins - 1]),
					minimumNumberOfCoins(coins, numberOfCoins - 1, value));
		} else {
			return minimumNumberOfCoins(coins, numberOfCoins - 1, value);
		}

	}

	public static void main(String[] args) {
		// System.out.println(subsequenceCount("oqmsboagu ", "oqmsboagu"));
		int arr[] = { 2, 5, 3, 6 };
		//System.out.println(minimumNumberOfCoins(arr, 4, 10));
		
		 System.out.println(getMaskedMobile("+NULL9987036620"));
	}
}
