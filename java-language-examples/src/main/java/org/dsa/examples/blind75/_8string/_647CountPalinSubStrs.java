package org.dsa.examples.blind75._8string;

public class _647CountPalinSubStrs {
  public int countSubstrings(String s) {
    int tc = 0;
    for (int i = 0; i < s.length(); i++) {
      int left = palinCount(s, i, i);
      int right = palinCount(s, i, i + 1);
      tc += left + right;
    }
    return tc;
  }


  public int palinCount(String s, int i, int j) {
    int count = 0;
    while (i >= 0 && j <= s.length() - 1) {
      if (s.charAt(i) != s.charAt(j)) {
        break;
      }
      count++;
      i--;
      j++;
    }
    return count;
  }
}
