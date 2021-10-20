package com.services;

import java.util.Stack;

/**
 * @author AnubhavChaturvedi
 * @category DSALabSolution
 * @date 2021-10-09
 */

public class BalancingBrackets {

	private Stack<Character> stack = null;

	public boolean checkBalancingBrackets(String pInput) {

		stack = new Stack<Character>();

		for (int i = 0; i < pInput.length(); i++) {

			char lCharacter = pInput.charAt(i);

			if (!String.valueOf(lCharacter).matches("^[\\\\(\\\\)\\\\{\\\\}\\[\\]]*$"))
				continue;

			if (lCharacter == '{' || lCharacter == '[' || lCharacter == '(')
				stack.push(lCharacter);
			else {
				if (stack.isEmpty())
					return false;

				char c = stack.pop();

				switch (lCharacter) {
				case '}':
					if (c != '{')
						return false;
					break;
				case ']':
					if (c != '[')
						return false;
					break;
				case ')':
					if (c != '(')
						return false;
					break;
				}
			}

		}

		return stack.isEmpty();
	}
}
