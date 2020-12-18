package array;

import java.util.Arrays;

public class FindTriplet {

	public static boolean find3Numbers(int arr[], int sum) {

		// List<Integer>list = new ArrayList(Arrays.asList(arr));
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			int j = i + 1, k = arr.length-1;
			while(j < k) {
				if (arr[i] + arr[j] + arr[k] == sum)
					return true;
				else if(arr[i] + arr[j] + arr[k]<sum) {
					j++;
				}else {
					k--;
				}
			}
		}

		return false;

	}
	
	public static void main(String[] args) {
		int arr[] = {12, 3, 4, 1, 6, -9};
		System.out.println(find3Numbers(arr, 24));
	}

}
