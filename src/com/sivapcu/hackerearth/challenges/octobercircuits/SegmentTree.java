package com.sivapcu.hackerearth.challenges.octobercircuits;

public class SegmentTree {
	private int[] nodes;

	public SegmentTree(int[] inputArray) {
		nodes = new int[2 * inputArray.length - 1];
		build(0, 0, inputArray.length - 1, inputArray);
	}

	private void build(int nodeIndex, int rangeStart, int rangeEnd, int[] inputArray) {
		if (rangeStart == rangeEnd) {
			// leaf node will have single element
			nodes[rangeStart] = inputArray[rangeStart];
		} else {
			int mid = (rangeStart + rangeEnd) / 2;
			int leftChild = 2 * nodeIndex + 1;
			int rightChild = 2 * nodeIndex + 2; // or leftChild + 1
			
			build(leftChild, rangeStart, mid, inputArray);
			build(rightChild, mid+1, rangeEnd, inputArray);
			nodes[nodeIndex] = nodes[leftChild] + nodes[rightChild];
		}
	}
	
	public int[] getNodes() {
		return nodes;
	}
}
