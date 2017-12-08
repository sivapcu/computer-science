package com.sivapcu.hackerearth.practice.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IThinkItsEasy {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String[] array = br.readLine().split(" ");
			mergeSort(array, 0, array.length-1);
			System.out.println(String.join(" ", array));
		}
	}

	private static void mergeSort(String[] array, int low, int high) {
		if(low < high) {
			int mid = (low+high)/2;
			mergeSort(array, low, mid);
			mergeSort(array, mid+1, high);
			merge(array, low, mid, high);
		}
	}

	private static void merge(String[] array, int low, int mid, int high) {
		int i = low, j = mid+1;
		String[] temp = new String[high-low+1];
		int k = 0;
		
		while(i<=mid && j<=high) {
			if(array[i].length() <= array[j].length()) {
				temp[k++] = array[i++];
			} else {
				temp[k++] = array[j++];
			}
		}
		
		while(i<=mid) {
			temp[k++] = array[i++];
		}
		
		while(j<=high) {
			temp[k++] = array[j++];
		}
		
		for(k=0; k<temp.length; k++) {
			array[low++] = temp[k];
		}
		
	}
}
