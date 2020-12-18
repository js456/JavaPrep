package heaps;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapUsingPriorityQueue {
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer>pqueue = new PriorityQueue<Integer>();
		
		pqueue.add(10);
		pqueue.add(20);
		pqueue.add(5);
		pqueue.add(6);
		pqueue.add(400);
		
		PriorityQueue<Student>pqueueMaxHeap = new PriorityQueue<>((s1,s2)-> s2.marks-s1.marks);
		
		pqueueMaxHeap.add(new Student(10));
		pqueueMaxHeap.add(new Student(20));
		pqueueMaxHeap.add(new Student(5));
		pqueueMaxHeap.add(new Student(6));
		pqueueMaxHeap.add(new Student(400));
		
		System.out.println(pqueueMaxHeap.peek().marks);
		
	}

}

class Student{
	
	String name;
	int marks;
	
	Student(int marks){
		this.marks = marks;
		this.name = String.valueOf(marks);
	}
	
	
}
