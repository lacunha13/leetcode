package com.leetcode;

public final class StringCanSegment {


	public boolean solution(final String word1, final String word2, final String mixed) {
		final boolean[] visited = new boolean[mixed.length()+1];
		visited[0] = false;
		return this.check(visited, word1, mixed) && this.check(visited, word2, mixed);
    }

	public boolean check(final boolean[] visited, final String word, final String mix) {
		for(int j = 0; j < word.length(); j++) {
			final char c = word.charAt(j);
			boolean found = false;
			for(int i = j; i < mix.length(); i++) {
				if (!visited[i] && c == mix.charAt(i)) {
					visited[i] = true;
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}

}
