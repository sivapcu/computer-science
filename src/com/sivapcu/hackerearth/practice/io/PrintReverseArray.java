package com.sivapcu.hackerearth.practice.io;

import java.util.Scanner;

public class PrintReverseArray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] input = new int[sc.nextInt()];
		
		for(int i=0; i<input.length; i++) {
			input[i] = sc.nextInt();
		}
		
		sc.close();
		
		for(int i = input.length-1; i>=0; i--) {
			System.out.println(input[i]);
		}
		
	}
}
