package com.sivapcu.hackerearth.practice.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
	static int output = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());

		for (int i = 0; i < size; i++) {
			char[] s1 = br.readLine().toCharArray();
			HashMap<Integer, Integer> s1CharCounts = new HashMap<>();
			for(char c : s1) {
				if(s1CharCounts.containsKey((int)c)) {
					s1CharCounts.put((int)c, s1CharCounts.get((int)c) + 1);
				} else {
					s1CharCounts.put((int)c, 1);
				}
			}
			
			char[] s2 = br.readLine().toCharArray();
			HashMap<Integer, Integer> s2CharCounts = new HashMap<>();
			for(char c : s2) {
				if(s2CharCounts.containsKey((int)c)) {
					s2CharCounts.put((int)c, s2CharCounts.get((int)c) + 1);
				} else {
					s2CharCounts.put((int)c, 1);
				}
			}
			
			for (Map.Entry<Integer, Integer> entry : s1CharCounts.entrySet()) {
				int s2Count = 0;
				Integer key = entry.getKey();
				if(s2CharCounts.get(key)!=null) {
					s2Count = s2CharCounts.get(key);
				}
				output = output + Math.abs(entry.getValue() - s2Count);
				s2CharCounts.remove(key);
			}
			
			for (Map.Entry<Integer, Integer> entry : s2CharCounts.entrySet()) {
				output = output + entry.getValue();
			}
			
			System.out.println(output);
			output = 0;
		}
	}
}
