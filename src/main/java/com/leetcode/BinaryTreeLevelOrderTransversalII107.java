package com.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-level-order-traversal
public class BinaryTreeLevelOrderTransversalII107 {

	public List<List<Integer>> levelOrder(final TreeNode root) {
		final List<List<Integer>> result = new ArrayList<>();
		List<Integer> partial = new ArrayList<>();
		ArrayDeque<TreeNode> current = new ArrayDeque<>();
		ArrayDeque<TreeNode> next = new ArrayDeque<>();
		if (root == null) {
			return result;
		}
		current.add(root);
		while (!current.isEmpty()) {
			final TreeNode node = current.poll();
			partial.add(node.val);
			if (node.left != null) {
				next.add(node.left);
			}
			if (node.right != null) {
				next.add(node.right);
			}
			if (current.isEmpty()) {
				final ArrayDeque<TreeNode> tmp = current;
				current = next;
				next = tmp;
				result.add(0, partial);
				partial = new ArrayList<>();
			}
		}
		return result;
    }






	 public class TreeNode {
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
