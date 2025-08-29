package org.dsa.examples.blind75._8string;

// https://leetcode.com/problems/longest-palindromic-substring/submissions/1593082744/
public class _5LongestPalinSubstr {
  public String longestPalindrome(String s) {
    String maxLen = "";
    for (int i = 0; i < s.length(); i++) {
      String oddLen = getPalinStr(s, i, i);
      String evenLen = getPalinStr(s, i, i + 1);
      String tempLen = oddLen.length() > evenLen.length() ? oddLen : evenLen;
      maxLen = maxLen.length() > tempLen.length() ? maxLen : tempLen;
    }

    return maxLen;
  }

  public String getPalinStr(String s, int i, int j) {
    int count = 0;
    while (i >= 0 && j <= s.length()-1) {
      if (s.charAt(i) != s.charAt(j)) {
        break;
      }
      count = count + 1;
      i--;
      j++;
    }
    return s.substring(i+1, j);
  }

}
