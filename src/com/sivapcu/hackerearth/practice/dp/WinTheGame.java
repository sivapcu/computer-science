package com.sivapcu.hackerearth.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WinTheGame {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfTestCases = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int i = 0; i < numOfTestCases; i++) {
			st = new StringTokenizer(br.readLine());
			double redBalls = Integer.parseInt(st.nextToken());
			double greenBalls = Integer.parseInt(st.nextToken());
			double output = redBalls/(redBalls + greenBalls);
			System.out.println(String.format("%.6f", output));
			
		}
	}
}
