package org.dsa.examples.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithUniqueChars {

  public int solution(String s) {
    int len = s.length();
    int longestSubStrLen = 0;
    Map<Character, Integer> lastSeenIndexMap = new HashMap<>();

    int followingIndex = 0;

    for (int pos = 0; pos < len; pos++) {
      char currentChar = s.charAt(pos);
      // Get the index where the current character was last seen
      int lastSeenIndex = lastSeenIndexMap.getOrDefault(currentChar, -1);

      // Move the start of the window if the current character is inside the current window
      if (lastSeenIndex >= followingIndex) {
        followingIndex = lastSeenIndex + 1;
      }
      longestSubStrLen = Math.max(longestSubStrLen, pos - followingIndex + 1);
      lastSeenIndexMap.put(currentChar, pos);// update the lastSeen index for the current char
    }
    return longestSubStrLen;
  }
}
