package com.jitendrasaini.tree;

import java.awt.HeadlessException;

public class SinglyLinkedList<T> {
    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;

    }

    public Node headNode; //head node of the linked list
    public int size;      //size of the linked list

    //Constructor - initializes headNode and size
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    //Helper Function that checks if List is empty or not 
    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }
    public void insertAtTail(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        if(headNode == null) {
        	headNode = newNode;
        	headNode.nextNode = null;
        	return;
        }
        Node nextNode = headNode;
        while(nextNode.nextNode != null) {
        	nextNode= nextNode.nextNode;
        }
        nextNode.nextNode = newNode;
        newNode.nextNode = null;
        size++;
    }
    public void insertAtTailList(SinglyLinkedList<T> list, T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        if(list.headNode == null) {
        	list.headNode = newNode;
        	list.headNode.nextNode = null;
        	return;
        }
        Node nextNode = list.headNode;
        while(nextNode.nextNode != null) {
        	nextNode= nextNode.nextNode;
        }
        nextNode.nextNode = newNode;
        newNode.nextNode = null;
        size++;
    }
    // Helper Function to printList
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");
        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }
        System.out.println(temp.data.toString() + " -> null");
    }
    public <T> void reverse(SinglyLinkedList<T> list){
    	System.out.println("reverse");
    	SinglyLinkedList<T>.Node current = list.headNode;
    	SinglyLinkedList<T>.Node next = null;
    	SinglyLinkedList<T>.Node prev = null;
    	while(current != null) {
    		next = current.nextNode;
    		current.nextNode = prev;
    		prev = current;
    		current = next;
    	}
    	list.headNode= prev;
    }
    public static <T> boolean detectLoop(SinglyLinkedList<T> list) {
        //Write -- Your -- Code
        SinglyLinkedList<T>.Node pointer1 = list.headNode;
        SinglyLinkedList<T>.Node pointer2 = null;
        boolean loopExist = false;
        if(pointer1.nextNode != null && pointer1.nextNode.nextNode != null){
            pointer2 = pointer1.nextNode.nextNode;
        }
         while(loopExist){
             if(pointer1 == pointer2){
                 loopExist = true;
             }else if(pointer1.nextNode != null){
                 pointer1 = pointer1.nextNode;
             }
            if(pointer2.nextNode != null && pointer2.nextNode.nextNode != null){
            pointer2 = pointer2.nextNode.nextNode;
            }
         }
        return loopExist;
    }
    public static <T> Object findMiddle(SinglyLinkedList<T> list) {
        SinglyLinkedList<T>.Node slow = list.headNode;
        SinglyLinkedList<T>.Node fast = list.headNode;
        while(fast != null && slow != null && fast.nextNode != null){
          slow = slow.nextNode;
          fast = fast.nextNode.nextNode;
        }
          return slow.data;
      }
    //performs union of two lists
    public <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        SinglyLinkedList<T>.Node current = list1.headNode;
        while(current != null) {
        	result.insertAtTailList(result, current.data);
        	current = current.nextNode;
        }
        current = list2.headNode;
        while(current != null) {
        	SinglyLinkedList<T>.Node search = search(result, current);
        	if(search == null) {
        		result.insertAtTailList(result,current.data);
        	}
        	current = current.nextNode;
        }
        return result;
    }
	private <T> SinglyLinkedList<T>.Node search(SinglyLinkedList<T> result, SinglyLinkedList<T>.Node node) {
    	
    	if(result != null) {
    		SinglyLinkedList<T>.Node current = result.headNode;
    		while(current != null) {
    			if(current.data == node.data) {
    				return current;
    			}
    			current = current.nextNode;
    		}
    	}
		return null;
    	
    }

	//performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        // Write -- Your -- Code
        return result;
    }
    public static void main(String[] args) {
    	SinglyLinkedList<Integer>list = new SinglyLinkedList<Integer>();
    	list.insertAtTail(122);
    	list.insertAtTail(11);
    	list.insertAtTail(8);
    	list.insertAtTail(5);
    	list.insertAtTail(2);
    	list.insertAtTail(-90);
    	list.printList();
    	SinglyLinkedList<Integer>list2 = new SinglyLinkedList<Integer>();
    	list2.insertAtTail(124);
    	list2.insertAtTail(11);
    	list2.insertAtTail(68);
    	SinglyLinkedList<Integer>result = list.union(list, list2);
    	result.printList();
	}
}