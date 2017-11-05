package com.sivapcu.hackerearth.challenges.octobercircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/replace-27c5286c/
 * @author siva
 *
 */
public class Replace {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(s.nextToken());
		int queries = Integer.parseInt(s.nextToken());
		
		int[] input = new int[size];
		s = new StringTokenizer(br.readLine());
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(s.nextToken());
		}

		for (int i = 0; i < queries; i++) {
			s = new StringTokenizer(br.readLine());
			int queryType = Integer.parseInt(s.nextToken());
			int a = Integer.parseInt(s.nextToken());
			int b = Integer.parseInt(s.nextToken());
			int x = Integer.parseInt(s.nextToken());
			if (queryType == 1) {
				int y = Integer.parseInt(s.nextToken());
				for (int j = a - 1; j <= b - 1; j++) {
					if (input[j] == x) {
						input[j] = y;
					}
				}
			} else {
				int count = 0;
				for (int j = a - 1; j <= b - 1; j++) {
					if (input[j] == x) {
						count++;
					}
				}
				System.out.println(count);
			}
		}
		br.close();
	}
}
