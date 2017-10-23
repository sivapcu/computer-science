package com.sivapcu.print;

@SuppressWarnings("unchecked")
public class MaxHeap<E> {
	private int lastElementIndex = -1;
	private final int MAX_HEAP_SIZE = 100;
	private E[] array = (E[]) new Object[MAX_HEAP_SIZE];

	public void add(E item) {
		array[++lastElementIndex] = item;
		trickleUp(lastElementIndex);
	}

	public E delete() {
		if (lastElementIndex == -1) {
			return null;
		}
		E deletedItem = array[0];
		swap(0, lastElementIndex--);
		trickleDown(0);
		return deletedItem;
	}

	private void trickleUp(int indexOfChild) {
		int parentIndex = (indexOfChild - 1) / 2;
		if (indexOfChild == 0) {
			return;
		}
		if (compare(parentIndex, indexOfChild) < 0) {
			swap(indexOfChild, parentIndex);
			trickleUp(parentIndex);
		}
	}

	private void trickleDown(int parentIndex) {
		int leftChildIndex = 2 * parentIndex + 1;
		int rightChildIndex = 2 * parentIndex + 2;

		if (leftChildIndex > lastElementIndex || rightChildIndex > lastElementIndex) {
			return;
		}

		if (leftChildIndex == lastElementIndex && compare(leftChildIndex, parentIndex) > 0) {
			swap(leftChildIndex, parentIndex);
			return;
		}

		if (rightChildIndex == lastElementIndex) {
			if (compare(leftChildIndex, rightChildIndex) > 0 && compare(leftChildIndex, parentIndex) > 0) {
				swap(leftChildIndex, parentIndex);
			} else if (compare(rightChildIndex, parentIndex) > 0) {
				swap(rightChildIndex, parentIndex);
			}
			return;
		}

		if (compare(leftChildIndex, rightChildIndex) > 0 && compare(leftChildIndex, parentIndex) > 0) {
			swap(leftChildIndex, parentIndex);
			trickleDown(leftChildIndex);
		} else if (compare(rightChildIndex, parentIndex) > 0) {
			swap(rightChildIndex, parentIndex);
			trickleDown(rightChildIndex);
		}
	}

	private void swap(int fromIndex, int toIndex) {
		E tmp = array[fromIndex];
		array[fromIndex] = array[toIndex];
		array[toIndex] = tmp;
	}

	private int compare(int index1, int index2) {
		return ((Comparable<E>) array[index1]).compareTo(array[index2]);
	}

	public String toString() {
		String string = "";
		for (int i = 0; i <= lastElementIndex; i++) {
			string = string + "array[" + i + "] = " + array[i] + "\n";
		}
		return string;
	}

}
