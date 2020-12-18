package com.jitendrasaini.stringProblems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {}
public class Solution {


    /*
     * Complete the 'chooseFlask' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY requirements
     *  2. INTEGER flaskTypes
     *  3. 2D_INTEGER_ARRAY markings
     */

    public static int chooseFlask(List<Integer> requirements, int flaskTypes, List<List<Integer>> markings) {
        int flaskType=-1;
    TreeMap<Integer, Integer>indexLossMap = new TreeMap<Integer,Integer>(Collections.reverseOrder());
    HashMap<Integer, ArrayList<Integer>>keyList = new HashMap<Integer,ArrayList<Integer>>();
    for(List list :markings) {
    	if(keyList.get(list.get(0))== null) {
    		ArrayList<Integer> list1 = new ArrayList<Integer>();
    		list1.add((Integer) list.get(1));
  		keyList.put((Integer)list.get(0), list1);
    	}else {
    		keyList.get(list.get(0)).add((Integer) list.get(1));
    	}
    }
    
    Collections.sort(requirements, Collections.reverseOrder());
    for (Entry<Integer, ArrayList<Integer>> entry : keyList.entrySet())  {

        List<Integer> marking= entry.getValue();
        Collections.sort(marking, Collections.reverseOrder());
        if(marking.get(1)<requirements.get(0)){
            continue;
        }else{
            int maxLoss= 0;
            for(Integer requirement : requirements){
                maxLoss+= getNearestMarkingDifference(marking,requirement);
            }
            indexLossMap.put(entry.getKey(),maxLoss);
        }

    
    }
    if(indexLossMap.size()>0) {
    	return indexLossMap.firstKey();
    }
    return -1;

    }

    public static int getNearestMarkingDifference(List<Integer> marking, int requirement){
        int minDifference = Integer.MAX_VALUE;
        for(int i =0; i<marking.size(); i++){
            if((marking.get(i)-requirement)<minDifference && marking.get(i)-requirement>=0){
                minDifference =marking.get(i)-requirement;
            }
        }
        return minDifference;
    }


	public static void main(String[] args) {
		List<Integer> requirements = new ArrayList<Integer>();
		requirements.add(4);
		requirements.add(6);
		//requirements.add(6);requirements.add(7);
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(0);
		list1.add(5);
		//list1.add(7);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(0);
		list2.add(7);
		//list2.add(9);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(0);
		list3.add(10);
		//list3.add(6);
		List<Integer> list4= new ArrayList<Integer>();
		list4.add(1);
		list4.add(4);
		List<Integer> list5 = new ArrayList<Integer>();
		list5.add(1);
		list5.add(10);
		List<List<Integer>> markings = new ArrayList<List<Integer>>();
		markings.add(list1);
		markings.add(list2);
		markings.add(list3);
		markings.add(list4);
		markings.add(list5);
		System.out.println(chooseFlask(requirements,3, markings));
	}
	
}