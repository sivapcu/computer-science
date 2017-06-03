package com.sivapcu.algo.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] input = {64, 34, 25, 12, 22, 11, 90};
//		int[] input = {5, 1, 4, 2, 8};
//		int[] input = {1, 2, 3, 4, 5};
		System.out.println("Input Array : "  + Arrays.toString(input));
//		bubbleSort(input);
//		bubbleSortOptimised1(input);
		bubbleSortOptimised2(input);
		System.out.println("Sorted Array : " + Arrays.toString(input));
	}
	
	/**
	 * Original Bubble sort algorithm
	 * @param input
	 */
	public static void bubbleSort(int[] input) {
		for(int i=0; i < input.length-1; i++) {
			System.out.println("Iteration " + (i+1));
			for(int j=0; j < input.length-1 ; j++) {
				if(input[j] > input [j+1]) {
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
				System.out.println(Arrays.toString(input));
			}
		}
	}
	
	/**
	 * Bubble sort algorithm with one optimization
	 * Optimization : After every outer loop, one will reach its final position, so it can avoided in the inner loop
	 * @param input
	 */
	public static void bubbleSortOptimised1(int[] input) {
		for(int i=0; i < input.length-1; i++) {
			System.out.println("Iteration " + (i+1));
			for(int j=0; j < (input.length-1-i) ; j++) { //Last i elements are already in place
				if(input[j] > input [j+1]) {
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
				}
				System.out.println(Arrays.toString(input));
			}
		}
	}
	
	/**
	 * Bubble sort algorithm with optimization
	 * Optimization : 
	 * 1) After every outer loop, one item will reach its final position, so it can avoided in the inner loop<br/>
	 * 2) if no swaps happen in an iteration, then it implies the list is already sorted
	 * @param input
	 */
	private static void bubbleSortOptimised2(int[] input) {
		for(int i=0; i < input.length-1; i++) {
			boolean isSorted = true;
			System.out.println("Iteration " + (i+1));
			for(int j=0; j < (input.length-1-i) ; j++) { //Last i elements are already in place
				if(input[j] > input [j+1]) {
					int temp = input[j];
					input[j] = input[j+1];
					input[j+1] = temp;
					isSorted = false; // since a swap happened in this iteration
				}
				System.out.println(Arrays.toString(input));
			}
			if(isSorted) {
				break;
			}
		}
	}
}
