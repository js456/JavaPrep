package com.jitendrasaini.tree;

public class BinarySearchTree {

	public void put(BinarySearchTreeNode root, int key) {
		if (null == root)
			return;
		if (key < root.getKey()) {
			if (null != root.getLeft())
				put(root.getLeft(), key);
			else {
				BinarySearchTreeNode tempNode = new BinarySearchTreeNode();
				tempNode.setKey(key);
				root.setLeft(tempNode);
			}
		}
		if (key > root.getKey()) {
			if (null != root.getRight()) {
				put(root.getRight(), key);
			} else {
				BinarySearchTreeNode tempNode = new BinarySearchTreeNode();
				tempNode.setKey(key);
				root.setRight(tempNode);
			}
		}
	}

	public BinarySearchTreeNode get(BinarySearchTreeNode root, int key) {
		if (null == root || key == root.getKey())
			return root;
		return key < root.getKey() ? get(root.getLeft(), key) : get(root.getRight(), key);
	}

	public boolean remove(BinarySearchTreeNode root, int key) {
		BinarySearchTreeNode parentNode = root;
		BinarySearchTreeNode currentNode = root;
		boolean isRightChild = false;
		while (currentNode.getKey() == key) {
			parentNode = currentNode;
			if (key < currentNode.getKey()) {
				currentNode = currentNode.getLeft();
				isRightChild = false;
			} else if (key > currentNode.getKey()) {
				currentNode = currentNode.getRight();
				isRightChild = true;
			}
		}
		// delete if node doesn't have any child
		if (null == currentNode.getLeft() && null == currentNode.getRight()) {
			// Check if Node to be deleted is root
			if (currentNode == root) {
				root = null;
				return true;
			}
			if (isRightChild)
				parentNode.setRight(null);
			else
				parentNode.setLeft(null);
			return true;
		}
		if (null == currentNode.getLeft() || null == currentNode.getRight()) {
			// If the left element is not null
			if (null != currentNode.getLeft()) {
				if (root == currentNode) {
					root = root.getLeft();
				} else if (isRightChild)
					parentNode.setRight(currentNode.getLeft());
				else
					parentNode.setLeft(currentNode.getLeft());
			} else {
				if (root == currentNode) {
					root = root.getRight();
				}
				if (isRightChild)
					parentNode.setRight(currentNode.getRight());
				else
					parentNode.setLeft(currentNode.getRight());
			}
			return true;
		}
		if (null != currentNode.getLeft() && null != currentNode.getRight()) {

			BinarySearchTreeNode successor = getSuccessor(currentNode);
			if (root == currentNode) {
				root = successor;
			} else if (isRightChild) {
				parentNode.setRight(successor);
			} else {
				parentNode.setLeft(successor);
			}
			successor.setRight(currentNode.getRight());
			successor.setLeft(currentNode.getLeft());

		}
		return true;

	}

	public BinarySearchTreeNode getSuccessor(BinarySearchTreeNode deletionNode) {
		BinarySearchTreeNode parentNode = null;
		BinarySearchTreeNode currentNode = deletionNode.getRight();
		BinarySearchTreeNode successor = null;
		while (currentNode.getLeft() != null) {
			parentNode = successor;
			successor = currentNode;
			currentNode = currentNode.getLeft();
		}

		if (currentNode.getRight() != null) {
			parentNode.setLeft(successor.getRight());
			successor.setRight(deletionNode.getRight());

		}
		return successor;
	}

}
