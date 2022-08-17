package com.leetcode;

//https://leetcode.com/problems/max-area-of-island/
public class MaxAreaIsland695 {

	private int n, m;

	public int maxAreaOfIsland(final int[][] grid) {

		int area = 0;
		this.n = grid.length;
		if (this.n == 0) {
			return 0;
		}
		this.m = grid[0].length;

		for(int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.m; j++) {
				if (grid[i][j] == 1) {
					final int count = this.tranverse(grid, i, j);
					if (count > area) {
						area = count;
					}

				}
			}
		}
		return area;

    }

	private int tranverse(final int[][] grid, final int i, final int j) {
		if (i < 0 || j < 0 || i >= this.n || j >= this.m || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;
		int count = 1;
		count += this.tranverse(grid, i + 1, j);
		count += this.tranverse(grid, i - 1, j);
		count += this.tranverse(grid, i, j + 1);
		count += this.tranverse(grid, i, j - 1);
		return count;
	}

}
