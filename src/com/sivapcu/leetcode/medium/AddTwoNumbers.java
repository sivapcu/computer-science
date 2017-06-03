package com.sivapcu.leetcode.medium;

/**
 * Question 2:<p>
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * <p>
 * <code>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 * </code>
 */
public class AddTwoNumbers {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode prev = null;
		ListNode current = null;
		int carryFwdVal = 0;
		while (l1 != null || l2 != null || carryFwdVal !=0) {
			prev = current;
			int value = carryFwdVal;
			if(l1!=null) {
				value = value + l1.val;
				l1 = l1.next;
			}
			if(l2!=null) {
				value = value + l2.val;
				l2 = l2.next;
			}
			current = new ListNode(value%10);
			carryFwdVal = value/10;
			if(prev==null) {
				head = current;
			} else {
				prev.next = current;
			}
		}
		return head;
    }
	
	public static void main(String[] args) {
//		int [] input1 = {9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9};
//		int [] input2 = {1};
		int [] input1 = {8,6,9,1,0,1,0,4,1};
		int [] input2 = {2,3,6,2,3,8,4,6,8};
		ListNode l1 = createListNode(input1);
		ListNode l2 = createListNode(input2);
		print(l1);
		print(l2);
		ListNode output = addTwoNumbers(l1, l2);
		print(output);
	}
	
	private static ListNode createListNode(int[] input) {
		int length = input.length;
		ListNode head = null;
		if(length > 0) {
			head = new ListNode(input[0]);
			ListNode current = head;
			for(int i=1; i< input.length; i++) {
				current.next = new ListNode(input[i]);
				current = current.next;
			}
		}
		return head;
	}

	public static void print(ListNode listNode) {
		ListNode current = listNode;
		while(current!=null) {
			System.out.print(current.val);
			current = current.next;
		}
		System.out.println();
	}
}
