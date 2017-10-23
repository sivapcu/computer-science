package com.sivapcu.leetcode.easy;

import java.util.Arrays;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to
 * [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3
 * different ways to solve this problem.
 * 
 * [show hint]
 * 
 * Related problem: Reverse Words in a String II
 * 
 * @author siva
 *
 */
public class ArrayRightRotation {
	//TODO find a better solution by using the array reversal technique
	public static void rotate(int[] nums, int k) {
		int[] output = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			output[(i + k) % nums.length] = nums[i];
		}
		nums = output;
		Arrays.stream(nums).forEach(val -> System.out.print(val+" "));
//		Arrays.stream(output).forEach(val -> System.out.print(val+" "));
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int k = 4;
		rotate(input, k);

	}
}
