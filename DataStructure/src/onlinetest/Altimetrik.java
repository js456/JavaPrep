package onlinetest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Altimetrik {
	
	public static int getMinimumPlatforms(List<Integer> arrivalTimes, List<Integer> depTimes) {
        System.out.println(arrivalTimes);
        int arrival[] = new int[arrivalTimes.size()];
		for (int i = 0; i < arrivalTimes.size(); i++) {
			System.out.println(i);
			int temp = arrivalTimes.get(i);
			System.out.println(temp);
			arrival[i] = arrivalTimes.get(i).intValue();
		}
        int departure[] = new int[depTimes.size()];
        for(int i =0;i<depTimes.size();i++) {
        	departure[i]=depTimes.get(i).intValue();
        }
        quickSort(arrival,departure);
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
            
              hashMap.forEach((key, value) -> { System.out.println("key:" + key + " value:"+ value); });
             
        }
        return maxSize;
    
    }
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
		
		int x =-4;
		System.out.println(x>>1);
		int y=4;
		System.out.println(y>>1);
		/*
		 * 
		 * //int arr[]= {900, 940, 950, 1100, 1500, 1800}; ///int dep[]= {910, 1200,
		 * 1120, 1130, 1900, 200}; List arrival = new ArrayList; List depart =
		 * Arrays.asList(dep); getMinimumPlatforms(arrival,depart);
		 */}
}