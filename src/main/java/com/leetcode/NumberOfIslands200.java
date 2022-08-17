package com.leetcode;

//https://leetcode.com/problems/number-of-islands/
public final class NumberOfIslands200 {

	int n;
	int m;

	public int numIslands(final char[][] grid) {

		int count = 0;
		this.n = grid.length;
		if (this.n == 0) {
			return 0;
		}
		this.m = grid[0].length;

		for(int i = 0; i < this.n; i++) {
			for(int j = 0; j < this.m; j++) {
				if (grid[i][j] == '1') {
					this.mark(grid, i, j);
					count++;
				}
			}
		}
		return count;
    }

	private void mark(final char[][] grid, final int i, final int j) {
		if (i < 0 || j < 0 || i >= this.n || j >= this.m || grid[i][j] == '0') {
			return;
		}
		grid[i][j] = '0';
		this.mark(grid, i+1, j);
		this.mark(grid, i-1, j);
		this.mark(grid, i, j+1);
		this.mark(grid, i, j-1);
	}
}
