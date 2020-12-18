package oracle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Test{
	
	public void print(String s) {
		System.out.println("Inside String");
	}
	public void print(Object s) {
		System.out.println("Inside Object");
	}
	public void print(Integer s) {
		System.out.println("Inside Integer");
	}
	public void print(Double s) {
		System.out.println("Inside Double");
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.print(0.0);
	}
 
    public boolean canAttendMeetings(Interval[] intervals) {
    	
    	if(intervals == null)
    		return false;
    	ArrayList<Interval> sortIntervals = sortIntervals(intervals);
    	int prevEnd = sortIntervals.get(0).end;
    	for(int i =1; i<sortIntervals.size();i++) {
    		
    		if(sortIntervals.get(i).start<prevEnd)
    			return false;
    		else
    			prevEnd= sortIntervals.get(i).end;
    	}
    	
        return true;
    }
    public ArrayList<Interval> sortIntervals(Interval[] intervals) {
    	
    	ArrayList<Interval>list = (ArrayList<Interval>) Arrays.asList(intervals);
    	Comparator<Interval>comparator = new Comparator<Test.Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				if(o1.start<o2.start) {
					return 1;
				}
				if(o1.start>o2.start) {
					return -1;
				}else
					return 0;
				
			}
		};
		Collections.sort(list, comparator);
		return list;
    }
    
 
    class Interval{
        public int start;
        public int end;
        
        
    }
 
}
/*
 * [[0,10],[40,50],[20,30]] -- returns true 
 * 
 * [[0,20],[15,30]] -- returns false
 * 
 * [[0,10],[20,30],[25,50]] -- returns false 
 * 
 * [[0,20],[30,40]] -- returns true
 * 
 * 
 */