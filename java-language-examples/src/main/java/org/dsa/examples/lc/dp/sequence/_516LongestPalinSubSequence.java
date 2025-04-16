package org.dsa.examples.lc.dp.sequence;

// approach: https://takeuforward.org/data-structure/longest-palindromic-subsequence-dp-28/
// https://leetcode.com/problems/longest-palindromic-subsequence/submissions/1608657668/
public class _516LongestPalinSubSequence {

  public int solution(String s1){
    String s2 = new StringBuilder(s1).reverse().toString();
    return new _1143LongestCommonSubsequenceLength().solution(s1, s2);
  }
}
