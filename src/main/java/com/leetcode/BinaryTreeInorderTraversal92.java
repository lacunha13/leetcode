package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/binary-tree-inorder-traversal/

public final class BinaryTreeInorderTraversal92 {

	public List<Integer> inorderTraversal(final TreeNode root) {
		if (root == null) {
			return Collections.emptyList();
		}
		final List<Integer> result = new ArrayList<>();
		final ArrayDeque<TreeNode> queue = new ArrayDeque<>();
		this.stack(root, queue);
		while(!queue.isEmpty()) {
			final TreeNode node = queue.poll();
			result.add(node.val);
			this.stack(node.right, queue);

		}
		return result;

    }

	public void stack(final TreeNode node, final ArrayDeque<TreeNode> queue) {
		if (node != null) {
			queue.addFirst(node);
			this.stack(node.left, queue);
		}
	}

	public final class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(final int val) { this.val = val; }
		TreeNode(final int val, final TreeNode left, final TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
