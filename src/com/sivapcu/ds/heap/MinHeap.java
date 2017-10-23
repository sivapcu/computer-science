package com.sivapcu.ds.heap;

@SuppressWarnings("unchecked")
public class MinHeap<E> {
	private int indexOfLastElement = -1;
	private static final int MAX_ARRAY_SIZE = 100;
	private E[] array = (E[])new Object[MAX_ARRAY_SIZE];
	
	public void add(E item) {
		// increment the last element position and add the element there
		// trickle up.
		array[++indexOfLastElement] = item;
		trickleUp(indexOfLastElement);
	}

	private void trickleUp(int currentIndex) {
		// find parent index
		// compare element at parent with element at current index.
		// if current element is less than parent , swap
		// trickleup on parent index
		// edge cases -> 1. if current index is 0 i.e., at root postion exit
		// -> 2. if parent is greater than or equal exit
		
		if(currentIndex == 0) {
			return;
		}
		
		int parentIndex = (currentIndex - 1)/2;
		
		if(((Comparable<E>)array[currentIndex]).compareTo(array[parentIndex]) < 0) {
			swap(currentIndex, parentIndex);
			trickleUp(parentIndex);
		}
	}
	
	private void swap(int fromIndex, int toIndex) {
		E tmp = array[fromIndex];
		array[fromIndex] = array[toIndex];
		array[toIndex] = tmp;
	}

	public E remove() {
		// if array is empty, return null;
		if(indexOfLastElement == -1) {
			return null;
		}
		if(indexOfLastElement == 0) {
			E root = array[0];
			indexOfLastElement--;
			return root;
		}
		E root = array[0];
		swap(0, indexOfLastElement--);
		trickleDown(0);
		return root;
	}

	private void trickleDown(int currentIndex) {
		// find child indexes
		// find the smaller child
		// replace currentIndex element with smallerChild element
		// trickle down on the smallerCHild index
		
		int leftChildIndex = 2 * currentIndex + 1;
		int rightChildIndex = 2 * currentIndex + 2;
		
		E current = array[currentIndex];
		E leftChild = array[leftChildIndex];
		E rightChild = array[rightChildIndex];
		
		if(leftChildIndex == indexOfLastElement && ((Comparable<E>)leftChild).compareTo(current) < 0) {
			swap(leftChildIndex, currentIndex);
			return;
		}
		
		if(rightChildIndex == indexOfLastElement) {
			if(((Comparable<E>)leftChild).compareTo(rightChild) < 0) {
				if(((Comparable<E>)leftChild).compareTo(current) < 0) {
					swap(leftChildIndex, currentIndex);
				} 
			} else if(((Comparable<E>)rightChild).compareTo(current) < 0) {
				swap(rightChildIndex, currentIndex);
			}
			return;
		}
		
		if(leftChildIndex > indexOfLastElement || rightChildIndex > indexOfLastElement) {
			return;
		}
		
		if(((Comparable<E>)leftChild).compareTo(rightChild) < 0) {
			if(((Comparable<E>)leftChild).compareTo(current) < 0) {
				swap(leftChildIndex, currentIndex);
				trickleDown(leftChildIndex);
			} 
		} else if(((Comparable<E>)rightChild).compareTo(current) < 0) {
			swap(rightChildIndex, currentIndex);
			trickleDown(rightChildIndex);
		}
	}
}
