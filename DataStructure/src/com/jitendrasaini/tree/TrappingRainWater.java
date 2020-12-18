package com.jitendrasaini.tree;

public class TrappingRainWater {
	
	public static int calculateRainWater(int []arr) {
		return 0;
		
		//for(int i =0; i<)
		
	}
	public static int getSecondHighestElementFromAnArr(int []arr) {
		int secondHeighestIndex = 0;
		int heighest =0;
		for(int i =1; i<arr.length-1; i++) {
			if(arr[i]> arr[heighest]) {
				heighest = i;
			}
			else if(arr[i]< arr[heighest]&& arr[i]> arr[secondHeighestIndex]) {
				secondHeighestIndex = i;
			}
		}
		return secondHeighestIndex;
	}

}
