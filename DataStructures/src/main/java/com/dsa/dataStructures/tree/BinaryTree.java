package com.dsa.dataStructures.tree;

public class BinaryTree {

	static class Node {

		// Declaration of Node elements
		int data;
		Node left;
		Node right;

		// Create a New-Node with left & right as null and return
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}

	static class BinaryTr {
		// -1: increment for each node insertion and take to length
		// 0 = root node
		static int indexForTraversal = -1;

		public static Node buildBinaryTree(int nodes[]) {
			indexForTraversal++;

			if (nodes[indexForTraversal] == -1) {
				return null;
			}

			// First node will be built
			Node newNode = new Node(nodes[indexForTraversal]);

			// Recursive call for left tree formation
			newNode.left = buildBinaryTree(nodes);

			// Recursive call for right tree formation
			newNode.right = buildBinaryTree(nodes);

			return newNode;
		}

	}

	public static void preOrder(Node root) {

//		Time : O( N )
		
		if (root == null) {
			System.out.println(-1);
//			return;
		} else {

			System.out.println(root.data);

			// Traverse thru left tree
			preOrder(root.left);

			// Traverse thru right tree
			preOrder(root.right);
		}
	}

	
	
	public static void inOrder(Node root) {
		
		if(root == null) {
			return;			
		}
		
		inOrder(root.left);
		
		System.out.println(root.data);
		
		inOrder(root.right);
		
		
	}
	
	
	public static void postOrder(Node root) {
		
		if(root == null) {
			return;
		}
		
		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);
		
	}
	
	
	public static void main(String ar[]) {
		int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

		BinaryTr binaryTr = new BinaryTr();

		// Returns root node
		Node root = binaryTr.buildBinaryTree(nodes);

//		System.out.println(root.data);

//		preOrder(root);

//		inOrder(root);
		
		postOrder(root);
		
	}

}
