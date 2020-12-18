package com.jitendrasaini.tree;

public class BinarySearchTreeNode {

	public int key;
	public BinarySearchTreeNode left;
	public BinarySearchTreeNode right;

	public BinarySearchTreeNode(int key) {
		this.key = key;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int data) {
		this.key = data;
	}

	public BinarySearchTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTreeNode left) {
		this.left = left;
	}

	public BinarySearchTreeNode getRight() {
		return right;
	}

	public void setRight(BinarySearchTreeNode right) {
		this.right = right;
	}

}
