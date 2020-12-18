package com.jitendrasaini.tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class PrintRightViewTree {

	BinarySearchTreeNode tree;

	public static void printRightView(BinarySearchTreeNode node) {
		if (node == null)
			return;
		printRightView(node.right);
		System.out.print(" " + node.key);
		printRightView(node.left);
	}

	public static void pringRightViewUsingLevelOrder(BinarySearchTreeNode node) {

		Queue<BinarySearchTreeNode> queue = new LinkedList();
		queue.add(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				BinarySearchTreeNode currentNode = queue.remove();
				if (i == size - 1)
					System.out.print(" " + currentNode.key);

				if (currentNode.left != null)
					queue.add(currentNode.left);
				if (currentNode.right != null)
					queue.add(currentNode.right);
			}
		}
	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new BinarySearchTreeNode(1);
		tree.root.left = new BinarySearchTreeNode(2);
		tree.root.right = new BinarySearchTreeNode(3);
		tree.root.left.left = new BinarySearchTreeNode(4);
		tree.root.left.right = new BinarySearchTreeNode(5);
		tree.root.right.left = new BinarySearchTreeNode(6);
		tree.root.right.right = new BinarySearchTreeNode(7);
		tree.root.right.right.right = new BinarySearchTreeNode(8);

		// printRightView(tree.root);
		pringRightViewUsingLevelOrder(tree.root);
	}
}

class BinaryTree {
	BinarySearchTreeNode root;
}