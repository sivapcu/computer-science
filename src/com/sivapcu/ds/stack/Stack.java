package com.sivapcu.ds.stack;

public class Stack {
	private int[] stk;
	private int top;
	
	public Stack(int size) {
		stk = new int[size];
		top = -1;
	}
	
	public void push(int item) {
		stk[++top] = item;
	}
	
	public int pop() {
		return stk[top--];
	}
	
	public int peek() {
		return stk[top];
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
}
