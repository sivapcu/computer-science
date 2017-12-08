package com.sivapcu.hackerearth.challenges.novcircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KilljeeAndMagicValue {
	
	private static final int prime = 1000000007;
	private static final int limit =  2000001;
	static long[] factorial = new long[limit];
	static long[] fibonacci = new long[limit];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		initialize();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int numOfTestCase = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int i = 0; i < numOfTestCase; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			System.out.println(calculateMagicNumber(k, calculateP(n, m)));
		}
		
	}

	private static void initialize() {
		fibonacci[0] = fibonacci[1] = 1;
		factorial[0] = factorial[1] = 1;
		for(int i = 2; i < limit; i++) {
			fibonacci[i] = (fibonacci[i-1]%prime + fibonacci[i-2]%prime) % prime;
			factorial[i] = ((i%prime)*(factorial[i-1]%prime)) % prime;
		}
	}
	
	private static long calculateP(int n, int m) {
		long sum = 0;
		for(int i = n; i <= m; i++) {
			sum = (sum + (fibonacci[i] * factorial[i]) % prime) % prime;
		}
		return sum;
	}
	
	private static long calculateMagicNumber(int k, long p) {
		return (p/k)%prime;
	}
}
