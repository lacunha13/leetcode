package com.leetcode;

public final class LinkedListMergeSortedLists {

	private final Node l1;
	private final Node l2;

	public LinkedListMergeSortedLists(final Node l1, final Node l2) {
		this.l1 = l1;
		this.l2 = l2;
	}

	public Node merge() {
		Node h1 = this.l1;
		Node h2 = this.l2;
		Node headM;
		if (h1.data <= h2.data) {
			headM = h1;
			h1 = h1.next;
		} else {
			headM = h2;
			h2 = h2.next;
		}
		Node tailM = headM;
		while (h1 != null && h2 != null) {
			Node newTail = null;
			if (h1.data <= h2.data) {
				newTail = h1;
				h1 = h1.next;
			} else {
				newTail = h2;
				h2 = h2.next;
			}
			tailM.next = newTail;
			tailM = newTail;
		}
		if (h1 != null) {
			tailM.next = h1;
		} else if (h2 != null) {
			tailM.next = h2;
		}
		return headM;
	}

	static final class Node {
		private final int data;
		private Node next;

		public Node(final int data, final Node node) {
			this.data = data;
			this.next = node;
		}

		public static void print(final Node node) {
			System.out.print(node.data + " ");
			if (node.next != null) {
				Node.print(node.next);
			} else {
				System.out.println();
			}
		}
	}

	public static Node arrayToLinkedList(final int[] sorted) {
		Node root = null;
		Node tail = null;
		for (final int i : sorted) {
			final Node tmp = new Node(i, null);
			if  (root == null) {
				root = tmp;
			} else {
				tail.next = tmp;
			}
			tail = tmp;
 		}
		return root;
	}

}
