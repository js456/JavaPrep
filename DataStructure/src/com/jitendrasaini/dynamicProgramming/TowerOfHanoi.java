package com.jitendrasaini.dynamicProgramming;

import java.util.Stack;

public class TowerOfHanoi {

	public static void main(String[] args) {
		int n =3;
		
		Tower []towers = new Tower[n];
		
		for(int i =0;i<3;i++) {
			towers[i]= new Tower(i);
		}
		
		for(int i =n-1;i>=0;i--) {
			towers[0].add(i);
		}
		towers[0].moveDisks(n, towers[1], towers[2]);
	}
}

class Tower{
	
	private Stack<Integer>disks;
	private int index;
	
	public Tower(int i) {
		disks = new Stack<Integer>();
		index = i;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void add(int d) {
		if(!disks.isEmpty() && disks.peek()<=d) {
			System.out.println("Can't place disks");
		}else {
			disks.push(d);
		}
	}
	
	public void moveToTop(Tower t) {
		int top = disks.pop();
		t.add(top);
	}
	
	public void moveDisks(int n, Tower source, Tower destination) {
		if(n>0) {
			moveDisks(n-1, destination, source);
			moveToTop(destination);
			moveDisks(n-1, this, destination);
		}
	}

}
