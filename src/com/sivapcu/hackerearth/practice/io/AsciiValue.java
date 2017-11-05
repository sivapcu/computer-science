package com.sivapcu.hackerearth.practice.io;

import java.util.Scanner;

public class AsciiValue {

	public static void main(String[] args) throws Exception {
//		Scanner sc = new Scanner(System.in);
//		System.out.println((int)(sc.next().charAt(0)));
		System.out.println(200%26);
		int i = 97 + (200%26);
		if(i > 122) {
			i = 96 + (i%26);
		}
		System.out.println((char)i);
		
	}
}
