package com.sivapcu.hackerearth.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Factorial {
	static long[] cache = new long[100000+1];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfTestCases = Integer.parseInt(br.readLine());
		cache[0] = 1L;
		cache[1] = 1L;
		for (int i = 0; i < numOfTestCases; i++) {
			int input = Integer.parseInt(br.readLine());
			System.out.println(factorial(input));
		}
	}

	private static long factorial(int input) {
		if (cache[input] > 0) {
			return cache[input];
		} else {
			cache[input] = (input * factorial(input - 1) % 1000000007);
			return cache[input];
		}
	}
}
