package com.sivapcu.hackerearth.challenges.noveasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DivisibleTrios {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int length = Integer.parseInt(st.nextToken());
		int constant = Integer.parseInt(st.nextToken());
		long[] array = new long[length];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < length; i++) {
			array[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0;
		for(int i = 0; i<length-2; i++) {
			for(int j = i+1; j < length-1; j++) {
				for(int k = j+1; k < length; k++) {
					if((array[i] + array[j] + array[k]) % constant == 0) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
