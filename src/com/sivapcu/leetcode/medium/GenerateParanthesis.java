package com.sivapcu.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses. <p>

	For example, given n = 3, a solution set is:
	
	[
	  "((()))",
	  "(()())",
	  "(())()",
	  "()(())",
	  "()()()"
	]
 * @author sivasankar_r
 *
 */
public class GenerateParanthesis {

	public static List<String> generateParenthesis(int n) {
	    List<String> list = new ArrayList<String>();
	   
	    return list;
	}
	
	public static void main(String[] args) {
		generateParenthesis(2).stream().forEach(System.out::println);
	}
	
}