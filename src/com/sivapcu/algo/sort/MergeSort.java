package com.sivapcu.algo.sort;

import java.util.Arrays;

public class MergeSort {
	int[] array;
	int[] temp;

	public MergeSort(int[] input) {
		this.array = input;
		this.temp = new int[input.length];
		split(0, array.length - 1);
	}

	public int[] sortedArray() {
		return array;
	}

	private void split(int low, int high) {
		if (low == high) {
			return;
		}
		int mid = (low + high) / 2;
		split(low, mid);
		split(mid + 1, high);
		merge(low, mid, high);
	}

	private void merge(int low, int mid, int high) {
		int i = low, j = mid + 1, tempPos = low;
		System.out.print("low: " + low + " mid: " + mid + " high: " + high);
		while (i <= mid && j <= high) {
			if (array[i] < array[j]) {
				temp[tempPos++] = array[i++];
			} else {
				temp[tempPos++] = array[j++];
			}
		}

		while (i <= mid) {
			temp[tempPos++] = array[i++];
		}

		while (j <= high) {
			temp[tempPos++] = array[j++];
		}

		System.out.print(" tempArray --> " + Arrays.toString(temp) + "-->");
		System.out.print(" Array --> " + Arrays.toString(array));
		for (tempPos = low; tempPos <= high; tempPos++) {
			array[tempPos] = temp[tempPos];
		}
		System.out.println(" updated array --> " + Arrays.toString(array));
	}

	public static void main(String[] args) {
		int[] array = { 8, 3, 6, 4, 1, 2, 7, 5 };
		System.out.println(Arrays.toString(array));
		MergeSort ms = new MergeSort(array);
		System.out.println(Arrays.toString(ms.sortedArray()));
	}
}
