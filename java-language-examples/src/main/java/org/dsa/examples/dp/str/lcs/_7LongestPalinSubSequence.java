package org.dsa.examples.dp.str.lcs;

// approach: https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/
public class _7LongestPalinSubSequence {

  public int solution(String s1){
    String s2 = new StringBuilder(s1).reverse().toString();
    return new _1LongestCommonSubsequenceLength().solution(s1, s2);
  }
}
