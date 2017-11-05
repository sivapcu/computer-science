package com.sivapcu.hackerearth.practice.io;

import java.util.Scanner;

public class StringReverse {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i = 0; i < t; i++) {
			char[] s = sc.next().toCharArray();
			// StringBuilder sb = new StringBuilder("");
			// for(int j = s.length-1; j >= 0; j--) {
			// sb.append(s[j]);
			// }
			// System.out.println(sb.toString());

			for (int j = 0; j < s.length / 2; j++) {
				char temp = s[j];
				s[j] = s[s.length - 1 - j];
				s[s.length - 1 - j] = temp;
			}
			System.out.println(s);
		}
		sc.close();
	}
}
