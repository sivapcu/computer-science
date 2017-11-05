package com.sivapcu.hackerearth.practice.io;

import java.util.Scanner;

public class CountDivisors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		int count = 0;
		if(k <= r) {
			while(l<=r) {
				if(l%k == 0) {
					count++;
				}
				l++;
			}
		}
		System.out.println(count);
	}
	
	public void bestAnswer() {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		int k = sc.nextInt();
		sc.close();
		int count = 0;
		if(l == r && l%k != 0) {
			System.out.println(0);
			System.exit(0);
		}
		
		while (l <= r) {
			if(l % k == 0) {
				break;
			}
			l++;
		}
 
		count = (r - l) / k + 1;
	}
}
 