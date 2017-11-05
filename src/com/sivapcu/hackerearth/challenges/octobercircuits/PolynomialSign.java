package com.sivapcu.hackerearth.challenges.octobercircuits;

import java.util.Scanner;

/**
 * Consider a polynomial function f(x)f(x) with integer coefficients:
 * a0+a1⋅x+...+an⋅xna0+a1⋅x+...+an⋅xn. Lets define superBig=10000^10000^10000.
 * Someone really wants to know sgn(f(superBig)) and sgn(f(−superBig)). Please,
 * help him to find the sign of these values. Note that an can be zero.
 * 
 * Read more about sgn function on https://en.wikipedia.org/wiki/Sign_function.
 * 
 * Input format
 * 
 * The first line contains single integer n(0≤n≤3⋅10^5). The second line
 * contains n+1 space separated integers ai(−10^18≤ai≤10^18) - the coefficients
 * of polynomial.
 * 
 * Output format
 * 
 * Print two space separated integers sgn(f(superBig)) and sgn(f(−superBig)).
 * 
 * Note that these values can be only −1, 0 or 1.
 * 
 * SAMPLE INPUT 1 -100 1
 * 
 * SAMPLE OUTPUT 1 -1
 * 
 * Explanation
 * 
 * sgn(f(superBig))=sgn(superBig−100)=1, superBig−100>0
 * sgn(f(−superBig))=sgn(−superBig−100)=−1, −superBig−100<0
 *
 */
public class PolynomialSign {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[] array = new long[n + 1];

		for (int i = 0; i <= n; i++) {
			array[i] = sc.nextLong();
		}
		sc.close();

		if (n == 0) {
			if (array[0] > 0) {
				System.out.print("1 1");
			} else if (array[0] < 0) {
				System.out.print("-1 -1");
			} else {
				System.out.print("0 0");
			}
		} else {
			while (n > 0) {
				if (array[n] == 0) {
					n--;
				} else {
					if ((n) % 2 == 0) {
						if (array[n] > 0) {
							System.out.print("1 1");
						} else {
							System.out.print("-1 -1");
						}
					} else {
						if (array[n] > 0) {
							System.out.print("1 -1");
						} else {
							System.out.println("-1 1");
						}
					}
					break;
				}
			}
		}
	}
}
