package com.sivapcu.hackerearth.challenges.octobercircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Temp {
	public static void main(String[] args) throws IOException {
		
//		System.out.println(count(-2, 2));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		
		System.out.println(line);
		
	}
	
	private static int count(int start, int end) {
		if(end >= start) {
			return end-start;
		} else {
			return start-end;
		}
	}
}
