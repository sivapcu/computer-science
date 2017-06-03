package com.sivapcu.ds.linkedlist;

public class LinkedListWithTail {
	private Node head;
	private Node tail;
	
	public Node getHead() {
		return head;
	}
	public void setHead(Node head) {
		this.head = head;
	}
	public Node getTail() {
		return tail;
	}
	public void setTail(Node tail) {
		this.tail = tail;
	}
	
	/**
	 * Appends the new data at the tail of the linked list
	 * <p>
	 * The Big O is O(1) since new data is directly added at the end of the list
	 * without traversing
	 * 
	 * @param data
	 */
	public void append(int data) {
//		long start = System.currentTimeMillis();
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
//		long end = System.currentTimeMillis();
//		System.out.println("Time taken in ms : "+ (end-start));
	}
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
}
