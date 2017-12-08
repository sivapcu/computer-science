package com.sivapcu.hackerearth.practice.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheBestPlayer {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] frequencies = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			frequencies[i] = Integer.parseInt(st.nextToken());
		}

		selectionSortDesc(frequencies);

		int k = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[][] keys = new int[k][];
		int total = 0;
		for (int i = 0; i < k; i++) {
			int keySize = Integer.parseInt(st.nextToken());
			keys[i] = new int[keySize];
			total += keySize;
		}

		if (total < n) {
			System.out.println(-1);
		} else {
			long sum = 0;
			int toBeInserted = 0;
			int pointer = 0;
			while (toBeInserted < n) {
				for (int i = 0; i < k && toBeInserted < n; i++) {
					if (pointer < keys[i].length) {
						sum = sum + (frequencies[toBeInserted] * (pointer + 1));
						keys[i][pointer] = frequencies[toBeInserted];
						toBeInserted++;
					}
				}
				pointer++;
			}
			System.out.println(sum);
		}
	}

	private static void selectionSortDesc(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			int currentLargestIndex = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] > a[currentLargestIndex]) {
					currentLargestIndex = j;
				}
			}
			if (i != currentLargestIndex) {
				swap(a, i, currentLargestIndex);
			}
		}
	}

	private static void swap(int[] a, int s, int t) {
		int temp = a[s];
		a[s] = a[t];
		a[t] = temp;
	}
}
