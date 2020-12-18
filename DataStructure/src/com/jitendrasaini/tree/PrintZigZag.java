package com.jitendrasaini.tree;

public class PrintZigZag {
	/* Driver program to test the above functions */
	public static void main(String[] args) {
		BinaryTreeZigZag tree = new BinaryTreeZigZag();
		tree.root = new NodeZigZag(1);
		tree.root.left = new NodeZigZag(2);
		tree.root.right = new NodeZigZag(3);
		tree.root.left.left = new NodeZigZag(7);
		tree.root.left.right = new NodeZigZag(6);
		tree.root.right.left = new NodeZigZag(5);
		tree.root.right.right = new NodeZigZag(4);
		System.out.println("Spiral order traversal of Binary Tree is ");
		tree.printSpiral(tree.root);
	}
}

class NodeZigZag {
	int data;
	NodeZigZag left, right;

	public NodeZigZag(int d) {
		data = d;
		left = right = null;
	}
}

class BinaryTreeZigZag {
	NodeZigZag root;

	// Function to print the spiral traversal of tree
	void printSpiral(NodeZigZag NodeZigZag) {
		int h = height(NodeZigZag);
		int i;

		/*
		 * ltr -> left to right. If this variable is set then the given label is
		 * traversed from left to right
		 */
		boolean ltr = false;
		for (i = 1; i <= h; i++) {
			printGivenLevel(NodeZigZag, i, ltr);

			/* Revert ltr to traverse next level in opposite order */
			ltr = !ltr;
		}
	}

	/*
	 * Compute the "height" of a tree -- the number of NodeZigZags along the longest
	 * path from the root NodeZigZag down to the farthest leaf NodeZigZag.
	 */
	int height(NodeZigZag NodeZigZag) {
		if (NodeZigZag == null)
			return 0;
		else {

			/* compute the height of each subtree */
			int lheight = height(NodeZigZag.left);
			int rheight = height(NodeZigZag.right);

			/* use the larger one */
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	/* Print NodeZigZags at a given level */
	void printGivenLevel(NodeZigZag NodeZigZag, int level, boolean ltr) {
		if (NodeZigZag == null)
			return;
		if (level == 1)
			System.out.print(NodeZigZag.data + " ");
		else if (level > 1) {
			if (ltr != false) {
				printGivenLevel(NodeZigZag.left, level - 1, ltr);
				printGivenLevel(NodeZigZag.right, level - 1, ltr);
			} else {
				printGivenLevel(NodeZigZag.right, level - 1, ltr);
				printGivenLevel(NodeZigZag.left, level - 1, ltr);
			}
		}
	}

}