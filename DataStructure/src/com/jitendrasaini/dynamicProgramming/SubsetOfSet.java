package com.jitendrasaini.dynamicProgramming;

import java.util.ArrayList;

public class SubsetOfSet {
	
	
	public static ArrayList<ArrayList<Integer>> getAllSubset(ArrayList<Integer>set, int index){
		
		ArrayList<ArrayList<Integer>> allSubSet;
		if(index == set.size()) {
			ArrayList<ArrayList<Integer>> tempSet = new ArrayList<ArrayList<Integer>>();
			tempSet.add(new ArrayList<Integer>());
			return tempSet;
		}else {
			allSubSet = getAllSubset(set, index+1);
			
			ArrayList<ArrayList<Integer>> createMoreSubset = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> list: allSubSet) {
				ArrayList<Integer>temp = new ArrayList<Integer>();
				temp.addAll(list);
				temp.add(set.get(index));
				createMoreSubset.add(temp);
			}
			allSubSet.addAll(createMoreSubset);
		}
		return allSubSet;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer>set = new ArrayList<Integer>();
		set.add(1);set.add(2);set.add(3);
		for(ArrayList<Integer>subset:getAllSubset(set, 0)) {
			System.out.println(subset);
		}
		
	}

}

