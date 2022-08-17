package com.leetcode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public final class LongestSubstringWithoutRepeatingCharacters3 {

	public int lengthOfLongestSubstring(final String s) {
		final Map<Character, Integer> found = new HashMap<>();
		int count = 0;
		int max = 0;
		for(int i=0; i < s.length(); i++) {
			final char c = s.charAt(i);
			if (found.containsKey(c)) {
				i = found.get(c);
				found.clear();
				count = 0;
				continue;
			} else {
				count++;
				found.put(c, i);
			}
			if (count > max) {
				max = count;
			}
		}
		return max;
    }

}
