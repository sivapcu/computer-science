package com.sivapcu.ds.linkedlist;

public class LinkedListGeneric<E> {
	class Node {
		E data;
		Node next;
	
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head;
	private int currentSize;
	
	public LinkedListGeneric() {
		this.head = null;
		this.currentSize = 0;
	}
	
	public void addFirst(E e) {
		Node node = new Node(e);
		node.next = head;
		head = node;
		currentSize++;
	}
	
	public void addLast(E e) {
		Node node = new Node(e);
		if(head == null) {
			head = node;
		} else {
			Node current = head;
			while(current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
		currentSize++;
	}
	
	public E removeFirst() {
		Node first = null;
		if(head == null) {
			System.out.println("List is empty");
		} else {
			first = head;
			head = head.next;
			System.out.println("Removed the first element : " + first.data);
		}
		return first.data;
	}
	
	public E removeLast() {
		Node current = null;
		if(head == null) {
			System.out.println("List is empty");
		} else {
			current = head;
			Node previous = null; 
			while (current.next != null) {
				previous = current;
				current = current.next;
			}
			previous.next = null;
			System.out.println("Removed the last element : " + current.data);
		}
		return current.data;
	}
	
	public void print() {
		if(head!=null) {
			Node current = head;
			while(current!=null) {
				System.out.print(current.data+" --> ");
				current = current.next;
			}
			System.out.println();
		} else {
			System.out.println("Zero elements found");
		}
	}
	
	public static void main(String[] args) {
		LinkedListGeneric<Integer> ll = new LinkedListGeneric<Integer>();
		int n = 10;
		for(int i = 0; i < n; i++) {
			ll.addFirst(i);
		}
		ll.print();
		ll.removeFirst();
		ll.removeFirst();
		ll.removeLast();
		ll.removeLast();
		ll.print();
	}
}
