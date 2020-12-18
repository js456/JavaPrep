package assessment;

import java.util.ArrayList;
import java.util.Stack;

public class EnqueroAssessment {

	class Node {

		private int data;
		private Node next;
		Node head;
		private Node tail;

		Node() {

		}

		Node(int data) {
			this.data = data;
		}

		public Node insert(int data) {

			Node node = new Node(data);
			if (head == null) {
				head = tail = node;
			} else {
				tail.next = node;
				tail = node;
			}
			return node;
		}

		public Node find(int data) {

			if (null == head) {
				System.out.println("List is empty...");
				return null;
			} else {
				Node current = head;
				do {
					current = current.next;
				} while (current != null || (current != null && current.data == data));

				return current;
			}
		}

	}

	public void printList(Node head) {

		System.out.println("Printing List...");
		Stack<Node> stack = new Stack<>();
		Node slow = head;
		Node fast = head;
		while (null != fast && null != fast.next) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node tempNode = slow;

		while (slow != null) {
			if(slow != null)
				stack.push(slow);
			slow = slow.next;
		}
		Node current = head;
		while (!stack.isEmpty()) {
			if(current != null && current != tempNode) {
				
				System.out.print(current.data);
				System.out.print(",");
				current = current.next;
			}
			
			System.out.print(stack.pop().data);
			System.out.print(",");
			
		}

	}
	
	public ArrayList<Integer> findMissingNumber(int []numbers){
		System.out.println("Finding missing number....");
		boolean arr[] = new boolean[Integer.MAX_VALUE-100];
		int maxIndex =Integer.MIN_VALUE;
		for(int i : numbers) {
			arr[i] = true;
			if(maxIndex<i)
				maxIndex = i;
		}
		ArrayList<Integer>list = new ArrayList<>();
		for(int i=1;i<=maxIndex;i++) {
			if(!arr[i]) {
				list.add(i);
			}
		}
		return list;
	}
	
	public int removeDuplicateLinkedList(Node head) {
		System.out.println("Removing duplicate.......");
		Node current = head;
		Node prev = null;
		int remainSize=1;
		while(current != null) {
			prev = current;
			current = current.next;
			if(current == null)
				break;
			remainSize++;
			if(prev.data == current.data) {
				prev.next = current.next;
				//current.next = null;
				remainSize--;
			}
		}
		
		return remainSize;
		
	}
	
}
