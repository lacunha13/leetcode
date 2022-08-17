package com.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 */
public final class AddTwoNumbers2 {

    public ListNode addTwoNumbers(final ListNode l1, final ListNode l2) {
    	final int base = 10;
    	ListNode h1 = l1;
    	ListNode h2 = l2;
    	ListNode result = null;
    	ListNode tail = null;
    	int carry = 0;
    	while(h1 != null && h2 != null || carry != 0) {
    		final int val1 = h1 != null ? h1.val : 0;
    		final int val2 = h2 != null ? h2.val : 0;
    		int sum = val1 + val2 + carry;
    		if (sum >= base) {
    			sum -= base;
    			carry = 1;
    		} else {
    			carry = 0;
    		}
    		if (h1 != null) {
    			h1 = h1.next;
    		}
    		if (h2 != null) {
    			h2 = h2.next;
    		}
    		final ListNode node = new ListNode(sum);
    		if (result == null) {
    			result = tail = node;
    		} else {
    			tail.next = node;
    			tail = node;
    		}
    	}
    	if (h1 != null) {
    		tail.next = h1;
    	} else if (h2 != null) {
    		tail.next = h2;
    	}
    	return result;
    }


    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode() {}
    	ListNode(final int val) { this.val = val; }
    	ListNode(final int val, final ListNode next) { this.val = val; this.next = next; }
    }
}
