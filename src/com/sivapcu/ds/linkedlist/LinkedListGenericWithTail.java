package com.sivapcu.ds.linkedlist;



public class LinkedListGenericWithTail<E> {
	class Node {
		E data;
		Node next;
	
		public Node(E data) {
			this.data = data;
			this.next = null;
		}
	}
	
	private Node head;
	private Node tail;
	private int currentSize;
	
	public LinkedListGenericWithTail() {
		this.head = null;
		this.tail = null;
		this.currentSize = 0;
	}
	
	public void addFirst(E e) {
		Node node = new Node(e);
		node.next = head;
		head = node;
		if(tail == null) {
			tail = node;
		}
		currentSize++;
	}
	
	public void addLast(E e) {
		Node node = new Node(e);
		if(head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		currentSize++;
	}
	
	public E removeFirst() {
		E output = null;
		if(head == null) {
			System.out.println("List is empty");
		} else if(head == tail) {
			output = head.data;
			head = null;
			tail = null;
			currentSize--;
			System.out.println("Removed the first element : " + output);
		} else {
			output = head.data;
			head = head.next;
			currentSize--;
			System.out.println("Removed the first element : " + output);
		}
		return output;
	}
	
	public E removeLast() {
		E output = null;
		if(head == null) {
			System.out.println("List is empty");
		} else if(head == tail) {
			output = tail.data; //last = head is also fine
			head = null;
			tail = null;
			currentSize--;
			System.out.println("Removed the last element : " + output);
		} else {
			Node current = head;
			Node previous = null;
			while (current != tail) {
				previous = current;
				current = current.next;
			}
			output = current.data;
			tail = previous;
			previous.next = null;
			currentSize--;
			System.out.println("Removed the last element : " + output);
		}
		return output;
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
		LinkedListGenericWithTail<Integer> ll = new LinkedListGenericWithTail<Integer>();
		ll.addFirst(3);
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(4);
		ll.addLast(5);
		ll.removeFirst();
		ll.removeLast();
		ll.addLast(6);
		ll.addLast(7);
		ll.addLast(8);
		ll.removeLast();
		ll.print();
	}
}
