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
public class ReplaceUsingSegmentTree {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(s.nextToken());
//		int queries = Integer.parseInt(s.nextToken());
		
		int[] input = new int[size];
		s = new StringTokenizer(br.readLine());
		for (int i = 0; i < input.length; i++) {
			input[i] = Integer.parseInt(s.nextToken());
		}
		SegmentTree segTree = new SegmentTree(input);
		int[] nodes = segTree.getNodes();
		
		for(int i = 0; i<nodes.length; i++) {
			System.out.print(nodes[i]+"\t");
		}
		br.close();
	}	
}
