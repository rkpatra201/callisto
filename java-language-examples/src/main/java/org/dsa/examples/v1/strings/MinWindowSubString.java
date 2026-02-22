package org.dsa.examples.v1.strings;

import java.util.Map;
import java.util.stream.Collectors;

public class MinWindowSubString {
  public String solution(String s, String t) {
    String result = "";
    if (s == null || t == null || s.length() == 0 || t.length() == 0) {
      return result;
    }
    if (s.length() < t.length()) {
      return result;
    }
    Map<Character, Long> freqMap = t.chars().mapToObj(i -> (char) i)
        .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
    int left = 0;
    int right = 0;
    int startIndex = -1;
    int min = Integer.MAX_VALUE;
    int count = 0;
    while (right < s.length()) {
      Character currentChar = s.charAt(right);
      if (freqMap.containsKey(currentChar)) {
        Long v = freqMap.get(currentChar);
        if (v > 0) {
          count++;
        }
        freqMap.put(currentChar, v - 1);
      } else {
        freqMap.put(currentChar, -1L);
      }

      while (count == t.length()) {
        int currentMin = right - left + 1;
        if (currentMin < min) {
          min = currentMin;
          startIndex = left;
        }
        Character leftChar = s.charAt(left);
        freqMap.put(leftChar, freqMap.get(leftChar) + 1);
        if (freqMap.get(leftChar) > 0) {
          count--;
        }
        left++;
      }

      right++;
    }
    result = startIndex == -1 ? result : s.substring(startIndex, startIndex + min);
    return result;
  }
}