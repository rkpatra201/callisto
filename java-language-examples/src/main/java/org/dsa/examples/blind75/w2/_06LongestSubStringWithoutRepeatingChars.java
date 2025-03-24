package org.dsa.examples.blind75.w2;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1584716294/
public class _06LongestSubStringWithoutRepeatingChars {

  public int lengthOfLongestSubstring(String str) {
    int max = 0;
    int j = 0;
    int i = 0;
    boolean[] track = new boolean[256];
    while ( i < str.length() && j < str.length() ) {

      if (!track[str.charAt(i)]) {
        track[str.charAt(i)] = true;
        i = i + 1;
        max = Math.max(max, i-j);
      } else {
        track[str.charAt(j)] = false;
        j = j + 1;
      }
    }
    return max;

  }
}
