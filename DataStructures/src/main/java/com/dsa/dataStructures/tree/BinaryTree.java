package com.dsa.dataStructures.tree;

import java.util.LinkedList;
import java.util.Queue;

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
			return;
		}

		System.out.println(root.data);

		// Traverse thru left tree
		preOrder(root.left);

		// Traverse thru right tree
		preOrder(root.right);

	}

	public static void inOrder(Node root) {

		if (root == null) {
			System.out.println(-1);
			return;
		}

		inOrder(root.left);

		System.out.println(root.data);

		inOrder(root.right);

	}

	public static void postOrder(Node root) {

		if (root == null) {
			System.out.println(-1);
			return;
		}

		postOrder(root.left);
		postOrder(root.right);
		System.out.println(root.data);

	}

	public static void levelOrderTraversal(Node root) {

		
		// Tree : null
		if(root == null) {
			return;
		}
		
		
		//Consider
		// Queue:  1 null 2 3 null 4 5 6 null
		// null - next line
		// output : will be level by level. Like left pyramid
		//		1
		//		23
		//		456
		
		
		
		Queue<Node> queue = new LinkedList();

		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {

			// Remove the node from the queue
			Node node = queue.remove();

			if (node == null) {
				// Reached final null and No more elements in Queue
				// Then break;
				if (queue.isEmpty()) {
					break;
				} else {
					System.out.println();
					// Queue is not empty even after remove null value from the queue
					queue.add(null);
				}
			} else {
				System.out.print(node.data);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}

			}

		}

	}

	public static void main(String ar[]) {
		int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

		BinaryTr binaryTr = new BinaryTr();

		// Returns root node
		Node root = binaryTr.buildBinaryTree(nodes);

//		preOrder(root);
		
//		inOrder(root);

//		postOrder(root);

		levelOrderTraversal(root);
		
	}

}
