package com.sivapcu.algo.sort;

import java.util.Arrays;

public class SelectionSort {
	public static void main(String[] args) {
		int[] input = { 3, 5, 1, 2, 4 };
		System.out.println("Input array : " + Arrays.toString(input));
		sort(input);
		System.out.println("Sorted array : " + Arrays.toString(input));
	}

	private static void sort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int currentSmallIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[currentSmallIndex]) {
					currentSmallIndex = j;
				}
			}
			if (i != currentSmallIndex) {
				swap(a, i, currentSmallIndex);
			}
		}
	}

	private static void swap(int[] a, int s, int t) {
		int temp = a[s];
		a[s] = a[t];
		a[t] = temp;
	}
}
