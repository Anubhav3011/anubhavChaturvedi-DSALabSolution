package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import com.model.Node;
import com.services.BalancingBrackets;
import com.services.BinaryTree;
import com.services.LongestPath;

/**
 * @author AnubhavChaturvedi
 * @category DSALabSolution
 * @date 2021-10-09
 */

public class Driver {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		try {
			Scanner lScanner = new Scanner(System.in);
			int lChoice = -1;

			do {
				System.out.print("\n" + "Please enter the Problem Statement from the following: " + "\n"
						+ "1. Balancing Brackets " + "\n" + "2. Longest Path (Root-To-Leaf in Binary Tree) " + "\n"
						+ "\nPress 0 to Exit " + "\n");

				lChoice = Integer.parseInt(lScanner.nextLine());
				switch (lChoice) {

				// Exit the program
				case 0: {
					break;
				}

				// Q1. Balancing Brackets
				case 1: {
					System.out.println("\n" + "***** Welcome to Balancing Brackets *****" + "\n");

					String lInput = null;
					System.out.println("Enter the expression to evaluate: " + "\n"
							+ "[Or you can use test case given in the question]" + "\n\n" + "1. ( [ [ { } ] ] )" + "\n"
							+ "2. ( [ [ { } ] ] ) )" + "\n");
					lInput = lScanner.nextLine();

					if (new BalancingBrackets().checkBalancingBrackets(lInput))
						System.out.println("The entered String has Balanced Brackets");
					else
						System.out.println("The entered Strings do not contain Balanced Brackets");
				}
					break;

				// Q2. Longest Path (Root-To-Leaf in Binary Tree]=)
				case 2: {
					System.out
							.println("\n" + "***** Welcome to Longest Path (Root-To-Leaf in Binary Tree) *****" + "\n");

					String lInput = null;
					System.out.println("Enter values for binary tree according to level order: " + "\n"
							+ "[Or you can use test case given in the question]" + "\n\n" + "100 20 130 10 50 110 140 5"
							+ "\n\n" + "                   100" + "\n" + "                   / \\" + "\n"
							+ "                  /   \\" + "\n" + "                 /     \\" + "\n"
							+ "                /       \\" + "\n" + "               20       130" + "\n"
							+ "              / \\       / \\" + "\n" + "             /   \\     /   \\" + "\n"
							+ "            10   50   110  140" + "\n" + "           /" + "\n" + "          5" + "\n\n");
					lInput = lScanner.nextLine();
					int[] lTreeArray = Arrays.stream(lInput.split("\s")).map(String::trim).mapToInt(Integer::parseInt)
							.toArray();

					Node lRoot = null;
					BinaryTree lBinaryTree = new BinaryTree();
					lRoot = lBinaryTree.insertLevelOrder(lTreeArray, lRoot, 0);
					System.out.println("\n" + "Binary Tree (Horizontal Representation)" + "\n");
					lBinaryTree.printBinaryTree(lRoot, 0);

					ArrayList<Integer> lTreeArrayList = new LongestPath().findLongestPath(lRoot);
					Collections.reverse(lTreeArrayList);
					System.out.println("\n" + "Longest Path "
							+ lTreeArrayList.toString().substring(1).replace("]", "").replaceAll(", ", " -> "));
				}
					break;

				default:
					System.out.println("Invalid choice. Enter a valid no.");
				}
			} while (lChoice != 0);
			lScanner.close();
		} catch (Exception e) {
			System.out.println("Error- " + e.getMessage());
			e.printStackTrace();
		}
	}
}
