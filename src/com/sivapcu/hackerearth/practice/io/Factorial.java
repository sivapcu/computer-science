package com.sivapcu.hackerearth.practice.io;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		System.out.println(factorial(input));
		sc.close();
	}
	
	private static int factorial(int input) {
		if(input > 1 ) {
			return input*factorial(input-1);			
		} else {
			return 1;
		}
	}

}
