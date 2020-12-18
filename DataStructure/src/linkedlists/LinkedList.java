package linkedlists;
import java.util.Stack;

public class LinkedList {

	
	public static Node makeList() {
		Node start = new Node(1);
		Node tail = start;
		for(int i= 2;i<11;i++) {
			Node temp = new Node(i);
			tail.next = temp;
			tail = temp;
		}
		return start;
	}
	
	
	// 1 2 3 4 5 6
	public static Node reverseList(Node start) {
		
		Node previous = null;
		Node current = start;
		Node next = null;
		while(current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		start = previous;
		return start;
	}
	public static void print(Node start) {
		Node revPointer = start;
		while(revPointer!= null) {
			System.out.print(revPointer.data);
			revPointer = revPointer.next;
			System.out.print(" ");
		}
	}
	public static void main(String[] args) {
		Node start = makeList();
		print(start);
		System.out.println();
		Node revPointer = reverseList(start);
		print(revPointer);
		
		
		Stack<String>stack = new Stack<String>();
	}
}

class Node {
	int data;
	Node next;

	Node(int d) {
		data = d;
		next = null;
	}
}

class DLinkedListNode{
	int data;
	DLinkedListNode next;
	DLinkedListNode previous;
	DLinkedListNode(int data){
		this.data = data;
	}
}