package org.dsa.examples.v1.dp.str;

import org.dsa.examples.v1.dp.str.str._5LongestCommonSubstrPrint;
import org.junit.Test;

public class _5LongestCommonSubstrPrintTest {

  @Test
  public void solution() {
    String s1 = "abkdc";
    String s2 = "akdc";
    String result = new _5LongestCommonSubstrPrint().solution(s1, s2);
    System.out.println(result);
  }
}