package com.jitendrasaini.dynamicProgramming;

public class MaxArraySum {

	static int maxSubsetSum(int[] arr, int sum, int n) {

		if (n == 0) {
			return arr[n];
		}

		int maxSum = 0;
		for (int i = n; i > 0; i--) {

			int tempSum = maxSubsetSum(arr, sum + arr[i], i - 2);
			if (tempSum > maxSum)
				maxSum = tempSum;
		}

		return maxSum;

	}

	public static int kandane(int[] arrA) {
		int max_end_here = 0;
		int max_so_far = 0;
		for (int i = 0; i < arrA.length; i++) {
			max_end_here += arrA[i];
			if (max_end_here < 0) {
				max_end_here = 0;
			}
			if (max_so_far < max_end_here) {
				max_so_far = max_end_here;
			}
		}
		return max_so_far;
	}

	public static int maxSubsetSum(int[] arr) {
		if (arr.length == 0)
			return 0;
		arr[0] = Math.max(0, arr[0]);
		if (arr.length == 1)
			return arr[0];
		arr[1] = Math.max(arr[0], arr[1]);
		for (int i = 2; i < arr.length; i++)
			arr[i] = Math.max(arr[i - 1], arr[i] + arr[i - 2]);
		return arr[arr.length - 1];
	}

	public static void main(String[] args) {

		int arr[] = { 2, 1, 5, 8, 4 };

		int result = maxSubsetSum(arr, 0, arr.length - 1);
		// System.out.println(result);
		System.out.println(maxSubsetSum(arr));
	}

}
