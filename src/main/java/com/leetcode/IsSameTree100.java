package com.leetcode;

//https://leetcode.com/problems/same-tree/
public final class IsSameTree100 {

	public boolean isSameTree(final TreeNode t1, final TreeNode t2) {
		if (t1 == null && t2 != null || t1 != null && t2 == null) {
			return false;
		} else if (t1 == null && t2 == null) {
			return true;
		}
		return t1.val == t2.val && this.isSameTree(t1.left, t2.left) && this.isSameTree(t1.right, t2.right);
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
