package com.jitendrasaini.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfString {

	/*
	 * 
	 *  ABC
	 *  
	 *  ABC ACB BAC BCA CBA CAB
	 *  
	 *  	
	 *  
	 *  
	 *   
	 */
	
	public static ArrayList<String> getAllPermutation(String str){
		
		if(str.length()<=1) {
			ArrayList<String>list =  new ArrayList<String>();
			list.add(str);
			return list;
		}
		ArrayList<String>allPerm = new ArrayList<String>();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			List<String> temp = getAllPermutation(str.substring(0, i) + str.substring(i + 1));
			for(String s: temp) {
				allPerm.add(s+ch);
			}
		}
		return allPerm;
	}
	
	
	public static int minStrength(int []w,int []s,int m,int n) {
	    //('m:',m,' n:',n)
	    if (n<=0 && m>0)
	        return 3000;
		if (m == 0 || n == 0) {
			return 0;
		}
	    if(w[m-1] <= s[n-1]) {
	    	int consider = minStrength(w,s,m-1,n-1);
	    	int notCons = minStrength(w,s,m,n-1);
	        int x = Math.min(s[n-1]+ consider,notCons);
	        //print('x:',x)
	        return x;
	    }

	    else {
	        int y = minStrength(w,s,m,n-1);
	       // print('y:',y)
	        return y;
	    }
	}

	public static void main(String[] args) {
		
		int []w = {10,11};
				int []s = {14,13,12};
				//System.out.println(minStrength(w,s,w.length,s.length));
				
		for(String str: getAllPermutation("abc")) {
			System.out.println(str);
		}
	}
}
