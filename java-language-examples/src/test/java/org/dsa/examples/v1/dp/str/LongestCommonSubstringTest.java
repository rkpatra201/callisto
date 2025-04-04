package org.dsa.examples.v1.dp.str;

import org.dsa.examples.v1.dp.str.LongestCommonSubstring;
import org.junit.Test;


public class LongestCommonSubstringTest {

  @Test
  public void solution() {
    String p1 = "abc";
    String p2= "abc";
    int result = new LongestCommonSubstring().solution(p1, p2);
    System.out.println(result);
  }
}