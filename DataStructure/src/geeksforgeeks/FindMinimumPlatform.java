package geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FindMinimumPlatform {

	public static void quickSort(int arr[], int depart[]) {
		sort(arr, 0, arr.length - 1, depart);
	}

	public static void sort(int arr[], int low, int high, int depart[]) {
		if (low < high) {
			int index = partition(low, high, arr, depart);
			sort(arr, low, index - 1, depart);
			sort(arr, index + 1, high, depart);
		}
	}

	public static int partition(int low, int high, int arr[], int depart[]) {
		int pivot = high;
		int indexOfSmallerElement = low - 1;
		for (int i = low; i < high; i++) {
			if (arr[i] < arr[pivot]) {
				indexOfSmallerElement++;
				int temp = arr[i];
				arr[i] = arr[indexOfSmallerElement];
				arr[indexOfSmallerElement] = temp;
			}
		}
		// place pivot value
		int temp = arr[pivot];
		arr[pivot] = arr[indexOfSmallerElement + 1];
		arr[indexOfSmallerElement + 1] = temp;

		int temp1 = depart[pivot];
		depart[pivot] = depart[indexOfSmallerElement + 1];
		depart[indexOfSmallerElement + 1] = temp1;
		return indexOfSmallerElement + 1;
	}

	public static void main(String[] args) {

    	int arrival[]= {900, 940, 950, 1100, 1500, 1800};
    	int depart[]= {910, 1200, 1120, 1130, 1900, 200};
		quickSort(arrival, depart);
		System.out.println(findMaxPlatform(arrival, depart));
		/*
		 * Scanner sc = new Scanner(System.in); int testCase = sc.nextInt(); while
		 * (testCase-- > 0) {
		 * 
		 * int n = sc.nextInt(); int[] arrival = \; int[] depart = new int[n];
		 * 
		 * for (int i = 0; i < n; i++) { arrival[i] = sc.nextInt(); } for (int i = 0; i
		 * < n; i++) { depart[i] = sc.nextInt(); } // arrange based on arrival
		 * 
		 * }
		 */
	}

	public static int findMaxPlatform(int arrival[], int[] departure) {
		//System.out.println(arrival[1]);
		DemoAbs temp = new DemoAbs() {
			void dosomethind() {
				
			}
		};
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		int maxSize = hashMap.size();
		for (int i = 0; i < arrival.length; i++) {
			if (hashMap.isEmpty()) {
				hashMap.put(departure[i], arrival[i]);
				continue;
			}
			hashMap.put(departure[i], arrival[i]);
			int tempArr = arrival[i];
			hashMap = hashMap.entrySet().stream().filter(map -> map.getKey().intValue() > tempArr)
					.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));
			if (hashMap.size() > maxSize) {
				maxSize = hashMap.size();
			}
			/*
			 * hashMap.forEach((key, value) -> { System.out.println("key:" + key + " value:"
			 * + value); });
			 */
		}
		return maxSize;
	}
	int longestPalSubstr(String str) 
	{ 
	    int maxLength = 1;
	    int start;
	    char strArr[]= str.toCharArray();
	    for (int i = 0; i < str.length(); i++) { 
	        for (int j = i; j < str.length(); j++) { 
	            int flag = 1; 
	  
	            // Check palindrome 
	            for (int k = 0; k < (j - i + 1) / 2; k++) 
	                if (strArr[i + k] != strArr[j - k]) 
	                    flag = 0; 
	  
	            // Palindrome 
	            if (flag >maxLength && (j - i + 1) > maxLength) { 
	                start = i; 
	                maxLength = j - i + 1; 
	            } 
	        } 
	    } 
	    return maxLength; 
	} 
}

abstract class DemoAbs{
	
}
