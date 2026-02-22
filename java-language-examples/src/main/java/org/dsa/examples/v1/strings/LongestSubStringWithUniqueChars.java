package org.dsa.examples.v1.strings;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/1569436432/
public class LongestSubStringWithUniqueChars {

  public int solution(String s) {
    int maxLen = 0;
    int start = 0;
    int current = 0;

    if (s.length() == 1) {
      return 1;
    }
    boolean[] visited = new boolean[256];
    while (start < s.length() && current < s.length()) {

      if (!visited[s.charAt(current)]) {

        visited[s.charAt(current)] = true;
        current = current + 1;

        maxLen = Math.max(maxLen, current - start);

      } else {
        visited[s.charAt(start)] = false; // remove the char from window
        start = start + 1; // reduce the window (current-start using increment) as duplicate found between start and current
      }


    }

    return maxLen;

  }
}
