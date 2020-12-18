package com.jitendrasaini.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PrintPermutationsWithDuplicate {
	
	public static Map<Character, Integer> createMap(String str){
		Map<Character,Integer>map = new HashMap<Character, Integer>();
		
		for(char ch:str.toCharArray()) {
			
			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		
		return map;
	}
	public static void generateAllPerms(String prefix,int remaining, Map<Character, Integer>map, ArrayList<String>result) {
		if(remaining ==0) {
			result.add(prefix);
		}
		
		for(char ch: map.keySet()) {
			int count = map.get(ch);
			if(count>0) {
				map.put(ch, count-1);
				generateAllPerms(prefix+ch, remaining-1, map, result);
				map.put(ch, count);
			}
		}
		
	}
	public static ArrayList<String> generateAllPerms(String str){
		
		ArrayList<String>perms = new ArrayList<String>();
		Map<Character, Integer> charMap = createMap(str);
		generateAllPerms("", str.length(), charMap, perms);
		return perms;
	}

	
	public static void main(String[] args) {
		
		for(String str: generateAllPerms("aac")) {
			System.out.println(str);
		}
		
	}
}
