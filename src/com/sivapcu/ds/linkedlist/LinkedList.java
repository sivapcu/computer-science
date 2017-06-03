package com.sivapcu.ds.linkedlist;

public class LinkedList {
	private Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}
	
	/**
	 * Traverses all the elements start from head and prints the values in the node
	 */
	public void print() {
		if(head!=null) {
			Node currentNode = head;
			while(currentNode!=null) {
				System.out.print(currentNode.getData()+" --> ");
				currentNode = currentNode.getNext();
			}
			System.out.println();
		} else {
			System.out.println("Zero elements found");
		}
	}
	
	public int length() {
		int count = 0;
		if(head!=null) {
			Node currentNode = head;
			while(currentNode!=null) {
				count++;
				currentNode = currentNode.getNext();
			}
		}
		return count;
	}
	
	/**
	 * Inserts the new data at the head of the linked list
	 * <p>
	 * The Big O is O(1) since the elements is always added at the head without
	 * any comparisons with other elements in the LinkedList
	 * 
	 * @param data
	 */
	public void push(int data) {
		if(head == null) {
			head = new Node(data);
		} else {
			Node oldHead = head;
			head = new Node(data);
			head.setNext(oldHead);
		}
	}

	/**
	 * Appends the new data at the tail of the linked list
	 * <p>
	 * The Big O is O(n) since all the elements in the list has to be traversed
	 * before adding the node. <p>This method can be optimised to O(1) by holding a
	 * reference to tail. Refer the <code>LinkedListWithTail.append()</code>
	 * 
	 * @param data
	 */
	public void append(int data) {
		// long start = System.currentTimeMillis();
		if(head == null) {
			head = new Node(data);
		} else {
			Node currentNode = head;
			Node prevNode = null;
			while(currentNode != null) {
				prevNode = currentNode;
				currentNode = currentNode.getNext();
			}
			currentNode = new Node(data);
			prevNode.setNext(currentNode);
		}
		// long end = System.currentTimeMillis();
		// System.out.println("Time taken in ms : "+ (end-start));
	}

	public void insertAfter(Node prevNode, int data) {
		if(prevNode == null) {
			System.out.println("Previous Node cannot be null");
		} else {
			Node newNode = new Node(data);
			newNode.setNext(prevNode.getNext());
			prevNode.setNext(newNode);
		}
	}
	
	/**
	 * Deletes the first occurrence of the node with the input data. 
	 * To delete a node from linked list, we need to do following steps. 
	 * 1) Find previous node of the node to be deleted. 
	 * 2) Changed next of previous node. 
	 * 3) Free memory for the node to be deleted.
	 * 
	 * @param data
	 */
	public void delete(int data) {
		String msg = "Input data not found in the linked list";
		if(head!=null) {
			Node currentNode = head;
			Node prevNode = null;
			while(currentNode!=null) {
				if(currentNode.getData() == data) {
					if(prevNode!=null) {
						prevNode.setNext(currentNode.getNext());
						currentNode = null;
					}else {
						head = currentNode.getNext();
						currentNode = null;
					}
					msg = "Deleted the element";
				} else {
					prevNode = currentNode;
					currentNode = currentNode.getNext();
				}
			}
		} 
		System.out.println(msg);
	}
	
	/**
	 * Deletes all occurrence of the node with the input data. 
	 * 
	 * @param data
	 */
	public void deleteAll(int data) {
		if(head!=null) {
			Node currentNode = head;
			Node prevNode = null;
			while(currentNode!=null) {
				if(currentNode.getData() != data) { // traverse to next element
					prevNode = currentNode;
					currentNode = currentNode.getNext();
				} else {
					if(prevNode!=null) { 
						prevNode.setNext(currentNode.getNext()); //if prevNode is not null, assign the next of currentNode to next of prevNode
					}else {
						head = currentNode.getNext(); // if prev is null, it means we are at head element. make the next of currentNode as head
					}
					currentNode = currentNode.getNext(); // as usual traverse to next element.
				}
			}
		} 
	}
	
}
