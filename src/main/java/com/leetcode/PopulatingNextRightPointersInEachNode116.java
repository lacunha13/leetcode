package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/

public final class PopulatingNextRightPointersInEachNode116 {

	public Node connect(final Node root) {
		final Deque<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			final int size = queue.size();
			for(int i = 0; i < size; i++) {
				final Node node = queue.poll();
				if (i == size -1) {
					node.next = null;
				} else {
					node.next = queue.peek();
				}
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return root;
    }


	public final class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(final int _val) {
	        this.val = _val;
	    }

	    public Node(final int _val, final Node _left, final Node _right, final Node _next) {
	        this.val = _val;
	        this.left = _left;
	        this.right = _right;
	        this.next = _next;
	    }
	}

}
