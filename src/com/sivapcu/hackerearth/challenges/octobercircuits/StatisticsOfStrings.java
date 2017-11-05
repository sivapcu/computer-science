package com.sivapcu.hackerearth.challenges.octobercircuits;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * https://www.hackerearth.com/challenge/competitive/october-circuits-17/algorithm/statistics-of-strings-3bec3843/
 * 
 * Data science is very popular now. A lot of universities have courses about
 * it. A lot of companies have open data science positions. So it's quite
 * important to know how to work with statistics. And this task can help you to
 * make first step into statistics.
 * 
 * Lets define S as all strings of the length n consisting of letters from the
 * some alphabet of the size a. For each string s lets define f(s) - maximum
 * among all z-function values of the string s. Your task is calculate ∑s∈Sf(s)
 * modulo mod.
 * 
 * You can read more about z-function on
 * https://e-maxx-eng.appspot.com/string/z-function.html. Also in this problem
 * we define z0=0.
 * 
 * Input format
 * 
 * First line of input contains three space separated integers n, a and mod
 * (1≤n≤22, 1≤a≤10^9, 1≤mod≤10^9).
 * 
 * Note that mod may be composite.
 * 
 * Output format
 * 
 * Print the single integer ∑s∈Sf(s) modulo mod.
 * 
 * @author siva
 *
 */
public class StatisticsOfStrings {
	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt();
		// int a = sc.nextInt();
		// int mod = sc.nextInt();
		int[] input = { 1, 2, 1, 3, 1, 2, 1 };
		int[] zFunction = zFunction(input);
		System.out.println(zFunction);
	}

	public static int[] zFunction(int[] input) {
		int[] output = new int[input.length];
		output[0] = 0;
		for(int index = 1; index < output.length; index++) {
			int i=0, j=index, value = 0;
			while(j < output.length && input[i] == input[j]) {
				value++;
				i++;
				j++;
			}
			output[index] = value;
		}
		return output;
	}
}
