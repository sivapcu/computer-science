package com.sivapcu.ds.heap;

@SuppressWarnings("unchecked")
public class MaxHeap<E> {
	private int indexOfLastElement = -1; // since no elements present
	private final int MAX_HEAP_SIZE = 100;
	private E[] array = (E[]) new Object[MAX_HEAP_SIZE];

	public void add(E item) {
		// 1. add item to first available space i.e., next index of the last
		// element
		// 2. recursively trickle up the item
		array[++indexOfLastElement] = item;
		trickleUp(indexOfLastElement);
	}

	private void trickleUp(int indexOfChild) {
		if (indexOfChild == 0) {
			return; // current element is the root.
		}
		int indexOfParent = (indexOfChild - 1) / 2;
		if (((Comparable<E>) array[indexOfParent]).compareTo(array[indexOfChild]) < 0) {
			// if parent is less than child, swap.
			// after swap, call trickle up recursively on the current parent
			// index
			swap(indexOfChild, indexOfParent);
			trickleUp(indexOfParent);
		}
	}

	private void swap(int fromIndex, int toIndex) {
		E tmp = array[fromIndex];
		array[fromIndex] = array[toIndex];
		array[toIndex] = tmp;
	}

	public E delete() {
		if (indexOfLastElement == -1) {
			return null; // heap is empty
		}
		E deletedItem = array[0]; // in heap data structure, always delete the
									// root element. Then fix the hole created
									// by filling the hole with the last element
									// in the heap
		swap(0, indexOfLastElement--); // instead of deleting the last element,
										// swap the zeroth element with
										// indexOfLastElement and decrement the
										// indexOfLastElement. By doing this,
										// the elements after current
										// indexOfLastElement automatically gets
										// sorted. And this is the algorithm for
										// heap sort also

		trickleDown(0); // trickleDown the current root element to its suitable
						// position.
		return deletedItem;
	}

	private void trickleDown(int indexOfParent) {
		int indexOfLeftChild = 2 * indexOfParent + 1;
		int indexOfRightChild = 2 * indexOfParent + 2;

		E parent = array[indexOfParent];
		E leftChild = array[indexOfLeftChild];
		E rightChild = array[indexOfRightChild];

		// exit cases for the recursive trickleDown is
		// 1. when leftChild is the lastElement in the heap, swap(left, parent)
		// and return null (remember no trickleDown on last element)
		// 2. when rightChild is the lastElement in the heap,
		// - check if left or right child is bigger, out of the bigger one,
		// compare if parent is bigger or child is bigger
		// - swap(biggerChild, parent) and return null (Remember no trickleDown
		// on last element)
		// 3. if 1st or 2nd exit scenarios doesn't satisfy, check if leftChild or
		// rightChild is outofbounds of the heap length and return null

		if (indexOfLeftChild == indexOfLastElement) { // exit case 1
			if(((Comparable<E>) leftChild).compareTo(parent) > 0) {
				// leftChild is bigger than parent.
				swap(indexOfLeftChild, indexOfParent);
			}
			return;
		}

		if (indexOfRightChild == indexOfLastElement) { // exit case 2
			if (((Comparable<E>) leftChild).compareTo(rightChild) > 0) {
				if (((Comparable<E>) leftChild).compareTo(parent) > 0) {
					swap(indexOfLeftChild, indexOfParent);
				}
			} else if (((Comparable<E>) rightChild).compareTo(parent) > 0) {
					swap(indexOfRightChild, indexOfParent);
			}
			return;
		}

		if (indexOfLeftChild > indexOfLastElement || indexOfRightChild > indexOfLastElement) { // exit
																								// case
																								// 3
			return; // the position of the left child of the current parent
					// beyond the current array length
		}

		if (((Comparable<E>) leftChild).compareTo(rightChild) > 0
				&& ((Comparable<E>) leftChild).compareTo(parent) > 0) {
			swap(indexOfLeftChild, indexOfParent);
			trickleDown(indexOfLeftChild);
		} else if (((Comparable<E>) rightChild).compareTo(parent) > 0) {
			swap(indexOfRightChild, indexOfParent);
			trickleDown(indexOfRightChild);
		}

	}
	
	public String toString() {
		String string = "";
		for (int i = 0; i <= indexOfLastElement; i++) {
			string = string + "array[" + i + "] = " + array[i] + "\n";
		}
		return string;
	}

}
