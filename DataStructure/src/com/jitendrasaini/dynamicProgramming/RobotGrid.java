package com.jitendrasaini.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RobotGrid {

	public static List<Point> failedPoint = new ArrayList<Point>();
	public static HashMap<Point, Boolean>map = new HashMap<Point, Boolean>();

	public static boolean getPath(int[][] grid, int r, int c, ArrayList<Point> path) {

		// check if row and column are out of limit
		if (!(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length)) {
			return false;
		}

		Point p = new Point(r, c);
		
		if(map.containsKey(p))
			return map.get(p);
		if(failedPoint.contains(p))
			return false;

		boolean origin = (r == 0) && (c == 0);

		if (origin || getPath(grid, r, c - 1, path) || getPath(grid, r - 1, c, path)) {
			path.add(p);
			map.put(p, true);
			return true;
		}

		failedPoint.add(p);
		return false;

	}
	
	public static void main(String[] args) {
		int [][]arr = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}} ;
	}
	
	

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}

/*
 * Robot Grid
 * 
 * path set
 * 
 * getPath(grid, r, c)
 * 
 * base condition check c should not be less then 0 and max column row should
 * not be less then 0 and max column
 * 
 * check if the cell is off limit if it is add it to set
 * 
 * 
 * add to path set current row and column
 *
 * getPath(grid, r, c+1) getPath(grid, r+1, c)
 * 
 * 
 * 
 * 
 * 
 * 
 */
