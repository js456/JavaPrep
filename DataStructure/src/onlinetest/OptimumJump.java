package onlinetest;

import java.io.BufferedReader;
import java.util.Scanner;

public class OptimumJump {

    public static void main(String args[] ) throws Exception {




        //Scanner
        Scanner s = new Scanner(System.in);
        //String name1 = s.nextLine();                 // Reading input from STDIN
        //System.out.println("Hi, " + name1 + ".");    // Writing output to STDOUT
        int arr[]= {1,2,3,4,100};
        System.out.println(optitumJump(arr,0));;

        // Write your code here

    }
    public static int optitumJump(int arr[], int i) {
    	if(i >= arr.length-2)
    		return arr[i];
    	if(i<0)
    		return arr[0];
    	int cost2 =0;
    	int cost = arr[i]+optitumJump(arr, i+2);
    	if(i>=1) {
    		cost2 = arr[i]+optitumJump(arr, i-1);
    	}
    	return Math.min(cost, cost2);
//    	else if(i>=1) {
//    		cost2= arr[i]+optitumJump(arr, i-1);
//    	}
//    	return Math.min(cost, cost2);
    }

}
