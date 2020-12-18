package amazonPractive.array;

public class ReplaceZero {
	
    static int minDist(int a[], int n, int x, int y) {
        int listx = 2*n;
        int listy = 2*n;
        int min_dist = n;
        for(int i =0;i<n;i++){
            if(a[i] == x){
                listx= i;
                 if(Math.abs(listx-listy)<min_dist){
                    min_dist = Math.abs((listx-listy));
                }
            }
             else if(a[i] == y){
                 listy= i;
                 if(Math.abs(listy-listx)<min_dist){
                    min_dist = Math.abs((listy-listx));
                }
             }
        }
        
        return min_dist==n?-1:min_dist;
     }
	
	public static int convertfive(int num) {

		int finalNum = 0;
		int sumToAdd = 1;
		while (num > 0) {
			int rem = num % 10;
			if (rem == 0) {
				finalNum = finalNum + sumToAdd * 5;

			} else {
				finalNum = finalNum + sumToAdd * rem;
			}
			num = num / 10;
			sumToAdd = sumToAdd * 10;
		}
		return finalNum;
	}

	public static void main(String[] args) {
		//System.out.println(convertfive(10405));
		
		int arr[] = {13, 98, 5, 10, 23, 13, 4, 53, 60, 78, 66, 68, 44, 69, 79, 71, 90, 17, 91, 84, 34, 52, 12, 11, 57, 61, 2};
		System.out.println(minDist(arr, 27, 78,68));;
	}
}
