package com.sivapcu.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Question 1: <p>
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * <p>
 * For example,
 * <p>
 * <code>Given nums = [2, 7, 11, 15], target = 9,<br/>
 * Because nums[0] + nums[1] = 2 + 7 = 9,<br/>
 * return [0, 1].</code>
 * 
 * @author sivasankar_r
 *
 */
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		int[] solution = new int[2];
		for(int i=0; i < nums.length; i++) {
			for(int j=i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					solution[0] = i;
					solution[1] = j;
					System.out.println(nums[i]);
					System.out.println(nums[j]);
					break;
				}
			}
		}
		return solution;
	}
	
	public static int[] twoSumHashmap(int[] nums, int target) {
		int[] solution = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i < nums.length; i++) {
			int rem = target - nums[i];
			if(map.containsKey(rem)) {
				solution[0] = i;
				solution[1] = map.get(rem);
				return solution;
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No Solution found");
	}
	
	public static void main(String[] args) {
		int[] input = {230,863,916,585,981,404,316,785,88,12,70,435,384,778,887,755,740,337,86,92,325,422,815,650,920,125,277,336,221,847,168,23,677,61,400,136,874,363,394,199,863,997,794,587,124,321,212,957,764,173,314,422,927,783,930,282,306,506,44,926,691,568,68,730,933,737,531,180,414,751,28,546,60,371,493,370,527,387,43,541,13,457,328,227,652,365,430,803,59,858,538,427,583,368,375,173,809,896,370,789};
		int target = 542;
		long start = System.currentTimeMillis();
		System.out.println(Arrays.toString(twoSum(input, target)));
		long end = System.currentTimeMillis();
		System.out.println("Time taken : "+(end-start));
		start = System.currentTimeMillis();
		System.out.println(Arrays.toString(twoSumHashmap(input, target)));
		end = System.currentTimeMillis();
		System.out.println("Time taken : "+(end-start));
	}
}
