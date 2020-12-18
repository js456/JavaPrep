package com.jitendrasaini.tree;

import java.util.Random;

public class QuickSort {
	
	public int getRandomPivot(int []arr) {
		Random rd = new Random();
		return rd.nextInt(arr.length);
	}
	public void quickSort(int []arr) {
		if(arr != null & arr.length >1) {
			quickSort(0, arr.length-1, arr);
		}
	}
	private void quickSort(int low, int high, int[] arr) {
		if(low < high) {
			int indexPosition = partition(low , high, arr);
			quickSort(low, indexPosition-1, arr);
			quickSort(indexPosition+1, high, arr);
		}
		
	}
	private int partition(int low, int high, int[] arr) {
		int pivot = high;
		int indexOfSmallerElement = low-1;
		for(int j = low; j<high; j++) {
			if(arr[j] < arr[pivot]) {
				indexOfSmallerElement++;
				switchValue(indexOfSmallerElement, j, arr);
			}
		}
		switchValue(indexOfSmallerElement +1, pivot, arr);
		return indexOfSmallerElement +1;
		
	}
	private void switchValue(int firstIndex, int secondIndex, int []arr){
		int temp = arr[firstIndex];
		arr[firstIndex] = arr[secondIndex];
		arr[secondIndex] = temp;
	}
	public static void main(String[] args) {

		int arr[] = {12,3,45,6,23,90,6,4,123};
		QuickSort quickSort = new QuickSort();
		quickSort.quickSort(arr);
		for(int i : arr) {
			System.out.print(i+" ");
		}
	}
	
}
