package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCopyArbitraryPointer {

	private Node head;

	public Node copy() {
		final Map<Node,Node> pointers = new HashMap<>();
		Node current = this.head;
		Node copyHead = null;
		Node copyTail = null;
		while (current != null) {
			final Node copy = new Node(current.data, null, current.arbitrary);
			if (copyHead == null) {
				copyHead = copy;
			} else {
				copyTail.next = copy;
			}
			copyTail = copy;
			pointers.put(current, copy);
			current = current.next;
		}
		current = copyHead;
		while (current != null) {
			current.arbitrary = pointers.get(current.arbitrary);
			current = current.next;
		}
		return copyHead;
	}

	static class Node {

		private final int data;
		private Node next;
		private Node arbitrary;

		public Node(final int data, final Node node, final Node arbitrary) {
			this.data = data;
			this.next = node;
			this.arbitrary  = arbitrary;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (this.arbitrary == null ? 0 : this.arbitrary.hashCode());
			result = prime * result + this.data;
			result = prime * result + (this.next == null ? 0 : this.next.hashCode());
			return result;
		}

		@Override
		public boolean equals(final Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (this.getClass() != obj.getClass()) {
				return false;
			}
			final Node other = (Node) obj;
			if (this.arbitrary == null) {
				if (other.arbitrary != null) {
					return false;
				}
			} else if (!this.arbitrary.equals(other.arbitrary)) {
				return false;
			}
			if (this.data != other.data) {
				return false;
			}
			if (this.next == null) {
				if (other.next != null) {
					return false;
				}
			} else if (!this.next.equals(other.next)) {
				return false;
			}
			return true;
		}
	}

}
