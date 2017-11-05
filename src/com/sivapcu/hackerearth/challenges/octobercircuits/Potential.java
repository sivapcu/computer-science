package com.sivapcu.hackerearth.challenges.octobercircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Potential {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		int[] x = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}

		int[] y = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			y[i] = Integer.parseInt(st.nextToken());
		}

		for (int index = 0; index < q; index++) {
			st = new StringTokenizer(br.readLine());
			int queryType = Integer.parseInt(st.nextToken());
			if(queryType == 1) {
				int pos = Integer.parseInt(st.nextToken());
				x[pos-1] = Integer.parseInt(st.nextToken());
			} else if(queryType == 2) {
				int pos = Integer.parseInt(st.nextToken());
				y[pos-1] = Integer.parseInt(st.nextToken());
			} else {
				int rangeLeft = Integer.parseInt(st.nextToken());
				int rangeRight = Integer.parseInt(st.nextToken());
				int max = 0;
				for(int j = rangeLeft-1; j<= rangeRight-1; j++) {
					int val = x[j] + Math.min(y[j], j+1-rangeLeft);
					if(val > max) {
						max = val;
					}
				}
				System.out.println(max);
			}
		}
		br.close();
	}
}
