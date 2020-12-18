package com.jitendrasaini.tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class BundaryTraversal {
	
	ArrayList <Integer> printBoundary(BinarySearchTreeNode node)
	{
		BinarySearchTreeNode currentNode = node;
	    LinkedList<BinarySearchTreeNode>list = new LinkedList<BinarySearchTreeNode>();
	    list.add(currentNode);
	    ArrayList <Integer> result = new ArrayList<Integer>();
	    while(!list.isEmpty()) {
	    	BinarySearchTreeNode tempNode = list.poll();
	    	System.out.println(tempNode.key);
	    	result.add(tempNode.key);
	    	if(tempNode.left!= null) {
	    		list.add(tempNode.left);
	    	}
	    	if(tempNode.right != null) {
	    		list.add(tempNode.right);
	    	}
	    }
	    return result;
	}

}
