package com.sivapcu.algo.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] input = {5, 2, 4, 6, 1, 3};
		System.out.println("Input array : " + Arrays.toString(input));
		insertionSortDesc(input);
		System.out.println("Sorted array : " + Arrays.toString(input));
	}

	private static void insertionSortAsc(int[] input) {
		// 1. start at index 1
		// 2. if index 1 < index 0 --> swap values of index 0 and 1
		// 3. start at index 2
		// 4. if index 2 < index 1 --> swap 2 and 1
		// 5. if index 1 < index 0 --> swap 1 and 0 
		System.out.println("Sort by Ascending...");
		for(int i = 1; i < input.length; i++) {
			for(int j=i-1; j >= 0; j--) {
				if(input[j+1] < input[j]) {
					int temp = input[j+1];
					input[j+1] = input[j];
					input[j] = temp;
				} else {
					break;
				}
			}
			System.out.println(Arrays.toString(input));
		}
	}
	
	private static void insertionSortDesc(int[] input) {
		System.out.println("Sort by Descending...");
		for(int i=1; i<input.length; i++) {
			for(int j=i-1; j>=0; j--) {
				if(input[j+1] > input[j]) {
					int temp = input[j+1];
					input[j+1] = input[j];
					input[j] = temp;
				} else {
					break;
				}
			}
			System.out.println(Arrays.toString(input));
		}
	}
}
