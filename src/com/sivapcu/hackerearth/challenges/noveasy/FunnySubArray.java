package com.sivapcu.hackerearth.challenges.noveasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class FunnySubArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine());
		int[] array = new int[length];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}

		Map<Integer, Integer> map = new HashMap<>();
		int longest = 0;
		for (int i = 0; i < length; i++) {
			if (map.containsKey(array[i])) {
				continue;
			}
			int subArrayLength = 1;
			int gap = 1;
			for (int j = i + 1; j < length; j++) {
				gap++;
				if (array[i] == array[j]) {
					subArrayLength = gap;
				}
			}
			if (subArrayLength > longest) {
				longest = subArrayLength;
			}
			map.put(array[i], subArrayLength);
		}
		System.out.println(longest);
	}

}