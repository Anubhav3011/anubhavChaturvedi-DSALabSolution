package com.services;

import com.model.Node;

/**
 * @author AnubhavChaturvedi
 * @category DSALabSolution
 * @date 2021-10-09
 */

public class BinaryTree {

	public Node insertLevelOrder(int[] pTreeArray, Node pRoot, int pIndex) {
		// Base case for recursion
		if (pIndex < pTreeArray.length) {
			Node lTemp = new Node(pTreeArray[pIndex]);
			pRoot = lTemp;

			// insert left child
			pRoot.left = insertLevelOrder(pTreeArray, pRoot.left, 2 * pIndex + 1);

			// insert right child
			pRoot.right = insertLevelOrder(pTreeArray, pRoot.right, 2 * pIndex + 2);
		}
		return pRoot;
	}

	public void printBinaryTree(Node pRoot, int pLevel) {
		// Base case for recursion
		if (pRoot == null)
			return;

		// Recursive call
		printBinaryTree(pRoot.right, pLevel + 1);

		//Printing branches
		if (pLevel != 0) {
			for (int i = 0; i < pLevel - 1; i++)
				System.out.print("|\t");
			System.out.println("|-------" + pRoot.data);
		} else
			System.out.println(pRoot.data);
		printBinaryTree(pRoot.left, pLevel + 1);
	}
}
