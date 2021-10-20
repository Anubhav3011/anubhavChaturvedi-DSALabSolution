package com.services;

/**
 * @author AnubhavChaturvedi
 * @category DSALabSolution
 * @date 2021-10-09
 */

import java.util.ArrayList;

import com.model.Node;

public class LongestPath {
	public ArrayList<Integer> findLongestPath(Node pRoot) {

		if (pRoot == null)
			return new ArrayList<Integer>();

		ArrayList<Integer> lRightNode = findLongestPath(pRoot.right);
		ArrayList<Integer> lLeftNode = findLongestPath(pRoot.left);

		if (lRightNode.size() < lLeftNode.size())
			lLeftNode.add(pRoot.data);
		else
			lRightNode.add(pRoot.data);

		return lLeftNode.size() > lRightNode.size() ? lLeftNode : lRightNode;
	}
}
