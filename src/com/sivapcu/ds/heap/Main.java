package com.sivapcu.ds.heap;

public class Main {
	public static void main(String[] args) {
		MaxHeap<Integer> heap = new MaxHeap<>();
		heap.add(100);
		heap.add(30);
		heap.add(60);
		heap.add(25);
		heap.add(15);
		heap.add(35);
		heap.add(55);
		heap.add(7);
		heap.add(12);
		heap.add(6);
		heap.add(2);
		heap.add(20);
		heap.add(15);
//		System.out.println(heap);
		heap.delete();
		heap.delete();
		System.out.println(heap);
	}
}
