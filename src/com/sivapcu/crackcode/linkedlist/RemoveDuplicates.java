package com.sivapcu.crackcode.linkedlist;


/**
 * Write code to remove duplicates from an unsorted linked list.
 * <p>
 * FOLLOW UP
 * <p>
 * How would you solve this problem if a temporary bu#er is not allowed?
 */
public class RemoveDuplicates {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		int[] input = {3, 1, 7, 3, 5, 7, 2, 9, 5, 3};
		for(int i : input) {
			ll.add(i);
		}
		ll.print();
		ll.removeDuplicates();
		System.out.println();
		ll.print();
	}
}
class LinkedList {
	class Node {
		public Node(int data) {
			this.data = data;
		}
		Node next;
		int data;
	}
	Node head;
	
	public void add(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while(current.next!=null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	public void removeDuplicates() {
		if(head == null) {
			return;
		}
		Node current = head.next;
		Node previous = head;
		while(current!=null) {
			Node temp = head;
			while(temp != current) {
				if(temp.data == current.data) {
					previous.next = current.next;
					current = current.next;
					break;
				}
				temp = temp.next;
			}
			if(temp == current) {
				previous = current;
				current = current.next;
			}
		}
	}

	public void print() {
		if(head == null) {
			System.out.println("Empty list");
			return;
		}
		Node current = head; 
		while(current!=null) {
			System.out.print(current.data+"  ");
			current = current.next;
		}
	}
}
