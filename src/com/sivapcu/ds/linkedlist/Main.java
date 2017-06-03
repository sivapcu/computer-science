package com.sivapcu.ds.linkedlist;

public class Main {
	public static void main(String[] args) {
		// createLlWith3Nodes();
		// createLlWith4NodesUsingPush();
		// createLlUsingAppend();
		// createLlUsingTailAppend();
		// createLlUsingPushInsertAppend();
		// calculateLength();
		delete();
	}

	private static void createLlWith3Nodes() {
		LinkedList ll = new LinkedList();
		Node head = new Node(0);
		Node one = new Node(1);
		Node two = new Node(2);
		
		ll.setHead(head);
		head.setNext(one);
		one.setNext(two);
		ll.print();
	}
	
	private static void createLlWith4NodesUsingPush() {
		LinkedList ll = new LinkedList();
		ll.push(0);
		ll.push(1);
		ll.push(2);
		ll.push(3);
		ll.print();
	}
	
	private static void createLlUsingAppend() {
		LinkedList ll = new LinkedList();
		ll.append(0);
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.print();
	}
	
	
	private static void createLlUsingTailAppend() {
		LinkedListWithTail ll = new LinkedListWithTail();
		ll.append(0);
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.print();
	}
	
	private static void createLlUsingPushInsertAppend() {
		LinkedList ll = new LinkedList();
		ll.append(0); // 0 -->
		ll.print();
		ll.append(1); // 0 --> 1 -->
		ll.print();
		ll.push(3); // 3 --> 0 --> 1 -->
		ll.print();
		ll.insertAfter(ll.getHead().getNext(), 2); //3 --> 0 --> 2 --> 1 --> 
		ll.print();
		ll.push(4);// 4 --> 3 --> 0 --> 2 --> 1 --> 
		ll.print();
		ll.append(5); // 4 --> 3 --> 0 --> 2 --> 1 --> 5-->
		ll.print();
		ll.append(6); // 4 --> 3 --> 0 --> 2 --> 1 --> 5--> 6 -->
		ll.print();
		ll.insertAfter(ll.getHead().getNext(), 7); // 4 --> 3 --> 7 --> 0 --> 2 --> 1 --> 5--> 6 -->
		ll.print();
	}
	
	private static void calculateLength() {
		LinkedList ll = new LinkedList();
		ll.push(0);
		ll.push(1);
		ll.push(2);
		ll.append(4);
		ll.push(3);
		ll.insertAfter(ll.getHead().getNext(), 5);
		ll.print();
		System.out.println("Length of the LinkedList = " + ll.length());
	}
	
	private static void delete() {
		LinkedList ll = new LinkedList();
		ll.append(2);
		ll.append(0);
		ll.append(2);
		ll.append(2);
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(2);
		ll.append(4);
		ll.append(2);
		ll.append(2);
		ll.print();
		ll.deleteAll(2);
		ll.print();
		
		java.util.LinkedList<String> list = new java.util.LinkedList<String>();
	}

}
