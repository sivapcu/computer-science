package com.sivapcu.ds.queue;

public class Queue {
	private int[] queArray;
	private int front;
	private int rear;
	private int size;
	
	public Queue(int size) {
		this.size = size;
		this.queArray = new int[size];
		this.front = 0;
		this.rear = -1;
	}
	
	public void insert(int item) { // insert an item at the end of the queue
		if(rear == size-1) {
			rear = -1;
		}
		queArray[++rear] = item;
	}
	
	public int remove() { // remove an item from the head of the queue
		int temp = queArray[front++];
		if(front == size) {
			front = 0;
		}
		return temp;
	}
	
	public boolean isEmpty() {
		return rear+1==front || front+size-1==rear;
	}
}
