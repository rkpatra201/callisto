package org.dsa.examples.blind75.w1;

// https://leetcode.com/problems/valid-anagram/submissions/1581468136/
public class _4ValidAnagram {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] track = new int[256];

    for (int i = 0; i < s.length(); i++) {
      track[s.charAt(i)] = track[s.charAt(i)] + 1;
    }

    for (int i = 0; i < t.length(); i++) {
      track[t.charAt(i)] = track[t.charAt(i)] - 1;
    }

    for (int i : track) {
      if (i != 0) {
        return false;
      }
    }

    return true;
  }
}
