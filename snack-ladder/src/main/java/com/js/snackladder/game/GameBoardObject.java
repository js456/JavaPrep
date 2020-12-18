package com.js.snackladder.game;

import java.util.ArrayList;
import java.util.List;

public class GameBoardObject {

	private Cordinate startCordinate;
	private Cordinate endCordinate;
	
	int x =4;
	static {
		int y = 7;
	}
	
	public static void main(String[] args) {
		/*
		 * 
		 * //int x = 5; { //int y =6; System.out.println(10*20+"abc");
		 * System.out.println("abc"+10*20); }
		 * 
		 * int x=0;int y =0; for(int z=0;z<5;z++) {
		 * 
		 * if((++x >2)||(++y>2)) { x++; } } System.out.println(x);
		 * System.out.println(y);
		 * 
		 * List<?extends Number>list = new ArrayList<Number>();
		 * 
		 * //list.add(2.29); list.add(null);
		 * 
		 * List<?super Number>list1 = new ArrayList<Number>();
		 * 
		 * list1.add(2.29); list1.add(null);
		 * 
		 * double data = 20.324; int sum =6; float value = 5.1f;
		 * System.out.println(data+sum+value);
		 */
		
		/*
		 * char arr[] = {1,2,3}; for(char ch:arr) { System.out.println(6%8); }
		 */
		List<Integer>list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		int arr[] = new int[list.size()];
		list.toArray();
		for(Object i : list.toArray()) {
			System.out.println(i);
		}
		
	}
	
	
	 
}
