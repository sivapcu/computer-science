package com.sivapcu.hackerearth.challenges.octobercircuits;

import java.util.Scanner;

public class CardGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aCount = sc.nextInt();
		long a[] = new long[aCount];

		for (int i = 0; i < aCount; i++) {
			a[i] = sc.nextInt();
		}

		int bCount = sc.nextInt();
		long b[] = new long[bCount];

		for (int i = 0; i < bCount; i++) {
			b[i] = sc.nextInt();
		}
		sc.close();

		long bMax = getMaxValue(b);
		
		long reqDollars = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i] <= bMax) {
				reqDollars = reqDollars + (bMax-a[i]) + 1;
			}
		}
		System.out.println(reqDollars);
	}

	private static long getMaxValue(long[] input) {
		long max = 0;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > max) {
				max = input[i];
			}
		}
		return max;
	}
}
