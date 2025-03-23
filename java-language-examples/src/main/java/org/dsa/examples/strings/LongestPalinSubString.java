package org.dsa.examples.strings;

// https://leetcode.com/problems/longest-palindromic-substring/submissions/1583139002/
public class LongestPalinSubString {
  public String longestPalindrome(String s) {
    String maxLen = "";
    for (int i = 0; i < s.length(); i++) {
      String oddLen = palinSubStr(s, i, i);
      String evenLen = palinSubStr(s, i, i + 1);
      String tempLen = oddLen.length() > evenLen.length() ? oddLen : evenLen;
      maxLen = maxLen.length() > tempLen.length() ? maxLen : tempLen;
    }

    return maxLen;
  }

  public String palinSubStr(String s, int i, int j) {
    int count = 0;
    while (i >= 0 && j <= s.length() - 1) {
      if (s.charAt(i) == s.charAt(j)) {
        count = count + 1;
      } else {
        break;
      }
      i--;
      j++;
    }
    return s.substring(i + 1, j);
  }
}
