package com.jitendrasaini.dynamicProgramming;

public class CoinChangeProblem {

	public static long count(int S[], int m, int n) {

		long[] table = new long[n + 1];

		// Arrays.fill(table, 0);

		table[0] = 1;

		for (int i = 0; i < m; i++) {

			for (int j = S[i]; j <= n; j++) {

				table[j] += table[j - S[i]];
			}
		}
		return table[n];
	}

	public static long countTopDown(int S[], int m, int n) {
		if (n == 0)
			return 1;
		if (n < 0)
			return 0;
		if (m <= 0 && n >= 1)
			return 0;
		return countTopDown(S, m, n - S[m - 1]) + countTopDown(S, m - 1, n);
	}

	public static void main(String[] args) {

		int S[] = { 1, 2, 3 };

		System.out.println(countTopDown(S, S.length, 4));
		
		System.out.println(count(S, S.length, 4));

	}
}
