package com.sivapcu.hackerearth.practice.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cipher {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = br.readLine().toCharArray();
		int rotate = Integer.parseInt(br.readLine());
		for (int i = 0; i < input.length; i++) {
			char c = input[i];
			if (c >= 48 && c <= 57) {
				// numbers 0 to 9
				int temp = c + (rotate % 10);
				if (temp > 57) {
					temp = 47 + (temp % 57);
				}
				input[i] = (char) temp;
			} else if (c >= 65 && c <= 90) {
				// uppercase letters
				int temp = c + (rotate % 26);
				if (temp > 90) {
					temp = 64 + (temp % 90);
				}
				input[i] = (char) temp;
			} else if (c >= 97 && c <= 122) {
				// lowercase letters

				int temp = c + (rotate % 26);
				if (temp > 122) {
					temp = 96 + (temp % 122);
				}
				input[i] = (char) temp;
			}
			System.out.print(input[i]);
		}
	}
}
